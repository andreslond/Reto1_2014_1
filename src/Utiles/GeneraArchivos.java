package Utiles;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oarboleda
 */
import java.io.*;

public class GeneraArchivos
{
    private static int MAXIMO = Integer.MAX_VALUE; 
    private static int MAX_DATOS_LINEA = 1000;
    private static int MAX_LINEAS = 5000;
    private static String archivoSalida= "Entrada1.txt";
            
    public static void main(String[] args)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivoSalida);
            pw = new PrintWriter(fichero);

            // El archico queda por fuera de la carpeta src
            for (int i = 0; i < MAX_LINEAS; i++){
                int tamaño = (int)(Math.random()*MAX_DATOS_LINEA);
                pw.println(crearLinea(tamaño));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static String crearLinea(int cantidad)
    {
        String aux="";
        
        for(int i=0; i<cantidad; i++){
            aux +=(int)(Math.random()*MAXIMO)+"\t";
        }
        return aux;
    }
}

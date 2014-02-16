package Aplicativo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oarboleda
 */
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

class SolucionReto1_SinModificar {

    private static String archivo = "Calentamiento1.txt";

    public static void mostrarArchivo(String nombre) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombre);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void mostrar(double[] arr) {
        int cont = 1;
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
//            System.out.println((i + 1) + ": " + arr[i] + ", ");
//            if()
            while ((i < arr.length - 1) && arr[i] == arr[i + 1]) {
                cont++;
                i++;
            }
            
            System.out.println((k + 1) + ": " + arr[i] + " --> " + cont);
            k++;
            cont = 1;
        }
    }

    public static double[] Proceso(String nombre) {

        Hashtable<String, Double> contenedor = new Hashtable<String, Double>();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombre);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            //Agregado
            String[] entradas;
            int cont = 0;
            double anterior = 0;
            //fin agregado
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //Agregado
                entradas = linea.split("\t");
                for (int i = 0; i < entradas.length; i++) {
                    try {
                        String clave = "a" + cont;
                        contenedor.put(clave, Double.parseDouble(entradas[i]));
                        cont++;
                        anterior = Double.parseDouble(entradas[i]);
                    } catch (NumberFormatException ex) {
                        System.out.println(ex + " " + entradas[i] + " " + i);
                    }
                }
                //Fin agregado
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //Agregado Este bloque permite pasar la tabla hash a un arreglo "arr" 
        //para despues ser ordenado
        int cont2 = 0;
        Enumeration<String> enumeracion = contenedor.keys();//Se extraen todos
        //los keys
        double[] arr = new double[contenedor.size()];// Se crea el arreglo del 
        //tamaño adecuado
        while (enumeracion.hasMoreElements()) {//
            arr[cont2] = contenedor.get(enumeracion.nextElement());
            cont2++;
        }
        //Ordenamieto quicksort
        java.util.Arrays.sort(arr);
        return arr;
        //Fin agregado
    }

    public static void main(String[] arg) {
        long tiempoILectura, tiempoFLectura, duracionLectura,
                tiempoIProceso, tiempoFProceso, duracionProceso,
                tiempoISalida, tiempoFSalida, duracionSalida;

        // Despliegue del archivo       
        tiempoILectura = System.currentTimeMillis();
        mostrarArchivo(archivo);
        tiempoFLectura = System.currentTimeMillis();
        duracionLectura = tiempoFLectura - tiempoILectura;

        // Proceso
        tiempoIProceso = System.currentTimeMillis();
        // Actualizar con el proceso propuesto        
//        mostrarArchivo(archivo);
        double[] arr = Proceso(archivo);

        tiempoFProceso = System.currentTimeMillis();
        duracionProceso = tiempoFProceso - tiempoIProceso;
        //termina proceso              

        // Generacion de la salida
        tiempoISalida = System.currentTimeMillis();
        // Actualizar con el proceso propuesto
//        mostrarArchivo(archivo);
        mostrar(arr);

        tiempoFSalida = System.currentTimeMillis();
        duracionSalida = tiempoFSalida - tiempoISalida;

        System.out.println("DuracionLectura=" + duracionLectura + "ms \tEquivalente a " + duracionLectura / 1000 + " s"
                + "\nDuracionProceso=" + duracionProceso + "ms \tEquivalente a " + duracionProceso / 1000 + " s"
                + "\nDuracionSalida=" + duracionSalida + "ms \tEquivalente a " + duracionSalida / 1000 + " s"
        );
    }
}

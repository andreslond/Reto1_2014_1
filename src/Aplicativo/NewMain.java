/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicativo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Torres
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void mostrar(double[] arr) {
        int cont = 1;
        int k = 0;
        
        for (int i = 0; i < arr.length; i++) {
//            System.out.println((i + 1) + ": " + arr[i] + ", ");
//            if()
            while ( (i < arr.length - 1 ) && arr[i] == arr[i + 1]) {
                cont++;
                i++;
            }

            System.out.println((k + 1) + ": " + arr[i] + " --> " + cont);
            k++;
            cont = 1;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        long tiempo1, tiempo2, total;

        tiempo1 = System.currentTimeMillis();

        Hashtable<String, Double> contenedor = new Hashtable<String, Double>();
//        Vector claves = new Vector();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
//            archivo = new File("D:\\Moodle\\Maraton\\Reto1_2014_1\\Ejercicio1\\Calentamiento1.txt");
//            archivo = new File("D:\\Moodle\\Maraton\\Reto1_2014_1\\Ejercicio1\\Entrada1.txt");
//            archivo = new File("D:\\Moodle\\Maraton\\Reto1_2014_1\\Ejercicio1\\PruebaRepetidos.txt");
            archivo = new File("D:\\Moodle\\Maraton\\Reto1_2014_1\\Ejercicio1\\Calentamiento1 - copia.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String[] entradas;
            int cont = 0;
            double anterior = 0;

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                entradas = linea.split("\t");

                for (int i = 0; i < entradas.length; i++) {
                    try {
                        String clave = "a" + cont;
//                    claves.add(clave);

                        contenedor.put(clave, Double.parseDouble(entradas[i]));
                        cont++;
//                    System.out.println(entradas[i]);
                        anterior = Double.parseDouble(entradas[i]);
                    } catch (NumberFormatException ex) {
                        System.out.println(ex + " " + entradas[i] + " " + i);
                    }
                }

//            System.out.println( linea);
//                System.out.println(contenedor.size());
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

        System.out.println("Ordenar datos:");

//        Enumeration<String> llaves = contenedor.keys();
//        int cont3 = 0;
//        while (llaves.hasMoreElements()) {
//            System.out.println(cont3 + " " + "hashtable llaves: " + llaves.nextElement());
//            cont3++;
//        }
//        System.out.println(cont3);
//        
//        int cont4 = 0;
//        Enumeration<Double> enumeration2 = contenedor.elements();
//        while (enumeration2.hasMoreElements()) {
//            System.out.println(cont4 + " " + "hashtable valores: " + enumeration2.nextElement());
//            cont4++;
//        }System.out.println(cont4);
        System.out.println(contenedor.size());
        int cont2 = 0;
        Enumeration<String> enumeracion = contenedor.keys();
        double[] arr = new double[contenedor.size()];
        while (enumeracion.hasMoreElements()) {
            arr[cont2] = contenedor.get(enumeracion.nextElement());

            cont2++;
        }

        System.out.println("_____________________________________________");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": " + arr[i] + ", ");
        }

        java.util.Arrays.sort(arr);

        
        mostrar(arr);
        
        tiempo2 = System.currentTimeMillis();
        total = tiempo2 - tiempo1;
        System.out.println(total);
    }
}

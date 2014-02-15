/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDatos;

import java.util.*;

/**
 *
 * @author oarboleda
 */
public class EjecutaPersonaVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector misDatos = new Vector();

        System.out.println("   PROCESAMIENTO PERSONAS USANDO VECTORES");
        // Se ingresan los datos
        for (int i=0; i<10; i++){
            Persona p = new Persona("Soy"+i, 30+i ,1.70);
            misDatos.add(p);
        }
        // Se imprimen los datos ingresados
        for (int i=0; i<misDatos.size(); i++){
            Persona aux = (Persona) misDatos.elementAt(i);
            System.out.println(aux.info());
        }
        
        // se construyen e insertan dos nuevas personas
        Persona p1 = new Persona("Soy el primer nuevo", 18, 1.78);
        Persona p2 = new Persona("Soy el segundo nuevo", 29, 1.68);
        misDatos.add(3,p1);
        misDatos.add(p2);
        System.out.println("\nLos datos actuales son");
        // Se imprimen de nuevo todos las personas
        for (int i=0; i<misDatos.size(); i++){
            Persona aux = (Persona) misDatos.elementAt(i);
            System.out.println("  "+aux.info());
        }

        int limite = misDatos.size()/2;
        System.out.println("Eliminando los primeros "+limite+" elementos");
        // se eliminan los elementos de las posiciones pares
        for (int i=0; i<limite; i++){
            System.out.println("....Removiendo posicion "+i);
            misDatos.removeElementAt(i);
        }
        System.out.println("Luego de eliminar....");
        // se eliminan los elementos de las posiciones pares
        for (int i=0; i<misDatos.size(); i++){
            Persona aux = (Persona) misDatos.elementAt(i);
            System.out.println("  "+aux.info());
        }

    }
}

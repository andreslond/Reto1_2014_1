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
public class EjecutaPersonaHash {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hashtable misDatos = new Hashtable();
        Vector misClaves = new Vector();

        System.out.println("   PROCESAMIENTO PERSONAS USANDO HASHTABLE");
        // Se ingresan los datos en la forma clave, valor
        for (int i=0; i<10; i++){
            Persona p = new Persona("Soy"+i, 30+i ,1.70);
            String clave = "i"+i;
            misClaves.add(clave);
            misDatos.put(clave,p);
            
        }
        // Se imprimen los datos ingresados
        for (int i=0; i<misDatos.size(); i++){
            String key = (String) misClaves.get(i);
            System.out.println("  .. recuperando clave "+key);
            Persona aux = (Persona) misDatos.get(key);
            System.out.println(aux.info());
        }

        // se construyen e insertan dos nuevas personas
        Persona p1 = new Persona("Soy el primer nuevo", 18, 1.78);
        Persona p2 = new Persona("Soy el segundo nuevo", 29, 1.68);
        misDatos.put("nuevo1",p1);
        misDatos.put("nuevo2",p2);
        misClaves.add(0, "nuevo1");
        misClaves.add(0, "nuevo2");
        System.out.println("\nLos datos actuales son");
        // Se imprimen de nuevo todos las personas
        for (int i=0; i<misClaves.size(); i++){
            Persona aux = (Persona) misDatos.get(misClaves.get(i));
            System.out.println("  "+aux.info());
        }

        int limite = misClaves.size()/2;
        System.out.println("\nEliminando las primeras "+limite+" claves");
        // se eliminan los elementos de las posiciones pares
        for (int i=0; i<limite; i++){
            String clave = (String) misClaves.get(i);
            System.out.println("....Removiendo clave--"+clave);
            misDatos.remove(clave);
        }
        System.out.println("Luego de eliminar....");
        // se eliminan los elementos de las posiciones pares
        for (int i=0; i<misClaves.size(); i++){
            String clave = (String) misClaves.get(i);
            Persona aux = (Persona) misDatos.get(clave);
            if ( aux!=null){
                System.out.println("  clave:"+clave+"  contenido: "+aux.info());
            }else{
                System.out.println("  la clave:"+clave+" habia sido borrada");                
            }

        }

    }
}

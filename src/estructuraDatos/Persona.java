/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package estructuraDatos;

/**
 *
 * @author oarboleda
 */
public class Persona {
    private int edad;
    private String nombre;
    private double estatura;
    private static int cantidad=0;
    private Persona amada;

    public Persona(){
        nombre=new String("N.N");
        edad=0;
        estatura=60;
        cantidad++;
    }

    public Persona(String n, int a, double t){
        nombre=new String(n);
        edad=a;
        estatura=t;
        cantidad++;
    }

    public String info(){
        return "Mi nombre es "+nombre+" Edad:"+edad+" Estatura:"+estatura;
    }

    public void cambiarNombre(String nn){
        nombre=new String(nn);
    }

    public void envejecer(int a){
        edad+=a;
    }

    public void crecer(double a){
        estatura+=a;
    }

    public void aprecia(Persona p){
        amada=p;
    }

    public int obtenerEdad(){
        return edad;
    }

    public double obtenerEstatura(){
        return estatura;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public String obtenerAmado(){
        if (amada==null){
            return " nadie";
        } else {
            return amada.obtenerNombre();
        }
    }

    public int numeroPersonas(){
        return cantidad;
    }
}

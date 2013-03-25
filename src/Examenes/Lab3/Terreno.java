/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab3;

/**
 *
 * @author Gotcha
 */
public class Terreno {
    private double largo;
    private double ancho;
    public Terreno siguiente = null;
    
    public Terreno(double a, double l){
        largo = l;
        ancho = a;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getArea(){
        return ancho * largo;
    }
    
    public void imprimir(){
        System.out.println(this.toString());
        
    }

    @Override
    public String toString() {
        return "Terreno{" + "largo=" + largo + ", ancho=" + ancho 
                + " area: " + getArea() + '}';
    }
    
    
}

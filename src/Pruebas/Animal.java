/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class Animal {
    protected boolean esMamifero;
    protected int cantidad;
    
    public Animal(boolean sm, int c){
        esMamifero = sm;
        cantidad = c;
    }
    
    public void comohabla(){
        System.out.println("YO ANIMAL HABLO");
    }
}

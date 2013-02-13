/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public abstract class Patito extends Animal {
    public Patito(){
        super(false,2);
    }
    
    public void queColor(){
        System.out.println("Soy Amarillo");
    }
}

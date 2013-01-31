/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class Perro extends Animal {
    private String raza;
    
    public Perro(String r){
        super(true, 4);
        raza = r;
    }
    
    @Override
    public void comohabla(){
        super.comohabla();
        System.out.println("GUAU GUAU GUAU");
    }
    
    
}

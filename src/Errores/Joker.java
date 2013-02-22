/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class Joker {
    public void atraco(boolean batman){
        if(!batman)
            System.out.println("YO ATRACO! O PONGO EL BALDE");
        else{
            int x[] = { 0,1 };
            System.out.println(x[2]);
        }
        System.out.println("Finalizo asalto");
    }
}

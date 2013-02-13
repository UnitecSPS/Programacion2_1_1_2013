/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class Gato extends Animal {
    public Gato(){
        super(true,4);
    }

    @Override
    public void comohabla() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

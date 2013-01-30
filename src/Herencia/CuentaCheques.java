/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria {

    public CuentaCheques(int n, String c) {
        super(n, c);
    }

    @Override
    public void patito() {
        System.out.println("SOY UN PATITO CHEQUECITO");
    }
    
    
}

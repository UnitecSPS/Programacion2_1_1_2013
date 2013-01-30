/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria {

    private ArrayList<Cheque> cheques = new ArrayList<>();
    
    public CuentaCheques(int n, String c) {
        super(n, c);
        cheques.add(new Cheque(1,30,"Al portador",true));
    }
    
    public void imprimirCheques(){
        for(Cheque ch : cheques){
            System.out.println("Cheque: " + ch);
        }
        
    }

    @Override
    public void patito() {
        System.out.println("SOY UN PATITO CHEQUECITO");
    }
    
    
}

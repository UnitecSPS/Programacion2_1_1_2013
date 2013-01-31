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
public class Banco {
    public static void main(String[] args) {
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        //UP CASTING
        CuentaBancaria ca = new CuentaAhorro(1,"Carlos",0.3);
        
        cuentas.add( ca );
        cuentas.add( new CuentaCheques(2,"Antonio"));
        cuentas.add(new CuentaBancaria(3,"erick"));
        
        for(CuentaBancaria cb : cuentas){
            cb.patito();
            
            //llamemos lo extra
            if( cb instanceof CuentaBancaria ){
                
                System.out.println("Tasa: " + 
                        ((CuentaAhorro)cb).getTasa()  );
            }
            else if( cb instanceof CuentaCheques ){
                System.out.println("CHEQUES\n-----");
                ((CuentaCheques)cb).imprimirCheques();
            }
        }
        
        //----DOWN CASTING INDIRECTO
        CuentaAhorro cah = (CuentaAhorro)ca;
        cah.setTasa(0.07);
        
        //--DOWN CASTING DIRECTO
        System.out.println("Tasa: " + ((CuentaAhorro)ca).getTasa());
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class CuentaCheques extends CuentaBancaria {

    private ArrayList<Cheque> cheques = new ArrayList<>();
    
    public CuentaCheques(int n, String c) {
        super(n, c);
    }
    
    public void imprimirCheques(){
        for(Cheque ch : cheques){
            System.out.println("Cheque: " + ch);
        }
        
    }

    @Override
    public boolean retiro(double m) {
        boolean pagado = super.retiro(m);
        agregarCheque(pagado, m);
        return pagado;
    }
    
    @Override
    public void patito() {
        System.out.println("SOY UN PATITO CHEQUECITO");
    }

    private void agregarCheque(boolean pagado, double m) {
        Scanner lea = new Scanner(System.in);
        System.out.println("Numero cheque: ");
        int nc = lea.nextInt();
        System.out.println("Dirigido a: ");
        String c = lea.next();
        
        cheques.add( new Cheque(nc, m, c, pagado) );
    }
    
    
}

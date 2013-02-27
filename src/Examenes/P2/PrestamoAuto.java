/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

/**
 *
 * @author Gotcha
 */
public class PrestamoAuto extends Prestamo implements IPrestamo {
    
    private Cuota cuotasSeguro[]; 
    
    public PrestamoAuto(String n, double m, int cant){
        super(n,m,cant);
        
        double pagseg = (monto * 0.15)/cant;
        cuotasSeguro = new Cuota[cant];
        for(int c = 0 ;  c < cant; c++ ){
            cuotasSeguro[c] = new Cuota(false,pagseg);
        }
    }
    
    @Override
    public void imprimir() {
        System.out.println(cliente + " Lps. " + monto);
    }

    @Override
    public double getTasaInteres() {
        return 0.25;
    }

    @Override
    public double saldoPendiente() {
        double tot = 0;
        for(int c=0; c < cuotas.length; c++){
            if(!cuotas[c].isPagada())
                tot += cuotas[c].getPagoMensual();
            
            if(!cuotasSeguro[c].isPagada())
                tot += cuotasSeguro[c].getPagoMensual();
        }
        return tot;
    }
    
    @Override
    public void pagarCuota(int nc){
        super.pagarCuota(nc);
        cuotasSeguro[nc].setPagada(true);
    }
    
}


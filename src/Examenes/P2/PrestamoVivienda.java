/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

/**
 *
 * @author Gotcha
 */
public class PrestamoVivienda extends Prestamo implements IPrestamo {

    private boolean usaBanprovi;
    
    public PrestamoVivienda(String n, double m, int c, boolean ub){
        super(n,m,c);
        usaBanprovi = ub;
    }
    
    @Override
    public void imprimir() {
        System.out.println(cliente + " Lps" + monto + " Pendiente: "+
                saldoPendiente());
    }

    @Override
    public double getTasaInteres() {
        return usaBanprovi ? 0.1 : 0.2;
    }

    @Override
    public double saldoPendiente() {
        double tot = 0;
        for(Cuota cuo : cuotas){
            if(!cuo.isPagada()){
                tot += cuo.getPagoMensual();
            }
        }
        return tot + 57000;
    }
    
}

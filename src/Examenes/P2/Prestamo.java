/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

/**
 *
 * @author Gotcha
 */
public abstract class Prestamo {
    protected String cliente;
    protected double monto;
    protected Cuota cuotas[];
    
    public Prestamo(String n, double m, int cant){
        cliente = n;
        monto = m;
        cuotas = new Cuota[cant];
        initCuotas(cant);
    }

    private void initCuotas(int cant) {
        double pago = monto/cant;
        for(int c = 0; c < cant; c++ ){
            cuotas[c] = new Cuota(false,pago);
        }
    }
    
    public abstract void imprimir();
    
    public void pagarCuota(int numCuota){
        cuotas[numCuota].setPagada(true);
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

/**
 *
 * @author Gotcha
 */
public class Cuota {
    private boolean pagada;
    private double pagoMensual;

    public Cuota(boolean pagada, double pagoMensual) {
        this.pagada = pagada;
        this.pagoMensual = pagoMensual;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }
    
    
}

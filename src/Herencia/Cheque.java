/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Gotcha
 */
class Cheque {
    public int numero;
    public double monto;
    public String aquien;
    public boolean pagado;

    public Cheque(int numero, double monto, String aquien, boolean pagado) {
        this.numero = numero;
        this.monto = monto;
        this.aquien = aquien;
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Cheque{" + "numero=" + numero + ", monto=" + monto + ", aquien=" + aquien + ", pagado=" + pagado + '}';
    }
    
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class CuentaBancaria{
    protected int numero;
    protected String cliente;
    protected double saldo;
    protected Date apertura;
    
    public CuentaBancaria(int n, String c){
        numero = n;
        cliente = c;
        saldo = 0;
        apertura = new Date();
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getApertura() {
        return apertura;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    public boolean retiro(double m){
        if( saldo > m){
            saldo -= m;
            return true;
        }
        return false;
    }
    
    public void patito(){
        System.out.println("SOY EL PATO PAPA");
    }
    
}

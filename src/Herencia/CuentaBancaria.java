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
public abstract class CuentaBancaria{
    protected int numero;
    protected String cliente;
    protected double saldo;
    protected Date apertura;
    public static final int VERSION = 9999;
    
    public final int X = 1;
    public final int Y = 2;
    public final int Z = 3;
    
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
    
    public final void deposito(double m){
        saldo += m;
    }
    
    public boolean retiro(double m){
        if( saldo > m){
            saldo -= m;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
       // VERSION = 2;
        return "{" + "numero=" + numero + ", cliente=" + cliente + ", saldo=" + saldo + ", apertura=" + apertura + '}';
    }
    
    public boolean transferencia(double m, CuentaBancaria destino){
        if( retiro(m) ){
            destino.deposito(m);
            return true;
        }
        return false;
    }
    
    public void patito(){
        
        final int c;
        c = 2;
        //c = 5;
        switch(c){
            case X:
                System.out.println("sss");
                break;
            case Y:
                System.out.println("ddd");
                break;
            case Z:
                System.out.println("klkl");
        }
        
        System.out.println("SOY EL PATO PAPA");
    }
    
}
 
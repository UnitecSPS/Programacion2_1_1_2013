/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public abstract class CellPhone {
    protected int serie;
    protected int numero;
    protected String user;

    public CellPhone(int serie, int numero, String user) {
        this.serie = serie;
        this.numero = numero;
        this.user = user;
    }

    public int getSerie() {
        return serie;
    }

    public int getNumero() {
        return numero;
    }

    public String getUser() {
        return user;
    }
    
    public abstract void mandarMsg(String msg);
    
    public abstract void llamar(int numDestino);

    @Override
    public String toString() {
        return "CellPhone{" + "serie=" + serie + ", numero=" + numero + ", user=" + user + '}';
    }
    
    
}

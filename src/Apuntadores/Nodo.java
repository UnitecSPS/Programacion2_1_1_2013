/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 *
 * @author Gotcha
 */
public class Nodo implements Cloneable, Serializable {
    public String texto;
    public Nodo siguiente;
    
    public Nodo(String txt){
        texto= txt;
        siguiente = null;
    }

    @Override
    protected Nodo clone() {
        try{
            Nodo nuevo = (Nodo)super.clone();
            nuevo.siguiente = null;
            return nuevo;
        }
        catch(Exception e){
            return null;
        }
    }
    
    

    @Override
    public String toString() {
        return "Nodo{" + "texto=" + texto + '}';
    }
    
    public void save(){
        try{
            FileOutputStream  ra = new FileOutputStream (this.texto+".pat");
            ObjectOutputStream out = new ObjectOutputStream(ra);
            out.writeObject(this);
            out.close();
            ra.close();
        }
        catch(Exception e){
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}

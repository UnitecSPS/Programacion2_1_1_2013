/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author Gotcha
 */
public class Serializar {
    public static void main(String[] args) {
        Nodo nu = new Nodo("Chelsea");
        nu.save();
        try{
            FileInputStream fi = new FileInputStream("Chelsea.pat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Nodo nb = (Nodo)oi.readObject();
            System.out.println("nb: " + nb);
        }
        catch(Exception e){
            System.out.println("e: " + e.getMessage());
        }
    }
}

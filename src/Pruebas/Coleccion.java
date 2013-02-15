/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public abstract class Coleccion {
    protected ArrayList valores;
    
    public Coleccion(){
        valores = new ArrayList();
    }
    
    public abstract void add(Object val);
    
    public final void imprimir(){
        for(Object obj : valores)
            System.out.println(obj);
    }
}

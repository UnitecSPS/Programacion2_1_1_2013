/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class MiArrayList implements Cloneable {
    public Nodo inicio;
    
    public MiArrayList(){
        inicio = null;
    }
    
    public void add(Nodo obj){
        if(obj == null) return;
        
        if( inicio == null ){
            inicio = obj;
        }
        else{
            Nodo tmp = inicio;
            
            while(tmp.siguiente != null){
                tmp = tmp.siguiente;
            }
            System.out.println("Agregando " + obj.texto + 
                    " despues de " + tmp.texto);
            tmp.siguiente = obj;
        }
    }
    
    public void printList(){
        Nodo tmp = inicio;
        
        while(tmp != null){
            System.out.println(tmp);
            tmp = tmp.siguiente;
        }
    }
    
    public boolean contain(String txt){
        Nodo tmp = inicio;
        
        while( tmp != null ){
            if( tmp.texto.equals(txt))
                return true;
            tmp = tmp.siguiente;
        }
        return false;
    }
    
    public void remove(String txt){
        if( inicio != null ){
            if( inicio.texto.equals(txt)){
                inicio = inicio.siguiente;
            }
            else{
                Nodo tmp = inicio;
                
                while(tmp.siguiente != null){
                    if( tmp.siguiente.texto.equals(txt)){
                        tmp.siguiente = tmp.siguiente.siguiente;
                        break;
                    }
                    else{
                        tmp = tmp.siguiente;
                    }
                }
            }
        }
    }
    
    public void addInTheMiddle(Nodo newObj, String t){
        Nodo tmp = inicio;
        
        while( tmp != null ){
            if( tmp.texto.equals(t)){
                newObj.siguiente = tmp.siguiente;
                tmp.siguiente = newObj;
                return;
            }
            tmp = tmp.siguiente;
        }
    }
    
    public void export(String txtfilename){
         try{
             FileWriter fw = new FileWriter(txtfilename);
             Nodo tmp = inicio;
             int cont = 1;
             
             fw.write("LISTADO DE NODOS\n-----------\n");
             
             while( tmp != null ){
                 fw.write(cont + "-" + tmp.texto + "\n");
                 tmp = tmp.siguiente;
                 cont++;
             }
             
             fw.close();
         }catch(Exception e){
             System.out.println("Error: " + e.getMessage());
         }
    }
    
    public void addFromFile(String filename){
        try{
            FileReader fr = new FileReader(filename);
            Scanner lector = new Scanner(fr);
            
            while(lector.hasNext()){
                add( new Nodo(lector.next()) );
            }
            
            fr.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public int size(){
        Nodo tmp = inicio;
        int cont = 0;
        
        while( tmp != null ){
            cont++;
            tmp = tmp.siguiente;
        }
        
        return cont;
    }
    
    public Nodo[] toArray(){
        Nodo array[] = new Nodo[size()];
        Nodo tmp = inicio;
        int pos = 0;
        
        while( tmp != null ){
            array[pos++] = tmp;
            tmp = tmp.siguiente;
        }
        
        return array;
    }
    
    public MiArrayList cloneList(){
        MiArrayList mi = new MiArrayList();
        Nodo tmp = inicio;
        
        while(tmp != null ){
            mi.add(tmp.clone());
            tmp = tmp.siguiente;
        }
        
        System.out.println("SE ACABO");
        return mi;
    }
    
    public MiArrayList clone(){
        try{
            return (MiArrayList)super.clone();
        }
        catch(Exception e){
            return null;
        }
    }
            
    
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Lotificadora {
    Terreno raiz;
    String nombre;
    FileWriter fw;
    int cantidad = 0;
    
    public Lotificadora(String n){
        nombre = n;
        raiz = null;
        
        try{
            fw = new FileWriter("Log.txt", true);
        }
        catch(Exception e){
            
        }
    }
    
    private void escribirEnLog(String msg)throws IOException{
        fw.write(msg+"\n");
        fw.flush();
    }
    
    public void agregar(Terreno terr)throws IOException{
        if(terr==null) return;
        
        terr.siguiente = raiz;
        raiz = terr;
        cantidad++;
        
        escribirEnLog("Se ha agregado un nuevo terreno: " + terr.toString());
    }
    
    public void imprimir(boolean export)throws IOException{
        Terreno tmp = raiz;
        String terrs = "";
        
        while(tmp != null){
            tmp.imprimir();
            terrs += tmp.toString() + "\n";
            tmp = tmp.siguiente;
        }
        
        if(export){
            FileWriter fi = new FileWriter("Terrenos" + nombre+".txt");
            fi.write(terrs);
            fi.close();
        }
            
        escribirEnLog("Se ha impreso todos los terrenos."+
                (export ? "Y se exporto a Terrenos" + nombre + ".txt" : ""));
    }
    
    public double getAreaPromedio()throws IOException{
        Terreno tmp = raiz;
        double tarea = 0;
        
        while(tmp!=null){
            tarea += tmp.getArea();
            tmp = tmp.siguiente;
        }
        
        return tarea/cantidad;
    }
    
    public void depurar(double minArea)throws IOException{
        int cantinicial = cantidad;
        
        if( raiz != null ){
            Terreno tmp = raiz;
            
            while(tmp != null){
                //la raiz se elimina
                if(tmp == raiz && raiz.getArea() < minArea){
                    raiz = raiz.siguiente;
                    cantidad--;
                    tmp = raiz;
                }
                else{
                    if(tmp.siguiente != null && 
                            tmp.siguiente.getArea() < minArea ){
                        tmp.siguiente = tmp.siguiente.siguiente;
                        cantidad--;
                    }
                    else{
                        //siempre me paso al siguiente;
                        tmp = tmp.siguiente;
                    }
                }
            }
        }
        
        escribirEnLog("Se ha depurado el listado de terrenos paso de " +
                cantinicial + " a " + cantidad);
    }
    
    public void verLog()throws IOException{
        FileReader fr = new FileReader("Log.txt");
        Scanner sc = new Scanner(fr);
        sc.useDelimiter(System.getProperty("line.separator"));
        
        while(sc.hasNext()){
            System.out.println("-" + sc.next());
        }
    }
    
}

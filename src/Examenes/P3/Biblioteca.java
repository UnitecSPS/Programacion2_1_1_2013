/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P3;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Biblioteca {
    RandomAccessFile ram;
    
    public Biblioteca(){
        try{
            ram = new RandomAccessFile("thebooks.boo", "rw");
        }
        catch(Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }
    
    public int getCodigo()throws IOException{
        RandomAccessFile rcod = new RandomAccessFile("codigos.boo", "rw");
        int cod;
        if( rcod.length() == 0 ){
            cod = 1;
        }
        else{
            cod = rcod.readInt();
        }
       
        rcod.seek(0);
        rcod.writeInt(cod+1);
        rcod.close();
        
        return cod;
    }
    
    public void adicionarLibro(String descrip, int copias)throws IOException{
        ram.seek(ram.length());
        //cod
        ram.writeInt(getCodigo());
        //des
        ram.writeUTF(descrip);
        //fech
        ram.writeLong(new Date().getTime());
        //copias
        ram.writeInt(copias);
        ram.writeInt(copias);
    }
    
    public long busquedaLibro(int cod)throws IOException{
        ram.seek(0);
        
        while(ram.getFilePointer() < ram.length()){
            long pos = ram.getFilePointer();
            int codi = ram.readInt();
            ram.readUTF();
            ram.readLong();
            ram.readInt();
            ram.readInt();
            
            if( codi == cod ){
                return pos;
            }
        }
        return -1;
    }
    
    public void prestarLibro(int cod)throws IOException{
        long pos = busquedaLibro(cod);
                
        if( pos != -1 ){
            ram.seek(pos);
            ram.readInt();
            ram.readUTF();
            ram.readLong();
            ram.readInt();
            int dispo = ram.readInt();
            
            if( dispo > 0 ){
                ram.seek(ram.getFilePointer()-4);
                ram.writeInt(dispo - 1);
                
                System.out.println("Dispo: " + (dispo-1));
                
            }
        }
    }
    
    public void devolverLibro(int cod)throws IOException{
        long pos = busquedaLibro(cod);
        
        if(pos != -1){
            ram.seek(pos);
            ram.readInt();
            ram.readUTF();
            ram.readLong();
            int ori = ram.readInt();
            int dispo = ram.readInt();
            
            if( dispo < ori ){
                ram.seek(ram.getFilePointer()-4);
                ram.writeInt(dispo+1);
            }
            else{
                System.out.println("ESTE LIBRO NO ES DE AQUI");
            }
        }
    }
    
    public void imprimirLibros(Date min)throws IOException{
        ram.seek(0);
        
        while(ram.getFilePointer() < ram.length()){
            int cod = ram.readInt();
            String d = ram.readUTF();
            long  fecha = ram.readLong();
            int ori = ram.readInt();
            int dispo = ram.readInt();
            
            if(fecha >= min.getTime()){
                Date f = new Date(fecha);
                System.out.println(cod + d + f + ori + dispo);
            }
        }
    }
    
    public void cambiarFecha(int cod)throws IOException{
        Scanner lea = new Scanner(System.in);
        long pos = busquedaLibro(cod);
        
        if( pos != -1){
            ram.seek(pos);
            int year = lea.nextInt();
            int mes = lea.nextInt();
            int dia = lea.nextInt();
            
            ram.readInt();
            ram.readUTF();
            
            Calendar c = Calendar.getInstance();
            c.set(year, mes - 1, dia);
            
            ram.writeLong( c.getTimeInMillis() );
        }
    }
    
    
}

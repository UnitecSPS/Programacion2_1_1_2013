/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Gotcha
 */
public class Rolas {
    private RandomAccessFile rSongs;
    private RandomAccessFile rInvoices;
    
    public Rolas(){
        try{
            rSongs = new RandomAccessFile("iSongs.msc","rw");
            rInvoices = new RandomAccessFile("iInvoices.msc", "rw");
            initCodes();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void initCodes()throws IOException {
        RandomAccessFile rCodes = new RandomAccessFile("iCodes.msc","rw");
        if( rCodes.length() == 0 ){
            rCodes.writeInt(1);
            rCodes.writeInt(1);
        }
        rCodes.close();
    }
    
    private int getNewCodeSong()throws IOException{
        return getCodigo(0);
    }
    
    private int getNewCodeInvoice()throws IOException{
        return getCodigo(4);
    }
    
    private int getCodigo(int offset)throws IOException{
        RandomAccessFile rCodes = new RandomAccessFile("iCodes.msc","rw");
        rCodes.seek(offset);
        int code = rCodes.readInt();
        rCodes.seek(offset);
        rCodes.writeInt(code+1);
        rCodes.close();
        return code;
    }
    
    public void addSong(String nc, double price)throws IOException{
        rSongs.seek( rSongs.length() );
        //codigo
        rSongs.writeInt( getNewCodeSong() );
        //nombre
        rSongs.writeUTF(nc);
        //precio
        rSongs.writeDouble(price);
        //cant
        rSongs.writeInt(0);
        //reviews
        rSongs.writeInt(0);
        //stars
        rSongs.writeInt(0);
        //dispo
        rSongs.writeBoolean(true);
    }
    
    public void songList()throws IOException{
        rSongs.seek(0);
        System.out.println("LISTADO DISPONIBLE DE CANCIONES");
        System.out.println("-------------------------------");
        
        while( rSongs.getFilePointer() < rSongs.length() ){
            int cod = rSongs.readInt();
            String n = rSongs.readUTF();
            double p = rSongs.readDouble();
            int cant = rSongs.readInt();
            int cantr = rSongs.readInt();
            int stars = rSongs.readInt();
            
            if( rSongs.readBoolean() ){
                double review = cantr > 0 ? stars/cantr : 0;
                System.out.printf("%d - %s - $%.2f - bajado %d veces - (%.1f/5)\n",
                        cod, n, p, cant, review);
            }
        }
    }
}

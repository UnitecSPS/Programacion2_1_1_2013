/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

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
        System.out.println("\nLISTADO DISPONIBLE DE CANCIONES");
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
    
    public boolean search(int codsong)throws IOException{
        rSongs.seek(0);
        
        while(rSongs.getFilePointer() < rSongs.length() ){
            int cod = rSongs.readInt();
            
            long pos = rSongs.getFilePointer();
            rSongs.readUTF();
            rSongs.seek( rSongs.getFilePointer() + 20 );
            boolean dispo = rSongs.readBoolean();
            
            if( dispo && codsong == cod){
                rSongs.seek(pos);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean download(int codsong, String cliente)throws IOException{
        if( search(codsong) ){
            System.out.println("Bajando " + rSongs.readUTF() + " .... ");
            double prec = rSongs.readDouble();
            
            //actualizar bajadas
            int cantb = rSongs.readInt();
            rSongs.seek(rSongs.getFilePointer()-4);
            rSongs.writeInt(cantb + 1);
            
            ///crear factura
            createInvoice(codsong, prec, cliente);
            return true;
        }
        return false;
    }

    private void createInvoice(int codsong, double prec, String c)throws IOException {
        rInvoices.seek( rInvoices.length() );
        //cod fact
        rInvoices.writeInt( getNewCodeInvoice() );
        //cod song
        rInvoices.writeInt(codsong);
        //cliente
        rInvoices.writeUTF(c);
        //precio
        rInvoices.writeDouble(prec);
        //fecha
        rInvoices.writeLong(new Date().getTime());
    }
    
    //TODO: TG3
    /**
     * Debe de registrar un nuevo review a una cancion existente y
     * disponible.(20%)
     * @param codsong Codigo de la cancion
     * @param stars Estrellas asignadas (1-5)
     */
    public void rateSong(int codsong, int stars)throws IOException{
        if(stars < 0 || stars > 5 )
            return;
        
        if( search(codsong) ){
            rSongs.readUTF();//leo el nombre
            //avanzo el precio + cant
            rSongs.seek(rSongs.getFilePointer()+12);
            //cant rev
            int cr = rSongs.readInt();
            int ce = rSongs.readInt();
            //me regreso
            rSongs.seek( rSongs.getFilePointer() - 8 );
            rSongs.writeInt(cr+1);
            rSongs.writeInt(ce+stars);
            System.out.println("Review Exitoso");
        }
    }
    
    /**
     * Debe desactivar una cancion existente segun el codigo de la misma (10%)
     * @param codsong Codigo de la cancion
     */
    public void deactivateSong(int codsong)throws IOException{
        if( search(codsong) ){
            String n = rSongs.readUTF();
            //avanzo hasta el final
            rSongs.seek(rSongs.getFilePointer()+20);
            rSongs.writeBoolean(false);
            System.out.println(n + " ha sido desactivada.");
        }
    }
    
    /**
     * Debe mostrar TODOS los datos de una factura segun su codigo (20%)
     * @param codinvoice Cod Invoice
     */
    public void showInvoice(int codinvoice)throws IOException{
        //Se muestra:
        //Fecha en la que fue bajada la cancion
        //Cod Factura // Cod Cancion - Nombre de Cancion
        // Cliente // Precio de la factura
        rInvoices.seek(0);
        
        while(rInvoices.getFilePointer() < rInvoices.length()){
            int cf = rInvoices.readInt();
            int cc = rInvoices.readInt();
            String cn = rInvoices.readUTF();
            double prec = rInvoices.readDouble();
            Date fech = new Date( rInvoices.readLong() );
            
            if( cf == codinvoice ){
                search(cc);
                String cancion = rSongs.readUTF();
                
                System.out.println("\n\nFecha: " + fech);
                System.out.println("Factura# " + cf + " Cancion# " + cc + " " +
                        cancion);
                System.out.println("Cliente: " + cn +" Lps." + prec);
                return;
            }
        }
        //si llegamos hasta aqui es porque:
        System.out.println("FACTURA NO EXISTE");
    }
    
    /**
     * Debe mostrar TODOS los datos de la cancion que MAS veces se ha
     * bajado, se muestra tambien cuantas veces se ha bajado (20%)
     */
    public void topSong()throws IOException{
        int cantMayor=0;
        int cc=0, cr=0, ce=0;
        double pm=0;
        boolean a;
        String n="";
        rSongs.seek(0);
        
        while(rSongs.getFilePointer() < rSongs.length() ){
            int cod = rSongs.readInt();
            String no = rSongs.readUTF();
            double p = rSongs.readDouble();
            int baj = rSongs.readInt();
            int crevs = rSongs.readInt();
            int cestre = rSongs.readInt();
            boolean acti = rSongs.readBoolean();
            
            if( baj > cantMayor ){
                cc = cod;
                n = no;
                cantMayor = baj;
                cr = crevs;
                ce = cestre;
                a = acti;
                pm = p;
            }
        }
        
        if( cantMayor > 0 ){
            double review = ce > 0 ? cr/ce : 0;
            System.out.printf("La mayor es: %d - %s - $%.2f - bajado %d veces - (%.1f/5)\n",
                        cc, n, pm, cantMayor, review);
        }
        else
            System.out.println("Aun no se bajan canciones");
    }
    
    /**
     * Debe de retornar el total que ha ganado la empresa con las canciones
     * bajadas desde una fecha min hasta el presente. (20%)
     * @param min La fecha de inicio del calculo, la factura debe de haber
     *      sido hecha en >= dicha fecha.
     * @return El monto ganado.
     */ 
    public double profitsSince(Date min)throws IOException{
        double total = 0;
        rInvoices.seek(0);
        
        while(rInvoices.getFilePointer() < rInvoices.length()){
            rInvoices.seek(rInvoices.getFilePointer()+8);
            rInvoices.readUTF();
            double to = rInvoices.readDouble();
            long fech = rInvoices.readLong();
            
            if( fech >= min.getTime())
                total += to;
        }
        
        return total;
    }
    
    //TODO= Agregar las opciones en el Main para probarlas (10%)
    
}
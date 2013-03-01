/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class MiFile {
    private File file = null;
    
    public void setFile(String dir){
        file = new File(dir);
    }
    
    public boolean crearFile()throws IOException{
        try{
            return file.createNewFile();
        }catch(NullPointerException e){
            System.out.println("CONFIGURAR PRIMERO UN ARCHIVO");
            return false;
        }
    }
    
    public void info(){
        try{
            if( file.exists() ){
                System.out.println("Nombre: " + file.getName());
                System.out.println("Padre: " + file.getAbsoluteFile().getParent());
                System.out.println("Path: " + file.getPath());
                System.out.println("Absolute: " + file.getAbsolutePath());
                
                if( file.isDirectory() ) 
                    System.out.println("ES UN DIRECTORIO");
                if( file.isFile() )
                    System.out.println("ES UN ARCHIVO");
                if( file.isHidden() )
                    System.out.println("ESTA OCULTO");
                if( file.isAbsolute() )
                    System.out.println("LO INSTANCIE CON UNA DIR ABSOLUTA");
                
                System.out.println("Mide: " + file.length() + " bytes");
                Date now = new Date( file.lastModified() );
                System.out.println("Ultima fecha de modificacion: " + now);
                  
                System.out.println("Archivo o Folder EXISTE");
            }
            else{
                System.out.println("Archivo o Folder AUN NO EXISTE");
            }
        }catch(NullPointerException e){
            System.out.println("CONFIGURAR PRIMERO UN ARCHIVO");
        }
    }
    
    public boolean crearDir(){
        try{
            return file.mkdirs();
        }catch(NullPointerException e){
            System.out.println("CONFIGURAR PRIMERO UN ARCHIVO");
            return false;
        }
    }
    
    public boolean borrar(){
        try{
            return file.delete();
        }catch(NullPointerException e){
            System.out.println("CONFIGURAR PRIMERO UN ARCHIVO");
            return false;
        }
    }
    
    public void listar(){
        try{
            if( file.isDirectory() ){
                File files[] = file.listFiles();
                
                for(File fi : files){
                    if( !fi.isHidden() ){
                    //fecha
                        Date now = new Date(fi.lastModified());
                        System.out.print(now + "\t");

                        if( fi.isDirectory())
                            System.out.print("<DIR>\t");
                        if( fi.isFile() ){
                            System.out.print("     \t" + fi.length()+" ");
                        }
                        System.out.println(fi.getName());
                    }
                }
            }
        }catch(NullPointerException e){
            System.out.println("CONFIGURAR PRIMERO UN ARCHIVO");
        }
    }
    
}

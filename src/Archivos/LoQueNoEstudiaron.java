/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class LoQueNoEstudiaron {
    public static void main(String[] args) {
        try{
            Scanner lea = new Scanner(System.in);
            System.out.println("Archivo: ");
            String filename = lea.next();
            
            FileWriter few = new FileWriter(filename, true);
            
            do{
                System.out.println("Ingrese texto: ");
                String texto = lea.next();
                
                if( texto.equalsIgnoreCase("exit"))
                    break;
                
                few.write(texto+"\n");
                few.flush();
            }while(true);
            
            few.close();
            
            //leer
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            char body[] = new char[(int)f.length()];
            int cbytes = fr.read(body);
            
            char body2[] = new char[5];
            fr.read(body2);
            
            System.out.println("CONTENIDO\n--------------\n");
            System.out.println(body);
            System.out.println("\n" + f.length() + " = "+ cbytes);
            System.out.println(body2);
            
            //con scanner
            fr = new FileReader(f);
            Scanner lector = new Scanner(fr);
            lector.useDelimiter(System.getProperty("line.separator"));
            
            while(lector.hasNext()){
                System.out.println("-" + lector.next());
            }
            
        }
        catch(Exception e){
            System.out.println("ERR: " + e.getMessage());
        }
    }
}

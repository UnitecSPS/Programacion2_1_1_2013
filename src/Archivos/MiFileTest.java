/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class MiFileTest {
    public static void main(String[] args) {
        MiFile mf = new MiFile();
        int op;
        Scanner lea = new Scanner(System.in);
        //lea.useDelimiter(System.getProperty("line.separator"));
        
        do{
            System.out.println("1- Configurar Archivo");
            System.out.println("2- Crear Archivo");
            System.out.println("3- Ver Informacion");
            System.out.println("4- Crear Directorio");
            System.out.println("5- Borrar Archivo");
            System.out.println("6- Listar Directorio");
            System.out.println("7- Salir");
            System.out.print("\nopcion: ");
            op = lea.nextInt();
            
            try{
                
                switch( op ){
                    case 1:
                        System.out.print("Direccion: ");
                        String filepath = lea.next();
                        mf.setFile(filepath);
                        break;
                    case 2:
                        if( mf.crearFile() )
                            System.out.println("SE CREO BIEN");
                        else
                            System.out.println("NO SE CREO");
                        break;
                    case 3:
                        mf.info();
                        break;
                    case 4:
                        if( mf.crearDir())
                            System.out.println("Se creo el Dir");
                        else
                            System.out.println("NO se pudo crear Dir");
                        break;
                    case 5:
                        if( mf.borrar())
                            System.out.println("Se borro exitosamente");
                        else
                            System.out.println("No se pudo borrar");
                        break;
                    case 6:
                        mf.listar();
                        break;
                }
                
                
            }catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
            
        }while( op != 7);
    }
}

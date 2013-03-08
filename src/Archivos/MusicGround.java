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
public class MusicGround {
    public static void main(String[] args) {
        Rolas roll = new Rolas();
        int op;
        Scanner lea = new Scanner(System.in);
        
        do{
            System.out.println("\n\nMENU PRINCIPAL\n---------");
            System.out.println("1- Agregar Cancion");
            System.out.println("2- Listar Canciones dispo.");
            System.out.println("3- Bajar Cancion");
            System.out.println("4- Salir");
            System.out.print("\nEscoja Opcion: ");
            op = lea.nextInt();
            
            try{
                switch( op ){
                    case 1:
                        System.out.println("Nombre de Cancion: ");
                        String n = lea.next();
                        System.out.println("Precio de Cancion: ");
                        double p = lea.nextDouble();
                        roll.addSong(n, p);
                        break;
                    case 2:
                        roll.songList();
                        break;
                    case 3:
                        System.out.println("Nombre Cliente: ");
                        String c = lea.next();
                        System.out.println("Cod Cancion: ");
                        int cod = lea.nextInt();
                        
                        if( roll.download(cod, c))
                            System.out.println("Se bajo masiso!");
                        else
                            System.out.println("No Existe o no esta Disponible");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=4);
        
    }
}

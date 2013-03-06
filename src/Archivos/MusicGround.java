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
            System.out.println("1- Agregar Cancion");
            System.out.println("2- Listar Canciones dispo.");
            System.out.println("3- Salir");
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
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=3);
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.util.Calendar;
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
            System.out.println("4- Rate Cancion");
            System.out.println("5- Desactivar Cancion");
            System.out.println("6- Mostrar Factura");
            System.out.println("7- Top Cancion");
            System.out.println("8- Ingresos desde");
            System.out.println("9- Salir");
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
                    case 4:
                        System.out.println("Cod Cancion: ");
                        cod = lea.nextInt();
                        System.out.println("Estrellas? (0-5): ");
                        int estrellas = lea.nextInt();
                        
                        roll.rateSong(cod, estrellas);
                        break;
                    case 5:
                        System.out.println("Cod Cancion: ");
                        roll.deactivateSong(lea.nextInt());
                        break;
                    case 6:
                        System.out.println("Codigo Factura: ");
                        roll.showInvoice(lea.nextInt());
                        break;
                    case 7:
                        roll.topSong();
                        break;
                    case 8:
                        System.out.println("Dia: ");
                        int dia = lea.nextInt();
                        System.out.println("Mes: ");
                        int mes = lea.nextInt();
                        System.out.println("Anio: ");
                        int year = lea.nextInt();
                        
                        Calendar cal = Calendar.getInstance();
                        //recordar que el mes empieza en cero en Calendar
                        cal.set(year,mes-1, dia);
                        double profit = roll.profitsSince(cal.getTime());
                        System.out.println("Ganado desde " + cal.getTime() + 
                                " : $" + profit);
                        break;
                        
                        
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }while(op!=9);
        
    }
}

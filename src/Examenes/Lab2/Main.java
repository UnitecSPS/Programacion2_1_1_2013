/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab2;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class Main {
    public static void main(String[] args) {
        ArrayDouble ad = new ArrayDouble();
        Scanner lea = new Scanner(System.in);
        int op=0;
        
        do{
            System.out.println("1- Agregar");
            System.out.println("2- Incluye?");
            System.out.println("3- SubMenu");
            System.out.println("4- Salir");
            System.out.print("Escoja Opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        ad.agregarElemento(lea.nextDouble());
                        break;
                    case 2:
                        if( ad.incluyeA(lea.nextDouble()) )
                            System.out.println("Existe!");
                        else
                            System.out.println("NO Existe!");
                        break;
                    case 3:
                        String sop;
                        do{
                            String ops[] = ad.misOpciones();
                            for(String o : ops){
                                System.out.println("\t-" + o);
                            }
                            System.out.println("\t- Salir");
                            System.out.print("\tIngrese Opcion: ");
                            sop = lea.next();
                            ad.ejecutarOpcion(sop);
                            
                        }while( !sop.equalsIgnoreCase("Salir"));
                        
                }
            }
            catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
            
        }while(op != 4);
        
    }
}

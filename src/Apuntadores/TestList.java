/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

import java.util.Scanner;

/**
 *
 * author Gotcha
 */
public class TestList {
    public static void main(String[] args) {
        MiArrayList mirray = new MiArrayList();
        Scanner lea = new Scanner(System.in);
        
        int op;
            
        do{
            System.out.println("1- Agregar Nodo");
            System.out.println("2- Listar Nodos");
            System.out.println("3- Buscar Nodo");
            System.out.println("4- Remover Nodo");
            System.out.println("5- Agregar en Medio");
            System.out.println("6- Exportar");
            System.out.println("7- Agregar de Archivo");
            System.out.println("9- Salir");
            System.out.print("\nEscoja opcion: ");
            op = lea.nextInt();
            
            switch( op ){
                case 1:
                    System.out.print("Texto: ");
                    String txt = lea.next();
                    mirray.add( new Nodo(txt) );
                    break;
                case 2:
                    mirray.printList();
                    break;
                case 3:
                    System.out.print("Texto: ");
                    txt = lea.next();
                    
                    if( mirray.contain(txt))
                        System.out.println("SI ESTA");
                    else
                        System.out.println("NO ESTA");
                    break;
                case 4:
                    System.out.print("Texto: ");
                    txt = lea.next();
                    mirray.remove(txt);
                    break;
                case 5:
                    System.out.print("Texto del Nuevo: ");
                    txt = lea.next();
                    System.out.print("Texto de En medio: ");
                    String medio = lea.next();
                    mirray.addInTheMiddle(new Nodo(txt), medio);
                    break;
                case 6:
                    System.out.print("Nombre de archivo txt: ");
                    txt = lea.next();
                    mirray.export(txt);
                    break;
                case 7:
                    System.out.print("Nombre de archivo txt: ");
                    txt = lea.next();
                    mirray.addFromFile(txt);
            }
        }while( op != 8);
            
    }
}

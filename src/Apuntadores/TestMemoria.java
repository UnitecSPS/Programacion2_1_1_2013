/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class TestMemoria {
    public static void main(String[] args) {
        Nodo a = new Nodo("Miguel");
        Nodo b = a;
        b.texto = "Lilian";
        
        System.out.println("a: " + a.texto);
        System.out.println("b: " + b.texto);
        
        a.texto = "Chapulin";
        
        System.out.println("a: " + a.texto);
        System.out.println("b: " + b.texto);
        
        String ca = "hola";
        Scanner lea = new Scanner(System.in);
        String cb = lea.next();
        String cc = cb;
        cb = "pepe";
        if( cc == cb )
            System.out.println("SON IGUALES");
        else
            System.out.println("NO SON IGUALES");
    }
}

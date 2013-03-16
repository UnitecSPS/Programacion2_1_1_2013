/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuntadores;

/**
 *
 * @author Gotcha
 */
public class CloneList {
    public static void main(String[] args) {
        MiArrayList la = new MiArrayList();
        la.addFromFile("patitos.txt");
        la.printList();
        
        MiArrayList lb = la.cloneList();
        lb.inicio.texto = "HACKED";
        lb.printList();
        System.out.println("LA");
        la.printList();
        
        System.out.println("LC");
        MiArrayList lc = la.clone();
        lc.inicio.texto = "HACKED";
        lc.printList();
        System.out.println("LA OTRA VEZ");
        la.printList();
              
        
        /*Nodo arr[] = la.toArray();
        System.out.println("\nLB------\n");
        for(Nodo nodo : arr){
            System.out.println(nodo);
        }
        arr[0].texto = "HACKEADO";
        System.out.println("\nLISTA A");
        la.printList();*/
        
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab3;

/**
 *
 * @author Gotcha
 */
public class Main {
    public static void main(String[] args) {
        Lotificadora loti = new Lotificadora("Santa Monica");
        try{
            loti.agregar(new Terreno(10, 5));
            loti.agregar(new Terreno(10, 6));
            loti.agregar(new Terreno(10, 7));
            loti.agregar(new Terreno(10, 8));
            loti.agregar(new Terreno(10, 9));
            loti.agregar(new Terreno(10, 10));
            
            System.out.println("LISTA INICIAL\n");
            loti.imprimir(false);
            System.out.println("Area Promedio: " + loti.getAreaPromedio());
            
            loti.depurar(80);
            System.out.println("Despues de depurarlo");
            loti.imprimir(true);
            
            System.out.println("Ver Log\n--------");
            loti.verLog();
            
            
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }       
    }
}

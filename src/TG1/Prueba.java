/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;

/**
 *
 * @author Immac
 */
public class Prueba {
    public static void main(String[] args) {
        Lab1 labTest = new Lab1(4);
        
        labTest.LlenarArreglo();
        System.out.println("");
              
        labTest.Imprimir();
        System.out.println(labTest.BuscarNum(5)?"true":"false");
        System.out.println(labTest.Suma());
        
               
    }
    
    
    
    
}

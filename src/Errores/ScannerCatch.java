/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.transform.TransformerException;

/**
 *
 * @author Gotcha
 */
public class ScannerCatch {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        String x = "num";
        
        do{
            try{
                
                x = lea.next();
                
                if( x.equals("num") ){
                    throw new TransformerException("Decepticon");
                }
                
                System.out.println("X: " + x);
                break;
           }
            catch(Exception e){
                System.out.println("NO Ingrese un numero");
                e.printStackTrace();
            }
        }while(true);
        
    }
}

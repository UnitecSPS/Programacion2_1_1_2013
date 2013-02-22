/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class ErrorClass {
    Object valores[] = new Object[5];
    
    public static void main(String[] args) {
        ErrorClass ec = new ErrorClass();
        ec.patito();
    }
    
    
    public void agregar(Object valor, int pos){
        if( pos < 0 || pos >= valores.length )
            throw new InvalidPositionException();
        valores[pos] = valor;
    }
    
    public void patito(){
        try{
            agregar(4,5000);
        }
        catch(InvalidPositionException e){
            System.out.println("POSICION INVALIDA");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

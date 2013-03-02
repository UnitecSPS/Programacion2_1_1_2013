/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab2;

/**
 *
 * @author Gotcha
 */
public class InvalidObjectException extends Exception{
    public InvalidObjectException(){
        super("OBJETO DIFERENTE, NO SE PUEDE UTILIZAR");
    }
}

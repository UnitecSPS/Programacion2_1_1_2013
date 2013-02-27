/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

/**
 *
 * @author Gotcha
 */
public class InvalidTypeException extends Exception {
    public InvalidTypeException(String type){
        super("Tipo " + type + " es un tipo invalido.");
    }
}

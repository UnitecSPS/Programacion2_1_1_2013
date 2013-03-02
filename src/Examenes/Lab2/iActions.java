/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab2;

/**
 *
 * @author Gotcha
 */
public interface iActions {
    void agregarElemento(Object val)throws InvalidObjectException;
    boolean incluyeA(Object val)throws InvalidObjectException;
    String[] misOpciones();
    void ejecutarOpcion(String op);
}

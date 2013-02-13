/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P1;

/**
 *
 * @author Gotcha
 */
public abstract class Servicio {
    protected int codigo;
    protected String nombre;
    protected double monto;

    public Servicio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public void imprimir(){
        System.out.println(codigo+nombre+monto);
    }
    
    public abstract double getMontoMensual();
    
    /**
     * Aqui vamos a imprimir segun el parametro <code>c</code>
     * @param c Es el parametro a imprimir
     * @return Se retorna el mismo parametro sumado 1.
     */
    public int patito(int c){
        System.out.println("c");
        return c +1;
    }
}

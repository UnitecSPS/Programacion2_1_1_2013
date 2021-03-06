/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ExamenLaboratorio1;

import java.util.Date;

public class Empleado {
    protected int codigo;
    protected String nombre;
    protected Date contratacion;
    protected double salario;

    public Empleado(int c, String n, double s){
        codigo = c;
        nombre = n;
        salario = s;
        contratacion = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getContratacion() {
        return contratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double pago(){
        return salario - (salario * 0.035);
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + "nombre=" + nombre;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.Lab2;

import java.util.ArrayList;

/**
 *
 * @author Gotcha
 */
public class ArrayDouble implements iEstadistica, iActions{
    ArrayList<Double> numeros = new ArrayList<>();
    
    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for(double val : numeros){
            if( min > val )
                min = val;
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for(double val : numeros){
            if( max < val )
                max = val;
        }
        return max;
    }

    @Override
    public double suma() {
        double sum = 0;
        for(double val : numeros){
            sum += val;
        }
        return sum;
    }

    @Override
    public double promedio() {
        return suma()/numeros.size();
    }
    
    public void rango(){
        double ran = maximo() - minimo();
        System.out.println("Rango: " + ran);
    }
    
    public void imprimir(){
        System.out.println("Hay " + numeros.size() + " numeros: ");
        for(double v : numeros){
            System.out.println(v);
        }
        System.out.println("Maximo: " + maximo());
        System.out.println("Minimo: " + minimo());
        System.out.println("Suma  : " + suma());
        System.out.println("Promedio: " + promedio());
    }
    
    public void desviacionStd(){
        double suma = 0;
        double prom = promedio();
        double longi = numeros.size() - 1;
        
        for(double valor : numeros){
            suma += Math.pow(valor - prom, 2);
        }
        
        double std = Math.sqrt( suma / longi );
        
        System.out.println("Desviacion Std: " + std);
    }

    @Override
    public void agregarElemento(Object val) throws InvalidObjectException {
        if( val instanceof Double){
            numeros.add((double)val);
        }
        else{
            throw new InvalidObjectException();
        }
        
    }

    @Override
    public boolean incluyeA(Object val) throws InvalidObjectException {
        if( val instanceof Double){
            return numeros.contains(val);
        }
        else{
            throw new InvalidObjectException();
        }
    }

    @Override
    public String[] misOpciones() {
        String ops[]={"Imprimir", "Desviacion", "Rango" };
        return ops;
    }

    @Override
    public void ejecutarOpcion(String op) {
        if(op.equalsIgnoreCase("Imprimir"))
            imprimir();
        else if( op.equalsIgnoreCase("Desviacion"))
            desviacionStd();
        else if( op.equalsIgnoreCase("Rango"))
            rango();
        else
            System.out.println("Opcion no existe");
    }
    
}

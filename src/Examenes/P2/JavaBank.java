/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class JavaBank {
    ArrayList<Prestamo> prestamos;
    
    public JavaBank(){
        prestamos = new ArrayList<>();
    }
    
    public boolean adicionarCliente(String tipo)throws InvalidTypeException{
        Scanner lea = new Scanner(System.in);
        
        String cliente = lea.next();
        double monto =  lea.nextDouble();
        int cant = lea.nextInt();
        
        if( tipo.equals("VIVIENDA") ){
            boolean ub = lea.nextBoolean();
            prestamos.add(new PrestamoVivienda(cliente,monto,cant,ub));
            return true;
        }
        else if(tipo.equals("AUTO")){
            prestamos.add(new PrestamoAuto(cliente,monto,cant));
            return true;
        }
        else{
            throw new InvalidTypeException(tipo);
        }
        
    } 
    
    public double montoTotalPendiente(String nombre){
        for(Prestamo pres : prestamos){
            if(pres.cliente.equals(nombre)){
                return ((IPrestamo)pres).saldoPendiente();
            }
        }
        System.out.println("NO SE ENCONTRO");
        return 0;
    }
    
    public void imprimir(){
        imprimir(0);
    }

    private void imprimir(int pos) {
        if( pos < prestamos.size()){
            prestamos.get(pos).imprimir();
            imprimir(pos+1);
        }
    }
    
    public void test(){
        try{
            adicionarCliente("VIVIENDA");
            System.out.println("Pendiente: " + montoTotalPendiente("Patito"));
            imprimir();
        }
        catch(Exception e){
            
        }
    }
    
    
}

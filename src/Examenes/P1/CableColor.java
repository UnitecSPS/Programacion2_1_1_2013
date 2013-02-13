/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P1;

import Examenes.P1.InternetService.AnchoBanda;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gotcha
 */
public class CableColor {
    private static ArrayList<Servicio> servicios;
    
    public static void main(String[] args) {
        servicios = new ArrayList<>();
        
        ImprimirServicios();
        agregarServicio("TV");
        
        boolean b = buscarCanalEnServicio(0, "HBO");
    }

    private static void ImprimirServicios() {
        ImprimirServicios(0,0,0);
    }

    private static void ImprimirServicios(int pos, int ctv, int ci) {
        if( pos < servicios.size() ){
            servicios.get(pos).imprimir();
            
            if( servicios.get(pos) instanceof TVService )
                ImprimirServicios(pos + 1, ctv + 1 , ci);
            else
                ImprimirServicios(pos + 1, ctv, ci + 1);
        }
        else{
            System.out.println("TV services: " + ctv);
            System.out.println("Internet Services: " + ci);
        }
    }

    private static void agregarServicio(String type) {
        Scanner lea = new Scanner(System.in);
        
        int cod = lea.nextInt();
        String n = lea.next();
        
        if( type.equals("TV") ){
            int cant = lea.nextInt();
            boolean id = lea.nextBoolean();
            
            servicios.add( new TVService(cod, n, cant, id)  );
        }
        else{
            AnchoBanda ab = AnchoBanda.valueOf(lea.next());
            
            servicios.add( new InternetService(cod, n, ab) );
        }
    }

    private static boolean buscarCanalEnServicio(int cod, String canal) {
        for(Servicio serv : servicios ){
            if( serv.codigo == cod && serv instanceof TVService ){
                return ((TVService)serv).buscar(canal);
            }
        }
        return false;
    }
    
    private static double pagarServicios(int cod){
        for(Servicio serv: servicios ){
            if( serv.codigo == cod )
                return serv.getMontoMensual();
        }
        return 0;
    }
    
}

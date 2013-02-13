/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P1;

import java.util.Calendar;

/**
 *
 * @author Gotcha
 */
public class FOD {
    public static void main(String[] args) {
        int num = CalendarOptions.MILLISECOND.ordinal();
        
        System.out.println("Ordinal de Month: " + num);
        
        Servicio serv = new Servicio(1,"Miguel"){
            public void help(){
                System.out.println("CALL 1-800-223-3239");
            }
            
            @Override
            public double getMontoMensual(){
                help();
                return 20.99;
            }
        };
        
        serv.imprimir();
        
        System.out.println("Monto: " + serv.getMontoMensual());
        
        Calendar cal = Calendar.getInstance();
        cal.set(1982, Calendar.AUGUST, 10);
        int day = cal.get(Calendar.DATE);
        cal.add(Calendar.DATE, 1);

        System.out.println("DIA DEL ANIO: " + day);
        
        System.out.println("FECHA: " + cal.getTime());
        
        System.out.println("Class: " + cal.getClass());
        
        Calendar ca2 = new Calendar() {

            @Override
            protected void computeTime() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            protected void computeFields() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void add(int field, int amount) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void roll(int field, boolean up) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int getMinimum(int field) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int getMaximum(int field) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int getGreatestMinimum(int field) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public int getLeastMaximum(int field) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
       
    }
}

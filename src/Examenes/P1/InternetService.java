/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P1;

/**
 *
 * @author Gotcha
 */
public class InternetService extends Servicio {
    public enum AnchoBanda{ 
        AB_256(150), AB_512(300), AB_1(600), AB_2(1000);
        
        int monto;
        
        AnchoBanda(int m){
            monto = m;
        }
        
        public int getMonto(){
            return monto;
        }
    }
    
    private AnchoBanda ab;
    
    public InternetService(int c, String n, AnchoBanda a){
        super(c,n);
        ab = a;
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Ancho Banda: " + ab);
    }
    
    @Override
    public double getMontoMensual(){
        return ab.getMonto();
    }
}

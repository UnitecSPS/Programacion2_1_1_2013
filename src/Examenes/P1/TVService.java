/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examenes.P1;

/**
 *
 * @author Gotcha
 */
public class TVService extends Servicio{
    private String canales[];
    private boolean esDigital;
    
    public TVService(int c, String n, int cant, boolean ed){
        super(c,n);
        canales = new String[cant];
        esDigital = ed;
    }
    
    public boolean buscar(String canal){
        return buscar(canal,0);
    }

    private boolean buscar(String canal, int pos) {
        if( pos < canales.length ){
            if( canales[pos].equals(canal) )
                return true;
            return buscar(canal, pos + 1 );
        }
        return false;
    }
    
    @Override
    public double getMontoMensual(){
        return (5 * canales.length ) + ( esDigital ? 5 : 0);
    }
    
    @Override
    public void imprimir(){
        super.imprimir();
        
        for(String c : canales)
            System.out.println("canal: " + c);
        
        System.out.println("EsDigital: " + esDigital);
    }
}

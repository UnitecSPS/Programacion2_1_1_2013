/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Gotcha
 */
public class ColeccionString extends Coleccion implements Comparable {

    @Override
    public void add(Object val) {
        if( val instanceof String){
            valores.add(val);
        }
    }

    @Override
    public boolean contain(Object val) {
        if( val instanceof String ){
            /*for(Object obj : valores){
                if( obj.equals(val) )
                    return true;
            }*/
            return valores.contains(val);
        }
        return false;
    }
    
}

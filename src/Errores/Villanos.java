/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class Villanos {
    Joker guazon = new Joker() ;
    int cantidad;
    
    public void maldad(boolean heroe){
        guazon.atraco(heroe);
        System.out.println("SEGUI WOJOOO");
    }
    
    public void setCrimenes(int cant)throws NoNumberException{
        if( cant <= 0 )
            throw new NoNumberException();
        cantidad+= cant;
    }
}

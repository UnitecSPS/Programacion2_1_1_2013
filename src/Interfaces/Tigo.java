/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public class Tigo {
    public static void main(String[] args) {
        
        SmartDevice sp = new PS3();
        
        sp.verCorreo();
        sp.runApp();
        
        if( sp instanceof BlackBerry &&
            sp instanceof SmartDevice &&
            sp instanceof CellPhone){
            
            System.out.println("SI SOY TODO ESO!");
        }
        
    }
}

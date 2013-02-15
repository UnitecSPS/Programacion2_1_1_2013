/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public interface SmartDevice {
    
    int version = 999;
    
    void verCorreo();
    String getIP();
    String[] wifiAvailables();
    void runApp();
}

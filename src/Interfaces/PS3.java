/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public class PS3 implements SmartDevice, MultiplayerGame {

    @Override
    public void verCorreo() {
        System.out.println("Loading PSN Mail");
    }

    @Override
    public String getIP() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] wifiAvailables() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void runApp() {
        System.out.println("Loading PSN");
    }

    @Override
    public void username() {
        System.out.println("gotchahn");
    }

    @Override
    public int maxusers() {
        return 5;
    }
    
}

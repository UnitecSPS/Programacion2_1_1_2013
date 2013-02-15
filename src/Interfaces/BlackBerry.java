/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public class BlackBerry extends CellPhone implements SmartDevice {

    private int bbPin;
    
    public BlackBerry(int s, int n, String u, int bbp){
        super(s,n,u);
        bbPin = bbp;
    }

    public int getBbPin() {
        return bbPin;
    }
    
    @Override
    public void mandarMsg(String msg) {
        System.out.println(msg + " please wait...." );
    }

    @Override
    public void llamar(int numDestino) {
        System.out.println("Calling .. " + numDestino + 
                " please restart!");
    }

    @Override
    public void verCorreo() {
        System.out.println("Loading gmail.com");
    }

    @Override
    public String getIP() {
        return "192.67.34.12";
    }

    @Override
    public String[] wifiAvailables() {
        String wifis[] = { "none" };
        return wifis;
    }

    @Override
    public void runApp() {
        System.out.println("Loading BBM");
    }
    
}

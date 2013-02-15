/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Gotcha
 */
public class iPhone extends CellPhone implements SmartDevice{
    
    public iPhone(int s, int n, String u){
        super(s, n, u);
    }

    @Override
    public void mandarMsg(String msg) {
        System.out.println(msg + " Sent from IPhone");
    }

    @Override
    public void llamar(int numDestino) {
        System.out.println("CLIRIN CLIRIN iLlamada");
    }

    @Override
    public void verCorreo() {
        System.out.println("Using iMail");
    }

    @Override
    public String getIP() {
        return "192.168.9.23";
    }

    @Override
    public String[] wifiAvailables() {
        String wifis[] = { "patitoWifi", "Unitec03", "El Papi Chulo" };
        return wifis;
    }

    @Override
    public void runApp() {
        System.out.println("Loading AppStore");
    }
}

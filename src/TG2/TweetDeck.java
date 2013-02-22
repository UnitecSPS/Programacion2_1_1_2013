/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gotcha
 */
public class TweetDeck implements MantenimientoSocial {

    private ArrayList<SocialClass> redes = new ArrayList<>();
    
    @Override
    public boolean agregarCuenta(String username, String tipo, Date fecha) {
        if( !buscar(username) ){
            if( tipo.toUpperCase().equals("FACEBOOK")){
                redes.add(new Facebook(username, fecha));
   
            }
            else if(tipo.toUpperCase().equals("TWITTER")){
                redes.add(new Twitter(username, fecha));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean agregarAmigo(String user1, String user2) {
        if( buscar(user1) && buscar(user2) ){
            SocialClass s1 = getSocialClass(user1);
            SocialClass s2 = getSocialClass(user2); 
            
            if( s1 instanceof Facebook && s2 instanceof Facebook ){
                s1.addFriend(s2.username);
                s2.addFriend(s1.username);
                return true;
            }
            else if(s1 instanceof Twitter && s2 instanceof Twitter){
                s1.addFriend(s2.username);
                return true;
            }
            else{
                System.out.println("NO SON DEL MISMO TIPO");
            }
        }
        return false;
    }

    @Override
    public boolean agregarComentario(String user1, int postid, String comment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean buscar(String username) {
        for(SocialClass sc : redes){
            if( sc.username.equals(username))
                return true;
        }
        return false;
    }
    
    public SocialClass getSocialClass(String username){
        for(SocialClass sc : redes){
            if( sc.username.equals(username))
                return sc;
        }
        return null;
    }

    @Override
    public boolean agregarPost(String user, String post) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[][] getTablaUsuario() {
        Object tabla[][] = new Object[redes.size()][4];
        
        for(int sc = 0; sc < redes.size(); sc++){
            SocialClass user = redes.get(sc);
            
            //username
            tabla[sc][0] = user.username;
            //fecha
            tabla[sc][1] = user.nacimiento;
            //edad
            tabla[sc][2] = user.getEdad();
            //mayor
            tabla[sc][3] = user.esMayorEdad();
        }
        
        return tabla;
    }

    @Override
    public String[] getUserCampos() {
        String columnas[] = { "Usuario", "Nacimiento", "Edad","Mayor" };
        return columnas;
    }
    
}

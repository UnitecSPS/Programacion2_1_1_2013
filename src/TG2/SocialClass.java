/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class SocialClass {
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String username;
    protected Date nacimiento;
    
    public SocialClass(String username, Date fecha){
        this.username = username;
        friends = new ArrayList<>();
        posts = new ArrayList<>();
        nacimiento = fecha;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    public boolean esMayorEdad(){
        return getEdad() >= 18;
    }
    
    public int getEdad(){
        Calendar now = Calendar.getInstance();
        int ahorita = now.get(Calendar.YEAR);
        
        if( nacimiento != null ){
            Calendar nac = Calendar.getInstance();
            nac.setTime(nacimiento);
            
            int naci = nac.get(Calendar.YEAR);
            
            return ahorita - naci;
        }
        return 0;
    }
    
    public final void addFriend(String user){
        //si el arreglo tiene ese amigo o si es a el mismo!
        if( friends.contains(user) || user.equals(username)){
            return;
        }
        friends.add(user);
        
        //----NO NECESARIO-----------
        System.out.printf("Agregado %s a la cuenta de %s de tipo %s\n\n"
                ,user,username,this.getClass().toString());
        //geClass() retornar el nombre de la clase con que fue instanciado.       
    }
    
    public abstract void viewMyInfo();
    
    public void crearPost(String message){
        posts.add(message);
    }
}

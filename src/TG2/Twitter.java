/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.Date;

public class Twitter extends SocialClass{

    public Twitter(String username, Date fecha){
        super(username, fecha);
    }
    
    @Override
    public void viewMyInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("POSTS:");
        for(String s: posts){
            System.out.println(s);
        }
    }
    
}

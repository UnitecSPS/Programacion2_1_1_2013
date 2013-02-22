/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class UberSocial {
    private static ArrayList<SocialClass> redes;
    private static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        redes = new ArrayList<>();
        int op=7;
        
        do{
            System.out.println("1- Agregar Cuenta");
            System.out.println("2- Agragar Amigo");
            System.out.println("3- Agregar Post (No estaba en el examen)");
            System.out.println("4- Agregar Comentario");
            System.out.println("5- Ver Info");
            System.out.println("6- Salir");
            System.out.print("Escoja Opcion: ");
  
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        agregarCuenta();
                        break;
                    case 2:
                        agregarAmigo();
                        break;
                    case 3:
                        agregarPost();
                        break;
                    case 4:
                        agregarComentario();
                        break;
                    case 5:
                        verUserInfo();
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }while(op != 6);
    }
        
    public static void agregarCuenta(){
        System.out.println("Ingrese el nombre de usuario");
        String user = lea.next();
        System.out.println("Ingrese el tipo de cuenta. FACEBOOK/TWITTER");
        String tipo = lea.next();

        SocialClass sc = buscarCuenta(user);
        
        if( sc == null){//quiere decir que no se encontro
            if( tipo.toUpperCase().equals("FACEBOOK")){
                redes.add(new Facebook(user, new Date()));
            }
            else if(tipo.toUpperCase().equals("TWITTER")){
                redes.add(new Twitter(user,new Date()));
            }
        }
        else
            System.out.println("USUARIO YA EXISTE");       
    }
    
    public static void agregarAmigo(){
        System.out.println("Ingrese ID de usuario");
        int user1 = lea.nextInt();
        System.out.println("Ingrese ID de usuario del amigo");
        int user2 = lea.nextInt();
        
        if( user1 >= 0 && user1 < redes.size() 
                && user2 >0 && user2 < redes.size()){
            
            SocialClass s1 = redes.get(user1);
            SocialClass s2 = redes.get(user2);
            
            if( s1 instanceof Facebook && s2 instanceof Facebook ){
                s1.addFriend(s2.username);
                s2.addFriend(s1.username);
            }
            else if(s1 instanceof Twitter && s2 instanceof Twitter){
                s1.addFriend(s2.username);
            }
            else{
                System.out.println("NO SON DEL MISMO TIPO");
            }
        }
        
    }
    
    public static void agregarComentario(){
        System.out.print("Ingrese el Facebook username del duenio del post");
        String user = lea.next();
        SocialClass sc = buscarCuenta(user);
        
        if( sc instanceof Facebook ){
            System.out.println("ID Post: ");
            int postid = lea.nextInt();
            System.out.println("Mensaje: ");
            String m = lea.next();
            
            ((Facebook)sc).addComment(postid, m);
        }
        else
            System.out.println("NO SE ENCONTRO EL USUARIO");
    }
    
    private static SocialClass buscarCuenta(String username) {
        
        for(SocialClass s: redes){
            if(s.username.equals(username))
                return s;
        }
        return null;
    }

    private static void agregarPost() {
        System.out.print("Ingrese el username: ");
        String user = lea.next();
        
        //al primero que encontremos
        for(SocialClass sc : redes){
            if( sc.username.equals(user)){
                System.out.println("Mensaje de Post: ");
           
                sc.crearPost(lea.next());
            }
        }
    }
    
    public static void verUserInfo(){
        System.out.print("Ingrese el username: ");
        String user = lea.next();

        //al primero que encontremos
        for(SocialClass sc : redes){
            if( sc.username.equals(user)){
                sc.viewMyInfo();
            }
        }
    }
}
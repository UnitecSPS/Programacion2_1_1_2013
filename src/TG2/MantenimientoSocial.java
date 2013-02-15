/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG2;

/**
 *
 * @author Gotcha
 */
public interface MantenimientoSocial {
    boolean agregarCuenta(String username, String tipo);
    boolean agregarAmigo(String user1, String user2);
    boolean agregarComentario(String user1, int postid, String comment);
    boolean buscar(String username);
    boolean agregarPost(String user, String post);
}

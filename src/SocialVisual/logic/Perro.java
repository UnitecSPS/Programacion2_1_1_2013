/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialVisual.logic;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Gotcha
 */
public class Perro extends Animal{
    public Perro(){
        super("perro.jpg");
    }

    @Override
    public void comoHabla() {
        JOptionPane.showMessageDialog(null, "guau guau");
    }
    
    
}

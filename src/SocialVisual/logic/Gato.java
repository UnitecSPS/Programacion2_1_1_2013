/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialVisual.logic;

import javax.swing.JOptionPane;

/**
 *
 * @author Gotcha
 */
public class Gato extends Animal{
    public Gato(){
        super("gato.jpg");
    }

    @Override
    public void comoHabla() {
        JOptionPane.showMessageDialog(null, "Miau Miau");
    }
}

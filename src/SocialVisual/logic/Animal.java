/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialVisual.logic;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gotcha
 */
public abstract class Animal extends JLabel {
    
    public Animal(String picName){
        super(new ImageIcon(picName));
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comoHabla();
            }
        });
    }
    
    public abstract void comoHabla();
}

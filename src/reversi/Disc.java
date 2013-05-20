/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author marta
 */

public class Disc {
    
    private boolean black = false;

    
    public Disc(boolean black) {
        this.black = black;
    }
    
    public boolean isBlack() {
        return black;
    }
    
    public void flip() {
        black = !black;
    }
        /*
     */
}

        
    




    


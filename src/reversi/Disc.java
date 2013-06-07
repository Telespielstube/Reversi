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
    
    /* The method isBlack holds the value of the current disc color. Which also means
     * the current players turn.
     * 
     * @return black    returns a boolean value if true, it is black's turn if not
     *                  it is white's turn.
     */
    public boolean isBlack() {
        return black;
    }
    
    /* This method flips all black discs to white and vice versa. Depending on which
     * players turn it is.
     * 
     */
    public void flip() {
        black = !black;
    }
}

        
    




    


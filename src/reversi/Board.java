/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import java.awt.*;
import javax.swing.*;

/**
 *
 * @author marta
 */
public class Board {
    
    public void createBoard() {
    JFrame frame = new JFrame("Reversi");
        frame.setSize(300, 300);
        frame.setLocation(120, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 64; i++)
        {
            JButton feld = new JButton();
            feld.setBackground(Color.GRAY);
            frame.add(feld);
        }
        frame.setVisible(true);
    }
}
    

 
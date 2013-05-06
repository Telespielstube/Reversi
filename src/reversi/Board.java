/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author marta
 */
public class Board {
    
    public Board() {
    }
    
    public void CreateBoard(int value) {
    JFrame frame = new JFrame("Reversi");
    JButton button = null;
        frame.setSize(500, 500);
        frame.setLocation(500, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(value, value));

        for (int i = 0; i < value * value; i++)
        {
            button = new JButton();
            button.setBackground(Color.LIGHT_GRAY);
            button.addActionListener(new PutDisc());
            frame.add(button);
        }
        frame.setVisible(true);
    }
    class PutDisc implements ActionListener {
        Disc disc = new Disc();
        public void actionPerformed(ActionEvent event) {
        }
    }
}
    

 
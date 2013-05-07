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
public class Board extends JFrame {
    
    public Board() {
    }
    
    private JButton button ;
    
    public void CreateBoard(int value) {
        setSize(500, 500);
        setLocation(500, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(value, value));

        for (int i = 0; i < value * value; i++)
        {
            button = new JButton();
            button.setBackground(Color.LIGHT_GRAY);
            button.addActionListener(new PutDisc());
            add(button);
        }
        setVisible(true);
    }
    class PutDisc implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        }
    }
     
  
}
    

 
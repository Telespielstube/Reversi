/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author marta
 */
public class GUI extends JFrame {
    
    public GUI(){
        setLocation(500, 300);
        setSize(550, 300);
        setVisible(true);
    }
    
    private JPanel panel;
    private JPanel buttonPanel;
    private JLabel label;
    private JButton button;
    private JMenuBar menuBar;
    private JMenu menuBoard;
    private JMenuItem small;
    private JMenuItem medium;
    private JMenuItem large;
    
    public void createGui() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
        menuBar = new JMenuBar();
        menuBoard = new JMenu("Board Size");
        small = new JMenuItem("Small");
        medium = new JMenuItem("Medium");
        large = new JMenuItem("Large");
        small.addActionListener(new smallBoard());
        medium.addActionListener(new mediumBoard());
        large.addActionListener(new largeBoard());
        menuBar.add(menuBoard);
        menuBoard.add(small);
        menuBoard.add(medium);
        menuBoard.add(large);
              
        panel = new JPanel();
        buttonPanel = new JPanel();
        label = new JLabel();
        button = new JButton("OK");
        button.addActionListener(new okButton());         
        label.setText("<html><center><b>Reversi</b><p/><p/><p/>"
                      + "Welcome to the famous boardgame Reversi.<p/>"
                      + "You need to choose the size of the board in the menu."
                      + "</center></html>");
        panel.add(BorderLayout.CENTER, label);
        buttonPanel.add(BorderLayout.SOUTH, button);
        button.setPreferredSize(new Dimension(80, 40));
        
        add(BorderLayout.SOUTH, buttonPanel);
        add(panel);
     
    }
    
    class okButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("");
        }
    }
    
    class smallBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.createBoard(8);
        }
    }
    
    class mediumBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.createBoard(9);
        }
    }
    
    class largeBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.createBoard(10);
        }
    }
}

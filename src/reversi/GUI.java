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
    
    public GUI(){}
    
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
        small.addActionListener(new SmallBoard());
        medium.addActionListener(new MediumBoard());
        large.addActionListener(new LargeBoard());
        menuBar.add(menuBoard);
        menuBoard.add(small);
        menuBoard.add(medium);
        menuBoard.add(large);
              
        panel = new JPanel();
        buttonPanel = new JPanel();
        label = new JLabel();
        button = new JButton("OK");
        button.addActionListener(new OKButton());         
        label.setText("<html><center><b>Reversi</b><p/><p/><p/>"
                      + "Welcome to the famous boardgame Reversi.<p/>"
                      + "You need to choose the size of the board in the menu."
                      + "</center></html>");
        panel.add(BorderLayout.CENTER, label);
        buttonPanel.add(BorderLayout.SOUTH, button);
        button.setPreferredSize(new Dimension(80, 40));
        
        add(BorderLayout.SOUTH, buttonPanel);
        setJMenuBar(menuBar);
        add(panel);
        setLocation(500, 300);
        setSize(550, 300);
        setVisible(true);
    }
    
    class OKButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("");
        }
    }
    
    class SmallBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(8);
        }
    }
    
    class MediumBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(9);
        }
    }
    
    class LargeBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(10);
        }
    }
}

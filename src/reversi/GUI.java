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
public class GUI {
    
    public GUI(){}
    
        JFrame frame;
        JLabel label;
    
    public void createGui() {
        frame = new JFrame("Reversi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
        JMenuBar menuBar = new JMenuBar();
        JMenu menuBoard = new JMenu("Board Size");
        JMenuItem small = new JMenuItem("Small");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem large = new JMenuItem("Large");
        menuBar.add(menuBoard);
        menuBoard.add(small);
        menuBoard.add(medium);
        menuBoard.add(large);
        small.addActionListener(new SmallBoard());
        medium.addActionListener(new MediumBoard());
        large.addActionListener(new LargeBoard());
        
        JPanel panel = new JPanel();
        JPanel buttonPanel = new JPanel();
        label = new JLabel();
        JButton button = new JButton("OK");
        button.addActionListener(new OKButton());         
        label.setText("<html><center><b>Reversi</b><p/><p/><p/>"
                      + "Welcome to the famous boardgame Reversi.<p/>"
                      + "You need to choose the size of the board in the menu."
                      + "</center></html>");
        panel.add(BorderLayout.CENTER, label);
        buttonPanel.add(BorderLayout.SOUTH, button);
        button.setPreferredSize(new Dimension(80, 40));
        
        frame.add(BorderLayout.SOUTH, buttonPanel);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setLocation(500, 300);
        frame.setSize(550, 300);
        frame.setVisible(true);
    }
    
    class OKButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("");
        }
    }
    
    class SmallBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(6);
        }
    }
    
    class MediumBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(8);
        }
    }
    
    class LargeBoard implements ActionListener {
        Board board = new Board();
        public void actionPerformed(ActionEvent event) {
            board.CreateBoard(10);
        }
    }
}

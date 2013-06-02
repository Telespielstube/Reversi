/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.*;

/**
 *
 * @author marta
 */
public class GUI extends JFrame implements ActionListener{
    private Board board;
    private Game game;
    private Disc disc;
    private JMenuBar menuBar;
    private JMenu menuBoardSize;
    private JMenuItem size6;
    private JMenuItem size8;
    private JMenuItem size10;
    private JLabel player1;
    private JLabel score1;
    private JLabel player2;
    private JLabel score2;
    private JPanel layout;
    private JPanel actionPanel;
    private JPanel playerPanel;
    private ReversiButton[][] field;
    private Disc currentDisc;
 
    public GUI(){     
        setTitle("Reversi");
        setLocation(500, 300);
        setSize(650, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 /*       
        menuBar = new JMenuBar();
        menuBoardSize = new JMenu("Board size");
        size6 = new JMenuItem("Size 6x6");
        size8 = new JMenuItem("Size 8x8");
        size10 = new JMenuItem("Size 10x10");
        menuBar.add(menuBoardSize);
        menuBoardSize.add(size6);
        size6.setActionCommand("6");
        size6.addActionListener(new BoardSize());
        menuBoardSize.add(size8);
        size8.setActionCommand("8");
        size8.addActionListener(new BoardSize());
        menuBoardSize.add(size10);
        size10.setActionCommand("10");
        size10.addActionListener(new BoardSize());
        setJMenuBar(menuBar);
        */
        playerPanel = new JPanel();
        board = new Board(8);
        board.startSetup();
        game = new Game(board);
        field = new ReversiButton[8][8];
    }
    
    public void GuiStartSetup() {        
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout grid = new GridLayout(8, 8);      
        actionPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, actionPanel); 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {         
                field[j][i] = new ReversiButton(j, i);
                field[j][i].setBackground(new Color(255, 255, 150));
                field[j][i].setSelected(false);
                currentDisc = board.getDiscAt(j, i);
                if (currentDisc != null) {
                    if (currentDisc.isBlack())
                        field[j][i].setIcon(new ImageIcon("pics/coinBlue.gif"));
                    else
                        field[j][i].setIcon(new ImageIcon("pics/coinRed.gif"));
                }
	        field[j][i].addActionListener(this);
                actionPanel.add(field[j][i]); 
            }
         } 
         player1 = new JLabel("Player 1: ");  
         score1= new JLabel(String.valueOf(board.getBlackScore()));
         player2 = new JLabel("Player 2: ");
         score2= new JLabel(String.valueOf(board.getWhiteScore()));
         playerPanel.add(player1);
         playerPanel.add(score1);
         playerPanel.add(player2);
         playerPanel.add(score2);
         playerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         background.add(BorderLayout.EAST, playerPanel);
         playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS)); 
         getContentPane().add(background);         
    }

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                currentDisc = board.getDiscAt(j, i);
                if (currentDisc != null) {
                    if (currentDisc.isBlack())
                        field[j][i].setIcon(new ImageIcon("pics/coinBlue.gif"));
                    else
                        field[j][i].setIcon(new ImageIcon("pics/coinRed.gif"));
                }    
            }
        }
        
        score1.setText(String.valueOf(board.getBlackScore()));
        score2.setText(String.valueOf(board.getWhiteScore()));

    }
    
    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() instanceof ReversiButton) {
            ReversiButton button = (ReversiButton) event.getSource();
            if (game.setDisc(button.getBoardX(), button.getBoardY()) == true ) 
                updateBoard();
            else
                JOptionPane.showMessageDialog(this, "Invalid Move\n\n Try Again!!!");
            }    
        }
    }
}

      


              



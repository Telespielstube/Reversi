
package reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author marta
 */
public class GUI extends JFrame implements ActionListener, BoardEventListener{
    private Board board;
    private Game game;
    private Disc disc;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem exit;
    private JMenu menuBoardSize;
    private JMenuItem size6;
    private JMenuItem size8;
    private JMenuItem size10;
    private JMenu help;
    private JMenuItem manual;
    private JMenuItem gameHelp;
    private JLabel player1;
    private JLabel score1;
    private JLabel player2;
    private JLabel score2;
    private JButton skipTurn;
    private JPanel background;
    private JPanel layout;
    private JPanel actionPanel;
    private JPanel playerPanel;
    private ReversiButton[][] field;
    private Disc currentDisc;
    private GridLayout grid;
    
    /* The GUI contructor.
     * 
     */
    public GUI(){     
        setTitle("Reversi");
        setLocation(450, 200);
        setSize(650, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        exit = new JMenuItem("Exit");
        menuBoardSize = new JMenu("Board size");
        size6 = new JMenuItem("Size 6x6");
        size8 = new JMenuItem("Size 8x8");
        size10 = new JMenuItem("Size 10x10");
        help = new JMenu("Help");
        manual = new JMenuItem("Reversi Rules");
        gameHelp = new JMenuItem("Help");
        menuBar.add(menuFile);
        menuFile.add(exit);
        exit.addActionListener(new Exit());
        menuBar.add(menuBoardSize);
        menuBoardSize.add(size6);
        BoardSizeListener sizeListener = new BoardSizeListener();
        size6.setActionCommand("6");
        size6.addActionListener(sizeListener);
        menuBoardSize.add(size8);
        size8.setActionCommand("8");
        size8.addActionListener(sizeListener);
        menuBoardSize.add(size10);
        size10.setActionCommand("10");
        size10.addActionListener(sizeListener);
        menuBar.add(help);
        help.add(manual);
        help.add(gameHelp);
        manual.addActionListener(new ReversiRules());
        gameHelp.addActionListener(new InGameHelp());
        setJMenuBar(menuBar);
        board = new Board(8);
        board.startSetup();
        game = new Game(board);
    }
    
    /*This method creates the rest of the graphical interface on screen.
     * 
     */
    public void guiStartSetup() {        
        BorderLayout layout = new BorderLayout();
        background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        grid = new GridLayout(board.getSize(), board.getSize());              
        player1 = new JLabel("Player 1: ");
        player1.setIcon(new ImageIcon("pics/coinBlackSmall.gif"));
        score1 = new JLabel(String.valueOf(board.getBlackScore()));
        player2 = new JLabel("Player 2: ");
        player2.setIcon(new ImageIcon("pics/coinWhiteSmall.gif"));
        score2 = new JLabel(String.valueOf(board.getWhiteScore()));
        skipTurn = new JButton("Skip Turn");
        skipTurn.addActionListener(new SkipButton());
        initActionPanel();
        playerPanel = new JPanel();

        playerPanel.add(player1);
        playerPanel.add(score1);
        playerPanel.add(player2);
        playerPanel.add(score2);
        playerPanel.add(skipTurn);
        playerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        background.add(BorderLayout.EAST, playerPanel);
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS)); 
        getContentPane().add(background);
        actionPanel.revalidate();
        actionPanel.repaint();
        board.addBoardListener(this);
    }
    
    /* This method initialises the graphical board and adds it to the already 
     * created graphical user interface.
     * 
     */
    private void initActionPanel()
    {
        field = new ReversiButton[board.getSize()][board.getSize()];
        actionPanel = new JPanel(grid);

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {         
                field[j][i] = new ReversiButton(j, i);
                field[j][i].setBackground(new Color(255, 255, 150));
                field[j][i].setSelected(false);
                currentDisc = board.getDiscAt(j, i);
                if (currentDisc != null) {
                    if (currentDisc.isBlack())
                        field[j][i].setIcon(new ImageIcon("pics/coinBlack.gif"));
                    else
                        field[j][i].setIcon(new ImageIcon("pics/coinWhite.gif"));
                }
	        field[j][i].addActionListener(this);
                actionPanel.add(field[j][i]); 
            }
         }
         background.add(BorderLayout.CENTER, actionPanel); 
    }
    
    /* This method fips the discs on the board and updates the scores after each 
     * player has set his stone.
     * 
     */
    public void updateBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                currentDisc = board.getDiscAt(j, i);
                if (currentDisc != null) {
                    if (currentDisc.isBlack())
                        field[j][i].setIcon(new ImageIcon("pics/coinBlack.gif"));
                    else
                        field[j][i].setIcon(new ImageIcon("pics/coinWhite.gif"));
                }    
            }
        }    
        score1.setText(String.valueOf(board.getBlackScore()));
        score2.setText(String.valueOf(board.getWhiteScore()));
   
    }
    
    /* The inner class SkipButton performes an action after the corresponding 
     * button was pressed.
     * 
     */
    class SkipButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            game.skipTurn();
        }
    }
    
    /* The inner class Exit leaves the application without any further check.
     * 
     */
    class Exit implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }
    
    /* This method within the inner class sets the new size of the board after 
     * the user has choosen another one in the menu bar.
     * 
     */
    class BoardSizeListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int size = Integer.parseInt(event.getActionCommand());
            board = new Board(size);
            board.startSetup();
            game = new Game(board);
            getContentPane().remove(background);
            guiStartSetup();
        }
    }
    
    /* ReversiRules shows the abridged reversi rules in a message box.
     * 
     */
    class ReversiRules implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, "This is an abridged version of the rules of Reversi \n\n"
                                              + "Reversi is a strategy board game for two players, \n"
                                              + "played on an 8×8 (6x6 or 10x10 are also possible in this game)\n"
                                              + "uncheckered board.\n"
                                              + "There are 64 identical game pieces called disks, which\n"
                                              + "are light on one side and dark on the other. Players take\n"
                                              + "turns placing discs on the board with their assigned\n"
                                              + "color facing up. During a play, any discs of the\n"
                                              + "opponent's color that are in a straight line and\n"
                                              + "bounded by the disc just placed and another disc of\n"
                                              + "the current player's color are turned over to the\n"
                                              + "current player's color. The object of the game is to \n"
                                              + "have the majority of discs turned to display your \n"
                                              + "color when the last playable empty square is filled.");
        }
    }
    
    /* This method shows the menu item description of all options in the game.
     * 
     */ 
    class InGameHelp implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, "The entire game is menu driven. Therefore all menu \n"
                                               + "options are briefly described here.\n\n"
                                               + "File\n"
                                               + "Exit:\n"
                                               + "This is the option to leave the game.\n\n"
                                               + "BoardSize\n"
                                               + "6x6:\n"
                                               + "Sets the board size to 6x6.\n"
                                               + "8x8:\n"
                                               + "Sets the board size to 8x8.\n"
                                               + "10x10:\n"
                                               + "Sets the board size to 10x10.\n\n"
                                               + "Help\n"
                                               + "Reversi Rules\n"
                                               + "Gives a short description of the game rules.\n"
                                               + "Help\n"
                                               + "This is the section you are already in.\n\n" );
        }
    }
    
    /* This method checks if the move on the board was valid. If this was not the case
     * the user gets a warning message.
     * 
     */
    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() instanceof ReversiButton) {
            ReversiButton button = (ReversiButton) event.getSource();
            if (game.setDiscVisual(button.getBoardX(), button.getBoardY()) == true ) {
                updateBoard();
                board.gameOver();
            }
        }    
    }
    /* This method triggers the winning event. Depending on the winner a message with
     * a confimration dialop pops up. The game can be continued with the default size, 
     * exited, or the dialog can be canceled, which has has the same effect as the yes 
     * button.
     * 
     */
    public void boardEventPerformed(BoardEvent event) {
        int ok = 0;
        if (event.getEventCode() == BoardEvent.INVALID_MOVE) {
            JOptionPane.showMessageDialog(null, "Invalid Move\n\n");
        } else if (event.getEventCode() == BoardEvent.GAME_OVER) { 
            if (board.getBlackScore() > board.getWhiteScore())
              JOptionPane.showMessageDialog(this, "Black has won\nStart over or try a different size.");
            if (board.getBlackScore() < board.getWhiteScore())
                JOptionPane.showMessageDialog(this, "White has won\nStart over or try a different size.");
            if (board.getBlackScore() == board.getWhiteScore())
                JOptionPane.showMessageDialog(this, "Draw\n Start over or try a different size.?");  
            } 
    }
}



      


              



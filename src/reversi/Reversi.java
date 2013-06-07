/*
 * This application is a game called Reversi or somethimes Othello. The game 
 * has a graphical interface and is controlled via the menu. The menu has the 
 * following items:
 * File: Exit
 * Board Size: 6x6, 8x8, 10x10
 * Help: Reversi Rules, Help
 * The default setting of the board is 8x8 and is shown on the left side. The player
 * section is shown right next to the board. The two players are preset and not 
 * customizable, ie player one is white and player two is black. The button 
 * below is to skip a turn in case one player is unable to make a move. After the
 * game is over and the winner is printed on screen the user is able to restart 
 * the game on the same board or choose another size.
 *
 */
package reversi;

/**
 *
 * @author marta
 */
public class Reversi {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        gui.guiStartSetup();
    }
}
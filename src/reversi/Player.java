/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import static Prog1Tools.IOTools.*;
/**
 *
 * @author marta
 */
public class Player {
    
    private Board board;
    private Disc disc;
    private boolean isBlack; 
   
    public Player(Board board, boolean isBlack) {
        this.board = board;
        this.isBlack = isBlack;
     
    }
    
    public void move() {
        int x = 0;
        int y = 0;
        x = readInteger("Enter x: ");     
        y = readInteger("Enter y: ");
        board.turnLegal(x, x, isBlack);
        board.setDisc(x, y, isBlack); 
        
    }
/*    
    public void turnWhite() {
        int x = 0;
        int y = 0;
        boolean isWhite = true;
        x = readInteger("Enter x: ");     
        y = readInteger("Enter y: ");
        board.setWhiteDisc(x, y);       
    } */ 
}

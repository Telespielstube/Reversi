/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


/**
 *
 * @author marta
 */
public class Game {
    
    private Board board;
    private boolean isBlack = false;
    
    public Game(Board board) {
       this.board = board;
    }
    
    public void reset(){
        isBlack = false; // white makes the first move.
    }
    
    public boolean setDisc(int x, int y) {
        boolean result = board.setDisc(x, y, isBlack);
        if (result == true) {
            isBlack = !isBlack;
            board.countPoint();
        }
        return result;
    }    
}


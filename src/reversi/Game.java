/*
 * The classe game contains all methods reliable to the ongoing game.
 * 
 */
package reversi;

/**
 *
 * @author marta
 */
public class Game {
    
    private Board board;
    private boolean isBlack = true;
    
    public Game(Board board) {
       this.board = board;
    }
    
    /*
     * The method setDiscVisual sets the disc on the grafical user interface board.
     * 
     * @param x         contains the x value of the turn in the matrix.
     * @param y         contains the y value of the turn in the matrix.
     * 
     * @return result   returns the x and y values as well as the color of the disc.
     * 
     */
    public boolean setDiscVisual(int x, int y) {
        boolean result = board.setDiscIntern(x, y, isBlack);
        if (result == true) {
            isBlack = !isBlack;
            board.countPoint();
        }
        return result;
    }
    
    /* SkipTurn skips the players turn in case there is now valid move to make.
     * 
     */
    public void skipTurn() {
        isBlack = !isBlack;        
    }
}


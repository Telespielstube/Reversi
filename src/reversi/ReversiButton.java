package reversi;

/*
 * This class represents the buttons on the reversi board. Each button is 
 * individually adressable.
 * 
 */
import javax.swing.JButton;
/**
 *
 * @author marta
 */
public class ReversiButton extends JButton {
    
    private int boardX;
    private int boardY;
    
    /* ReversiButton constuctor.
     * 
     */
    public ReversiButton(int x, int y) {
        this.boardX = x;
        this.boardY = y;
    }
    
    /*
     * This method gets the x value of the turn on the board.
     * 
     * @return boardX returns the x value of the turn.
     */
    public int getBoardX() {
        return boardX;
    }
    
    /* This method gets the y value of the turn on the board.
     * 
     * @return boardY returns the y value of the turn.
     */
    public int getBoardY() {
        return boardY;
    }
}

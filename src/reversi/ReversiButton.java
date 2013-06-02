package reversi;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JButton;
/**
 *
 * @author marta
 */
public class ReversiButton extends JButton {
    
    private int boardX;
    private int boardY;
   
    public ReversiButton(int x, int y) {
        this.boardX = x;
        this.boardY = y;
    }
    public int getBoardX() {
        return boardX;
    }
    public int getBoardY() {
        return boardY;
    }
}

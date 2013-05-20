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
public class Game {
    
    private Board board;
    private Player player1;
    private Player player2;
    private boolean possible = true;
    
    public Game(Board board) {
       this.board = board;
    }
    
    public void match() {
        player1 = new Player(board, true);
        player2 = new Player(board, false);
        board.countPoint();
        
        while (true) {
            player1.move();
            board.countPoint();
            board.print();           
            player2.move();
            board.countPoint();
            board.print();
       }
    }
}


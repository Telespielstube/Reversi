/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class Board {
    private ArrayList<Disc> discsToBeFlipped;
    private ArrayList<BoardEventListener> eventListenerList = new ArrayList();
    private Game game;
    private Disc disc;
    private Disc [][] matrix;
    private int boardSize;
    private int blackCount = 0;
    private int whiteCount = 0;
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.discsToBeFlipped = new ArrayList<Disc>();
    }
    
    /* The getSize method is to obtain the size of the board.
     * 
     * @return boardSize    contains the size of the reversi board.
     * 
     */
    public int getSize() {
        return boardSize;
    }
    
    /* The method pictures the board and start setup of the discs internally.
     * 
     */
    public void startSetup() {
        matrix = new Disc[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {             
                matrix[i][j] = null;                    
            }   
            System.out.printf("\n");    
        } 
        matrix[(boardSize / 2) -1][(boardSize / 2) -1] = new Disc(false);
        matrix[(boardSize / 2) -1][(boardSize / 2)] = new Disc(true);
        matrix[(boardSize / 2)][(boardSize / 2) -1] = new Disc(true);
        matrix[(boardSize / 2)][(boardSize / 2)] = new Disc(false);
        countPoint();
    }

    /* This method places the discs internally on the board. This does not make
     * the turn visible on screen.
     * 
     * @param x         contains the x value of the turn on the board.
     * @param y         contains the y value of the turn on the board.
     * @param isBlack   contains the color of the players turn.
     * 
     * @return legal    returns the value if the turn was a legal move considering the rules of reversi. 
     */
    public boolean setDiscIntern(int x, int y, boolean isBlack) {
        boolean legal = turnLegal(x, y, isBlack);
        if (!legal) {
            fireBoardEvent(BoardEvent.INVALID_MOVE);
            return false;
        }
        if (legal) { 
            if (matrix[x][y] == null) {
                matrix[x][y] = new Disc(isBlack);
            }
            for (Disc flipDisc: discsToBeFlipped) {
                flipDisc.flip();
            }
        }
        discsToBeFlipped.clear();
        
        return legal;
    }
    
    /* This method actually contains the rules of reversi. It scans all directions
     * whether the move was legal and if there are any discs to turn.
     * 
     * @param x                    contains the x value of the turn on the board.
     * @param y                    contains the y value of the turn on the board.
     * @param isBlack              contains the color of the players turn.
     * 
     * @return discsToBeFlipped    returns the value whether there are discs to flip.
     * 
     */   
    public boolean turnLegal(int x, int y, boolean isBlack) {
        if (matrix[x][y] != null)
            return false;

        ArrayList<Disc> currentDiscsToBeFlipped = new ArrayList<Disc>();

        boolean endDiscFound = false;      
        // checks left-hand(x-1) route of currently set disc
        for (int i = x-1; i >= 0; i--) {
            if (matrix[i][y] == null)
                break;
            if (matrix[i][y].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][y]);            
        }
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear();
        endDiscFound = false;

        // checks right-hand(x+1) route of currently set disc
        for (int i = x+1; i < boardSize; i++) {
            if (matrix[i][y] == null)
                break;
            if (matrix[i][y].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][y]);            
        }        
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear();        
        endDiscFound = false;
        
        // checks upper(y-1) route of currently set disc
        for (int i = y-1; i >= 0; i--) {
            if (matrix[x][i] == null)
                break;
            if (matrix[x][i].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[x][i]);            
        }
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear();
        endDiscFound = false;
        
        // checks lower(y+1) route of currently set Disc
        for (int i = y+1; i < boardSize; i++) {
            if (matrix[x][i] == null)
                break;
            if (matrix[x][i].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[x][i]);            
        }  
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear(); 
        endDiscFound = false;
         
        // checks top-left route of currently set disc
        for (int i = x-1, j = y-1; i >= 0 && j >=0; i--, j--) {
                if (matrix[i][j] == null)
                    break;
            if (matrix[i][j].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][j]); 
        } 
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear();       
        endDiscFound = false;
        
        // checks top-right route of currently set disc
        for (int i = x+1, j = y-1; i < boardSize && j >= 0; i++, j--) {
            if (matrix[i][j] == null)
                break;
            if (matrix[i][j].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][j]); 
        } 
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear(); 
        endDiscFound = false;
       
        // checks bottom-left route of currently set disc
        for (int i = x-1, j = y+1; i >= 0 && j < boardSize; i--, j++) {
                if (matrix[i][j] == null)
                    break;
            if (matrix[i][j].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][j]); 
        } 
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear(); 
        endDiscFound = false;
       
        // checks bottom-right route of currently set disc
        for (int i = x+1, j = y+1; i < boardSize && j < boardSize; i++, j++) {
                if (matrix[i][j] == null)
                    break;
            if (matrix[i][j].isBlack() == isBlack) {
                endDiscFound = true;
                break;
            }
            currentDiscsToBeFlipped.add(matrix[i][j]); 
        } 
        if (endDiscFound) {
            discsToBeFlipped.addAll(currentDiscsToBeFlipped);
        }
        currentDiscsToBeFlipped.clear(); 
       
        return !discsToBeFlipped.isEmpty();
    }
       
    /* countPoint sums up the discs for the white player and the black player.
     * 
     */
    public void countPoint() {  
        blackCount = 0;
        whiteCount = 0;
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (matrix[i][j] != null){ 
                    if(matrix[i][j].isBlack()) {
                        blackCount++;
                    }
                    else {
                        whiteCount++;
                    }
                }
            }
        }
   
    }
    
    public Disc getDiscAt(int x, int y) {
        return matrix[x][y];
    }
    
    /* getBlackScore retrieves the total score for the black player.
     * 
     */
    public int getBlackScore() {
        return blackCount;
    }

    /* getWhiteScore retrieves the total score for the white player.
     * 
     */
    public int getWhiteScore() {
        return whiteCount;
    }
       
    public void addBoardListener(BoardEventListener eventListener) {
        eventListenerList.add(eventListener);
    }
    
    private void fireBoardEvent(int eventCode) {
        BoardEvent event = new BoardEvent(this, eventCode);
        for (int i = 0; i < eventListenerList.size(); i++) {
            eventListenerList.get(i).boardEventPerformed(event);
        }
    }
    /* This method checks if the game is over by checking the number of discs on the board 
     * and compares them to the boardsize.
     * 
     * @return gameOver     returns the value if the game is over.
     * 
     */
    public boolean gameOver() {
        boolean gameOver = false;
        int squareBoard = boardSize * boardSize;
        int sumOfDiscs = blackCount + whiteCount;
        
        if (sumOfDiscs < boardSize - 4)
            gameOver = false;
        else if (blackCount > whiteCount && sumOfDiscs == squareBoard || whiteCount == 0) {
            gameOver = true;
        } 
        else if (blackCount < whiteCount && sumOfDiscs == squareBoard || blackCount == 0) {
            gameOver = true;
        }
        else if (blackCount == whiteCount && sumOfDiscs == squareBoard) {
            gameOver = true;
        }
        if (gameOver == true) {
            fireBoardEvent(BoardEvent.GAME_OVER);
        }
        return gameOver;
    }
}
    
    

    
   
    

 
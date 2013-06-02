/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author marta
 */
public class Board {
    private ArrayList<Disc> discsToBeFlipped;
    private int boardSize;
    private Disc disc;
    private int blackCount = 0;
    private int whiteCount = 0;
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.discsToBeFlipped = new ArrayList<Disc>();
    }
    
    private Disc [][] matrix;
    
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

    public boolean setDisc(int x, int y, boolean isBlack) {
        boolean legal = turnLegal(x, y, isBlack);

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
        endDiscFound = false;
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
        
        // checks top-right route of currently set disc
        endDiscFound = false;
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
       
        // checks bottom-left route of currently set disc
        endDiscFound = false;
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
       
        // checks bottom-right route of currently set disc
        endDiscFound = false;
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
    
    public int getBlackScore() {
        return blackCount;
    }

    public int getWhiteScore() {
        return whiteCount;
    }
        
    public boolean gameOver() {
        boolean gameOver = false;
        int sumOfDiscs = 0;
        
        sumOfDiscs = blackCount + whiteCount;
        if (sumOfDiscs < this.boardSize - 4)
            gameOver = false;
        if (blackCount > whiteCount && sumOfDiscs == this.boardSize || whiteCount == 0) {
            System.out.println("Player X is the winner with " + blackCount + " Discs on the board"); 
            gameOver = true;
        } 
        else if (blackCount < whiteCount && sumOfDiscs == this.boardSize || blackCount == 0) {
            System.out.println("Player X is the winner with " + blackCount + " Discs on the board");
            gameOver = true;
        }
        return gameOver;
    }
}
    
    

    
   
    

 
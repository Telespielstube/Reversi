/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author marta
 */
public class Board extends JFrame {
    
    private int boardSize;
    private Player player;
    private int blackCount = 0;
    private int whiteCount = 0;
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
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
        if (boardSize == 6) {
            matrix[2][2] = new Disc(false);
            matrix[2][3] = new Disc(true);
            matrix[3][2] = new Disc(true);
            matrix[3][3] = new Disc(false);
        }
        if (boardSize == 8) {
            matrix[3][3] = new Disc(false);
            matrix[3][4] = new Disc(true);
            matrix[4][3] = new Disc(true);
            matrix[4][4] = new Disc(false);
        }
        if (boardSize == 10) {
            matrix[4][4] = new Disc(false);
            matrix[4][5] = new Disc(true);
            matrix[5][4] = new Disc(true);
            matrix[5][5] = new Disc(false);
        }
    }
    
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null) 
                    System.out.printf(" - "); 
                else if (matrix[i][j].isBlack())
                    System.out.printf(" X "); 
                else 
                    System.out.printf(" O "); 
            }
        System.out.println();
        }
        countPoint();
        System.out.printf("Player 1: %2d\n", blackCount);
        System.out.printf("Player 2: %2d\n", whiteCount);
    }
    
    public void setDisc(int x, int y, boolean isBlack) {
        if (matrix[x][y] == null) {
            matrix[x][y] = new Disc(isBlack);
        }
    }
    
    public boolean turnLegal(int x, int y, boolean isBlack) {
        boolean legal = true;
        if (matrix[x][y] != null || matrix[]) {
            System.out.println("Invalid move");
            legal = false;
        } else {
            legal = true;
        }
        return legal;
    }
    public void countPoint() {  
        blackCount = 0;
        whiteCount = 0;
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (matrix[i][j] != null){ 
                    if(matrix[i][j].isBlack()) {
                        blackCount++;
                    } else {
                        whiteCount++;
                    }
                }
            }
        }
    }
}
    
    

    
   
    

 
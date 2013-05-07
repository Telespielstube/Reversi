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
    
    private int [][] matrix;
    
    public int[][] StartSetup(int boardSize) {
        matrix = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {             
                matrix[i][j] = 0;                    
                System.out.printf("%3d", matrix[i][j]);
            }   
            System.out.printf("\n");    
        }
        return matrix;
    }
    
}
    


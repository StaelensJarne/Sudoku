/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Jarne Staelens
 */
public class RunSudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku s = new Sudoku(3, 3);
        fillinSudoku(s);     
    }
    
    public static void fillinSudoku(Sudoku s){
        s.setValue(1, 3, 5);
        s.setValue(1, 4, 3);
        s.setValue(2, 1, 8);
        s.setValue(2, 8, 2);
        s.setValue(3, 2, 7);
        s.setValue(3, 5, 1);
        s.setValue(3, 7, 5);
        s.setValue(4, 1, 4);
        s.setValue(3, 6, 5);
        s.setValue(4, 6, 5);
        s.setValue(4, 7, 3);    
        s.setValue(5, 2, 1);
        s.setValue(5, 5, 7);
        s.setValue(5, 9, 6);
        s.setValue(6, 3, 3);
        s.setValue(6, 4, 2);
        s.setValue(6, 8, 8);
        s.setValue(7, 2, 6);
        s.setValue(7, 4, 5);
        s.setValue(7, 9, 9);
        s.setValue(8, 3, 4);
        s.setValue(8, 8, 3);
        s.setValue(9, 6, 9);
        s.setValue(9, 7, 7);
    }  
}

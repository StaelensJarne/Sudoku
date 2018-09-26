/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author jarne
 */
public class SimpleSolver 
{
    public Sudoku solve(Sudoku SudokuToSlove)
    {
        Sudoku solution = new Sudoku(SudokuToSlove);
        int size = solution.getSize();
        int aantalCellen = size * size;
        for(int i = 0; i < aantalCellen; i++)
        {
            int value = 1;
            int row = 1 + i / size;
            int colum = 1 + i % size;
            while(solution.getValue(row, colum) == Sudoku.LEEG)
            {
                solution.setValue(row, colum, value);
                value++;
            }
            
        }
        return solution;
    }
    
}

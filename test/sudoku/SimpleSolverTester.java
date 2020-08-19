/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.*;

/**
 *
 * @author Jarne Staelens
 */
public class SimpleSolverTester {
    
    @Test
    public void testSolve()
    {
        Sudoku s = new Sudoku("src/data/small.Sudoku");
        SimpleSolver ss = new SimpleSolver();
        
        s = ss.solve(s);
        
        System.err.println(s.toString());   
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.*;

/**
 *
 * @author jarne
 */
public class SudokuTester {
    
    //@Ignore // negeert de test 
    @Test
    public void testToString()
    {
        Sudoku s = new Sudoku(3, 3);
        //System.out.println(s.toString());
        Assert.assertEquals("-------------------------\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "-------------------------\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "-------------------------\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "| 0 0 0 | 0 0 0 | 0 0 0 |\n" +
                            "-------------------------",s.toString());
    }
    
    @Test
    public void testReadSudokuFromFile()
    {
        Sudoku s = new Sudoku("src/data/test.sudoku");
        //System.err.println(s.toString());
        Assert.assertEquals(1, s.getValue(1, 1));
        Assert.assertEquals(1, s.getValue(4, 2));
        Assert.assertEquals(3, s.getValue(6, 6));
    }
    
    @Test 
    public void testGeldigeWaarde()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertEquals(geldigeWaarde, s.getValue(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testOngeldigeWaarde()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int geldigeWaarde = -1;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue( s.isEmpty(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testOngeldigeRij()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = -1;
        int geldigeKolom = 4;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertEquals(Sudoku.LEEG, s.getValue(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testOngeldigeKolom()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = -1;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue(s.isEmpty(geldigeRij, geldigeKolom));
        Assert.assertEquals(Sudoku.LEEG, s.getValue(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testLeegeCel()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        s.empty(geldigeRij, geldigeKolom);
        
        Assert.assertTrue(s.isEmpty(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testLeegeCelOngeldigeRij()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = -1;
        int geldigeKolom = 4;
        int geldigeWaarde = 6;
        
        s.empty(geldigeRij, geldigeKolom);
        
        Assert.assertTrue(s.isEmpty(geldigeRij, geldigeKolom));
    }
    
    @Test
    public void testLeegeCelOngeldigeKolom()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = -1;
        int geldigeWaarde = 6;
        
        s.empty(geldigeRij, geldigeKolom);
        
        Assert.assertTrue(s.isEmpty(geldigeRij, geldigeKolom));
    }
    
    
    @Test
    public void testIsValidValueGeldigeWaarde()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int geldigeWaarde = 5;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue(s.isValidValue(geldigeRij, geldigeKolom, geldigeWaarde));
    }
    
    @Test
    public void testSpelregelRij()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int nogKolom = 6;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue(s.isValidValue(geldigeRij, geldigeKolom, geldigeWaarde));
        Assert.assertFalse(s.isValidValue(geldigeRij, nogKolom, geldigeWaarde));
        
        s.setValue(geldigeRij, nogKolom, geldigeWaarde);
        Assert.assertTrue(s.isEmpty(geldigeRij, nogKolom));
    }
    
    @Test
    public void testSpelregelKolom()
    {
        Sudoku s = new Sudoku(3, 2);
        int geldigeRij = 3;
        int geldigeKolom = 4;
        int nogEenRij = 6;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue(s.isValidValue(geldigeRij, geldigeKolom, geldigeWaarde));
        Assert.assertFalse(s.isValidValue(nogEenRij, geldigeKolom, geldigeWaarde));
        
        s.setValue(nogEenRij, geldigeKolom, geldigeWaarde);
        Assert.assertTrue(s.isEmpty(nogEenRij, geldigeKolom));
    }
    
    
    @Test
    public void testSpelregelBlok()
    {
        Sudoku s = new Sudoku(3, 2);
        //int geldigeRij = 3;
        //int geldigeKolom = 4;
        int geldigeRij = 1;
        int geldigeKolom = 5;
        //int nogEenRijInDezelfdeBlok = 1;
        //int nogEenKolomInDezelfdeBlok = 3;
        int nogEenRijInDezelfdeBlok = 3;
        int nogEenKolomInDezelfdeBlok = 6;
        int geldigeWaarde = 6;
        
        s.setValue(geldigeRij, geldigeKolom, geldigeWaarde);
        
        Assert.assertTrue(s.isValidValue(geldigeRij, geldigeKolom, geldigeWaarde));
        Assert.assertFalse(s.isValidValue(nogEenRijInDezelfdeBlok, nogEenKolomInDezelfdeBlok, geldigeWaarde));
        
        s.setValue(nogEenRijInDezelfdeBlok, nogEenKolomInDezelfdeBlok, geldigeWaarde);
        Assert.assertTrue(s.isEmpty(nogEenRijInDezelfdeBlok, nogEenKolomInDezelfdeBlok));
    }
    
    @Test
    public void testCopyConstructor()
    {
        Sudoku origin = new Sudoku(2, 2);
        origin.setValue(1, 1, 1);
        origin.setValue(3, 2, 4);
        origin.setValue(4, 4, 4);
        Sudoku s2 = new Sudoku(origin);
        
        Assert.assertEquals(1, s2.getValue(1, 1));
        Assert.assertEquals(4, s2.getValue(3, 2));
        Assert.assertEquals(4, s2.getValue(4, 4));
        
        Assert.assertTrue(origin.equals(s2));
    }
    
    @Test
    public void testUndo()
    {
        Sudoku s = new Sudoku(2, 2);
        s.setValue(1, 1, 1);
        s.setValue(3, 2, 4);
        s.setValue(4, 4, 4);
        
        s.Undo();
        
        Assert.assertEquals(1, s.getValue(1, 1));
        Assert.assertEquals(4, s.getValue(3, 2));
        Assert.assertEquals(Sudoku.LEEG, s.getValue(4, 4));
        
        s.Undo();
        
        Assert.assertEquals(1, s.getValue(1, 1));
        Assert.assertEquals(Sudoku.LEEG, s.getValue(3, 2));
        
        s.Undo();
        
        Assert.assertEquals(Sudoku.LEEG, s.getValue(1, 1));
        
        s.Undo();
    }
 
}

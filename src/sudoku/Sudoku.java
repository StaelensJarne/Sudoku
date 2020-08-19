/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Jarne Staelens
 */
public class Sudoku 
{
    private int[][] cellen;
    private int blokHoogte;
    private int blokBreette;
    private int size; 
    private Stack<Change> veranderingen;
    
    public static int LEEG = 0;

    public void initialize(int blokHoogte, int blokBreette)
    {
        this.blokHoogte = blokHoogte;
        this.blokBreette = blokBreette;
        size = blokHoogte * blokBreette;
        cellen = new int[size][size];
        veranderingen = new Stack<>();
    }
    
    public Sudoku(int blokHoogte, int blokBreette)
    {
        initialize(blokHoogte, blokBreette);
    }

    public Sudoku(String file) 
    {
        Path path = Paths.get(file);
        try
        {
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            String[] numberChars = content.split("\\D+");
            initialize(Integer.parseInt(numberChars[0]),Integer.parseInt(numberChars[1]));
            for(int index = 0; index < numberChars.length - 2; index++)
            {
                setValue(1 + index / size, 1 + index % size,Integer.parseInt(numberChars[index + 2]));
            }
        }
        catch(Exception e)
        {
            System.err.println(e.toString());
        }
    }
    
    public Sudoku(Sudoku s2)
    {
        this(s2.blokHoogte, s2.blokBreette);
        for(int r = 0; r < size; r++)
            for(int c = 0; c < size; c++)
                cellen[r][c] = s2.cellen[r][c];
    }
    
    private boolean isValidIndex(int index)
    {
        return 0 < index && index <= size;
    }
    
    public boolean isValidValue(int row, int colum, int value)
    {
        if(value < 0 || size < value) return false;
        if(value == LEEG || getValue(row, colum) == value) return true;
        for(int i = 1; i <= size; i++)
        {
            if(getValue(row, i) == value) return false;
            if(getValue(i,colum) == value) return false;
        }    
        int bovensteCel = 1 + blokHoogte * ((row - 1)/ blokHoogte);
        int linkseCel = 1 + blokBreette * ((colum -1) / blokBreette); 
        for(int r = 0; r < blokHoogte; r++)
            for(int c = 0; c < blokBreette; c++)
                if(getValue(r+bovensteCel,c+linkseCel) == value) return false;   
        return true;
    }
    
    public boolean isEmpty(int row, int colum)
    {
        if(isValidIndex(row) && isValidIndex(colum))
            return cellen[row - 1][colum - 1] == LEEG; 
        return true;
    }
    
    public void empty(int row, int colum)
    {
        setValue(row, colum, LEEG);
    }
    
    public int getValue(int row, int colum)
    {
        if(isValidIndex(row) && isValidIndex(colum))
            return cellen[row - 1][colum - 1];
        return LEEG;
    }
    
    public void setValue(int row, int colum, int value)
    {
        if(isValidIndex(row) && isValidIndex(colum) && isValidValue(row, colum, value))
        {
            veranderingen.push(new Change(row, colum, getValue(row, colum), value));
            cellen[row -1][colum -1] = value;         
        }
    }
    
    public void Undo()
    {
        if(!(veranderingen.empty()))
        {
            Change laatste = veranderingen.pop();
            cellen[laatste.getRow() -1][laatste.getColum() -1] = laatste.getOldValue();
        }
        
    }
    
    public int getBlokHoogte() 
    {
        return blokHoogte;
    }

    public int getBlokBreette() 
    {
        return blokBreette;
    }
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 2 * (size + blokHoogte) +1; i++)
            res.append("-");
        String lineSeparator = res.toString();  //variable die een lijn tekent
        res = new StringBuilder();
        for(int r = 0; r < size; r++)
        {
            if(r % blokHoogte == 0)
            {
               res.append(lineSeparator);
               res.append("\n");
            }
            for(int c = 0; c < size; c++)
            {
                if(c % blokBreette == 0) res.append("| ");
                res.append(cellen[r][c]);
                res.append(" ");
            }
            res.append("|\n");
        }
        res.append(lineSeparator);
        return res.toString();
    }   
    
    @Override
    public boolean equals(Object eenObject)
    {
        if(eenObject == this) return true;
        if(eenObject == null) return false;
        if(!(eenObject instanceof Sudoku)) return false;
        Sudoku s1 = (Sudoku)eenObject;
        if(s1.blokHoogte != this.blokHoogte || s1.blokBreette != this.blokBreette) return false;
        for(int r = 0; r < size; r++)
            for(int c = 0; c < size; c++)
                if(cellen[r][c] != s1.cellen[r][c]) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Arrays.deepHashCode(this.cellen);
        hash = 89 * hash + this.blokHoogte;
        hash = 89 * hash + this.blokBreette;
        return hash;
    }

    public int getSize() 
    {
        return size;
    }
}

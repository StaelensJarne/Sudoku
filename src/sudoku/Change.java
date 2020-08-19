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
public class Change 
{
    private final int row;
    private final int colum;
    private final int value;
    private final int oldValue;

    public Change(int row, int colum, int oldValue, int value) 
    {
        this.row = row;
        this.colum = colum;    
        this.oldValue = oldValue;
        this.value = value;
    }

    @Override
    public String toString() 
    {
        return "Change on place :" + "row = " + getRow() + ", colum = " + getColum() + ", van " + getOldValue() + ", naar" + getValue();
    }

    public int getRow() {
        return row;
    }

    public int getColum() {
        return colum;
    }

    public int getValue() {
        return value;
    }

    public int getOldValue() {
        return oldValue;
    } 
}

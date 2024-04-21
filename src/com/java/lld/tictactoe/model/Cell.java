package com.java.lld.tictactoe.model;

public class Cell {
    private int row;
    private int col;
    private CellType cellType;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getCellType() {
        return cellType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.cellType = CellType.FILLED;
    }

    public boolean isEmpty() {
        return CellType.EMPTY.equals(this.getCellType());
    }

    public void print() {
        System.out.print("|" + (CellType.EMPTY.equals(cellType) ? " " : symbol.getCharacter()) + "|");
    }
}

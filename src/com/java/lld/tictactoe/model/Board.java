package com.java.lld.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for(int r =0 ; r<=dimension; r++) {
            List<Cell> row = new ArrayList<>();
            for(int c=0; c<=dimension; c++) {
                row.add(new Cell(r,c));
            }
            this.board.add(row);
        }
    }

    public int getDimension() {
        return dimension;
    }

//    public void setDimension(int dimension) {
//        this.dimension = dimension;
//    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public boolean isEmptyCell(Cell cell) {
        return board.get(cell.getRow()).get(cell.getCol()).isEmpty();
    }

    public Cell updateCell(Cell cell) {
        if(this.isEmptyCell(cell)) {
            Cell actualCell = board.get(cell.getRow()).get(cell.getCol());
            actualCell.setSymbol(cell.getSymbol());
            return actualCell;
        }
        return null;
    }

//    public void setBoard(List<List<Cell>> board) {
//        this.board = board;
//    }

    public void printBoard() {
        for(List<Cell> row: this.board) {
            for(Cell cell : row) {
                cell.print();
            }
            System.out.println();
        }
    }
}

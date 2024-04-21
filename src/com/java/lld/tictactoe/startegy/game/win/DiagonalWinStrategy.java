package com.java.lld.tictactoe.startegy.game.win;

import com.java.lld.tictactoe.model.Board;
import com.java.lld.tictactoe.model.Move;
import com.java.lld.tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinStrategy implements WinStrategy{
    Map<Symbol, Integer> topDownDiagnolMap;
    Map<Symbol, Integer> bottomUpDiagnolMap;

    public DiagonalWinStrategy() {
        topDownDiagnolMap = new HashMap<>();
        bottomUpDiagnolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        // TODO
        int r = move.getCell().getRow();
        int c = move.getCell().getCol();
        Symbol symbol =  move.getSymbol();
        if(r == c) {
            int freq = topDownDiagnolMap.getOrDefault(symbol, 0)+1;
            topDownDiagnolMap.put(symbol, freq);
            if(board.getBoard().size() == freq) {
                return true;
            }
        }
        if(r+c == board.getBoard().size()) {
            int freq = bottomUpDiagnolMap.getOrDefault(symbol, 0)+1;
            bottomUpDiagnolMap.put(symbol, freq);
            if(board.getBoard().size() == freq) {
                return true;
            }
        }
        return false;
    }
}

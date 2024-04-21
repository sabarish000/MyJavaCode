package com.java.lld.tictactoe.startegy.game.win;

import com.java.lld.tictactoe.model.Board;
import com.java.lld.tictactoe.model.Move;
import com.java.lld.tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinStrategy implements WinStrategy {
    private Map<Integer,Map<Symbol, Integer>> rowsFreqMap;

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol moveSymbol = move.getSymbol();
        Map<Symbol, Integer> freqMap = rowsFreqMap.getOrDefault(row, new HashMap<>());
        int freq = freqMap.getOrDefault(moveSymbol, 0)+1;
        freqMap.put(moveSymbol, freq);
        rowsFreqMap.put(row, freqMap);
        return freq == board.getBoard().size();
    }
}

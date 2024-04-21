package com.java.lld.tictactoe.startegy.game.win;

import com.java.lld.tictactoe.model.*;

import java.util.HashMap;
import java.util.Map;

public class ColWinStrategy implements WinStrategy{
    private Map<Integer, Map<Symbol, Integer>> colsFreqMap;
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol moveSymbol = move.getSymbol();
        Map<Symbol, Integer> freqMap = colsFreqMap.getOrDefault(col, new HashMap<>());
        int freq = freqMap.getOrDefault(moveSymbol, 0)+1;
        freqMap.put(moveSymbol, freq);
        colsFreqMap.put(col, freqMap);
        return freq == board.getBoard().get(0).size();
    }
}

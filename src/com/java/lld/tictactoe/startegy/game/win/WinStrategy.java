package com.java.lld.tictactoe.startegy.game.win;

import com.java.lld.tictactoe.model.Board;
import com.java.lld.tictactoe.model.Move;

public interface WinStrategy {
    boolean checkWinner(Board board, Move move);
}

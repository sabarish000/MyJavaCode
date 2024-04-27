package com.java.lld.tictactoe.controller;

import com.java.lld.tictactoe.exception.InvalidGameException;
import com.java.lld.tictactoe.exception.InvalidMoveException;
import com.java.lld.tictactoe.model.*;
import com.java.lld.tictactoe.startegy.game.win.WinStrategy;

import java.util.List;

public class GameController {

    public static Game startGame(int dimensions, List<Player> playerList, List<WinStrategy> winStrategyList) throws InvalidGameException {
        return Game.getBuilder()
                .setDimension(dimensions)
                .setPlayers(playerList)
                .setWinStrategies(winStrategyList)
                .build();
    }

    public static  Move makeMove(Game game, Cell cell) throws InvalidMoveException {
        Move move = game.makeMove(cell);
        game.checkWinner(move);
        return move;
    }

//    public static void checkWinner(Game game) {
//        if(!game.isGameEnded()) {
//            // printGameState(game);
//        }
//    }
    public static void printGameState(Game game) {
        if(GameState.WIN.equals(game.getGameState())) {
            System.out.println(game.getWinner().getName() + " has won the game!!!");
        } else if(GameState.DRAW.equals(game.getGameState())) {
            System.out.println(" Game ended as draw!!");
        }
    }
}

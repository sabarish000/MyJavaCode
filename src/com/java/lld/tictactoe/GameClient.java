package com.java.lld.tictactoe;

import com.java.lld.tictactoe.controller.GameController;
import com.java.lld.tictactoe.exception.InvalidGameException;
import com.java.lld.tictactoe.exception.InvalidMoveException;
import com.java.lld.tictactoe.exception.InvalidPlayerException;
import com.java.lld.tictactoe.factory.PlayerFactory;
import com.java.lld.tictactoe.model.*;
import com.java.lld.tictactoe.startegy.game.win.ColWinStrategy;
import com.java.lld.tictactoe.startegy.game.win.DiagonalWinStrategy;
import com.java.lld.tictactoe.startegy.game.win.RowWinStrategy;
import com.java.lld.tictactoe.startegy.game.win.WinStrategy;
import com.java.lld.tictactoe.utils.PlayerValidator;

import java.util.*;

public class GameClient {
    private static final int RETRIES = 3;
    public static void main(String[] args) {
        Scanner scanner = null;
        Game game = null;
        do {
            
            int dimension = 0;
            do {
                scanner = new Scanner(System.in);
                System.out.println("Please enter number of players: ");
                try {
                    if(scanner.hasNextInt()) {
                        dimension = scanner.nextInt();
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid number of players, please try again!!");
                    if(scanner.hasNextInt()) {
                        dimension = scanner.nextInt();
                    }
                }
            } while(dimension<=0);
            List<Player> players = new ArrayList<>();
            for(int i=0; i<dimension; i++) {
                System.out.println("Please enter name for player"+i);
                String name = scanner.next();
                System.out.println("Please enter symbol for player"+i);
                Character symbol = scanner.next().charAt(0);
                players.add(PlayerFactory.getPlayer(name,symbol));
                try {
                    PlayerValidator.isValidPlayersList(players);
                } catch (InvalidPlayerException e) {
                    System.out.println(e.getMessage());
                    players.remove(i);
                    System.out.println("Removed player"+i);
                    i--;
                }
            }

            List<WinStrategy> winStrategyList = Arrays.asList(new WinStrategy[]{new RowWinStrategy(),new ColWinStrategy(), new DiagonalWinStrategy()});
            try {
                game = GameController.startGame(dimension, players, winStrategyList);
            } catch (InvalidGameException e) {
                e.printStackTrace();
            }
        } while(game == null);

        while(game.getGameState()== GameState.IN_PROGRESS) {
            Player  currPlayer = game.getNextPlayer();
            System.out.println("Now it's turn of "+currPlayer.getName());
            System.out.println("Please enter your move row: ");
            int row = scanner.nextInt();
            System.out.println("Please enter your move column: ");
            int col = scanner.nextInt();
            try {
                Move move = GameController.makeMove(game, new Cell(row, col));
                // GameController.checkWinner(game);
                // GameController.printGameState(game);
                if(!GameState.IN_PROGRESS.equals(game.getGameState()) ) {
                    GameController.printGameState(game);
                }
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

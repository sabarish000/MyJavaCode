package com.java.lld.tictactoe.model;

import com.java.lld.tictactoe.exception.InvalidGameException;
import com.java.lld.tictactoe.exception.InvalidMoveException;
import com.java.lld.tictactoe.startegy.game.win.WinStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int dimension;
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private List<WinStrategy> winStrategies;
    private int nextPlayerIndex;
    private Player winner;
    private GameState gameState;

    public Player getNextPlayer() {
        return this.players.get(nextPlayerIndex);
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    private Game(GameBuilder builder) throws InvalidGameException {
        validateGame(builder);
        this.dimension = builder.dimension;
        this.board = new Board(dimension);
        this.players = builder.players;
        this.winStrategies = builder.winStrategies;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0; // TODO random player pick
        this.gameState = GameState.IN_PROGRESS;
    }

    private void validateGame(GameBuilder builder) throws InvalidGameException {
        if(builder.dimension <= 0) {
            throw new InvalidGameException("Dimension should be a positive number");
        }
        if(builder.winStrategies.isEmpty()) {
            throw new InvalidGameException("Please provide one or more Win strategies.");
        }
        if(builder.players.stream().filter(p -> p.getPlayerType().equals(PlayerType.BOT)).count()>1) {
            throw new InvalidGameException("Only one Bot player allowed per game.");
        }
        if(builder.players.stream().map(Player::getSymbol).map(Symbol::getCharacter).distinct().count() != builder.players.size()) {
            throw new InvalidGameException("All the players should have unique symbols");
        }
    }

    public Move makeMove(Cell cell) throws InvalidMoveException {
        if(cell.isEmpty()) {
            throw new InvalidMoveException("Invalid move, please provide a cell!");
        } else if(!isValidCell(cell)) {
            throw new InvalidMoveException("Invalid move, please provide a valid cell with in range!");
        }else  if(!this.board.isEmptyCell(cell)) {
            throw new InvalidMoveException("Invalid move, entered is cell is already occupied, please try again!");
        }
        Cell actualCell = this.board.updateCell(cell);
        Move move = new Move(actualCell, actualCell.getSymbol());
        this.moves.add(move);
        return move;
    }

    private boolean isValidCell(Cell cell) {
        try {
            board.getBoard().get(cell.getRow()).get(cell.getCol());
        } catch(IndexOutOfBoundsException iobEx) {
            return false;
        }
        return true;
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public boolean isGameEnded() {
        // TODO
        // gameState = GameState.WIN;

        // gameState = GameState.DRAW;
        return false;
    }

    public static class GameBuilder {
        private int dimension;
        private List<Player> players;
        private List<WinStrategy> winStrategies;

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinStrategies(List<WinStrategy> winStrategies) {
            this.winStrategies = winStrategies;
            return this;
        }

        public Game build() throws InvalidGameException {
            return new Game(this);
        }
    }
}

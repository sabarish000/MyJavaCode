package com.java.lld.tictactoe.factory;

import com.java.lld.tictactoe.model.*;

public class PlayerFactory {
    public static  Player getPlayer(String name, Character symbol, PlayerType playerType) {
        if(PlayerType.BOT.equals(playerType)) {
            return new BotPlayer(name, new Symbol(symbol), BotDifficultyLevel.MEDIUM);
        } else {
            return new HumanPlayer(name, new Symbol(symbol));
        }
    }

    public static  Player getPlayer(String name, Character symbol) {
        return new HumanPlayer(name, new Symbol(symbol));
    }

    public static  Player getPlayer(String name, Character symbol, BotDifficultyLevel botDifficultyLevel) {
        return new BotPlayer(name, new Symbol(symbol), botDifficultyLevel);
    }
}

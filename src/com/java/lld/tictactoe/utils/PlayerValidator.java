package com.java.lld.tictactoe.utils;

import com.java.lld.tictactoe.exception.InvalidPlayerException;
import com.java.lld.tictactoe.model.Player;
import com.java.lld.tictactoe.model.PlayerType;
import com.java.lld.tictactoe.model.Symbol;

import java.util.List;

public class PlayerValidator {
    public static boolean isValidPlayersList(List<Player> playerList) throws InvalidPlayerException {
        if(playerList.stream().filter(p -> p.getPlayerType().equals(PlayerType.BOT)).count()>1) {
            throw new InvalidPlayerException("Only one Bot player allowed per game.");
        }
        if(playerList.stream().map(Player::getSymbol).map(Symbol::getCharacter).distinct().count() != playerList.size()) {
            throw new InvalidPlayerException("All the players should have unique symbols");
        }
        return true;
    }
}

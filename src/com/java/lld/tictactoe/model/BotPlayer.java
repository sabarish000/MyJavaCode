package com.java.lld.tictactoe.model;

import com.java.lld.tictactoe.startegy.bot.play.BotPlayStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayStrategy botPlayStrategy;

    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol,PlayerType.BOT );
        this.difficultyLevel = difficultyLevel;

    }

    @Override
    public void makeMove() {
        //TODO
    }
}

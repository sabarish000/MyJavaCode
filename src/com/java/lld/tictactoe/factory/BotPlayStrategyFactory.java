package com.java.lld.tictactoe.factory;

import com.java.lld.tictactoe.model.BotDifficultyLevel;
import com.java.lld.tictactoe.startegy.bot.play.BotPlayStrategy;
import com.java.lld.tictactoe.startegy.bot.play.EasyBotPlayStrategy;
import com.java.lld.tictactoe.startegy.bot.play.HardBotPlayStrategy;
import com.java.lld.tictactoe.startegy.bot.play.MediumBotPlayStrategy;

public class BotPlayStrategyFactory {
    public static BotPlayStrategy getBotPlayStrategy(BotDifficultyLevel botDifficultyLevel) {
        if(BotDifficultyLevel.EASY.equals(botDifficultyLevel)) {
            return new EasyBotPlayStrategy();
        } else if(BotDifficultyLevel.MEDIUM.equals(botDifficultyLevel)) {
            return new MediumBotPlayStrategy();
        } else {
            return new HardBotPlayStrategy();
        }
    }
}

package com.java.lld.tictactoe.exception;

public class InvalidPlayerException extends Exception{
    public InvalidPlayerException(String message) {
        super(message);
        printStackTrace();
    }
}

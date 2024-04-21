package com.java.lld.tictactoe.exception;

public class InvalidGameException extends  Exception{
    public InvalidGameException(String msg) {
        super(msg);
        printStackTrace();
    }
}

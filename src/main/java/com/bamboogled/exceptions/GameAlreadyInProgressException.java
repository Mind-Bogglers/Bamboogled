package com.bamboogled.exceptions;

public class GameAlreadyInProgressException extends Exception {
    public GameAlreadyInProgressException(String message) {
        super(message);
    }
}

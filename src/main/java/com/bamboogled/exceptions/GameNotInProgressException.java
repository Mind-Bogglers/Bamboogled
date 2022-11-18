package com.bamboogled.exceptions;

public class GameNotInProgressException extends Exception {
    public GameNotInProgressException(String message) {
        super(message);
    }
}

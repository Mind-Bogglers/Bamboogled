package com.bamboogled.exceptions;

/**
 * Exception thrown when there is no path for a certain word.
 * @author Hassan El-Sheikha
 */
public class NoPathException extends Exception {
    public NoPathException(String message) {
        super(message);
    }
}

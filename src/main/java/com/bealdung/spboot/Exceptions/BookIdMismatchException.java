package com.bealdung.spboot.Exceptions;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIdMismatchException() {

    }
}

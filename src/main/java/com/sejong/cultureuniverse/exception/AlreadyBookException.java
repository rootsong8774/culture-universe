package com.sejong.cultureuniverse.exception;

public class AlreadyBookException extends RuntimeException {
    
    
    public AlreadyBookException() {
    }
    
    public AlreadyBookException(String message) {
        super(message);
    }
    
    public AlreadyBookException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public AlreadyBookException(Throwable cause) {
        super(cause);
    }
}


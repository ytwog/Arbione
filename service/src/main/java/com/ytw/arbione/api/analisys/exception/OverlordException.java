package com.ytw.arbione.api.analisys.exception;

public class OverlordException extends RuntimeException {

    public OverlordException(String message) {
        super(message);
    }

    public OverlordException(String message, Throwable cause) {
        super(message, cause);
    }
}

package io.tomo.lms.exception;

public class BookExistException extends Exception {
    public BookExistException() {
    }

    public BookExistException(String message) {
        super(message);
    }

    public BookExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookExistException(Throwable cause) {
        super(cause);
    }

    public BookExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

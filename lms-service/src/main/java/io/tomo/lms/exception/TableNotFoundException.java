package io.tomo.lms.exception;

public class TableNotFoundException extends Exception {
    public TableNotFoundException() {
    }

    public TableNotFoundException(String message) {
        super(message);
    }

    public TableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableNotFoundException(Throwable cause) {
        super(cause);
    }

    public TableNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

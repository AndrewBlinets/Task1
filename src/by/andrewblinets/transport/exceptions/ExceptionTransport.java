package by.andrewblinets.transport.exceptions;

public class ExceptionTransport extends Exception {

    public ExceptionTransport() {
    }

    public ExceptionTransport(String message) {
        super(message);
    }

    public ExceptionTransport(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionTransport(Throwable cause) {
        super(cause);
    }

    public ExceptionTransport(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

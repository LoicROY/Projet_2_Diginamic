package fr.diginamic.projet.Exception;

public class SalarieException extends Exception{

    public SalarieException() {
        super();
    }

    public SalarieException (String message) {
        super(message);
    }

    public SalarieException (String message, Throwable cause) {
        super(message, cause);
    }

    public SalarieException (Throwable cause) {
        super(cause);
    }

    protected SalarieException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

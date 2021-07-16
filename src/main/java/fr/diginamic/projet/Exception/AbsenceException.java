package fr.diginamic.projet.Exception;

public class AbsenceException extends Exception {

    public AbsenceException() {
        super();
    }

    public AbsenceException(String message) {
        super(message);
    }

    public AbsenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsenceException(Throwable cause) {
        super(cause);
    }

    protected AbsenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

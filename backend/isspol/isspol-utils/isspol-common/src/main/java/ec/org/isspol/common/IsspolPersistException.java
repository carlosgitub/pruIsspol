package ec.org.isspol.common;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolPersistException extends Exception {

    public IsspolPersistException() {
    }

    public IsspolPersistException(String message) {
        super(message);
    }

    public IsspolPersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsspolPersistException(Throwable cause) {
        super(cause);
    }

    public IsspolPersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package ec.org.isspol.common;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolProcessException extends Exception {

    public IsspolProcessException() {
    }

    public IsspolProcessException(String message) {
        super(message);
    }

    public IsspolProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsspolProcessException(Throwable cause) {
        super(cause);
    }

    public IsspolProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package ec.org.isspol.common;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolException extends Exception {

    public IsspolException() {
    }

    public IsspolException(String message) {
        super(message);
    }

    public IsspolException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsspolException(Throwable cause) {
        super(cause);
    }
}

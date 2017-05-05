package ec.org.isspol.common;

/**
 * Created by santiago.yacelga on 19/04/2017.
 */
public class IsspolSearchException extends  Exception  {
    public IsspolSearchException() {
    }

    public IsspolSearchException(String message) {
        super(message);
    }

    public IsspolSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public IsspolSearchException(Throwable cause) {
        super(cause);
    }

    public IsspolSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

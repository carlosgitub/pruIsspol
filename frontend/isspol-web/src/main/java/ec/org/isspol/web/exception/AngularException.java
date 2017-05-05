package ec.org.isspol.web.exception;

/**
 * Created by santiago.yacelga on 4/26/2017.
 */
public class AngularException extends  Exception{

    private String customMessage;

    public AngularException(String customMessage) {
        this.customMessage = customMessage;
    }

    public AngularException(String message, String customMessage) {
        super(message);
        this.customMessage = customMessage;
    }

    public AngularException(String message, Throwable cause, String customMessage) {
        super(message, cause);
        this.customMessage = customMessage;
    }

    public AngularException(Throwable cause, String customMessage) {
        super(cause);
        this.customMessage = customMessage;
    }

    public AngularException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String customMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}

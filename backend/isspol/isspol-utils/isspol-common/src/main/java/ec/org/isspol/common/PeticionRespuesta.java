package ec.org.isspol.common;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mauchilan on 24/3/17.
 */
public class PeticionRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    private String method;
    private Object[] parameters;
    private Object resullt;
    private Map<String, Object> mapaParametros;
    private Exception exception;

    public PeticionRespuesta() {
    }

    public PeticionRespuesta(String method, Object[] parameters) {
        this.method = method;
        this.parameters = parameters;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Object getResullt() {
        return resullt;
    }

    public void setResullt(Object resullt) {
        this.resullt = resullt;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Map<String, Object> getMapaParametros() {
        return mapaParametros;
    }

    public void setMapaParametros(Map<String, Object> mapaParametros) {
        this.mapaParametros = mapaParametros;
    }
}

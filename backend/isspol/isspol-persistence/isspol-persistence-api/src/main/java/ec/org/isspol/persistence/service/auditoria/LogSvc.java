package ec.org.isspol.persistence.service.auditoria;

import ec.org.isspol.common.IsspolPersistException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public interface LogSvc {

    public Map<String, Object> logAuditoria(HashMap<String, Object> values) throws IsspolPersistException;
}

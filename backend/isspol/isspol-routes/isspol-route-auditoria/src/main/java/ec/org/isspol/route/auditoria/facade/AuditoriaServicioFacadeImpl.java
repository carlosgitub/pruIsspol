package ec.org.isspol.route.auditoria.facade;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.persistence.service.auditoria.LogSvc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class AuditoriaServicioFacadeImpl implements AuditoriaServicioFacade{

    private LogSvc logSvc;

    @Override
    public Map<String, Object> logAuditoria(HashMap<String, Object> values) throws IsspolPersistException {
        return logSvc.logAuditoria(values);
    }

    public void setLogSvc(LogSvc logSvc) {
        this.logSvc = logSvc;
    }
}

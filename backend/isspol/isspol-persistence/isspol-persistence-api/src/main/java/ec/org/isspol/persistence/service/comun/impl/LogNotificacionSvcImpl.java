package ec.org.isspol.persistence.service.comun.impl;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.persistence.dao.comun.LogNotificacionDao;
import ec.org.isspol.persistence.service.comun.LogNotificacionSvc;
import ec.org.isspol.persistence.entities.comun.LogNotificacion;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class LogNotificacionSvcImpl implements LogNotificacionSvc {

    private LogNotificacionDao logNotificacionDao;

    @Override
    public void insertLogNotificacion(LogNotificacion logNotificacion) throws IsspolPersistException {
        logNotificacionDao.insertar(logNotificacion);
    }

    public void setLogNotificacionDao(LogNotificacionDao logNotificacionDao) {
        this.logNotificacionDao = logNotificacionDao;
    }
}

package ec.org.isspol.persistence.service.comun;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.persistence.entities.comun.LogNotificacion;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public interface LogNotificacionSvc {

    void insertLogNotificacion(LogNotificacion logNotificacion) throws IsspolPersistException;
}

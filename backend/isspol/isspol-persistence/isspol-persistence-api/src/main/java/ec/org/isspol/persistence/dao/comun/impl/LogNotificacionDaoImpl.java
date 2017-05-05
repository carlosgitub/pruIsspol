package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.comun.LogNotificacionDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.comun.LogNotificacion;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class LogNotificacionDaoImpl extends GenericDaoImpl<LogNotificacion, Integer> implements LogNotificacionDao{

    public LogNotificacionDaoImpl() {
        super(LogNotificacion.class);
    }
}

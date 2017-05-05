package ec.org.isspol.persistence.dao.auditoria.impl;

import ec.org.isspol.persistence.dao.auditoria.LogDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.auditoria.Log;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class LogDaoImpl extends GenericDaoImpl<Log,Integer> implements LogDao {
    public LogDaoImpl() {
        super(Log.class);
    }


}

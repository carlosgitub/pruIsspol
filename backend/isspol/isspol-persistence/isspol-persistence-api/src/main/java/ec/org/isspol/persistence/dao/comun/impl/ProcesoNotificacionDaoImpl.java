package ec.org.isspol.persistence.dao.comun.impl;

import ec.org.isspol.persistence.dao.comun.ProcesoNotificacionDao;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.entities.comun.ProcesoNotificacion;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class ProcesoNotificacionDaoImpl extends GenericDaoImpl<ProcesoNotificacion, Integer> implements ProcesoNotificacionDao{

    public ProcesoNotificacionDaoImpl() {
        super(ProcesoNotificacion.class);
    }
}

package ec.org.isspol.persistence.service.comun.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.ProcesoNotificacionDao;
import ec.org.isspol.persistence.service.comun.ProcesoNotificacionSvc;
import ec.org.isspol.persistence.entities.comun.ProcesoNotificacion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public class ProcesoNotificacionSvcImpl implements ProcesoNotificacionSvc {

    private ProcesoNotificacionDao procesoNotificacionDao;

    @Override
    public ProcesoNotificacion buscarProcesoNotificacionPorCodigo(String codigo) throws IsspolSearchException {
        return procesoNotificacionDao.buscarPorCriterio(Restrictions.eq("codigo", codigo));
    }

    public void setProcesoNotificacionDao(ProcesoNotificacionDao procesoNotificacionDao) {
        this.procesoNotificacionDao = procesoNotificacionDao;
    }
}

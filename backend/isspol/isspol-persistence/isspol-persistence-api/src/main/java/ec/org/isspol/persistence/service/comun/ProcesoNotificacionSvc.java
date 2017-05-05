package ec.org.isspol.persistence.service.comun;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.comun.ProcesoNotificacion;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public interface ProcesoNotificacionSvc {

    ProcesoNotificacion buscarProcesoNotificacionPorCodigo(String codigo) throws IsspolSearchException;
}

package ec.org.isspol.persistence.service.comun;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.comun.Parametro;

/**
 * Created by carlos.calo on 25/04/2017.
 */
public interface ParametroSvc {

    /**
     * @title Buscar por Id
     * @description Buscar por ID parametrp
     * @author carlos.calo
     * @date 25/04/2017
     * @param idParametro
     * @return
     * @throws IsspolSearchException
     */
    Parametro buscarParametroPorId(String idParametro) throws IsspolSearchException;
}

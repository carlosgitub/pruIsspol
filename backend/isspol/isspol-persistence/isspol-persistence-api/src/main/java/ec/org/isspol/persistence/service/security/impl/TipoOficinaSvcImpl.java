package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.TipoOficinaDao;
import ec.org.isspol.persistence.entities.security.TipoOficina;
import ec.org.isspol.persistence.service.security.TipoOficinaSvc;

import java.util.List;

/**
 * Created by Javier on 28/04/2017.
 */
public class TipoOficinaSvcImpl implements TipoOficinaSvc {

    private TipoOficinaDao tipoOficinaDao;

    @Override
    public List<TipoOficina> listarTipoOficinas() throws IsspolSearchException {
        try {
            return tipoOficinaDao.listarPorCriterio(null);
        }catch (IsspolSearchException e){
            throw new IsspolSearchException("ERROR al listar los registros", e);
        }
    }

    public void setTipoOficinaDao(TipoOficinaDao tipoOficinaDao) {
        this.tipoOficinaDao = tipoOficinaDao;
    }
}

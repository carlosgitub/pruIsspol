package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.security.IconoDao;
import ec.org.isspol.persistence.entities.security.Icono;
import ec.org.isspol.persistence.service.security.IconoSvc;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by paul.salgado on 21/04/2017.
 */

public class IconoSvcImpl implements IconoSvc {

    private IconoDao iconoDao;

    @Override
    public void insertarIcono(Icono icono) throws IsspolPersistException {
        iconoDao.insertar(icono);
    }

    @Override
    public void actualizarIcono(Icono icono) throws IsspolPersistException {
        iconoDao.actualizar(icono);
    }

    @Override
    public void eliminarIcono(Icono icono) throws IsspolPersistException {
        iconoDao.eliminar(icono);
    }

    @Override
    public List<Icono> listarTodosIcono() throws IsspolSearchException {
        return iconoDao.listarPorCriterio(null);
    }

    @Override
    public Icono buscarIconoPorId(Integer id) throws IsspolSearchException {
        return iconoDao.buscarPorCriterio(Restrictions.eq("idIcono", id));
    }

    public void setIconoDao(IconoDao iconoDao) {
        this.iconoDao = iconoDao;
    }
}

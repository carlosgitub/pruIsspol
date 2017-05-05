package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.UsuarioOficinaDao;
import ec.org.isspol.persistence.entities.security.UsuarioOficina;
import ec.org.isspol.persistence.service.security.UsuarioOficinaSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 05/05/2017.
 */
public class UsuarioOficinaSvcImpl implements UsuarioOficinaSvc {

    private UsuarioOficinaDao usuarioOficinaDao;

    @Override
    public void insertarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException {
        usuarioOficinaDao.insertar(usuarioOficina);
    }

    @Override
    public void actualizarUsuarioOficina(UsuarioOficina usuarioOficina) throws IsspolPersistException {
        usuarioOficinaDao.actualizar(usuarioOficina);
    }

    @Override
    public List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException {
        return usuarioOficinaDao.listarTodosUsuarioOficina();
    }

    @Override
    public UsuarioOficina buscarUsuarioOficinaPorId(Integer id) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idUsuarioOficina", id);
        UsuarioOficina usuarioOficina = null;
        try{
            usuarioOficina = usuarioOficinaDao.buscarPorCriterio(criterion);
        } catch (IsspolSearchException ex){
            throw  new IsspolSearchException(ex);
        }
        return usuarioOficina;
    }

    @Override
    public List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException {
        return usuarioOficinaDao.listarUsuarioOficinaPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        try{
            return usuarioOficinaDao.listarUsuarioOficinaNoEliminadoPorUsuario(idUsuario, filterParam);
        }catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros: UsuarioOficina", e);
        }
    }

    public void setUsuarioOficinaDao(UsuarioOficinaDao usuarioOficinaDao) {
        this.usuarioOficinaDao = usuarioOficinaDao;
    }
}

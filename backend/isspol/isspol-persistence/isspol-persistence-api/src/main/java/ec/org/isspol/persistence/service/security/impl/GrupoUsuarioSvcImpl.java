package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.security.GrupoUsuarioDao;
import ec.org.isspol.persistence.entities.security.GrupoUsuario;
import ec.org.isspol.persistence.service.security.GrupoUsuarioSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class GrupoUsuarioSvcImpl implements GrupoUsuarioSvc {

    private GrupoUsuarioDao grupoUsuarioDao;

    @Override
    public void insertarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException {
        grupoUsuarioDao.insertar(grupoUsuario);
    }

    @Override
    public void actualizarGrupoUsuario(GrupoUsuario grupoUsuario) throws IsspolPersistException {
        grupoUsuarioDao.actualizar(grupoUsuario);
    }

    @Override
    public List<GrupoUsuario> listarTodosGrupoUsuario() throws IsspolSearchException {
        return grupoUsuarioDao.listarTodosGrupoUsuario();
    }

    @Override
    public GrupoUsuario buscarGrupoUsuarioPorId(Integer id) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("idGrupoUsuario", id);
        GrupoUsuario grupoUsuario = null;
        try{
            grupoUsuario = grupoUsuarioDao.buscarPorCriterio(criterion);
        } catch (IsspolSearchException ex){
            throw  new IsspolSearchException(ex);
        }
        return grupoUsuario;
    }

    @Override
    public List<GrupoUsuario> listarGrupoUsuarioPorUsuario(String idUsuario) throws IsspolSearchException {
        return grupoUsuarioDao.listarGrupoUsuarioPorUsuario(idUsuario);
    }

    @Override
    public PagedResult<GrupoUsuario> listarGrupoUsuarioNoEliminadoPorUsuario
            (String idUsuario, FilterParam filterParam) throws IsspolSearchException {
        try{
            return grupoUsuarioDao.listarGrupoUsuarioNoElimiandoPorUsuario(idUsuario, filterParam);
        }catch (Exception e){
            throw new IsspolSearchException("ERROR al listar los registros: GrupoUsuario", e);
        }
    }

    public void setGrupoUsuarioDao(GrupoUsuarioDao grupoUsuarioDao) throws IsspolPersistException {
        this.grupoUsuarioDao = grupoUsuarioDao;
    }
}

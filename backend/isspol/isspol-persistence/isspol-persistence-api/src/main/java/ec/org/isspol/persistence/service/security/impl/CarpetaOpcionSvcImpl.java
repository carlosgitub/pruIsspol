package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.dao.security.CarpetaOpcionDao;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;
import ec.org.isspol.persistence.service.security.CarpetaOpcionSvc;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public class CarpetaOpcionSvcImpl implements CarpetaOpcionSvc {

    private CarpetaOpcionDao carpetaOpcionDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public void insertarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionDao.insertar(carpetaOpcion);
    }

    @Override
    public void actualizarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionDao.actualizar(carpetaOpcion);
    }

    @Override
    public void eliminarCarpetaOpcion(CarpetaOpcion carpetaOpcion) throws IsspolPersistException {
        carpetaOpcionDao.eliminar(carpetaOpcion);
    }

    @Override
    public List<CarpetaOpcion> listarTodosCarpetaOpcion() throws IsspolSearchException {
        return carpetaOpcionDao.listarCarpetaOpcion();
    }

    @Override
    public List<CarpetaOpcion> listarCarpetaOpcionPorIdCarpetaPadre(Integer id) throws IsspolSearchException {
        return carpetaOpcionDao.listarPorCriterio(Restrictions.eq("carpetaOpcion.idCarpetaOpcion", id));
    }

    @Override
    public CarpetaOpcion buscarCarpetaOpcionPorId(Integer id) throws IsspolSearchException {
        return carpetaOpcionDao.buscarPorCriterio(Restrictions.eq("idCarpetaOpcion", id));
    }

    @Override
    public Map<String, Object> obtenerCarpetaOpcionPorGrupo(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_GRUPO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_CARPETA_OPCION_POR_GRUPO, sqlParameters, values);
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }

    public void setCarpetaOpcionDao(CarpetaOpcionDao carpetaOpcionDao) {
        this.carpetaOpcionDao = carpetaOpcionDao;
    }
}

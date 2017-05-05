package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.dao.security.OpcionDao;
import ec.org.isspol.persistence.entities.security.Opcion;
import ec.org.isspol.persistence.service.security.OpcionSvc;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 21/04/2017.
 */
public class OpcionSvcImpl implements OpcionSvc {

    private OpcionDao opcionDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public void insertarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionDao.insertar(opcion);
    }

    @Override
    public void actualizarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionDao.actualizar(opcion);
    }

    @Override
    public void eliminarOpcion(Opcion opcion) throws IsspolPersistException {
        opcionDao.eliminar(opcion);
    }

    @Override
    public List<Opcion> listarTodosOpcion() throws IsspolSearchException {
        return opcionDao.listarPorCriterio(null);
    }

    @Override
    public List<Opcion> listarOpcionPorIdCarpetaOpcion(Integer id) throws IsspolSearchException {
        return opcionDao.listarPorCriterio(Restrictions.eq("carpetaOpcion.idCarpetaOpcion", id));
    }

    @Override
    public Opcion buscarOpcionPorId(Integer id) throws IsspolSearchException {
        return opcionDao.buscarPorCriterio(Restrictions.eq("idOpcion", id));
    }

    @Override
    public Map<String, Object> obtenerOpcionUsoFrecuentes(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_OPCION_USO_FRECUENTE, sqlParameters, values);
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }
    public void setOpcionDao(OpcionDao opcionDao) {
        this.opcionDao = opcionDao;
    }
}

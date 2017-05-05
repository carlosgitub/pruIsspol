package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.dao.security.OficinaDao;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.service.security.OficinaSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 21/3/17.
 */
public class OficinaSvcImpl implements OficinaSvc {

    private OficinaDao oficinaDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException {

        try {
            return oficinaDao.listarOficinaPaginado(filterParam);
        } catch (Exception e) {
            throw new IsspolSearchException("ERROR al listar los registros paginados", e);
        }
    }

    @Override
    public Oficina buscarPorCriterio(Criterion criterion) throws IsspolSearchException {
        return oficinaDao.buscarPorCriterio(criterion);
    }

    @Override
    public List<Oficina> listarOficina() throws IsspolSearchException {
        return oficinaDao.listarPorCriterio(null);
    }

    @Override
    public Oficina buscarOficinaPorId(Integer idOficina) throws IsspolSearchException {
        return oficinaDao.buscarPorCriterio(Restrictions.eq("idOficina",idOficina));
    }

    @Override
    public Map<String, Object> procOficinaCrud(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_OPERACION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_OFICINA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_SUCURSAL, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_TIPO_OFICINA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_NOMBRE, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_CODIGO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DIRECCION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_TELEFONO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_PROVINCIA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_CANTON, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_HABILITADO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_EMPRESA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_CODIGO_2, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_TEL_CODIGO_AREA, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_TEL_CODIGO_REGION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_OTRO_TELEFONO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AF_LATITUD, Types.DOUBLE),
                new SqlParameter(IsspolConstant.AF_LONGITUD, Types.DOUBLE),
                new SqlParameter(IsspolConstant.AS_CREACION_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_CREACION_EQUIPO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_OFICINA_CRUD, sqlParameters, values);
    }

    public Map<String, Object> obtenerOficinaNombreOficina(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_OFICINA, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_SUCURSAL, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_OBTENER_OFICINA_NOMBRE_OFICINA, sqlParameters, values);
    }

    @Override
    public Map<String, Object> obtenerSucursalOficina(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_OFICINA, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_SUCURSAL, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_OBTENER_SUCURSAL_OFICINA, sqlParameters, values);
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }

    public void setOficinaDao(OficinaDao oficinaDao) {
        this.oficinaDao = oficinaDao;
    }

}

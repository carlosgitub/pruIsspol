package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.dao.security.EstructuraOrganizacionalDao;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.service.security.EstructuraOrganizacionalSvc;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paul.salgado on 18/04/2017.
 */
public class EstructuraOrganizacionalSvcImpl implements EstructuraOrganizacionalSvc {

    private EstructuraOrganizacionalDao estructuraOrganizacionalDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public Collection<EstructuraOrganizacional> listarEstructuraOrg() throws IsspolSearchException {
        return estructuraOrganizacionalDao.listarEstructuraOrg();
    }

    @Override
    public List<EstructuraOrganizacional> listarTodosEstructuraOrganizacional() throws IsspolSearchException {
        return estructuraOrganizacionalDao.listarPorCriterio(null);
    }

    @Override
    public Map<String, Object> listarCargo() throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{};
        Map<String, Object> values = new HashMap<>();
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_DDDW_ESTRUCTURA_ORGANIZACIONAL, sqlParameters, values);
    }

    @Override
    public Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException, IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlInOutParameter(IsspolConstant.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_CODIGO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DESCRIPCION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ORDEN, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_NIVEL, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO_ACT, Types.VARCHAR),
        };

        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR, sqlParameters, values);
    }

    @Override
    public Map<String, Object> procEstructuraOrganizacionalEliminar(HashMap<String, Object> values) throws IsspolPersistException, IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR),
        };

        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR, sqlParameters, values);
    }

    public void setEstructuraOrganizacionalDao(EstructuraOrganizacionalDao estructuraOrganizacionalDao) {
        this.estructuraOrganizacionalDao = estructuraOrganizacionalDao;
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }
}

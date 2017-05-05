package ec.org.isspol.persistence.service.auditoria.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.service.auditoria.LogSvc;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class LogSvcImpl implements LogSvc {

    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public Map<String, Object> logAuditoria(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters=new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_DESCRIPCION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_REFERENCIA,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_TIPO,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_MAQUINA,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_APLICACION,Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_LOG,sqlParameters,values);
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }
}

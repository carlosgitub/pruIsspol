package ec.org.isspol.persistence.dao.procedimiento.impl;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenado;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public class FuncionProcedimientoAlmacenadoDaoImpl implements FuncionProcedimientoAlmacenadoDao {

    private DataSource dataSource;

    @Override
    public <K, V> Map<K, V> ejecutarProcedimientoAlmacenado(String nombre, SqlParameter[] parametrosSql, Map valores) throws IsspolPersistException {
        try {
            FuncionProcedimientoAlmacenado sp = new FuncionProcedimientoAlmacenado(dataSource, nombre, parametrosSql, Boolean.FALSE);
            return sp.execute(valores);
        } catch (RuntimeException e) {
            throw new IsspolPersistException(e);
        }
    }

    @Override
    public <K, V> Map<K, V> ejecutarFuncion(String nombre, SqlParameter[] parametrosSql, Map valores) throws IsspolPersistException {
        try {
            FuncionProcedimientoAlmacenado sp = new FuncionProcedimientoAlmacenado(dataSource, nombre, parametrosSql, Boolean.TRUE);
            return sp.execute(valores);
        } catch (RuntimeException e) {
            throw new IsspolPersistException(e);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

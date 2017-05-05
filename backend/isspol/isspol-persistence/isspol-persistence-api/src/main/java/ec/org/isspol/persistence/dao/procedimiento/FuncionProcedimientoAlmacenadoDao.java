package ec.org.isspol.persistence.dao.procedimiento;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import org.springframework.jdbc.core.SqlParameter;

import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public interface FuncionProcedimientoAlmacenadoDao {

    /**
     *
     * @param nombre
     * @param parametrosSql
     * @param valores
     * @param <K>
     * @param <V>
     * @return
     * @throws IsspolPersistException
     */
    <K, V>Map<K, V> ejecutarProcedimientoAlmacenado(String nombre, SqlParameter[] parametrosSql, Map valores) throws IsspolPersistException;

    /**
     *
     * @param nombre
     * @param parametrosSql
     * @param valores
     * @param <K>
     * @param <V>
     * @return
     * @throws IsspolPersistException
     */
    <K, V>Map<K, V> ejecutarFuncion(String nombre, SqlParameter[] parametrosSql, Map valores) throws IsspolPersistException;

}

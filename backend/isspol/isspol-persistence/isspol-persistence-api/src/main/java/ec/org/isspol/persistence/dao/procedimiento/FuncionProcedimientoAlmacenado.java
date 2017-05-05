package ec.org.isspol.persistence.dao.procedimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

/**
 * Created by mauchilan on 29/3/17.
 */
public class FuncionProcedimientoAlmacenado extends SimpleJdbcCall {

    private static final Logger logger = LoggerFactory.getLogger(FuncionProcedimientoAlmacenado.class);
    /**
     *
     * @param dataSource
     * @param sql
     * @param sqlParameters
     * @param function
     */
    public FuncionProcedimientoAlmacenado(DataSource dataSource, String sql, SqlParameter[] sqlParameters, Boolean function){
        super(dataSource);
        setProcedureName(sql);
        setFunction(function);
        setStoreProcedure();
        setDeclaredParameters(sqlParameters);
    }

    private void setStoreProcedure(){
        if (!isFunction()){
            setAccessCallParameterMetaData(Boolean.FALSE);
            setReturnValueRequired(Boolean.TRUE);
            addDeclaredParameter (new SqlOutParameter("RETURN_VALUE", Types.INTEGER));
        }
    }

    /**
     *
     * @param parameters
     */
    private void setDeclaredParameters(SqlParameter[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            addDeclaredParameter(parameters[i]);
        }
    }

    /**
     *
     * @param valuesParameter
     * @return
     * @throws DataAccessException
     */
    public Map execute(Map valuesParameter) throws RuntimeException {
        try {
            compile();
            Map out = super.execute(valuesParameter);
            return  out;
        } catch (Exception e){
            logger.error("Error calling SP {} ", this.getProcedureName(), e);
            throw new RuntimeException(e);
        }
    }

}

package ec.org.isspol.persistence.service.comun.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.CantonDao;
import ec.org.isspol.persistence.dao.comun.ComunDao;
import ec.org.isspol.persistence.dao.comun.EstadoDao;
import ec.org.isspol.persistence.dao.comun.ProvinciaDao;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.persistence.service.comun.ComunSvc;
import ec.org.isspol.persistence.entities.comun.Pais;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 17/04/2017.
 */
public class ComunSvcImpl implements ComunSvc {
    private ComunDao comunDao;
    private ProvinciaDao provinciaDao;
    private CantonDao cantonDao;
    private EstadoDao estadoDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    public void setComunDao(ComunDao comunDao) {
        this.comunDao = comunDao;
    }

    public void setProvinciaDao(ProvinciaDao provinciaDao) {
        this.provinciaDao = provinciaDao;
    }

    public void setCantonDao(CantonDao cantonDao) {
        this.cantonDao = cantonDao;
    }

    public void setEstadoDao(EstadoDao estadoDao) {
        this.estadoDao = estadoDao;
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }

    @Override
    public List<Pais> listarPaises() {
        List<Pais>paises= comunDao.getAllPais();
        return paises;
    }

    @Override
    public List<Provincia> listarProvincias() throws IsspolSearchException {
        return provinciaDao.listarPorCriterio(null);
    }

    @Override
    public List<Canton> listarContonesPorProvincia(Provincia provincia) throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("provincia", provincia);
        try {
            return cantonDao.listarPorCriterio(criterion);
        }catch (IsspolSearchException e){
            throw new IsspolSearchException("Error al traer los cantones",e);
        }
    }

    @Override
    public List<Estado> listarEstados() throws IsspolSearchException {
        Criterion criterion = Restrictions.eq("eliminado", Boolean.FALSE);
        try{
            return estadoDao.listarPorCriterio(criterion);
        }catch (IsspolSearchException e){
            throw new IsspolSearchException("Error al traer los estados comun", e);
        }
    }

    public Map<String, Object> fechaHoraSistema(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters=new SqlParameter[]{
                new SqlOutParameter(IsspolConstant.FECHA, Types.DATE)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_FECHAHORASISTEMA,sqlParameters,values);
    }
}

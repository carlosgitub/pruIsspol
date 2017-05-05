package ec.org.isspol.route.comun.facade;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.comun.*;
import ec.org.isspol.persistence.service.comun.ComunSvc;
import ec.org.isspol.persistence.service.comun.LogNotificacionSvc;
import ec.org.isspol.persistence.service.comun.ProcesoNotificacionSvc;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public class ComunServicioFacadeImpl implements ComunServicioFacade {
    private ComunSvc comunSvc;
    private LogNotificacionSvc logNotificacionSvc;
    private ProcesoNotificacionSvc procesoNotificacionSvc;


    /**
     *
     * @return
     */
    @Override
    public List<Pais> listaPaises() throws IsspolException {
        return comunSvc.listarPaises();
    }

    /**
     *
     * @param values
     * @return
     */
    @Override
    public Map<String, Object> fechaHoraSistema(HashMap<String, Object> values) throws IsspolPersistException{
        return comunSvc.fechaHoraSistema(values);
    }

    public void insertarLogNotificacion(LogNotificacion logNotificacion, String codigoProcesoNotificacion) throws IsspolSearchException, IsspolPersistException {
        logNotificacion.setProcesoNotificacion(procesoNotificacionSvc.buscarProcesoNotificacionPorCodigo(codigoProcesoNotificacion));
        logNotificacionSvc.insertLogNotificacion(logNotificacion);
    }

    @Override
    public List<Provincia> listarProvincias() throws IsspolSearchException {
        return comunSvc.listarProvincias();
    }

    @Override
    public List<Canton> listarCantonesPorProvincia(Provincia provincia) throws IsspolSearchException {
        return comunSvc.listarContonesPorProvincia(provincia);
    }

    @Override
    public List<Estado> listarEstados() throws IsspolSearchException {
        return comunSvc.listarEstados();
    }

    public void setLogNotificacionSvc(LogNotificacionSvc logNotificacionSvc) {
        this.logNotificacionSvc = logNotificacionSvc;
    }

    public void setProcesoNotificacionSvc(ProcesoNotificacionSvc procesoNotificacionSvc) {
        this.procesoNotificacionSvc = procesoNotificacionSvc;
    }

    public void setComunSvc(ComunSvc comunSvc) {
        this.comunSvc = comunSvc;
    }

}

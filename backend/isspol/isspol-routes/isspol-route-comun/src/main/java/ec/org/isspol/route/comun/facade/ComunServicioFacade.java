package ec.org.isspol.route.comun.facade;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.comun.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public interface ComunServicioFacade {
    List<Pais> listaPaises() throws IsspolException;
    Map<String,Object>fechaHoraSistema(HashMap<String,Object>values) throws IsspolPersistException;

    /**
     * @title Insertar nueva Notificacion
     * @description Insertar nueva Notificacion que sera enviada por Quartz
     * @author carlos.calo
     * @date 25/04/2017
     * @param logNotificacion
     * @param codigoProcesoNotificacion
     * @throws IsspolSearchException
     * @throws IsspolPersistException
     */
    void insertarLogNotificacion(LogNotificacion logNotificacion, String codigoProcesoNotificacion) throws IsspolSearchException, IsspolPersistException;

    /**
     * @title listarProvincias
     * @description Lista todas las provincias
     * @autor Javier Parada
     * @date 27/04/2017
     * @return
     * @throws IsspolSearchException
     */
    List<Provincia> listarProvincias() throws IsspolSearchException;

    /**
     * @title listarCantonPorProvincia
     * @description Lista todos los cantones en base a una provincia
     * @param provincia
     * @return
     * @throws IsspolSearchException
     */
    List<Canton> listarCantonesPorProvincia(Provincia provincia) throws IsspolSearchException;

    /**
     * @title listarEstado
     * @description Lista los estados de la tabla comun.estado
     * @autor Javier Parada
     * @date 03/05/2017
     * @return
     * @throws IsspolSearchException
     */
    List<Estado> listarEstados() throws IsspolSearchException;


}

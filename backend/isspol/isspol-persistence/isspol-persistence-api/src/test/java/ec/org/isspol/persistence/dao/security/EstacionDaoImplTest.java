package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Estacion;
import ec.org.isspol.persistence.service.security.EstacionSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by mavelin.ati on 18/04/2017.
 */
public class EstacionDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(EstacionDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void insertarEstacion() throws IsspolPersistException {
        EstacionSvc estacionSvc = (EstacionSvc) getBean("estacionSvc");

        Estacion estacion = new Estacion();

        estacion.setHostname("Sistemas");
        estacion.setDireccionFisica("30-E3-7A-2D-9A-7D");
        estacion.setIp("192.168.2.231");
        estacion.setDescripcion("Sistemas");
        estacion.setUbicacion("Desarrollo");

        estacion.setEliminado(false);
        estacion.setCreacionUsuario("Administrador");
        estacion.setCreacionFecha(new Date());
        estacion.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacion.setModificaUsuario("Administrador");
        estacion.setModificaFecha(new Date());
        estacion.setModificaEquipo("30-E3-7A-2D-9A-7D");

        estacionSvc.insertarEstacion(estacion);
    }

    @Test
    public void actualizarEstacion() throws IsspolPersistException {
        EstacionSvc estacionSvc = (EstacionSvc) getBean("estacionSvc");

        Estacion estacion = new Estacion();
        estacion.setIdEstacion(11);
        estacion.setHostname("Servidor Jboss");
        estacion.setDireccionFisica("C8-D3-FF-26-29-79");
        estacion.setIp("192.168.2.248");
        estacion.setDescripcion("Base de Datos");
        estacion.setUbicacion("Servidor Desarrollo");

        estacion.setEliminado(false);
        estacion.setCreacionUsuario("Administrador");
        estacion.setCreacionFecha(new Date());
        estacion.setCreacionEquipo("30-E3-7A-2D-9A-7D");
        estacion.setModificaUsuario("Administrador");
        estacion.setModificaFecha(new Date());
        estacion.setModificaEquipo("30-E3-7A-2D-9A-7D");

        estacionSvc.actualizarEstacion(estacion);
    }

    @Test
    public void listarTodosEstacion() throws IsspolSearchException {
        EstacionSvc estacionSvc = (EstacionSvc) getBean("estacionSvc");

        List<Estacion> estacions = estacionSvc.listarTodosEstacion();
        for (Estacion estacion: estacions){
            logger.info("Estacion {} --> {}",
                    "Hostname: " + estacion.getHostname(),
                    "Ip: " + estacion.getIp());
        }
        Assert.assertNotNull(estacions);
    }

    @Test
    public void buscarEstacionPorId() throws IsspolSearchException {
        EstacionSvc estacionSvc = (EstacionSvc) getBean("estacionSvc");
        Integer id = 10;
        Estacion estacion = estacionSvc.buscarEstacionPorId(id);
        logger.info("Estacion {} --> {}",
                "IdGrupoUsuario: " + estacion.getIdEstacion(),
                "Ip: " + estacion.getIp());
    }

    @Test
    public void testListarEstacionNoEliminado() throws IsspolSearchException{
        EstacionSvc estacionSvc = (EstacionSvc) getBean("estacionSvc");

        PagedResult<Estacion> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia paginado, visualiza los primeros n registros de la lista*/
        filterParam.setItemsPerPage(2);
        pagedResult =  estacionSvc.listarEstacionNoEliminado(filterParam);
        for (Estacion estacion : (List<Estacion>)pagedResult.getItems()){
            logger.info("Estacion {} --> {}",
                    "IdGrupoUsuario: " + estacion.getIdEstacion(),
                    "Ip: " + estacion.getIp());
        }
    }

}

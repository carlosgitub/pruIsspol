package ec.org.isspol.test.seguridad.route;


import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.entities.security.TipoOficina;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SucursalServiceClientTest
 * Clase que permite el test del cliente para el módulo de sucursales y oficinas
 * Fecha: 18/04/2017
 * Autor: Javier Parada
 */
public class SucursalServiceClientTest extends CamelSpringTestSupport {

    private static final Logger LOG = LoggerFactory.getLogger(SucursalServiceClientTest.class);

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route-client-test.xml");
    }

    @Test
    @Ignore
    public void testInsertarSucursal() throws IsspolPersistException {
        Sucursal sucursal = new Sucursal();
        //sucursal.setIdSucursal(1);
        sucursal.setNombre("ISSPOL123444");
        sucursal.setCreacionUsuario("JPA");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        sucursal.setCreacionFecha(new Date());
        sucursal.setCreacionEquipo("PC-JPA");
        sucursal.setModificaUsuario("JPA");
        sucursal.setModificaFecha(new Date());
        sucursal.setModificaEquipo("PC-MODIFICA-TEST");
        sucursal.setEliminado(Boolean.FALSE);
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        LOG.info("Llamando al método: {} ", IsspolConstant.METODO_INSERTAR_SUCURSAL);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_INSERTAR_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{sucursal});
        LOG.info("INSERTANDO {}");
        try {
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if (peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (Exception ex) {
            throw new IsspolPersistException("------Existe un error-----", ex);
        }


    }

    public Sucursal testBuscarSucursalPorId() throws IsspolException {
        Integer idSucursal = 59;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Sucursal sucursal = null;
        LOG.info("calling methodo buscarsucursalPorId ID ==> {} ", idSucursal);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_SUCURSAL_POR_ID);
        peticionRespuesta.setParameters(new Object[]{idSucursal});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        sucursal = (Sucursal) peticionRespuesta.getResullt();
        LOG.info("ID: {}", sucursal.getIdSucursal());
        LOG.info("NOMBRE: {}", sucursal.getNombre());
        return sucursal;
    }

    @Test
    @Ignore
    public void testBuscarSucursalPorId1() throws IsspolException {
        Integer idSucursal = 59;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Sucursal sucursal = null;
        LOG.info("calling methodo buscarsucursalPorId ID ==> {} ", idSucursal);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_SUCURSAL_POR_ID);
        peticionRespuesta.setParameters(new Object[]{idSucursal});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        sucursal = (Sucursal) peticionRespuesta.getResullt();
        LOG.info("ID: {}", sucursal.getIdSucursal());
        LOG.info("NOMBRE: {}", sucursal.getNombre());
    }

    @Test
    @Ignore
    public void testActualizarSucursal() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Sucursal sucursal = this.testBuscarSucursalPorId();

        LOG.info("Sucursal a actualizar; ID: {}", sucursal.getIdSucursal());
        LOG.info("Sucursal a actualizar; Nombre: {}", sucursal.getNombre());
        LOG.info("Llamando al método actualizarSucursal ==> {} ", IsspolConstant.METODO_ACTUALIZAR_SUCURSAL);
        sucursal.setNombre("ISSPOL-ACTUALIZADO");
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_ACTUALIZAR_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{sucursal});
        usuarioService.callRemoteService(peticionRespuesta);
    }

    @Test
    @Ignore
    public void testListarTodasSucursales() throws IsspolException {
        PeticionRespuesta isspolMessage = null;
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        //List<Sucursal> sucursales = null;
        LOG.info("Llamando al método listarTodasSucursales ==> {} ", IsspolConstant.METODO_LISTAR_TODAS_SUCURSAL);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_TODAS_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        for (Sucursal sucursal : (List<Sucursal>) isspolMessage.getResullt()) {
            LOG.info("ID: {}", sucursal.getIdSucursal());
            LOG.info("Nombre: {}", sucursal.getNombre());
        }
    }

    @Test
    @Ignore
    public void testListarSucursalPaginado() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        FilterParam filterParam = new FilterParam(3, 0);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_SUCURSAL_PAGINADO);
        peticionRespuesta.setParameters(new Object[]{filterParam});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        PagedResult<Sucursal> pag = (PagedResult<Sucursal>) peticionRespuesta.getResullt();
        for (Sucursal sucursal : (List<Sucursal>) pag.getItems()) {
            LOG.info("ID: {}", sucursal.getIdSucursal());
            LOG.info("Nombre: {}", sucursal.getNombre());
        }
    }

    @Test
    @Ignore
    public void testListarOficinasPaginado() throws IsspolSearchException, IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        FilterParam filterParam = new FilterParam(3, 0);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_OFICINA_PAGINADO);
        peticionRespuesta.setParameters(new Object[]{filterParam});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        PagedResult<Oficina> pag = (PagedResult<Oficina>) peticionRespuesta.getResullt();
        for (Oficina oficina : (List<Oficina>) pag.getItems()) {
            LOG.info("ID: {}", oficina.getIdOficina());
            LOG.info("Nombre: {}", oficina.getNombre());
        }
    }

    @Test
    @Ignore
    public void testProcOficinaCrud() throws IsspolPersistException, IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        Map<String, Object> in = new HashMap<>();
        in.put(IsspolConstant.AS_OPERACION, "C");/*C:create; U:update*/
        in.put(IsspolConstant.AI_ID_OFICINA, null);
        in.put(IsspolConstant.AI_ID_SUCURSAL, 1);
        in.put(IsspolConstant.AI_ID_TIPO_OFICINA, 1);
        in.put(IsspolConstant.AS_NOMBRE, "OFICINA GYE NORTE TESTS");
        in.put(IsspolConstant.AS_CODIGO, "1004");
        in.put(IsspolConstant.AS_DIRECCION, "DIRECCION GYE");
        in.put(IsspolConstant.AS_TELEFONO,"2222222");
        in.put(IsspolConstant.AI_ID_PROVINCIA,9);
        in.put(IsspolConstant.AI_ID_CANTON,62);
        in.put(IsspolConstant.AI_HABILITADO,1);
        in.put(IsspolConstant.AI_ID_EMPRESA,1);
        in.put(IsspolConstant.AS_CODIGO_2, "OF-CEP12");
        in.put(IsspolConstant.AS_TEL_CODIGO_AREA, "02");
        in.put(IsspolConstant.AS_TEL_CODIGO_REGION, "04");
        in.put(IsspolConstant.AS_OTRO_TELEFONO, "23232323");
        in.put(IsspolConstant.AF_LATITUD, 1);
        in.put(IsspolConstant.AF_LONGITUD,12);
        in.put(IsspolConstant.AS_CREACION_USUARIO,"JPA");
        in.put(IsspolConstant.AS_CREACION_EQUIPO,"00-67-69-00");

        PeticionRespuesta isspolMessage = new PeticionRespuesta(IsspolConstant.METODO_PROC_OFICINA_CRUD, new Object[]{in});
        isspolMessage = usuarioService.callRemoteService(isspolMessage);
        Map<String, Object> result = (Map<String, Object>)isspolMessage.getResullt();
        Assert.assertNotNull(result);
        LOG.info("Resultado: {}",result);
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            LOG.info("{}---{}", entry.getKey(), entry.getValue());
        }
    }

    @Test
    @Ignore
    public void testListaTipoOficinas() throws IsspolException {
        UsuarioService usuarioService = context.getRegistry().lookupByNameAndType("usuarioService", UsuarioService.class);
        LOG.info("Llamando al método listarTodasSucursales ==> {} ", IsspolConstant.METODO_LISTAR_TIPO_OFICINAS);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.METODO_LISTAR_TIPO_OFICINAS, null);
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        for (TipoOficina tipoOficina : (List<TipoOficina>) peticionRespuesta.getResullt()) {
            LOG.info("ID: {} Nombre: {} ", tipoOficina.getIdTipoOficina(), tipoOficina.getNombre());
        }
    }
}

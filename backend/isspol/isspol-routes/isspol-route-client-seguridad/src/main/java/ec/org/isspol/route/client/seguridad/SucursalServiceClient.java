package ec.org.isspol.route.client.seguridad;


import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.entities.security.TipoOficina;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

/**
 * SucursalServiceClient
 * Clase que permite el Servicio para consumir desde el cliente para el módulo de sucursales y oficinas
 * Fecha: 18/04/2017
 * Autor: Javier Parada
 */
public class SucursalServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceClient.class);

    private CamelContext context;
    private UsuarioService usuarioService;

    /**
     * Método para insertar una sucursal
     *
     * @param sucursal
     */
    public void insertarSucursal(Sucursal sucursal) throws IsspolPersistException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        //try {
        sucursal.setEliminado(Boolean.FALSE);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_INSERTAR_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{sucursal});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        //} catch (IsspolException e) {
        //logger.error("Error llamando al método: ".concat(IsspolConstant.METODO_INSERTAR_SUCURSAL), e);
        //throw new IsspolException(e);

        //}
    }

    /**
     * Método para actualizar sucursales
     *
     * @param sucursal
     */
    public void actualizarSucursal(Sucursal sucursal) throws IsspolPersistException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_ACTUALIZAR_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{sucursal});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
    }

    /**
     * Método para eliminar una sucursal
     *
     * @param sucursal
     */
    public void eliminarSucursal(Sucursal sucursal) throws IsspolPersistException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_ELIMINAR_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{sucursal});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());

    }

    /**
     * Método para listar todas las sucursales
     *
     * @return
     */
    public List<Sucursal> listarTodasSucursales() throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Sucursal> sucursales = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_TODAS_SUCURSAL);
        peticionRespuesta.setParameters(new Object[]{});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        sucursales = (List<Sucursal>) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        return sucursales;
    }

    /**
     * Método que devuelve la sucursal en base al id del registro (PK)
     *
     * @param id
     * @return
     */

    public Sucursal buscarSucursalPorId(Integer id) throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Sucursal sucursal = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_BUSCAR_SUCURSAL_POR_ID);
        peticionRespuesta.setParameters(new Object[]{id});
        peticionRespuesta = usuarioService.callRemoteService((peticionRespuesta));
        sucursal = (Sucursal) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        return sucursal;
    }

    public PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;

        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_SUCURSAL_PAGINADO);
        peticionRespuesta.setParameters(new Object[]{filterParam});
        peticionRespuesta = (PeticionRespuesta) usuarioService.callRemoteService(peticionRespuesta);
        pagedResult = (PagedResult) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());

        return pagedResult;
    }

    public void setContext(CamelContext context) {
        this.context = context;
    }

    /*Métodos para el mantenimiento de Oficinas*/

    public PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PagedResult pagedResult = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_LISTAR_OFICINA_PAGINADO);
        peticionRespuesta.setParameters(new Object[]{filterParam});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        pagedResult = (PagedResult) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        return pagedResult;
    }

    public Map<String, Object> procOficinaCrud(HashMap<String, Object> values) throws IsspolPersistException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        Map<String, Object> response = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        peticionRespuesta.setMethod(IsspolConstant.METODO_PROC_OFICINA_CRUD);
        peticionRespuesta.setParameters(new Object[]{values});
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        response = (Map<String, Object>) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolPersistException(peticionRespuesta.getException());
        return response;
    }

    public List<TipoOficina> listarTipoOficina() throws IsspolSearchException, IsspolException {
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta(IsspolConstant.METODO_LISTAR_TIPO_OFICINAS, null);
        peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
        List<TipoOficina> tipoOficinas = (List<TipoOficina>) peticionRespuesta.getResullt();
        if (peticionRespuesta.getException() != null)
            throw new IsspolException(peticionRespuesta.getException());
        return tipoOficinas;
    }

}

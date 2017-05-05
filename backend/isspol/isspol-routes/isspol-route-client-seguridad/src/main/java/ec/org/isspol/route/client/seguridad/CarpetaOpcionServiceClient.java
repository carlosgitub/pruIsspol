package ec.org.isspol.route.client.seguridad;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.persistence.entities.security.*;
import ec.org.isspol.route.security.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by paul.salgado on 26/04/2017.
 */
public class CarpetaOpcionServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(CarpetaOpcionServiceClient.class);

    private CamelContext context;
    public void setContext(CamelContext context) {
        this.context = context;
    }

    private UsuarioService usuarioService;

    public List<CarpetaOpcion> listarCarpetaOpcion(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<CarpetaOpcion> lista = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_CARPETA_OPCION);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lista = (List<CarpetaOpcion>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return lista;
    }

    public List<CarpetaOpcion> listarCarpetaOpcionPorIdCarpetaPadre(Integer idCarpetaOpcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<CarpetaOpcion> lista = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_CARPETA_OPCION_POR_ID_CARPETA_PADRE);
            peticionRespuesta.setParameters(new Object[]{idCarpetaOpcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lista = (List<CarpetaOpcion>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return lista;
    }

    public List<Opcion> listarOpcion(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Opcion> lista = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_OPCION);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lista = (List<Opcion>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return lista;
    }

    public List<Opcion> listarOpcionPorIdCarpetaOpcion(Integer idCarpetaOpcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Opcion> lista = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_OPCION_POR_ID_CARPETA_OPCION);
            peticionRespuesta.setParameters(new Object[]{idCarpetaOpcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lista = (List<Opcion>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return lista;
    }

    public List<Icono> listarIcono(){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        List<Icono> lista = null;
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_LISTAR_ICONO);
            peticionRespuesta.setParameters(new Object[]{});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            lista = (List<Icono>) peticionRespuesta.getResullt();
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method: ".concat(peticionRespuesta.getMethod()), e);
        }
        return lista;
    }

    public void insertarCarpetaOpcion(CarpetaOpcion carpetaOpcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_CARPETA_OPCION);
            peticionRespuesta.setParameters(new Object[]{carpetaOpcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }

    public void actualizarCarpetaOpcion(CarpetaOpcion carpetaOpcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_CARPETA_OPCION);
            peticionRespuesta.setParameters(new Object[]{carpetaOpcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }
    public void eliminarCarpetaOpcion(CarpetaOpcion carpetaOpcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ELIMINAR_CARPETA_OPCION);
            peticionRespuesta.setParameters(new Object[]{carpetaOpcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }

    public void insertarOpcion(Opcion opcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_INSERTAR_OPCION);
            peticionRespuesta.setParameters(new Object[]{opcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }

    public void actualizarOpcion(Opcion opcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ACTUALIZAR_OPCION);
            peticionRespuesta.setParameters(new Object[]{opcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }
    public void eliminarOpcion(Opcion opcion){
        usuarioService = context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class);
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        try {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_ELIMINAR_OPCION);
            peticionRespuesta.setParameters(new Object[]{opcion});
            peticionRespuesta = usuarioService.callRemoteService(peticionRespuesta);
            if(peticionRespuesta.getException() != null)
                throw new IsspolException(peticionRespuesta.getException());
        } catch (IsspolException e) {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
    }

    public CarpetaOpcion buscarCarpetaOpcionPorId(Integer id)
    {
        this.usuarioService = ((UsuarioService)this.context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class));
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        CarpetaOpcion result = null;
        try
        {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_CARPETA_OPCION_POR_ID);
            peticionRespuesta.setParameters(new Object[] { id });
            peticionRespuesta = this.usuarioService.callRemoteService(peticionRespuesta);
            result = (CarpetaOpcion)peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null) {
                throw new IsspolException(peticionRespuesta.getException());
            }
        }
        catch (IsspolException e)
        {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return result;
    }

    public Opcion buscarOpcionPorId(Integer id)
    {
        this.usuarioService = ((UsuarioService)this.context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class));
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        Opcion result = null;
        try
        {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_OPCION_POR_ID);
            peticionRespuesta.setParameters(new Object[] { id });
            peticionRespuesta = this.usuarioService.callRemoteService(peticionRespuesta);
            result = (Opcion)peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null) {
                throw new IsspolException(peticionRespuesta.getException());
            }
        }
        catch (IsspolException e)
        {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return result;
    }

    public Icono buscarIconoPorId(Integer id)
    {
        this.usuarioService = ((UsuarioService)this.context.getRegistry().lookupByNameAndType("usuario", UsuarioService.class));
        PeticionRespuesta peticionRespuesta = new PeticionRespuesta();
        Icono result = null;
        try
        {
            peticionRespuesta.setMethod(IsspolConstant.METHOD_BUSCAR_ICONO_POR_ID);
            peticionRespuesta.setParameters(new Object[] { id });
            peticionRespuesta = this.usuarioService.callRemoteService(peticionRespuesta);
            result = (Icono)peticionRespuesta.getResullt();
            if (peticionRespuesta.getException() != null) {
                throw new IsspolException(peticionRespuesta.getException());
            }
        }
        catch (IsspolException e)
        {
            logger.error("Error Calling Remote Method ".concat(peticionRespuesta.getMethod()), e);
        }
        return result;
    }
}

package ec.org.isspol.web.seguridades;

import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.UsuarioServiceClient;
import ec.org.isspol.web.comun.ComunController;
import ec.org.isspol.web.dto.seguridad.GrupoDto;
import ec.org.isspol.web.map.SeguridadDtoMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

/**
 * Created by Edison Aulestia on 18/04/2017.
 */
@Controller
public class GrupoController extends ComunController{

    private static final Logger logger = LoggerFactory.getLogger(GrupoController.class);
    public  Grupo insertarActualizarGrupo(GrupoDto grupo) {
        Grupo grup = null;
        grupo.setNombre(grupo.getNombre().toUpperCase());
        try {
            if (grupo.getIdGrupo() == null) {
                grupo.setCreacionUsuario(getHostName());
                grupo.setCreacionEquipo(getDireccionMac());
                grupo.setModificaUsuario(getHostName());
                grupo.setModificaEquipo(getDireccionMac());
                grupo.setCreacionFecha(new Date());
                grupo.setModificaFecha(new Date());
                grupo.setEliminado(false);
            } else {
                grupo.setModificaUsuario(getHostName());
                grupo.setModificaEquipo(getDireccionMac());
            }
            grup = SeguridadDtoMap.INSTANCE.grupoDtoToGrupo( grupo );

            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
             client.insertarActualizarGrupo(grup);
        } catch (Exception ex) {
            logger.error("Error al insertar Grupo - Rol", ex);
           return grup;
        }
        return grup;
    }
    public  Grupo eliminarGrupo( GrupoDto grupo) {
        Grupo grup = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            grupo.setEliminado(true);
            grupo.setModificaUsuario(getHostName());
            grupo.setModificaEquipo(getDireccionMac());
            grup = SeguridadDtoMap.INSTANCE.grupoDtoToGrupo( grupo );
            client.eliminarGrupo(grup);
        } catch (Exception ex) {
            logger.error("Error al eliminar Grupo - Rol", ex);
            grup.setException(ex);
            return grup;
        }
        return grup;
    }

    public List<Grupo> listarGrupos() {


        List<Grupo> lista = null;
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        try {
            lista = client.listarTodos();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        return lista;

    }

    public Grupo buscarGrupoPorId(Integer idGrupo){
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        Grupo grupo=null;
        try{
            grupo=client.buscarGrupoPorId(idGrupo);
        }catch (Exception e){
            logger.info("Error al buscar el grupo {}", e);
        }

        return grupo;
    }
}

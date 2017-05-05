package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.entities.security.Estacion;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.UsuarioServiceClient;
import ec.org.isspol.web.comun.ComunController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by mavelin.ati on 25/04/2017.
 */
@Controller
public class EstacionController extends ComunController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @RequestMapping(value = "/insertarActualizarEstacion_json", method = RequestMethod.POST)
    public @ResponseBody Estacion insertarActualizarEstacion(@RequestBody Estacion estacion, HttpSession session) {
        try {
            estacion.setEliminado(false);
            estacion.setModificaUsuario(getHostName());
            estacion.setModificaFecha(new Date());
            estacion.setModificaEquipo(getDireccionMac());
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            if(estacion.getIdEstacion() == null){
                estacion.setCreacionUsuario(getHostName());
                estacion.setCreacionFecha(new Date());
                estacion.setCreacionEquipo(getDireccionMac());
                client.insertarEstacion(estacion);
            } else {
                client.actualizarEstacion(estacion);
            }
        } catch (Exception ex) {
            logger.error("Error al insertarActualizar: Estacion", ex);
            //estacion.sete
            return estacion;
        }
        return estacion;
    }

    @RequestMapping(value = "/eliminarEstacion_json", method = RequestMethod.POST)
    public @ResponseBody Estacion eliminarEstacion(@RequestBody Estacion estacion, HttpSession session) {
        try {
            estacion.setEliminado(true);
            estacion.setModificaUsuario(getHostName());
            estacion.setModificaFecha(new Date());
            estacion.setModificaEquipo(getDireccionMac());
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            client.actualizarEstacion(estacion);
        } catch (Exception ex) {
            logger.error("Error al eliminar Estacion ", ex);
            return estacion;
        }
        return estacion;
    }

    public List<Estacion> listarTodosEstacion() {
        List<Estacion> estacions = null;
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacions = client.listarTodosEstacion();
        } catch (Exception ex) {
            logger.error("Error metodo listarTodosEstacion ", ex);
        }
        return estacions;
    }

    public Estacion buscarEstacionPorId(Integer id) {
        Estacion estacion = new Estacion();
        try {
            UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
            estacion = client.buscarEstacionPorId(id);
        } catch (Exception ex) {
            logger.error("Error metodo buscarEstacionPorId ", ex);
        }
        return estacion;
    }

    public PagedResult<Estacion> listarEstacionNoEliminado(FilterParam filterParam) {
        PagedResult<Estacion> estacionPagedResult = null;
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        try{
            estacionPagedResult = client.listarEstacionNoEliminado(filterParam);
        }catch (Exception ex){
            logger.error("Error metodo listarEstacionNoEliminado ", ex);
        }
        return estacionPagedResult;
    }
}

package ec.org.isspol.web.comun;

import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.route.client.comun.ComunClienteServicio;
import ec.org.isspol.route.client.context.AppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.List;

/**
 * Created by Paul Salgado on 25/04/2017.
 */
@Controller
public class ComunController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ComunController.class);

    private String direccionMac;
    private String hostName;
    private InetAddress localhost;

    public ComunController() {
        try {
            localhost = InetAddress.getLocalHost();
        } catch (Exception e) {
            logger.error("Error al obtener el host: ", e);
        }
    }

    public String getDireccionMac() {
        StringBuilder sb = null;
        try {
            byte[] mac = NetworkInterface.getByInetAddress(localhost).getHardwareAddress();
            sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            direccionMac = sb.toString();
        } catch (Exception e) {
            logger.error("Error al obtener direccion MAC: ", e);
        }
        return direccionMac;
    }

    public String getHostName() {
        hostName = localhost.getHostName();
        return hostName;
    }
    
    public Boolean isNullOrEmpty(String value){
        if(value == null)
            return Boolean.TRUE;
        return value.isEmpty();
    }


    public List<Provincia> listarProvincias(){
        List<Provincia> lista = null;
        ComunClienteServicio client = (ComunClienteServicio) AppContext.getBean("comunClienteServicio");
        try {
            lista = client.listarProvincias();
        } catch (Exception e) {
            logger.error("Error metodo listarProvincias", e);
        }
        return lista;
    }

    public List<Canton> listarCantonesPorProvincia(Provincia provincia){
        List<Canton> lista = null;
        ComunClienteServicio client = (ComunClienteServicio) AppContext.getBean("comunClienteServicio");
        try {
            lista = client.listarCantonesPorProvincia(provincia);
        } catch (Exception e) {
            logger.error("Error metodo listarCantonesPorProvincia", e);
        }
        return lista;
    }

    public List<Estado> listarEstados() {
        List<Estado> lista = null;
        ComunClienteServicio client = (ComunClienteServicio) AppContext.getBean("comunClienteServicio");
        try {
            lista = client.listarEstados();
        } catch (Exception e) {
            logger.error("Error metodo listarEstados", e);
        }
        return lista;
    }



}

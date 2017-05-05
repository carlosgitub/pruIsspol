package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.persistence.entities.security.Oficina;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.entities.security.TipoOficina;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.SucursalServiceClient;
import ec.org.isspol.web.comun.ComunController;
import ec.org.isspol.web.exception.AngularException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Javier on 18/04/2017.
 */
public class SucursalController extends ComunController{

    private static final Logger logger = LoggerFactory.getLogger(SucursalController.class);

    public Sucursal insertarSucursal(Sucursal sucursal) {
            if (sucursal.getIdSucursal() == null) {
                sucursal.setCreacionUsuario(getHostName());
                sucursal.setCreacionEquipo(getDireccionMac());
                sucursal.setModificaUsuario(getHostName());
                sucursal.setModificaEquipo(getDireccionMac());
                sucursal.setCreacionFecha(new Date());
                sucursal.setModificaFecha(new Date());
            } else {
                sucursal.setModificaUsuario(getHostName());
                sucursal.setModificaEquipo(getDireccionMac());
            }
            SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            client.insertarSucursal(sucursal);
        } catch (Exception e) {
            logger.error("Error al insertar Sucursal", e);
            sucursal.setException(e);
            return sucursal;
        }
        return sucursal;
    }

    public List<Sucursal> listarSucursales() {
        List<Sucursal> lista = null;
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            lista = client.listarTodasSucursales();
        } catch (Exception e) {
            logger.error("Error al listar las Sucursales", e);
        }
        return lista;
    }

    public Sucursal eliminarSucursal(Sucursal sucursal) {
        sucursal.setEliminado(true);
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            client.eliminarSucursal(sucursal);
        } catch (Exception e) {
            logger.error("Error al eliminar", e);
            sucursal.setException(e);
            return sucursal;
        }
        return sucursal;
    }

    public PagedResult<Sucursal> listarSucursalPaginado(FilterParam filterParam) {
        PagedResult<Sucursal> listaPaginada = null;
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            listaPaginada = client.listarSucursalPaginado(filterParam);
        } catch (Exception e) {
            logger.error("Error al listar las Sucursales", e);
        }
        return listaPaginada;
    }


    public PagedResult<Oficina> listarOficinaPaginado(FilterParam filterParam) {
        PagedResult<Oficina> listaPaginada = null;
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            listaPaginada = client.listarOficinaPaginado(filterParam);
        } catch (Exception e) {
            logger.error("Error al listar las oficinas", e);
        }
        return listaPaginada;
    }

    public Oficina insertarActualizarOficina(Oficina oficina) throws IsspolPersistException {
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        String strOperacion = "C";
        if(oficina.getIdOficina() != null)
            strOperacion = "U";
        String mensaje = "";
        Oficina objOficina = null;
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AS_OPERACION, strOperacion);/*C:create; U:update*/
        in.put(IsspolConstant.AI_ID_OFICINA, oficina.getIdOficina());
        in.put(IsspolConstant.AI_ID_SUCURSAL, oficina.getSucursal().getIdSucursal());
        in.put(IsspolConstant.AI_ID_TIPO_OFICINA, oficina.getTipoOficina().getIdTipoOficina());
        in.put(IsspolConstant.AS_NOMBRE, oficina.getNombre());
        in.put(IsspolConstant.AS_CODIGO, oficina.getCodigo());
        in.put(IsspolConstant.AS_DIRECCION, oficina.getDireccion());
        in.put(IsspolConstant.AS_TELEFONO, oficina.getTelefono());
        in.put(IsspolConstant.AI_ID_PROVINCIA, oficina.getProvincia().getIdProvincia());
        in.put(IsspolConstant.AI_ID_CANTON, oficina.getCanton().getIdCanton());
        in.put(IsspolConstant.AI_HABILITADO, oficina.getEstado().getIdEstado());
        in.put(IsspolConstant.AI_ID_EMPRESA, 1);
        in.put(IsspolConstant.AS_CODIGO_2, oficina.getCodigo2());
        in.put(IsspolConstant.AS_TEL_CODIGO_AREA, oficina.getTelCodigoArea());
        in.put(IsspolConstant.AS_TEL_CODIGO_REGION, oficina.getTelCodigoRegion());
        in.put(IsspolConstant.AS_OTRO_TELEFONO, oficina.getOtroTelefono());
        in.put(IsspolConstant.AF_LATITUD, oficina.getLatitud());
        in.put(IsspolConstant.AF_LONGITUD, oficina.getLongitud());
        in.put(IsspolConstant.AS_CREACION_USUARIO, "JPA");
        in.put(IsspolConstant.AS_CREACION_EQUIPO, "00-67-69-00");
        PeticionRespuesta message = new PeticionRespuesta(IsspolConstant.METODO_PROC_OFICINA_CRUD, new Object[]{in});
        try {
            Map<String, Object> response = client.procOficinaCrud(in);
            mensaje = response.get("AS_MSJ").toString();
            if (mensaje != null || mensaje != "")
                throw new AngularException(mensaje);
        } catch (Exception e) {
            logger.warn("Error al recibir el mensaje", mensaje);
            objOficina = new Oficina();
            objOficina.setException(new AngularException(mensaje));
        } finally {
            return objOficina;
        }
    }

    public List<TipoOficina> listarTipoOficinas() {
        List<TipoOficina> lista = null;
        SucursalServiceClient client = (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        try {
            lista = client.listarTipoOficina();
        } catch (Exception e) {
            logger.error("Error al listar los Tipos de Oficina", e);
        }
        return lista;
    }




    public Sucursal buscarSucursalPorId(Integer idSucursal) throws IsspolSearchException, IsspolException {
        SucursalServiceClient sucursalServiceClient= (SucursalServiceClient) AppContext.getBean("sucursalServiceClient");
        Sucursal sucursal=sucursalServiceClient.buscarSucursalPorId(idSucursal);
        return sucursal;
    }

    

}


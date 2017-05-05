package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolProcessException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.CarpetaOpcion;
import ec.org.isspol.persistence.entities.security.Opcion;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.CarpetaOpcionServiceClient;
import ec.org.isspol.web.comun.ComunController;
import ec.org.isspol.web.dto.CarpetaOpcionDto;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrganizacionMenuController extends ComunController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OrganizacionMenuController.class);
    private ModelMapper mapper = new ModelMapper();
    private CarpetaOpcionServiceClient client;

    private PropertyMap<CarpetaOpcion, CarpetaOpcionDto> mapping = new PropertyMap<CarpetaOpcion, CarpetaOpcionDto>() {
        @Override
        protected void configure() {
            map().setId(source.getIdCarpetaOpcion());
            map().setLabel(source.getNombre());

            map().setNombreCarpetaOpcionPadre(source.getCarpetaOpcion().getNombre());
            map().setIdCarpetaOpcionPadre(source.getCarpetaOpcion().getIdCarpetaOpcion());

            map().setIdIcono(source.getIcono().getIdIcono());
            map().setIcono(source.getIcono().getIcono());
        }
    };

    public OrganizacionMenuController() {
        mapper.addMappings(mapping);
    }

    Type listType = new TypeToken<List<CarpetaOpcionDto>>() {
    }.getType();

    public List<CarpetaOpcionDto> listarCarpetaOpcion() throws IsspolSearchException, IsspolException, IsspolProcessException {
        List<CarpetaOpcion> listaCarpetaOpcion;
        List<CarpetaOpcionDto> result;
        try {
            client = ((CarpetaOpcionServiceClient) AppContext.getBean("carpetaOpcionServiceClient"));
            listaCarpetaOpcion = client.listarCarpetaOpcion();
            for (CarpetaOpcion x: listaCarpetaOpcion){
                logger.info("Carpeta: '{}' '{}'", x.getNombre(), x.getIcono().getIcono());
            }
        } catch (Exception e) {
            logger.error("Error al listar CarpetaOpcion: ", e);
            throw new IsspolSearchException("Error: ", e);
        }
        try {
            result = (List<CarpetaOpcionDto>) mapper.map(listaCarpetaOpcion, listType);
        } catch (Exception e) {
            logger.error("Error al convertir CarpetaOpcionDto: ", e);
            throw new IsspolProcessException(e);
        }
        return result;
    }

    public List<Opcion> listarOpcion() throws IsspolSearchException, IsspolException {
        List<Opcion> listaOpcion;
        try {
            client = ((CarpetaOpcionServiceClient) AppContext.getBean("carpetaOpcionServiceClient"));
            listaOpcion = client.listarOpcion();
        } catch (Exception e) {
            logger.error("Error al listar Opcion: ", e);
            throw new IsspolSearchException(e);
        }
        return listaOpcion;
    }

    public CarpetaOpcion insertarCarpetaOpcion(CarpetaOpcionDto carpetaOpcionDto)
            throws IsspolPersistException {
        CarpetaOpcion carpetaOpcion = new CarpetaOpcion();
        try {
            this.client = ((CarpetaOpcionServiceClient) AppContext.getBean("carpetaOpcionServiceClient"));
            carpetaOpcion.setNombre(carpetaOpcionDto.getLabel());
            carpetaOpcion.setDescripcion(carpetaOpcionDto.getDescripcion());
            carpetaOpcion.setCarpetaOpcion(client.buscarCarpetaOpcionPorId(carpetaOpcionDto.getIdCarpetaOpcion()));
            carpetaOpcion.setOrden(carpetaOpcionDto.getOrden());
            carpetaOpcion.setIcono(client.buscarIconoPorId(carpetaOpcionDto.getIdIcono()));
            carpetaOpcion.setCodigo(carpetaOpcionDto.getCodigo());
            carpetaOpcion.setNivel(carpetaOpcionDto.getNivel());
            carpetaOpcion.setObjeto(carpetaOpcionDto.getObjeto());
            carpetaOpcion.setParametro(carpetaOpcionDto.getParametro());
            carpetaOpcion.setVisible(carpetaOpcionDto.getVisible());
            carpetaOpcion.setCreacionUsuario(getHostName());
            carpetaOpcion.setCreacionFecha(new Date());
            carpetaOpcion.setCreacionEquipo(getDireccionMac());
            carpetaOpcion.setModificaUsuario(getHostName());
            carpetaOpcion.setModificaFecha(new Date());
            carpetaOpcion.setModificaEquipo(getDireccionMac());
            this.client.insertarCarpetaOpcion(carpetaOpcion);
        } catch (Exception e) {
            logger.warn("Error al insertar Carpeta Opcion", e);
        }
        return carpetaOpcion;
    }
}

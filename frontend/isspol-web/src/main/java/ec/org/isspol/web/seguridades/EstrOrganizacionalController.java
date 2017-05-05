package ec.org.isspol.web.seguridades;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.entities.security.EstructuraOrganizacional;
import ec.org.isspol.persistence.entities.security.NivelEstructuraOrg;
import ec.org.isspol.route.client.context.AppContext;
import ec.org.isspol.route.client.seguridad.EstructuraOrganizacionalClient;
import ec.org.isspol.route.client.seguridad.UsuarioServiceClient;
import ec.org.isspol.web.dto.EstructuraOrganizacionalDto;
import ec.org.isspol.web.exception.AngularException;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by santiago.yacelga on 20/04/2017.
 */
public class EstrOrganizacionalController {
    private static final Logger logger = LoggerFactory.getLogger(EstrOrganizacionalController.class);
    private ModelMapper mapper = new ModelMapper();

    private PropertyMap<EstructuraOrganizacional, EstructuraOrganizacionalDto> mapping = new PropertyMap<EstructuraOrganizacional, EstructuraOrganizacionalDto>() {
        @Override
        protected void configure() {
            map().setPadreEstructuraOrganizacional(source.getPadreEstructuraOrganizacional().getId());
            map().setLabelPadre(source.getPadreEstructuraOrganizacional().getLabel());
        }
    };

    public EstrOrganizacionalController() {
        mapper.addMappings(mapping);
    }

    Type listType = new TypeToken<Collection<EstructuraOrganizacionalDto>>() {
    }.getType();


    public Collection<EstructuraOrganizacionalDto> listarEstructuraOrganizacional() throws IsspolSearchException, IsspolException, IsspolProcessException {
        EstructuraOrganizacionalClient client = null;
        Collection<EstructuraOrganizacional> lstEstOr = null;
        try {
            client = (EstructuraOrganizacionalClient) AppContext.getBean("estructuraOrganizacionalClient");
            lstEstOr = client.listarEstrucOraganiz();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
            throw new IsspolSearchException("Error" + ex);
        }
        Collection<EstructuraOrganizacionalDto> result = null;
        try {
            if (lstEstOr != null) {
                result = mapper.map(lstEstOr, listType);
            }
        } catch (Exception ex) {
            throw new IsspolProcessException("Error" + ex);
        }
        return result;
    }

    ;

    public Collection<NivelEstructuraOrg> listarTodosNivelEstructuraOrg() throws IsspolSearchException, IsspolException {
        EstructuraOrganizacionalClient client = null;
        Collection<NivelEstructuraOrg> lstNivel = null;
        try {
            client = (EstructuraOrganizacionalClient) AppContext.getBean("estructuraOrganizacionalClient");
            lstNivel = client.listarTodosNivelEstructuraOrg();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
            throw new IsspolSearchException(ex);
        }
        return lstNivel;
    }

    public EstructuraOrganizacional insertarEstrOrganizacional(EstructuraOrganizacionalDto estructuraOrganizacional) throws IsspolPersistException {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        String mensaje = "";
        EstructuraOrganizacional estr = null;
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, estructuraOrganizacional.getId());
        in.put(IsspolConstant.AS_CODIGO, estructuraOrganizacional.getCodigo());
        in.put(IsspolConstant.AS_DESCRIPCION, estructuraOrganizacional.getLabel());
        in.put(IsspolConstant.AI_ORDEN, estructuraOrganizacional.getOrden());
        in.put(IsspolConstant.AI_NIVEL, estructuraOrganizacional.getNivel().getIdNivelEstructuraOrg());
        in.put(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, estructuraOrganizacional.getPadreEstructuraOrganizacional());
        in.put(IsspolConstant.AS_USUARIO, "ADMIN");
        in.put(IsspolConstant.AS_USUARIO_ACT, "ESYACELGA");

       PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR);
        message.setParameters(new Object[]{in});
        try {
            Map<String, Object> response = (Map<String, Object>) client.procEstructuraOrganizacionalGuardar(in);
            mensaje = response.get("AS_MSJ").toString();
            if (mensaje != null || mensaje != "") {
                throw new AngularException(mensaje);
            }
        } catch (Exception ex) {
            logger.warn("Error al recibir el mensaje", mensaje);
            estr = new EstructuraOrganizacional();
            estr.setException(new AngularException(mensaje));

        } finally {

            return estr;
        }

    }

    public EstructuraOrganizacional elimiarEstructuraOrganizacional(EstructuraOrganizacionalDto estructuraOrganizacional) throws IsspolPersistException {
        UsuarioServiceClient client = (UsuarioServiceClient) AppContext.getBean("usuarioServiceClient");
        String mensaje = "";
        EstructuraOrganizacional estr = null;
        HashMap<String, Object> in = new HashMap();
        in.put(IsspolConstant.AI_ID_ESTRUCTURA, estructuraOrganizacional.getId());
        in.put(IsspolConstant.AS_USUARIO, "YO");
        in.put(IsspolConstant.AS_MSJ, "Root B");


       PeticionRespuesta message = new PeticionRespuesta();
        message.setMethod(IsspolConstant.METHOD_PROC_ESTRUCTURA_ORGANIZACIONAL_ELIMINAR);
        message.setParameters(new Object[]{in});
        try {
            Map<String, Object> response = (Map<String, Object>) client.procEstructuraOrganizacionalEliminar(in);
            mensaje = response.get("AS_MSJ").toString();
            if (mensaje != null || mensaje != "") {
                throw new AngularException(mensaje);
            }
        } catch (Exception ex) {
            logger.warn("Error al recibir el mensaje", mensaje);
            estr = new EstructuraOrganizacional();
            estr.setException(new AngularException(mensaje));

        } finally {

            return estr;
        }
    }

    ;


}

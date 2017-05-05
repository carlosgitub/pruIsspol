package ec.org.isspol.route.security.service.bean;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.security.facade.UsuarioServiceFacade;
import ec.org.isspol.route.security.service.UsuarioService;
import ec.org.isspol.service.pool.IsspolServiceProcesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by mauchilan on 24/3/17.
 */
public class UsuarioServiceBean extends IsspolServiceProcesor implements UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceBean.class);

    private UsuarioServiceFacade usuarioServiceFacade;

    @Override
    public PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException{
        long startTime = System.currentTimeMillis();
        Method method = null;
        try {
            this.usuarioServiceFacade = (UsuarioServiceFacade) getServicePool().borrowObject();
            for (Method cm : (this.usuarioServiceFacade .getClass().getDeclaredMethods())) {
                if (peticionRespuesta.getMethod().equals(cm.getName())) {
                    method = cm;
                    break;
                }
            }
            if (method == null)
                throw new Exception("Method ".concat(peticionRespuesta.getMethod()).concat(" not found in ").concat(this.usuarioServiceFacade.getClass().getName()));
            peticionRespuesta = getCaller().callRemoteClass(method, this.usuarioServiceFacade, peticionRespuesta);
            long endTime = System.currentTimeMillis();
            logger.info("Method {} took {} milliseconds", peticionRespuesta.getMethod(), String.valueOf(endTime - startTime));
        }catch (Exception e){
            peticionRespuesta.setException(e);
            logger.error("Error ",e);
            throw new IsspolException("Error ", e);
        }finally {
            try {
                getServicePool().returnObject(this.usuarioServiceFacade);
            } catch (Exception e) {
                logger.error("Error ",e);
                throw new IsspolException("Error ", e);
            }
        }
        return peticionRespuesta;
    }

    @Override
    public Object createService() {
        return this.usuarioServiceFacade;
    }

    public void setUsuarioServiceFacade(UsuarioServiceFacade usuarioServiceFacade) {
        this.usuarioServiceFacade = usuarioServiceFacade;
    }

}

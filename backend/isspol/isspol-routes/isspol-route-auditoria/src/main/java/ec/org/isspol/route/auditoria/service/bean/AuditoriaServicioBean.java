package ec.org.isspol.route.auditoria.service.bean;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.auditoria.facade.AuditoriaServicioFacade;
import ec.org.isspol.route.auditoria.service.AuditoriaServicio;
import ec.org.isspol.service.pool.IsspolServiceProcesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class AuditoriaServicioBean extends IsspolServiceProcesor implements AuditoriaServicio {
    private static final Logger logger = LoggerFactory.getLogger(AuditoriaServicioBean.class);

    private AuditoriaServicioFacade auditoriaServicioFacade;

    @Override
    public Object createService(){
        return this.auditoriaServicioFacade;
    }

    @Override
    public PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException{
        long startTime = System.currentTimeMillis();
        Method method = null;
        try {
            this.auditoriaServicioFacade = (AuditoriaServicioFacade) getServicePool().borrowObject();
            for (Method cm : (this.auditoriaServicioFacade.getClass().getDeclaredMethods())) {
                if (peticionRespuesta.getMethod().equals(cm.getName())) {
                    method = cm;
                    break;
                }
            }
            if (method == null)
                throw new Exception("Method ".concat(peticionRespuesta.getMethod()).concat(" not found in ").concat(this.auditoriaServicioFacade.getClass().getName()));
            peticionRespuesta = getCaller().callRemoteClass(method, this.auditoriaServicioFacade, peticionRespuesta);
            long endTime = System.currentTimeMillis();
            logger.info("Method {} took {} milliseconds", peticionRespuesta.getMethod(), String.valueOf(endTime - startTime));
        }catch (Exception e){
            logger.error("Error ",e);
            throw new IsspolException("Error ", e);
        }finally {
            try {
                getServicePool().returnObject(this.auditoriaServicioFacade);
            } catch (Exception e) {
                logger.error("Error ",e);
                throw new IsspolException("Error ", e);
            }
        }
        return peticionRespuesta;
    }

    public void setAuditoriaServicioFacade(AuditoriaServicioFacade auditoriaServicioFacade) {
        this.auditoriaServicioFacade = auditoriaServicioFacade;
    }
}

package ec.org.isspol.route.comun.service.bean;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.comun.facade.ComunServicioFacade;
import ec.org.isspol.route.comun.service.ComunServicio;
import ec.org.isspol.service.pool.IsspolServiceProcesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public class ComunServicioBean extends IsspolServiceProcesor implements ComunServicio {
    private static final Logger logger = LoggerFactory.getLogger(ComunServicioBean.class);

    private ComunServicioFacade comunServicioFacade;

    @Override
    public PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException{
        long startTime = System.currentTimeMillis();
        Method method = null;
        try {
            this.comunServicioFacade = (ComunServicioFacade) getServicePool().borrowObject();
            for (Method cm : (this.comunServicioFacade.getClass().getDeclaredMethods())) {
                if (peticionRespuesta.getMethod().equals(cm.getName())) {
                    method = cm;
                    break;
                }
            }
            if (method == null)
                throw new Exception("Method ".concat(peticionRespuesta.getMethod()).concat(" not found in ").concat(this.comunServicioFacade.getClass().getName()));
            peticionRespuesta = getCaller().callRemoteClass(method, this.comunServicioFacade, peticionRespuesta);
            long endTime = System.currentTimeMillis();
            logger.info("Method {} took {} milliseconds", peticionRespuesta.getMethod(), String.valueOf(endTime - startTime));
        }catch (Exception e){
            logger.error("Error ",e);
            throw new IsspolException("Error ", e);
        }finally {
            try {
                getServicePool().returnObject(this.comunServicioFacade);
            } catch (Exception e) {
                logger.error("Error ",e);
                throw new IsspolException("Error ", e);
            }
        }
        return peticionRespuesta;
    }

    @Override
    public Object createService() {
        return this.comunServicioFacade;
    }

    public void setComunServicioFacade(ComunServicioFacade comunServicioFacade) {
        this.comunServicioFacade = comunServicioFacade;
    }

}

package ec.org.isspol.route.security.service.bean;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;
import ec.org.isspol.route.security.facade.IAfiliacionServiceFacade;
import ec.org.isspol.route.security.service.IAfiliacionServiceBean;
import ec.org.isspol.service.pool.IsspolServiceProcesor;

import java.lang.reflect.Method;

/**
 * Created by roberto.chasipanta on 5/4/2017.
 */
public class AfiliacionServiceBeanImpl extends IsspolServiceProcesor implements IAfiliacionServiceBean {

    private IAfiliacionServiceFacade afiliacionServiceFacade;

    @Override
    public Object createService() {
        return afiliacionServiceFacade;
    }

    @Override
    public PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException {
        long startTime = System.currentTimeMillis();
        Method method = null;
        try {
            afiliacionServiceFacade = (IAfiliacionServiceFacade) getServicePool().borrowObject();
            for (Method cm : (afiliacionServiceFacade.getClass().getDeclaredMethods())) {
                if (peticionRespuesta.getMethod().equals(cm.getName())) {
                    method = cm;
                    break;
                }
            }
            if (method == null)
                throw new Exception("Method ".concat(peticionRespuesta.getMethod()).
                        concat(" not found in ").concat(afiliacionServiceFacade.getClass().getName()));
            peticionRespuesta = getCaller().callRemoteClass(method, afiliacionServiceFacade, peticionRespuesta);
            long endTime = System.currentTimeMillis();
        } catch (Exception e) {
            peticionRespuesta.setException(e);
            throw new IsspolException("Error ", e);
        } finally {
            try {
            } catch (Exception e) {
                throw new IsspolException("Error ", e);
            }
        }
        return peticionRespuesta;
    }


    public IAfiliacionServiceFacade getAfiliacionServiceFacade() {
        return afiliacionServiceFacade;
    }

    public void setAfiliacionServiceFacade(IAfiliacionServiceFacade afiliacionServiceFacade) {
        this.afiliacionServiceFacade = afiliacionServiceFacade;
    }


}

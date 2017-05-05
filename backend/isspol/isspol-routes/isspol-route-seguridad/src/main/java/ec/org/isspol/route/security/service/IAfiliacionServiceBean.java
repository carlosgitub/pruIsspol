package ec.org.isspol.route.security.service;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;

/**
 * Created by roberto.chasipanta on 5/4/2017.
 */
public interface IAfiliacionServiceBean {
    PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException;
}

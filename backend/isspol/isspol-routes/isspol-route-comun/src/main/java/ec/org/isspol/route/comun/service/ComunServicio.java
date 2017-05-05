package ec.org.isspol.route.comun.service;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;

/**
 * Created by andres.campoverde on 18/04/2017.
 */
public interface ComunServicio {
    PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException;
}

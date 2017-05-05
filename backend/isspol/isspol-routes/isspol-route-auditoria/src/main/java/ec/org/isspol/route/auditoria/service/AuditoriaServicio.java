package ec.org.isspol.route.auditoria.service;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public interface AuditoriaServicio {
    PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException;
}

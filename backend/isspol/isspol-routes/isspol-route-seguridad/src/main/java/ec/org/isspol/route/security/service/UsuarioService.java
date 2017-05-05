package ec.org.isspol.route.security.service;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.PeticionRespuesta;

/**
 * Created by mauchilan on 24/3/17.
 */
public interface UsuarioService {

    PeticionRespuesta callRemoteService(PeticionRespuesta peticionRespuesta) throws IsspolException;

}

package ec.org.isspol.route.security.facade.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.UsuarioSvc;
import ec.org.isspol.route.security.facade.IAfiliacionServiceFacade;

/**
 * Created by roberto.chasipanta on 5/5/2017.
 */
public class AfiliacionServiceFacadeImpl implements IAfiliacionServiceFacade{
    private UsuarioSvc usuarioSvc;

    public UsuarioSvc getUsuarioSvc() {
        return usuarioSvc;
    }

    public void setUsuarioSvc(UsuarioSvc usuarioSvc) {
        this.usuarioSvc = usuarioSvc;
    }

    public Usuario buscarUsuarioPorId(String idUsuario) throws IsspolSearchException{
        return usuarioSvc.buscarPorIdUsuario(idUsuario);
    }
}
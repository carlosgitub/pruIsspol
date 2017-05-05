package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.EstadoUsuarioDao;
import ec.org.isspol.persistence.entities.security.EstadoUsuario;

/**
 * Created by mauchilan on 20/3/17.
 */
public class EstadoUsuarioDaoImpl extends GenericDaoImpl<EstadoUsuario, Integer> implements EstadoUsuarioDao{

    public EstadoUsuarioDaoImpl(){
        super(EstadoUsuario.class);
    }

}

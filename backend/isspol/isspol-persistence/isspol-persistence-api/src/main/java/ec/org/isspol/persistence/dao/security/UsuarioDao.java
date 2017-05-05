package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.Usuario;

import java.util.Collection;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public interface UsuarioDao extends GenericDao<Usuario, String> {

    /**
     * listaUsuario()
     * Metodo que devuelve una lista de usuarios incluidos las clases referenciadas como objetos
     * 19/04/2017
     * @autor: Paul Salgado
     * @param:
     * @return: List<Usuario>
     */
    public List<Usuario> listaUsuario() throws IsspolSearchException;


    public Usuario buscarUsuarioxId (String idUsuario) throws IsspolSearchException;

}

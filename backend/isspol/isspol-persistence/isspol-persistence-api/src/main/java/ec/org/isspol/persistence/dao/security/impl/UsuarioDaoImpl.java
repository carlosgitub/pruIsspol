package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.UsuarioDao;
import ec.org.isspol.persistence.entities.security.Usuario;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.Collection;
import java.util.List;

/**
 * Created by mauchilan on 20/3/17.
 */
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, String> implements UsuarioDao {

    public UsuarioDaoImpl(){
        super(Usuario.class);
    }

    public List<Usuario> listaUsuario() throws IsspolSearchException{
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Usuario.class);

        criteria.createAlias("usuario", "usuarioA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("usuarioA", FetchMode.JOIN);

        criteria.createAlias("estadoUsuario","estadoUsuarioA");
        criteria.setFetchMode("estadoUsuarioA", FetchMode.JOIN);

        criteria.createAlias("estructuraOrganizacional" ,"estructuraOrganizacionalA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("estructuraOrganizacionalA", FetchMode.JOIN);

        criteria.createAlias("horario" ,"horarioA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("horarioA", FetchMode.JOIN);

        criteria.createAlias("personaTipoSubtipo" ,"personaTipoSubtipoA");
        criteria.setFetchMode("personaTipoSubtipoA", FetchMode.JOIN);

        criteria.createAlias("personaTipoSubtipo.persona" ,"personaA");
        criteria.setFetchMode("personaA", FetchMode.JOIN);

        return criteria.list();
    }

    @Override
    public Usuario buscarUsuarioxId(String idUsuario) throws IsspolSearchException {
        Session sessionHibernate = (Session) entityManager.unwrap(Session.class);
        Criteria criteria = sessionHibernate.createCriteria(Usuario.class);

        criteria.createAlias("usuario", "usuarioA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("usuarioA", FetchMode.JOIN);

        criteria.add(Restrictions.eq("idUsuario",idUsuario));

        criteria.createAlias("listaUsuarioOficinas", "listaUsuarioOficinasA");
        criteria.setFetchMode("listaUsuarioOficinasA", FetchMode.JOIN);

        criteria.createAlias("estadoUsuario","estadoUsuarioA");
        criteria.setFetchMode("estadoUsuarioA", FetchMode.JOIN);

        criteria.createAlias("estructuraOrganizacional" ,"estructuraOrganizacionalA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("estructuraOrganizacionalA", FetchMode.JOIN);

        criteria.createAlias("horario" ,"horarioA", JoinType.LEFT_OUTER_JOIN);
        criteria.setFetchMode("horarioA", FetchMode.JOIN);

        criteria.createAlias("personaTipoSubtipo" ,"personaTipoSubtipoA");
        criteria.setFetchMode("personaTipoSubtipoA", FetchMode.JOIN);

        criteria.createAlias("personaTipoSubtipo.persona" ,"personaA");
        criteria.setFetchMode("personaA", FetchMode.JOIN);

        return (Usuario) criteria.uniqueResult();
    }
}

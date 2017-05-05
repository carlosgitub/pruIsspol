package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.FilterParam;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.common.PagedResult;
import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.security.UsuarioOficina;

import java.util.List;

/**
 * Created by mavelin.ati on 05/05/2017.
 */
public interface UsuarioOficinaDao extends GenericDao<UsuarioOficina, Integer>{

   /**
    * listarTodosUsuarioOficina()
    * Metodo que devuelve una lista de usuarioOficina incluidos las clases referenciadas como objetos
    * 05/05/2017
    * @autor: mavelin.ati
    * @param:
    * @return: List<UsuarioOficina>
    */
   public List<UsuarioOficina> listarTodosUsuarioOficina() throws IsspolSearchException;

   /**
    * listarUsuarioOficinaPorUsuario()
    * Metodo que devuelve una lista de usuarioOficina por idUsuario incluidos las clases referenciadas como objetos
    * 05/05/2017
    * @autor: mavelin.ati
    * @param:
    * @return: List<UsuarioOficina>
    */
   public List<UsuarioOficina> listarUsuarioOficinaPorUsuario(String idUsuario) throws IsspolSearchException;

   /**
    * listarUsuarioOficinaNoEliminadoPorUsuario()
    * Metodo que devuelve una lista de usuarioOficina No Eliminados, por idUsuario,
    * incluidos las clases referenciadas como objetos
    * 05/05/2017
    * @autor: mavelin.ati
    * @param:
    * @return: List<UsuarioOficina>
    */
   PagedResult<UsuarioOficina> listarUsuarioOficinaNoEliminadoPorUsuario
   (String idUsuario, FilterParam filterParam) throws IsspolSearchException;

}

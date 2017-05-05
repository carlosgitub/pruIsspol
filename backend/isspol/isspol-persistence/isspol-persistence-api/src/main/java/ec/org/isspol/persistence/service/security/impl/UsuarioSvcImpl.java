package ec.org.isspol.persistence.service.security.impl;

import ec.org.isspol.common.IsspolConstant;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.procedimiento.FuncionProcedimientoAlmacenadoDao;
import ec.org.isspol.persistence.dao.security.UsuarioDao;
import ec.org.isspol.persistence.entities.security.Usuario;
import ec.org.isspol.persistence.service.security.UsuarioSvc;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mauchilan on 21/3/17.
 */
public class UsuarioSvcImpl implements UsuarioSvc {

    private UsuarioDao usuarioDao;
    private FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao;

    @Override
    public void insertarUsuario(Usuario usuario)throws IsspolPersistException{
        usuarioDao.insertar(usuario);
    }

    @Override
    public Usuario buscarUsuarioxId(String idUsuario) throws IsspolSearchException {
        return usuarioDao.buscarUsuarioxId(idUsuario);
    }

    @Override
    public Usuario buscarPorIdUsuario(String idUsuario) throws IsspolSearchException{
        return usuarioDao.buscarPorCriterio(Restrictions.eq("idUsuario", idUsuario));
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws IsspolPersistException {
        usuarioDao.actualizar(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws IsspolPersistException {
        usuarioDao.eliminar(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() throws IsspolSearchException {
        return usuarioDao.listaUsuario();
    }


    public List<Usuario> listarUsuariosPorEstadoUsuario (Integer idEstadoUsuario) throws IsspolSearchException{
        return usuarioDao.listarPorCriterio(Restrictions.eq("estadoUsuario.idEstadoUsuario", idEstadoUsuario));
    }

    @Override
    public Map<String, Object> procUsuarioInsertar(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USU_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_OFICINA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_PERSONA_SUBTIPO_AFILIACION, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ESTADO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_EMAIL, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_IDENTIFICACION, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AI_SECUENCIAL, Types.INTEGER),
                new SqlParameter(IsspolConstant.AB_CUALQUIER_ESTACION, Types.BIT),
                new SqlParameter(IsspolConstant.AI_ID_HORARIO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO_SUPERIOR, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_DASHBOARD_INICIO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DIRECCION_FISICA, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_INSERTAR, sqlParameters, values);
    }

    @Override
    public Map<String, Object> procUsuarioValidarFormulario(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_IDENTIFICACION, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AI_IDPERSONASUBTIPO, Types.INTEGER),
                new SqlOutParameter(IsspolConstant.AS_APELLIDOPATERNO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_APELLIDOMATERNO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_NOMBRES, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_IDUSUARIO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_CORREO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_VALIDAR_FORMULARIO, sqlParameters, values);
    }

    @Override
    public Map<String, Object> procUsuarioActualizar(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USU_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_OFICINA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ESTADO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_EMAIL, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AB_CAMBIAR_PWD_PRX_LOGON, Types.BIT),
                new SqlParameter(IsspolConstant.AB_NO_PUEDE_CAMBIAR_PWD, Types.BIT),
                new SqlParameter(IsspolConstant.AB_PWD_NUNCA_EXPIRA, Types.BIT),
                new SqlParameter(IsspolConstant.AB_BLOQUEADA, Types.BIT),
                new SqlParameter(IsspolConstant.AI_ID, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_IDENTIFICACION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AB_CUALQUIER_ESTACION, Types.BIT),
                new SqlParameter(IsspolConstant.AI_TIEMPO_INACTIVIDAD, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO_ACT, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DIRECCION_FISICA, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_HORARIO, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO_SUPERIOR, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ID_DASHBOARD_INICIO, Types.INTEGER)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_ACTUALIZAR, sqlParameters, values);
    }

    public Map<String, Object> procUsuarioSolicitudCambioClave(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_CORREO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DATO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_CODIGO_TIPO_TOKEN, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_CODIGO_PROCESO_NOTIFICACION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AD_FECHA, Types.TIMESTAMP),
                new SqlParameter(IsspolConstant.AS_EQUIPO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_SOLICITUD_CAMBIO_CLAVE, sqlParameters, values);
    }

    public Map<String, Object> procUsuarioCambiarClave(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_TOKEN, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USU_CLAVE, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AD_FECHA, Types.TIMESTAMP),
                new SqlParameter(IsspolConstant.AS_EQUIPO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_CAMBIAR_CLAVE, sqlParameters, values);
    }

    public Map<String, Object> procUsuarioVerificarBloqueo(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AB_MANUAL, Types.BOOLEAN),
                new SqlParameter(IsspolConstant.AI_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AD_FECHA, Types.TIMESTAMP),
                new SqlParameter(IsspolConstant.AS_EQUIPO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_VERIFICAR_BLOQUEO, sqlParameters, values);
    }

    @Override
    public Map<String, Object> procEstructuraOrganizacionalGuardar(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlInOutParameter(IsspolConstant.AI_ID_ESTRUCTURA, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_CODIGO, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_DESCRIPCION, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AI_ORDEN, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_NIVEL, Types.INTEGER),
                new SqlParameter(IsspolConstant.AI_ID_ESTRUCTURA_PADRE, Types.INTEGER),
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO_ACT, Types.VARCHAR),
        };

        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_ESTRUCTURA_ORGANIZACIONAL_GUARDAR, sqlParameters, values);
    }

    /**
     * Creado por Andres Campoverde : 17-04-2017
     *
     * @param values
     * @return
     * @AS_USUARIO VARCHAR(15)
     * @AS_MSJ VARCHAR(100)
     */
    @Override
    public Map<String, Object> verificarSesion(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AS_MSJ, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_VERIFICAR_SESION_USUARIO, sqlParameters, values);
    }

    @Override
    public Map<String, Object> validarClaveUsuario(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters=new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USU_USUARIO,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AB_VALIDA_HOSTNAME,Types.BIT),
                new SqlParameter(IsspolConstant.AS_HOSTNAME,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_CLAVE,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AS_USUARIO,Types.VARCHAR),
                new SqlParameter(IsspolConstant.AD_FECHA,Types.TIMESTAMP),
                new SqlParameter(IsspolConstant.AS_EQUIPO,Types.VARCHAR),
                new SqlOutParameter(IsspolConstant.AB_REQ_CAMBIO_PWD,Types.INTEGER),
                new SqlOutParameter(IsspolConstant.AS_MSJ,Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_VALIDA_CLAVE, sqlParameters, values);
    }

    @Override
    public Map<String, Object> obtenerInformacionSesion(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_USUARIO_OBTENER_INFORMACION_SESION, sqlParameters, values);
    }

    @Override
    public Map<String, Object> obtenerListaFavoritos(HashMap<String, Object> values) throws IsspolPersistException {
        SqlParameter[] sqlParameters = new SqlParameter[]{
                new SqlParameter(IsspolConstant.AS_USUARIO, Types.VARCHAR)
        };
        return funcionProcedimientoAlmacenadoDao.ejecutarProcedimientoAlmacenado(IsspolConstant.PROC_FAVORITO_LISTA, sqlParameters, values);
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void setFuncionProcedimientoAlmacenadoDao(FuncionProcedimientoAlmacenadoDao funcionProcedimientoAlmacenadoDao) {
        this.funcionProcedimientoAlmacenadoDao = funcionProcedimientoAlmacenadoDao;
    }
}

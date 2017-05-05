package ec.org.isspol.persistence.entities.comun;

// Generated 25-abr-2017 16:35:33 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProcesoNotificacion generated by hbm2java
 */
@Entity
@Table(name = "proceso_notificacion", schema = "comun", catalog = "siisspolweb")
public class ProcesoNotificacion implements java.io.Serializable {

	private Integer idProcesoNotificacion;
	private String descripcion;
	private String codigo;
	private Boolean eliminado;
	private String titulo;
	private String cuerpo;
	private String conCopia;
	private String conCopiaOculto;
	private String archivoAdjunto;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<LogNotificacion> logNotificacions = new HashSet<LogNotificacion>(
			0);

	public ProcesoNotificacion() {
	}

	public ProcesoNotificacion(Integer idProcesoNotificacion, Boolean eliminado) {
		this.idProcesoNotificacion = idProcesoNotificacion;
		this.eliminado = eliminado;
	}

	public ProcesoNotificacion(Integer idProcesoNotificacion,
			String descripcion, Boolean eliminado, String titulo,
			String cuerpo, String conCopia, String conCopiaOculto,
			String archivoAdjunto, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<LogNotificacion> logNotificacions) {
		this.idProcesoNotificacion = idProcesoNotificacion;
		this.descripcion = descripcion;
		this.eliminado = eliminado;
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.conCopia = conCopia;
		this.conCopiaOculto = conCopiaOculto;
		this.archivoAdjunto = archivoAdjunto;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.logNotificacions = logNotificacions;
	}

	@Id
	@Column(name = "id_proceso_notificacion", unique = true, nullable = false)
	public Integer getIdProcesoNotificacion() {
		return this.idProcesoNotificacion;
	}

	public void setIdProcesoNotificacion(Integer idProcesoNotificacion) {
		this.idProcesoNotificacion = idProcesoNotificacion;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "eliminado", nullable = false)
	public Boolean getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "cuerpo")
	public String getCuerpo() {
		return this.cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Column(name = "con_copia")
	public String getConCopia() {
		return this.conCopia;
	}

	public void setConCopia(String conCopia) {
		this.conCopia = conCopia;
	}

	@Column(name = "con_copia_oculto")
	public String getConCopiaOculto() {
		return this.conCopiaOculto;
	}

	public void setConCopiaOculto(String conCopiaOculto) {
		this.conCopiaOculto = conCopiaOculto;
	}

	@Column(name = "archivo_adjunto")
	public String getArchivoAdjunto() {
		return this.archivoAdjunto;
	}

	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	@Column(name = "creacion_usuario", length = 100)
	public String getCreacionUsuario() {
		return this.creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	@Column(name = "creacion_fecha", length = 23)
	public Date getCreacionFecha() {
		return this.creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	@Column(name = "creacion_equipo", length = 20)
	public String getCreacionEquipo() {
		return this.creacionEquipo;
	}

	public void setCreacionEquipo(String creacionEquipo) {
		this.creacionEquipo = creacionEquipo;
	}

	@Column(name = "modifica_usuario", length = 100)
	public String getModificaUsuario() {
		return this.modificaUsuario;
	}

	public void setModificaUsuario(String modificaUsuario) {
		this.modificaUsuario = modificaUsuario;
	}

	@Column(name = "modifica_fecha", length = 23)
	public Date getModificaFecha() {
		return this.modificaFecha;
	}

	public void setModificaFecha(Date modificaFecha) {
		this.modificaFecha = modificaFecha;
	}

	@Column(name = "modifica_equipo", length = 20)
	public String getModificaEquipo() {
		return this.modificaEquipo;
	}

	public void setModificaEquipo(String modificaEquipo) {
		this.modificaEquipo = modificaEquipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "procesoNotificacion")
	public Set<LogNotificacion> getLogNotificacions() {
		return this.logNotificacions;
	}

	public void setLogNotificacions(Set<LogNotificacion> logNotificacions) {
		this.logNotificacions = logNotificacions;
	}

}

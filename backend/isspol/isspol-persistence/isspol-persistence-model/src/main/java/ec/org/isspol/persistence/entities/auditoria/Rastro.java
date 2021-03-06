package ec.org.isspol.persistence.entities.auditoria;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rastro generated by hbm2java
 */
@Entity
@Table(name = "rastro", schema = "auditoria", catalog = "siisspolweb")
public class Rastro implements java.io.Serializable {

	private Integer idRastro;
	private Tabla tabla;
	private Character accion;
	private Date fecha;
	private String usuario;
	private String usuarioBdd;
	private String maquina;
	private String aplicacion;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<RastroDetalle> rastroDetalles = new HashSet<RastroDetalle>(0);
	private Set<RastroPk> rastroPks = new HashSet<RastroPk>(0);

	public Rastro() {
	}

	public Rastro(Integer idRastro, Tabla tabla, Character accion, Date fecha, String usuarioBdd,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.idRastro = idRastro;
		this.tabla = tabla;
		this.accion = accion;
		this.fecha = fecha;
		this.usuarioBdd = usuarioBdd;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Rastro(Integer idRastro, Tabla tabla, Character accion, Date fecha, String usuario, String usuarioBdd,
			String maquina, String aplicacion, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo, Set<RastroDetalle> rastroDetalles,
			Set<RastroPk> rastroPks) {
		this.idRastro = idRastro;
		this.tabla = tabla;
		this.accion = accion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.usuarioBdd = usuarioBdd;
		this.maquina = maquina;
		this.aplicacion = aplicacion;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.rastroDetalles = rastroDetalles;
		this.rastroPks = rastroPks;
	}

	@Id

	@Column(name = "id_rastro", unique = true, nullable = false)
	public Integer getIdRastro() {
		return this.idRastro;
	}

	public void setIdRastro(Integer idRastro) {
		this.idRastro = idRastro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tabla", nullable = false)
	public Tabla getTabla() {
		return this.tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	@Column(name = "accion", nullable = false, length = 1)
	public Character getAccion() {
		return this.accion;
	}

	public void setAccion(Character accion) {
		this.accion = accion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 23)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "usuario", length = 50)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "usuario_bdd", nullable = false, length = 50)
	public String getUsuarioBdd() {
		return this.usuarioBdd;
	}

	public void setUsuarioBdd(String usuarioBdd) {
		this.usuarioBdd = usuarioBdd;
	}

	@Column(name = "maquina", length = 50)
	public String getMaquina() {
		return this.maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	@Column(name = "aplicacion", length = 50)
	public String getAplicacion() {
		return this.aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Column(name = "creacion_usuario", nullable = false, length = 20)
	public String getCreacionUsuario() {
		return this.creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creacion_fecha", nullable = false, length = 23)
	public Date getCreacionFecha() {
		return this.creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	@Column(name = "creacion_equipo", nullable = false, length = 20)
	public String getCreacionEquipo() {
		return this.creacionEquipo;
	}

	public void setCreacionEquipo(String creacionEquipo) {
		this.creacionEquipo = creacionEquipo;
	}

	@Column(name = "modifica_usuario", nullable = false, length = 20)
	public String getModificaUsuario() {
		return this.modificaUsuario;
	}

	public void setModificaUsuario(String modificaUsuario) {
		this.modificaUsuario = modificaUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifica_fecha", nullable = false, length = 23)
	public Date getModificaFecha() {
		return this.modificaFecha;
	}

	public void setModificaFecha(Date modificaFecha) {
		this.modificaFecha = modificaFecha;
	}

	@Column(name = "modifica_equipo", nullable = false, length = 20)
	public String getModificaEquipo() {
		return this.modificaEquipo;
	}

	public void setModificaEquipo(String modificaEquipo) {
		this.modificaEquipo = modificaEquipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rastro")
	public Set<RastroDetalle> getRastroDetalles() {
		return this.rastroDetalles;
	}

	public void setRastroDetalles(Set<RastroDetalle> rastroDetalles) {
		this.rastroDetalles = rastroDetalles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rastro")
	public Set<RastroPk> getRastroPks() {
		return this.rastroPks;
	}

	public void setRastroPks(Set<RastroPk> rastroPks) {
		this.rastroPks = rastroPks;
	}

}

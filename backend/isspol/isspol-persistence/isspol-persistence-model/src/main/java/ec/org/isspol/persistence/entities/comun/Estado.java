package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import ec.org.isspol.persistence.entities.security.Oficina;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", schema = "comun", catalog = "siisspolweb")
public class Estado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado", unique = true, nullable = false)
	private Integer idEstado;
	@Column(name = "descripcion", nullable = false, length = 10)
	private String descripcion;
	@Column(name = "es_vigente", nullable = false)
	private Boolean esVigente;
	@Column(name = "creacion_usuario", nullable = false, length = 20)
	private String creacionUsuario;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creacion_fecha", nullable = false, length = 23)
	private Date creacionFecha;
	@Column(name = "creacion_equipo", nullable = false, length = 20)
	private String creacionEquipo;
	@Column(name = "modifica_usuario", nullable = false, length = 20)
	private String modificaUsuario;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifica_fecha", nullable = false, length = 23)
	private Date modificaFecha;
	@Column(name = "modifica_equipo", nullable = false, length = 20)
	private String modificaEquipo;
	@Column(name = "eliminado", nullable = false)
	private Boolean eliminado;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private Set<Oficina> oficinas = new HashSet<Oficina>(0);

	public Estado() {
	}

	public Estado(Integer idEstado, String descripcion, Boolean esVigente, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idEstado = idEstado;
		this.descripcion = descripcion;
		this.esVigente = esVigente;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Estado(Integer idEstado, String descripcion, Boolean esVigente, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo,
			Set<Oficina> oficinas) {
		this.idEstado = idEstado;
		this.descripcion = descripcion;
		this.esVigente = esVigente;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.oficinas = oficinas;
	}

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEsVigente() {
		return this.esVigente;
	}

	public void setEsVigente(Boolean esVigente) {
		this.esVigente = esVigente;
	}

	public String getCreacionUsuario() {
		return this.creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	public Date getCreacionFecha() {
		return this.creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	public String getCreacionEquipo() {
		return this.creacionEquipo;
	}

	public void setCreacionEquipo(String creacionEquipo) {
		this.creacionEquipo = creacionEquipo;
	}

	public String getModificaUsuario() {
		return this.modificaUsuario;
	}

	public void setModificaUsuario(String modificaUsuario) {
		this.modificaUsuario = modificaUsuario;
	}

	public Date getModificaFecha() {
		return this.modificaFecha;
	}

	public void setModificaFecha(Date modificaFecha) {
		this.modificaFecha = modificaFecha;
	}

	public String getModificaEquipo() {
		return this.modificaEquipo;
	}

	public void setModificaEquipo(String modificaEquipo) {
		this.modificaEquipo = modificaEquipo;
	}

	public Set<Oficina> getOficinas() {
		return this.oficinas;
	}

	public void setOficinas(Set<Oficina> oficinas) {
		this.oficinas = oficinas;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
}

package ec.org.isspol.persistence.entities.persona;
// Generated 03-may-2017 11:11:44 by Hibernate Tools 4.0.1.Final

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
 * TipoDiscapacidad generated by hbm2java
 */
@Entity
@Table(name = "tipo_discapacidad", schema = "persona", catalog = "siisspolweb")
public class TipoDiscapacidad implements java.io.Serializable {

	private Integer idTipoDiscapacidad;
	private String descripcion;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<Dependiente> dependientes = new HashSet<Dependiente>(0);
	private Set<Montepio> montepios = new HashSet<Montepio>(0);
	private Set<Montepio> montepios_1 = new HashSet<Montepio>(0);

	public TipoDiscapacidad() {
	}

	public TipoDiscapacidad(Integer idTipoDiscapacidad, Boolean eliminado, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idTipoDiscapacidad = idTipoDiscapacidad;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public TipoDiscapacidad(Integer idTipoDiscapacidad, String descripcion, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<Dependiente> dependientes, Set<Montepio> montepios, Set<Montepio> montepios_1) {
		this.idTipoDiscapacidad = idTipoDiscapacidad;
		this.descripcion = descripcion;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.dependientes = dependientes;
		this.montepios = montepios;
		this.montepios_1 = montepios_1;
	}

	@Id

	@Column(name = "id_tipo_discapacidad", unique = true, nullable = false)
	public Integer getIdTipoDiscapacidad() {
		return this.idTipoDiscapacidad;
	}

	public void setIdTipoDiscapacidad(Integer idTipoDiscapacidad) {
		this.idTipoDiscapacidad = idTipoDiscapacidad;
	}

	@Column(name = "descripcion", length = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "eliminado", nullable = false)
	public Boolean getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	@Column(name = "creacion_usuario", nullable = false, length = 20)
	public String getCreacionUsuario() {
		return this.creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDiscapacidad")
	public Set<Dependiente> getDependientes() {
		return this.dependientes;
	}

	public void setDependientes(Set<Dependiente> dependientes) {
		this.dependientes = dependientes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDiscapacidad")
	public Set<Montepio> getMontepios() {
		return this.montepios;
	}

	public void setMontepios(Set<Montepio> montepios) {
		this.montepios = montepios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDiscapacidad")
	public Set<Montepio> getMontepios_1() {
		return this.montepios_1;
	}

	public void setMontepios_1(Set<Montepio> montepios_1) {
		this.montepios_1 = montepios_1;
	}

}

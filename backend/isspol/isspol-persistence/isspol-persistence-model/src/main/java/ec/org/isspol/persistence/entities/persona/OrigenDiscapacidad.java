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
 * OrigenDiscapacidad generated by hbm2java
 */
@Entity
@Table(name = "origen_discapacidad", schema = "persona", catalog = "siisspolweb")
public class OrigenDiscapacidad implements java.io.Serializable {

	private Integer idOrigenDiscapacidad;
	private String descripcion;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<CausantePension> causantePensions = new HashSet<CausantePension>(0);
	private Set<Montepio> montepios = new HashSet<Montepio>(0);
	private Set<Dependiente> dependientes = new HashSet<Dependiente>(0);

	public OrigenDiscapacidad() {
	}

	public OrigenDiscapacidad(Integer idOrigenDiscapacidad, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo) {
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public OrigenDiscapacidad(Integer idOrigenDiscapacidad, String descripcion, Boolean eliminado,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo, Set<CausantePension> causantePensions, Set<Montepio> montepios,
			Set<Dependiente> dependientes) {
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
		this.descripcion = descripcion;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.causantePensions = causantePensions;
		this.montepios = montepios;
		this.dependientes = dependientes;
	}

	@Id

	@Column(name = "id_origen_discapacidad", unique = true, nullable = false)
	public Integer getIdOrigenDiscapacidad() {
		return this.idOrigenDiscapacidad;
	}

	public void setIdOrigenDiscapacidad(Integer idOrigenDiscapacidad) {
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invalides")
	public Set<CausantePension> getCausantePensions() {
		return this.causantePensions;
	}

	public void setCausantePensions(Set<CausantePension> causantePensions) {
		this.causantePensions = causantePensions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "origenDiscapacidad")
	public Set<Montepio> getMontepios() {
		return this.montepios;
	}

	public void setMontepios(Set<Montepio> montepios) {
		this.montepios = montepios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "origenDiscapacidad")
	public Set<Dependiente> getDependientes() {
		return this.dependientes;
	}

	public void setDependientes(Set<Dependiente> dependientes) {
		this.dependientes = dependientes;
	}

}

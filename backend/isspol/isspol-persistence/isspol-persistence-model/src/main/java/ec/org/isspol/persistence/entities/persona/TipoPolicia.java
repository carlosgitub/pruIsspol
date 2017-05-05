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
 * TipoPolicia generated by hbm2java
 */
@Entity
@Table(name = "tipo_policia", schema = "persona", catalog = "siisspolweb")
public class TipoPolicia implements java.io.Serializable {

	private Integer idTipoPolicia;
	private String descripcion;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<PersonaTipoSubtipo> personaTipoSubtipos = new HashSet<PersonaTipoSubtipo>(0);

	public TipoPolicia() {
	}

	public TipoPolicia(Integer idTipoPolicia, Boolean eliminado, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idTipoPolicia = idTipoPolicia;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public TipoPolicia(Integer idTipoPolicia, String descripcion, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<PersonaTipoSubtipo> personaTipoSubtipos) {
		this.idTipoPolicia = idTipoPolicia;
		this.descripcion = descripcion;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.personaTipoSubtipos = personaTipoSubtipos;
	}

	@Id

	@Column(name = "id_tipo_policia", unique = true, nullable = false)
	public Integer getIdTipoPolicia() {
		return this.idTipoPolicia;
	}

	public void setIdTipoPolicia(Integer idTipoPolicia) {
		this.idTipoPolicia = idTipoPolicia;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPolicia")
	public Set<PersonaTipoSubtipo> getPersonaTipoSubtipos() {
		return this.personaTipoSubtipos;
	}

	public void setPersonaTipoSubtipos(Set<PersonaTipoSubtipo> personaTipoSubtipos) {
		this.personaTipoSubtipos = personaTipoSubtipos;
	}

}
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
 * TipoAfiliacion generated by hbm2java
 */
@Entity
@Table(name = "tipo_afiliacion", schema = "persona", catalog = "siisspolweb")
public class TipoAfiliacion implements java.io.Serializable {

	private Integer idTipoAfiliacion;
	private String nombre;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<TipoSubtipoAfiliacion> tipoSubtipoAfiliacions = new HashSet<TipoSubtipoAfiliacion>(0);

	public TipoAfiliacion() {
	}

	public TipoAfiliacion(Integer idTipoAfiliacion, String nombre, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo) {
		this.idTipoAfiliacion = idTipoAfiliacion;
		this.nombre = nombre;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public TipoAfiliacion(Integer idTipoAfiliacion, String nombre, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<TipoSubtipoAfiliacion> tipoSubtipoAfiliacions) {
		this.idTipoAfiliacion = idTipoAfiliacion;
		this.nombre = nombre;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.tipoSubtipoAfiliacions = tipoSubtipoAfiliacions;
	}

	@Id

	@Column(name = "id_tipo_afiliacion", unique = true, nullable = false)
	public Integer getIdTipoAfiliacion() {
		return this.idTipoAfiliacion;
	}

	public void setIdTipoAfiliacion(Integer idTipoAfiliacion) {
		this.idTipoAfiliacion = idTipoAfiliacion;
	}

	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAfiliacion")
	public Set<TipoSubtipoAfiliacion> getTipoSubtipoAfiliacions() {
		return this.tipoSubtipoAfiliacions;
	}

	public void setTipoSubtipoAfiliacions(Set<TipoSubtipoAfiliacion> tipoSubtipoAfiliacions) {
		this.tipoSubtipoAfiliacions = tipoSubtipoAfiliacions;
	}

}

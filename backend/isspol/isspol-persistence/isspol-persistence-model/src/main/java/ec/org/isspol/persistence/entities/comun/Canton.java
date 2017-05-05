package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import ec.org.isspol.persistence.entities.persona.Direccion;
import ec.org.isspol.persistence.entities.security.Oficina;

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
 * Canton generated by hbm2java
 */
@Entity
@Table(name = "canton", schema = "comun", catalog = "siisspolweb")
public class Canton implements java.io.Serializable {

	private Integer idCanton;
	private Provincia provincia;
	private String codigo;
	private String nombre;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<Ciudad> ciudads = new HashSet<Ciudad>(0);
	private Set<Parroquia> parroquias = new HashSet<Parroquia>(0);
	private Set<Oficina> oficinas = new HashSet<Oficina>(0);

	public Canton() {
	}

	public Canton(Integer idCanton, Provincia provincia, String codigo, String nombre, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo) {
		this.idCanton = idCanton;
		this.provincia = provincia;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Canton(Integer idCanton, Provincia provincia, String codigo, String nombre, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<Ciudad> ciudads, Set<Parroquia> parroquias, Set<Oficina> oficinas) {
		this.idCanton = idCanton;
		this.provincia = provincia;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.ciudads = ciudads;
		this.parroquias = parroquias;
		this.oficinas = oficinas;
	}

	@Id

	@Column(name = "id_canton", unique = true, nullable = false)
	public Integer getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia", nullable = false)
	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Column(name = "codigo", nullable = false, length = 4)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "canton")
	public Set<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(Set<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "canton")
	public Set<Parroquia> getParroquias() {
		return this.parroquias;
	}

	public void setParroquias(Set<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "canton")
	public Set<Oficina> getOficinas() {
		return this.oficinas;
	}

	public void setOficinas(Set<Oficina> oficinas) {
		this.oficinas = oficinas;
	}

}

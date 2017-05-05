package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ciudad generated by hbm2java
 */
@Entity
@Table(name = "ciudad", schema = "comun", catalog = "siisspolweb")
public class Ciudad implements java.io.Serializable {

	private Integer idCiudad;
	private Canton canton;
	private Integer zona;
	private String codigo;
	private String descripcion;
	private Boolean cabeceracantonal;
	private String nombre;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public Ciudad() {
	}

	public Ciudad(Integer idCiudad, Boolean cabeceracantonal, String nombre) {
		this.idCiudad = idCiudad;
		this.cabeceracantonal = cabeceracantonal;
		this.nombre = nombre;
	}

	public Ciudad(Integer idCiudad, Canton canton, Integer zona, String codigo, String descripcion,
			Boolean cabeceracantonal, String nombre, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idCiudad = idCiudad;
		this.canton = canton;
		this.zona = zona;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cabeceracantonal = cabeceracantonal;
		this.nombre = nombre;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@Id

	@Column(name = "id_ciudad", unique = true, nullable = false)
	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_canton")
	public Canton getCanton() {
		return this.canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	@Column(name = "zona")
	public Integer getZona() {
		return this.zona;
	}

	public void setZona(Integer zona) {
		this.zona = zona;
	}

	@Column(name = "codigo", length = 8)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "cabeceracantonal", nullable = false)
	public Boolean getCabeceracantonal() {
		return this.cabeceracantonal;
	}

	public void setCabeceracantonal(Boolean cabeceracantonal) {
		this.cabeceracantonal = cabeceracantonal;
	}

	@Column(name = "nombre", nullable = false, length = 200)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "creacion_usuario", length = 20)
	public String getCreacionUsuario() {
		return this.creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@Column(name = "modifica_usuario", length = 20)
	public String getModificaUsuario() {
		return this.modificaUsuario;
	}

	public void setModificaUsuario(String modificaUsuario) {
		this.modificaUsuario = modificaUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

}

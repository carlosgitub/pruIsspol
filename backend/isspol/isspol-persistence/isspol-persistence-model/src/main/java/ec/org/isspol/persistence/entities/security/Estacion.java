package ec.org.isspol.persistence.entities.security;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Estacion generated by hbm2java
 */
@Entity
@Table(name = "estacion", schema = "seguridad", catalog = "siisspolweb")
public class Estacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estacion", unique = true, nullable = false)
	private Integer idEstacion;
	@Column(name = "hostname", nullable = false, length = 50)
	private String hostname;
	@Column(name = "direccion_fisica", length = 20)
	private String direccionFisica;
	@Column(name = "ip", length = 20)
	private String ip;
	@Column(name = "descripcion", length = 50)
	private String descripcion;
	@Column(name = "ubicacion", length = 50)
	private String ubicacion;
	@Column(name = "eliminado", nullable = false)
	private Boolean eliminado;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estacion")
	private Set<EstacionUsuario> estacionUsuarios = new HashSet<EstacionUsuario>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estacion")
	private Set<ImpresoraEstacion> impresoraEstacions = new HashSet<ImpresoraEstacion>(0);

	public Estacion() {
	}

	public Estacion(Integer idEstacion, String hostname, Boolean eliminado, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idEstacion = idEstacion;
		this.hostname = hostname;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Estacion(Integer idEstacion, String hostname, String direccionFisica, String ip, String descripcion,
			String ubicacion, Boolean eliminado, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo, Set<EstacionUsuario> estacionUsuarios,
			Set<ImpresoraEstacion> impresoraEstacions) {
		this.idEstacion = idEstacion;
		this.hostname = hostname;
		this.direccionFisica = direccionFisica;
		this.ip = ip;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.estacionUsuarios = estacionUsuarios;
		this.impresoraEstacions = impresoraEstacions;
	}

	public Integer getIdEstacion() {
		return this.idEstacion;
	}

	public void setIdEstacion(Integer idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getDireccionFisica() {
		return this.direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Boolean getEliminado() {
		return this.eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
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

	public Set<EstacionUsuario> getEstacionUsuarios() {
		return this.estacionUsuarios;
	}

	public void setEstacionUsuarios(Set<EstacionUsuario> estacionUsuarios) {
		this.estacionUsuarios = estacionUsuarios;
	}

	public Set<ImpresoraEstacion> getImpresoraEstacions() {
		return this.impresoraEstacions;
	}

	public void setImpresoraEstacions(Set<ImpresoraEstacion> impresoraEstacions) {
		this.impresoraEstacions = impresoraEstacions;
	}

}

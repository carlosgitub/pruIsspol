package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import ec.org.isspol.persistence.entities.security.UsuarioUbicacionGeografica;

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
 * UbicacionGeografica generated by hbm2java
 */
@Entity
@Table(name = "ubicacion_geografica", schema = "comun", catalog = "siisspolweb")
public class UbicacionGeografica implements java.io.Serializable {

	private Integer idUbicacionGeografica;
	private UbicacionGeografica ubicacionGeografica;
	private TipoUbicacionGeografica tipoUbicacionGeografica;
	private String descripcion;
	private String codigoUbicacion;
	private String codigoPostal;
	private Boolean esOtro;
	private Boolean visible;
	private Boolean esCapital;
	private String codigo2;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<UsuarioUbicacionGeografica> usuarioUbicacionGeograficas = new HashSet<UsuarioUbicacionGeografica>(0);
	private Set<UbicacionGeografica> ubicacionGeograficas = new HashSet<UbicacionGeografica>(0);

	public UbicacionGeografica() {
	}

	public UbicacionGeografica(Integer idUbicacionGeografica, TipoUbicacionGeografica tipoUbicacionGeografica,
			String descripcion, String codigoUbicacion, Boolean esOtro, Boolean visible, Boolean esCapital,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.idUbicacionGeografica = idUbicacionGeografica;
		this.tipoUbicacionGeografica = tipoUbicacionGeografica;
		this.descripcion = descripcion;
		this.codigoUbicacion = codigoUbicacion;
		this.esOtro = esOtro;
		this.visible = visible;
		this.esCapital = esCapital;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public UbicacionGeografica(Integer idUbicacionGeografica, UbicacionGeografica ubicacionGeografica,
			TipoUbicacionGeografica tipoUbicacionGeografica, String descripcion, String codigoUbicacion,
			String codigoPostal, Boolean esOtro, Boolean visible, Boolean esCapital, String codigo2,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo, Set<UsuarioUbicacionGeografica> usuarioUbicacionGeograficas,
			Set<UbicacionGeografica> ubicacionGeograficas) {
		this.idUbicacionGeografica = idUbicacionGeografica;
		this.ubicacionGeografica = ubicacionGeografica;
		this.tipoUbicacionGeografica = tipoUbicacionGeografica;
		this.descripcion = descripcion;
		this.codigoUbicacion = codigoUbicacion;
		this.codigoPostal = codigoPostal;
		this.esOtro = esOtro;
		this.visible = visible;
		this.esCapital = esCapital;
		this.codigo2 = codigo2;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.usuarioUbicacionGeograficas = usuarioUbicacionGeograficas;
		this.ubicacionGeograficas = ubicacionGeograficas;
	}

	@Id

	@Column(name = "id_ubicacion_geografica", unique = true, nullable = false)
	public Integer getIdUbicacionGeografica() {
		return this.idUbicacionGeografica;
	}

	public void setIdUbicacionGeografica(Integer idUbicacionGeografica) {
		this.idUbicacionGeografica = idUbicacionGeografica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ubicacion_geografica_padre")
	public UbicacionGeografica getUbicacionGeografica() {
		return this.ubicacionGeografica;
	}

	public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_ubicacion_geografica", nullable = false)
	public TipoUbicacionGeografica getTipoUbicacionGeografica() {
		return this.tipoUbicacionGeografica;
	}

	public void setTipoUbicacionGeografica(TipoUbicacionGeografica tipoUbicacionGeografica) {
		this.tipoUbicacionGeografica = tipoUbicacionGeografica;
	}

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "codigo_ubicacion", nullable = false, length = 10)
	public String getCodigoUbicacion() {
		return this.codigoUbicacion;
	}

	public void setCodigoUbicacion(String codigoUbicacion) {
		this.codigoUbicacion = codigoUbicacion;
	}

	@Column(name = "codigo_postal", length = 10)
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Column(name = "es_otro", nullable = false)
	public Boolean getEsOtro() {
		return this.esOtro;
	}

	public void setEsOtro(Boolean esOtro) {
		this.esOtro = esOtro;
	}

	@Column(name = "visible", nullable = false)
	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Column(name = "es_capital", nullable = false)
	public Boolean getEsCapital() {
		return this.esCapital;
	}

	public void setEsCapital(Boolean esCapital) {
		this.esCapital = esCapital;
	}

	@Column(name = "codigo_2", length = 5)
	public String getCodigo2() {
		return this.codigo2;
	}

	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ubicacionGeografica")
	public Set<UsuarioUbicacionGeografica> getUsuarioUbicacionGeograficas() {
		return this.usuarioUbicacionGeograficas;
	}

	public void setUsuarioUbicacionGeograficas(Set<UsuarioUbicacionGeografica> usuarioUbicacionGeograficas) {
		this.usuarioUbicacionGeograficas = usuarioUbicacionGeograficas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ubicacionGeografica")
	public Set<UbicacionGeografica> getUbicacionGeograficas() {
		return this.ubicacionGeograficas;
	}

	public void setUbicacionGeograficas(Set<UbicacionGeografica> ubicacionGeograficas) {
		this.ubicacionGeograficas = ubicacionGeograficas;
	}

}

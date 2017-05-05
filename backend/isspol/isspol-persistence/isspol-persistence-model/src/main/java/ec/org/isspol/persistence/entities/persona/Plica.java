package ec.org.isspol.persistence.entities.persona;
// Generated 03-may-2017 11:11:44 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Plica generated by hbm2java
 */
@Entity
@Table(name = "plica", schema = "persona", catalog = "siisspolweb")
public class Plica implements java.io.Serializable {

	private Integer idPlica;
	private TipoPlica tipoPlica;
	private PersonaTipoSubtipo personaTipoSubtipo;
	private Date fechaPlica;
	private String numero;
	private Integer idUbicacionGeografica;
	private Date fechaRegistro;
	private Boolean abierto;
	private Date fechaApertura;
	private String nombreDelegado;
	private Boolean estadoFisico;
	private Boolean estadoFormatoNuevo;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public Plica() {
	}

	public Plica(Integer idPlica, TipoPlica tipoPlica, PersonaTipoSubtipo personaTipoSubtipo, Date fechaPlica,
			String numero, Integer idUbicacionGeografica, Date fechaRegistro, Boolean abierto, Date fechaApertura,
			String nombreDelegado, Boolean estadoFisico, Boolean estadoFormatoNuevo, Boolean eliminado,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.idPlica = idPlica;
		this.tipoPlica = tipoPlica;
		this.personaTipoSubtipo = personaTipoSubtipo;
		this.fechaPlica = fechaPlica;
		this.numero = numero;
		this.idUbicacionGeografica = idUbicacionGeografica;
		this.fechaRegistro = fechaRegistro;
		this.abierto = abierto;
		this.fechaApertura = fechaApertura;
		this.nombreDelegado = nombreDelegado;
		this.estadoFisico = estadoFisico;
		this.estadoFormatoNuevo = estadoFormatoNuevo;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@Id

	@Column(name = "id_plica", unique = true, nullable = false)
	public Integer getIdPlica() {
		return this.idPlica;
	}

	public void setIdPlica(Integer idPlica) {
		this.idPlica = idPlica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_plica", nullable = false)
	public TipoPlica getTipoPlica() {
		return this.tipoPlica;
	}

	public void setTipoPlica(TipoPlica tipoPlica) {
		this.tipoPlica = tipoPlica;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona_tipo_subtipo", nullable = false)
	public PersonaTipoSubtipo getPersonaTipoSubtipo() {
		return this.personaTipoSubtipo;
	}

	public void setPersonaTipoSubtipo(PersonaTipoSubtipo personaTipoSubtipo) {
		this.personaTipoSubtipo = personaTipoSubtipo;
	}

	@Column(name = "fecha_plica", nullable = false, length = 23)
	public Date getFechaPlica() {
		return this.fechaPlica;
	}

	public void setFechaPlica(Date fechaPlica) {
		this.fechaPlica = fechaPlica;
	}

	@Column(name = "numero", nullable = false, length = 6)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "id_ubicacion_geografica", nullable = false)
	public Integer getIdUbicacionGeografica() {
		return this.idUbicacionGeografica;
	}

	public void setIdUbicacionGeografica(Integer idUbicacionGeografica) {
		this.idUbicacionGeografica = idUbicacionGeografica;
	}

	@Column(name = "fecha_registro", nullable = false, length = 23)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "abierto", nullable = false)
	public Boolean getAbierto() {
		return this.abierto;
	}

	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}

	@Column(name = "fecha_apertura", nullable = false, length = 23)
	public Date getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	@Column(name = "nombre_delegado", nullable = false, length = 100)
	public String getNombreDelegado() {
		return this.nombreDelegado;
	}

	public void setNombreDelegado(String nombreDelegado) {
		this.nombreDelegado = nombreDelegado;
	}

	@Column(name = "estado_fisico", nullable = false)
	public Boolean getEstadoFisico() {
		return this.estadoFisico;
	}

	public void setEstadoFisico(Boolean estadoFisico) {
		this.estadoFisico = estadoFisico;
	}

	@Column(name = "estado_formato_nuevo", nullable = false)
	public Boolean getEstadoFormatoNuevo() {
		return this.estadoFormatoNuevo;
	}

	public void setEstadoFormatoNuevo(Boolean estadoFormatoNuevo) {
		this.estadoFormatoNuevo = estadoFormatoNuevo;
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

}
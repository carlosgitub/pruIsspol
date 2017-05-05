package ec.org.isspol.persistence.entities.persona;
// Generated 03-may-2017 11:11:44 by Hibernate Tools 4.0.1.Final

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

/**
 * PersonaTipoSubtipo generated by hbm2java
 */
@Entity
@Table(name = "persona_tipo_subtipo", schema = "persona", catalog = "siisspolweb")
public class PersonaTipoSubtipo implements java.io.Serializable {

	private Integer idPersonaTipoSubtipo;
	private TipoSubtipoAfiliacion tipoSubtipoAfiliacion;
	private Persona persona;
	private TipoPolicia tipoPolicia;
	private Integer secuencia;
	private Date fechaRegistro;
	private Boolean situacionActual;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<Pasantia> pasantias = new HashSet<Pasantia>(0);
	private Set<SeguroBeneficiario> seguroBeneficiarios = new HashSet<SeguroBeneficiario>(0);
	private Set<Dependiente> dependientesForIdPersonaTipoSubtipo = new HashSet<Dependiente>(0);
	private Set<DependienteNovedad> dependienteNovedads = new HashSet<DependienteNovedad>(0);
	private Set<VidaInstitucional> vidaInstitucionals = new HashSet<VidaInstitucional>(0);
	private Set<CausantePension> causantePensions = new HashSet<CausantePension>(0);
	private Set<Plica> plicas = new HashSet<Plica>(0);
	private Set<Dependiente> dependientesForIdPersonaTipoSubtipoCausante = new HashSet<Dependiente>(0);
	private Set<Supervivencia> supervivencias = new HashSet<Supervivencia>(0);
	private Set<SupervivenciaNovedad> supervivenciaNovedads = new HashSet<SupervivenciaNovedad>(0);
	private Set<Seguro> seguros = new HashSet<Seguro>(0);
	private Set<Montepio> montepios = new HashSet<Montepio>(0);

	public PersonaTipoSubtipo() {
	}

	public PersonaTipoSubtipo(Integer idPersonaTipoSubtipo, TipoSubtipoAfiliacion tipoSubtipoAfiliacion,
			Persona persona, Integer secuencia, Date fechaRegistro, Boolean situacionActual, Boolean eliminado,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.idPersonaTipoSubtipo = idPersonaTipoSubtipo;
		this.tipoSubtipoAfiliacion = tipoSubtipoAfiliacion;
		this.persona = persona;
		this.secuencia = secuencia;
		this.fechaRegistro = fechaRegistro;
		this.situacionActual = situacionActual;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public PersonaTipoSubtipo(Integer idPersonaTipoSubtipo, TipoSubtipoAfiliacion tipoSubtipoAfiliacion,
			Persona persona, TipoPolicia tipoPolicia, Integer secuencia, Date fechaRegistro, Boolean situacionActual,
			Boolean eliminado, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo, Set<Pasantia> pasantias,
			Set<SeguroBeneficiario> seguroBeneficiarios, Set<Dependiente> dependientesForIdPersonaTipoSubtipo,
			Set<DependienteNovedad> dependienteNovedads, Set<VidaInstitucional> vidaInstitucionals,
			Set<CausantePension> causantePensions, Set<Plica> plicas,
			Set<Dependiente> dependientesForIdPersonaTipoSubtipoCausante, Set<Supervivencia> supervivencias,
			Set<SupervivenciaNovedad> supervivenciaNovedads, Set<Seguro> seguros, Set<Montepio> montepios) {
		this.idPersonaTipoSubtipo = idPersonaTipoSubtipo;
		this.tipoSubtipoAfiliacion = tipoSubtipoAfiliacion;
		this.persona = persona;
		this.tipoPolicia = tipoPolicia;
		this.secuencia = secuencia;
		this.fechaRegistro = fechaRegistro;
		this.situacionActual = situacionActual;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.pasantias = pasantias;
		this.seguroBeneficiarios = seguroBeneficiarios;
		this.dependientesForIdPersonaTipoSubtipo = dependientesForIdPersonaTipoSubtipo;
		this.dependienteNovedads = dependienteNovedads;
		this.vidaInstitucionals = vidaInstitucionals;
		this.causantePensions = causantePensions;
		this.plicas = plicas;
		this.dependientesForIdPersonaTipoSubtipoCausante = dependientesForIdPersonaTipoSubtipoCausante;
		this.supervivencias = supervivencias;
		this.supervivenciaNovedads = supervivenciaNovedads;
		this.seguros = seguros;
		this.montepios = montepios;
	}

	@Id

	@Column(name = "id_persona_tipo_subtipo", unique = true, nullable = false)
	public Integer getIdPersonaTipoSubtipo() {
		return this.idPersonaTipoSubtipo;
	}

	public void setIdPersonaTipoSubtipo(Integer idPersonaTipoSubtipo) {
		this.idPersonaTipoSubtipo = idPersonaTipoSubtipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_subtipo_afiliacion", nullable = false)
	public TipoSubtipoAfiliacion getTipoSubtipoAfiliacion() {
		return this.tipoSubtipoAfiliacion;
	}

	public void setTipoSubtipoAfiliacion(TipoSubtipoAfiliacion tipoSubtipoAfiliacion) {
		this.tipoSubtipoAfiliacion = tipoSubtipoAfiliacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false)
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_policia")
	public TipoPolicia getTipoPolicia() {
		return this.tipoPolicia;
	}

	public void setTipoPolicia(TipoPolicia tipoPolicia) {
		this.tipoPolicia = tipoPolicia;
	}

	@Column(name = "secuencia", nullable = false)
	public Integer getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	@Column(name = "fecha_registro", nullable = false, length = 23)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "situacion_actual", nullable = false)
	public Boolean getSituacionActual() {
		return this.situacionActual;
	}

	public void setSituacionActual(Boolean situacionActual) {
		this.situacionActual = situacionActual;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<Pasantia> getPasantias() {
		return this.pasantias;
	}

	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<SeguroBeneficiario> getSeguroBeneficiarios() {
		return this.seguroBeneficiarios;
	}

	public void setSeguroBeneficiarios(Set<SeguroBeneficiario> seguroBeneficiarios) {
		this.seguroBeneficiarios = seguroBeneficiarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	public Set<Dependiente> getDependientesForIdPersonaTipoSubtipo() {
		return this.dependientesForIdPersonaTipoSubtipo;
	}

	public void setDependientesForIdPersonaTipoSubtipo(Set<Dependiente> dependientesForIdPersonaTipoSubtipo) {
		this.dependientesForIdPersonaTipoSubtipo = dependientesForIdPersonaTipoSubtipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<DependienteNovedad> getDependienteNovedads() {
		return this.dependienteNovedads;
	}

	public void setDependienteNovedads(Set<DependienteNovedad> dependienteNovedads) {
		this.dependienteNovedads = dependienteNovedads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<VidaInstitucional> getVidaInstitucionals() {
		return this.vidaInstitucionals;
	}

	public void setVidaInstitucionals(Set<VidaInstitucional> vidaInstitucionals) {
		this.vidaInstitucionals = vidaInstitucionals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<CausantePension> getCausantePensions() {
		return this.causantePensions;
	}

	public void setCausantePensions(Set<CausantePension> causantePensions) {
		this.causantePensions = causantePensions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<Plica> getPlicas() {
		return this.plicas;
	}

	public void setPlicas(Set<Plica> plicas) {
		this.plicas = plicas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipoByIdPersonaTipoSubtipoCausante")
	public Set<Dependiente> getDependientesForIdPersonaTipoSubtipoCausante() {
		return this.dependientesForIdPersonaTipoSubtipoCausante;
	}

	public void setDependientesForIdPersonaTipoSubtipoCausante(
			Set<Dependiente> dependientesForIdPersonaTipoSubtipoCausante) {
		this.dependientesForIdPersonaTipoSubtipoCausante = dependientesForIdPersonaTipoSubtipoCausante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<Supervivencia> getSupervivencias() {
		return this.supervivencias;
	}

	public void setSupervivencias(Set<Supervivencia> supervivencias) {
		this.supervivencias = supervivencias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<SupervivenciaNovedad> getSupervivenciaNovedads() {
		return this.supervivenciaNovedads;
	}

	public void setSupervivenciaNovedads(Set<SupervivenciaNovedad> supervivenciaNovedads) {
		this.supervivenciaNovedads = supervivenciaNovedads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<Seguro> getSeguros() {
		return this.seguros;
	}

	public void setSeguros(Set<Seguro> seguros) {
		this.seguros = seguros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personaTipoSubtipo")
	public Set<Montepio> getMontepios() {
		return this.montepios;
	}

	public void setMontepios(Set<Montepio> montepios) {
		this.montepios = montepios;
	}

}
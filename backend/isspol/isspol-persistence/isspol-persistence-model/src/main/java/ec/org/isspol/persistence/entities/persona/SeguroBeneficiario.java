package ec.org.isspol.persistence.entities.persona;
// Generated 03-may-2017 11:11:44 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
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
 * SeguroBeneficiario generated by hbm2java
 */
@Entity
@Table(name = "seguro_beneficiario", schema = "persona", catalog = "siisspolweb")
public class SeguroBeneficiario implements java.io.Serializable {

	private Integer idSeguroBeneficiario;
	private PersonaTipoSubtipo personaTipoSubtipo;
	private SeguroBeneficiario seguroBeneficiario;
	private Seguro seguro;
	private Parentesco parentesco;
	private Integer idOrigenDiscapacidad;
	private Integer idTipoDiscapaciadad;
	private BigDecimal valorSeguro;
	private BigDecimal pensionInicial;
	private BigDecimal pensionFinal;
	private Integer idCobrador;
	private BigDecimal porcentajePlica;
	private Boolean benSwAux;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<SeguroBeneficiario> seguroBeneficiarios = new HashSet<SeguroBeneficiario>(0);

	public SeguroBeneficiario() {
	}

	public SeguroBeneficiario(Integer idSeguroBeneficiario, PersonaTipoSubtipo personaTipoSubtipo,
			Integer idOrigenDiscapacidad, Integer idTipoDiscapaciadad, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo) {
		this.idSeguroBeneficiario = idSeguroBeneficiario;
		this.personaTipoSubtipo = personaTipoSubtipo;
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
		this.idTipoDiscapaciadad = idTipoDiscapaciadad;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public SeguroBeneficiario(Integer idSeguroBeneficiario, PersonaTipoSubtipo personaTipoSubtipo,
			SeguroBeneficiario seguroBeneficiario, Seguro seguro, Parentesco parentesco, Integer idOrigenDiscapacidad,
			Integer idTipoDiscapaciadad, BigDecimal valorSeguro, BigDecimal pensionInicial, BigDecimal pensionFinal,
			Integer idCobrador, BigDecimal porcentajePlica, Boolean benSwAux, Boolean eliminado, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo, Set<SeguroBeneficiario> seguroBeneficiarios) {
		this.idSeguroBeneficiario = idSeguroBeneficiario;
		this.personaTipoSubtipo = personaTipoSubtipo;
		this.seguroBeneficiario = seguroBeneficiario;
		this.seguro = seguro;
		this.parentesco = parentesco;
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
		this.idTipoDiscapaciadad = idTipoDiscapaciadad;
		this.valorSeguro = valorSeguro;
		this.pensionInicial = pensionInicial;
		this.pensionFinal = pensionFinal;
		this.idCobrador = idCobrador;
		this.porcentajePlica = porcentajePlica;
		this.benSwAux = benSwAux;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.seguroBeneficiarios = seguroBeneficiarios;
	}

	@Id

	@Column(name = "id_seguro_beneficiario", unique = true, nullable = false)
	public Integer getIdSeguroBeneficiario() {
		return this.idSeguroBeneficiario;
	}

	public void setIdSeguroBeneficiario(Integer idSeguroBeneficiario) {
		this.idSeguroBeneficiario = idSeguroBeneficiario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona_tipo_subtipo_beneficiario", nullable = false)
	public PersonaTipoSubtipo getPersonaTipoSubtipo() {
		return this.personaTipoSubtipo;
	}

	public void setPersonaTipoSubtipo(PersonaTipoSubtipo personaTipoSubtipo) {
		this.personaTipoSubtipo = personaTipoSubtipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seguro_beneficiario_padre")
	public SeguroBeneficiario getSeguroBeneficiario() {
		return this.seguroBeneficiario;
	}

	public void setSeguroBeneficiario(SeguroBeneficiario seguroBeneficiario) {
		this.seguroBeneficiario = seguroBeneficiario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_seguro")
	public Seguro getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parentesco")
	public Parentesco getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	@Column(name = "id_origen_discapacidad", nullable = false)
	public Integer getIdOrigenDiscapacidad() {
		return this.idOrigenDiscapacidad;
	}

	public void setIdOrigenDiscapacidad(Integer idOrigenDiscapacidad) {
		this.idOrigenDiscapacidad = idOrigenDiscapacidad;
	}

	@Column(name = "id_tipo_discapaciadad", nullable = false)
	public Integer getIdTipoDiscapaciadad() {
		return this.idTipoDiscapaciadad;
	}

	public void setIdTipoDiscapaciadad(Integer idTipoDiscapaciadad) {
		this.idTipoDiscapaciadad = idTipoDiscapaciadad;
	}

	@Column(name = "valor_seguro", scale = 4)
	public BigDecimal getValorSeguro() {
		return this.valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	@Column(name = "pension_inicial", scale = 4)
	public BigDecimal getPensionInicial() {
		return this.pensionInicial;
	}

	public void setPensionInicial(BigDecimal pensionInicial) {
		this.pensionInicial = pensionInicial;
	}

	@Column(name = "pension_final", scale = 4)
	public BigDecimal getPensionFinal() {
		return this.pensionFinal;
	}

	public void setPensionFinal(BigDecimal pensionFinal) {
		this.pensionFinal = pensionFinal;
	}

	@Column(name = "id_cobrador")
	public Integer getIdCobrador() {
		return this.idCobrador;
	}

	public void setIdCobrador(Integer idCobrador) {
		this.idCobrador = idCobrador;
	}

	@Column(name = "porcentaje_plica", scale = 4)
	public BigDecimal getPorcentajePlica() {
		return this.porcentajePlica;
	}

	public void setPorcentajePlica(BigDecimal porcentajePlica) {
		this.porcentajePlica = porcentajePlica;
	}

	@Column(name = "BenSwAux")
	public Boolean getBenSwAux() {
		return this.benSwAux;
	}

	public void setBenSwAux(Boolean benSwAux) {
		this.benSwAux = benSwAux;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seguroBeneficiario")
	public Set<SeguroBeneficiario> getSeguroBeneficiarios() {
		return this.seguroBeneficiarios;
	}

	public void setSeguroBeneficiarios(Set<SeguroBeneficiario> seguroBeneficiarios) {
		this.seguroBeneficiarios = seguroBeneficiarios;
	}

}
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoNovedad generated by hbm2java
 */
@Entity
@Table(name = "tipo_novedad", schema = "persona", catalog = "siisspolweb")
public class TipoNovedad implements java.io.Serializable {

	private Integer idTipoNovedad;
	private String descripcion1;
	private String descripcion2;
	private String descripcion3;
	private String descripcion4;
	private BigDecimal numerico1;
	private BigDecimal numerico2;
	private BigDecimal numerico3;
	private BigDecimal numerico4;
	private BigDecimal numerico5;
	private Integer numerico6;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<VidaInstitucional> vidaInstitucionals = new HashSet<VidaInstitucional>(0);

	public TipoNovedad() {
	}

	public TipoNovedad(Integer idTipoNovedad, Boolean eliminado, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idTipoNovedad = idTipoNovedad;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public TipoNovedad(Integer idTipoNovedad, String descripcion1, String descripcion2, String descripcion3,
			String descripcion4, BigDecimal numerico1, BigDecimal numerico2, BigDecimal numerico3, BigDecimal numerico4,
			BigDecimal numerico5, Integer numerico6, Boolean eliminado, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo,
			Set<VidaInstitucional> vidaInstitucionals) {
		this.idTipoNovedad = idTipoNovedad;
		this.descripcion1 = descripcion1;
		this.descripcion2 = descripcion2;
		this.descripcion3 = descripcion3;
		this.descripcion4 = descripcion4;
		this.numerico1 = numerico1;
		this.numerico2 = numerico2;
		this.numerico3 = numerico3;
		this.numerico4 = numerico4;
		this.numerico5 = numerico5;
		this.numerico6 = numerico6;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.vidaInstitucionals = vidaInstitucionals;
	}

	@Id

	@Column(name = "id_tipo_novedad", unique = true, nullable = false)
	public Integer getIdTipoNovedad() {
		return this.idTipoNovedad;
	}

	public void setIdTipoNovedad(Integer idTipoNovedad) {
		this.idTipoNovedad = idTipoNovedad;
	}

	@Column(name = "descripcion1", length = 60)
	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	@Column(name = "descripcion2", length = 50)
	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	@Column(name = "descripcion3", length = 50)
	public String getDescripcion3() {
		return this.descripcion3;
	}

	public void setDescripcion3(String descripcion3) {
		this.descripcion3 = descripcion3;
	}

	@Column(name = "descripcion4", length = 50)
	public String getDescripcion4() {
		return this.descripcion4;
	}

	public void setDescripcion4(String descripcion4) {
		this.descripcion4 = descripcion4;
	}

	@Column(name = "numerico1", precision = 18, scale = 0)
	public BigDecimal getNumerico1() {
		return this.numerico1;
	}

	public void setNumerico1(BigDecimal numerico1) {
		this.numerico1 = numerico1;
	}

	@Column(name = "numerico2", precision = 18, scale = 0)
	public BigDecimal getNumerico2() {
		return this.numerico2;
	}

	public void setNumerico2(BigDecimal numerico2) {
		this.numerico2 = numerico2;
	}

	@Column(name = "numerico3", precision = 18, scale = 0)
	public BigDecimal getNumerico3() {
		return this.numerico3;
	}

	public void setNumerico3(BigDecimal numerico3) {
		this.numerico3 = numerico3;
	}

	@Column(name = "numerico4", precision = 18, scale = 0)
	public BigDecimal getNumerico4() {
		return this.numerico4;
	}

	public void setNumerico4(BigDecimal numerico4) {
		this.numerico4 = numerico4;
	}

	@Column(name = "numerico5", precision = 18, scale = 0)
	public BigDecimal getNumerico5() {
		return this.numerico5;
	}

	public void setNumerico5(BigDecimal numerico5) {
		this.numerico5 = numerico5;
	}

	@Column(name = "numerico6")
	public Integer getNumerico6() {
		return this.numerico6;
	}

	public void setNumerico6(Integer numerico6) {
		this.numerico6 = numerico6;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoNovedad")
	public Set<VidaInstitucional> getVidaInstitucionals() {
		return this.vidaInstitucionals;
	}

	public void setVidaInstitucionals(Set<VidaInstitucional> vidaInstitucionals) {
		this.vidaInstitucionals = vidaInstitucionals;
	}

}

package ec.org.isspol.persistence.entities.security;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MotivoCierreSesion generated by hbm2java
 */
@Entity
@Table(name = "motivo_cierre_sesion", schema = "seguridad", catalog = "siisspolweb")
public class MotivoCierreSesion implements java.io.Serializable {

	private Integer idMotivoCierreSesion;
	private String motivo;
	private Boolean vigente;
	private Boolean esLunch;
	private Boolean esSalidaDefinitiva;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public MotivoCierreSesion() {
	}

	public MotivoCierreSesion(Integer idMotivoCierreSesion, String motivo, Boolean vigente, Boolean esLunch,
			Boolean esSalidaDefinitiva, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idMotivoCierreSesion = idMotivoCierreSesion;
		this.motivo = motivo;
		this.vigente = vigente;
		this.esLunch = esLunch;
		this.esSalidaDefinitiva = esSalidaDefinitiva;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@Id

	@Column(name = "id_motivo_cierre_sesion", unique = true, nullable = false)
	public Integer getIdMotivoCierreSesion() {
		return this.idMotivoCierreSesion;
	}

	public void setIdMotivoCierreSesion(Integer idMotivoCierreSesion) {
		this.idMotivoCierreSesion = idMotivoCierreSesion;
	}

	@Column(name = "motivo", nullable = false, length = 100)
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Column(name = "vigente", nullable = false)
	public Boolean getVigente() {
		return this.vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	@Column(name = "es_lunch", nullable = false)
	public Boolean getEsLunch() {
		return this.esLunch;
	}

	public void setEsLunch(Boolean esLunch) {
		this.esLunch = esLunch;
	}

	@Column(name = "es_salida_definitiva", nullable = false)
	public Boolean getEsSalidaDefinitiva() {
		return this.esSalidaDefinitiva;
	}

	public void setEsSalidaDefinitiva(Boolean esSalidaDefinitiva) {
		this.esSalidaDefinitiva = esSalidaDefinitiva;
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

}

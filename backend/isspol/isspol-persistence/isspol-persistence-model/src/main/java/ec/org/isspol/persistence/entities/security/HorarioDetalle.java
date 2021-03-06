package ec.org.isspol.persistence.entities.security;
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
 * HorarioDetalle generated by hbm2java
 */
@Entity
@Table(name = "horario_detalle", schema = "seguridad", catalog = "siisspolweb")
public class HorarioDetalle implements java.io.Serializable {

	private Integer idHorarioDetalle;
	private Horario horario;
	private Integer dia;
	private Date desde;
	private Date hasta;
	private Boolean permitido;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer idHorarioDetalle, Horario horario, Integer dia, Date desde, Date hasta,
			Boolean permitido, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idHorarioDetalle = idHorarioDetalle;
		this.horario = horario;
		this.dia = dia;
		this.desde = desde;
		this.hasta = hasta;
		this.permitido = permitido;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@Id

	@Column(name = "id_horario_detalle", unique = true, nullable = false)
	public Integer getIdHorarioDetalle() {
		return this.idHorarioDetalle;
	}

	public void setIdHorarioDetalle(Integer idHorarioDetalle) {
		this.idHorarioDetalle = idHorarioDetalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_horario", nullable = false)
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Column(name = "dia", nullable = false)
	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "desde", nullable = false, length = 23)
	public Date getDesde() {
		return this.desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hasta", nullable = false, length = 23)
	public Date getHasta() {
		return this.hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	@Column(name = "permitido", nullable = false)
	public Boolean getPermitido() {
		return this.permitido;
	}

	public void setPermitido(Boolean permitido) {
		this.permitido = permitido;
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

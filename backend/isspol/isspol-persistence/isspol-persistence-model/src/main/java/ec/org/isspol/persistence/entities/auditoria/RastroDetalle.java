package ec.org.isspol.persistence.entities.auditoria;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RastroDetalle generated by hbm2java
 */
@Entity
@Table(name = "rastro_detalle", schema = "auditoria", catalog = "siisspolweb")
public class RastroDetalle implements java.io.Serializable {

	private RastroDetalleId id;
	private Columna columna;
	private Rastro rastro;
	private String valorAnterior;
	private String valorNuevo;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public RastroDetalle() {
	}

	public RastroDetalle(RastroDetalleId id, Columna columna, Rastro rastro, String creacionUsuario, Date creacionFecha,
			String creacionEquipo, String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.id = id;
		this.columna = columna;
		this.rastro = rastro;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public RastroDetalle(RastroDetalleId id, Columna columna, Rastro rastro, String valorAnterior, String valorNuevo,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.id = id;
		this.columna = columna;
		this.rastro = rastro;
		this.valorAnterior = valorAnterior;
		this.valorNuevo = valorNuevo;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idRastro", column = @Column(name = "id_rastro", nullable = false)),
			@AttributeOverride(name = "idColumna", column = @Column(name = "id_columna", nullable = false)) })
	public RastroDetalleId getId() {
		return this.id;
	}

	public void setId(RastroDetalleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_columna", nullable = false, insertable = false, updatable = false)
	public Columna getColumna() {
		return this.columna;
	}

	public void setColumna(Columna columna) {
		this.columna = columna;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rastro", nullable = false, insertable = false, updatable = false)
	public Rastro getRastro() {
		return this.rastro;
	}

	public void setRastro(Rastro rastro) {
		this.rastro = rastro;
	}

	@Column(name = "valor_anterior")
	public String getValorAnterior() {
		return this.valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	@Column(name = "valor_nuevo")
	public String getValorNuevo() {
		return this.valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
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

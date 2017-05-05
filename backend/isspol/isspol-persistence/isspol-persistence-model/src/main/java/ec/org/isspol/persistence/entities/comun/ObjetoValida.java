package ec.org.isspol.persistence.entities.comun;
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
 * ObjetoValida generated by hbm2java
 */
@Entity
@Table(name = "objeto_valida", schema = "comun", catalog = "siisspolweb")
public class ObjetoValida implements java.io.Serializable {

	private ObjetoValidaId id;
	private Objeto objeto;
	private Integer ord;
	private Boolean validar;
	private String msg;
	private Boolean blanco;
	private String expresionSi;
	private String expresionA;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public ObjetoValida() {
	}

	public ObjetoValida(ObjetoValidaId id, Objeto objeto, Boolean validar, Boolean blanco, String creacionUsuario,
			Date creacionFecha, String creacionEquipo, String modificaUsuario, Date modificaFecha,
			String modificaEquipo) {
		this.id = id;
		this.objeto = objeto;
		this.validar = validar;
		this.blanco = blanco;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public ObjetoValida(ObjetoValidaId id, Objeto objeto, Integer ord, Boolean validar, String msg, Boolean blanco,
			String expresionSi, String expresionA, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.id = id;
		this.objeto = objeto;
		this.ord = ord;
		this.validar = validar;
		this.msg = msg;
		this.blanco = blanco;
		this.expresionSi = expresionSi;
		this.expresionA = expresionA;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "obj", column = @Column(name = "obj", nullable = false)),
			@AttributeOverride(name = "col", column = @Column(name = "col", nullable = false, length = 50)) })
	public ObjetoValidaId getId() {
		return this.id;
	}

	public void setId(ObjetoValidaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "obj", nullable = false, insertable = false, updatable = false)
	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	@Column(name = "ord")
	public Integer getOrd() {
		return this.ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

	@Column(name = "validar", nullable = false)
	public Boolean getValidar() {
		return this.validar;
	}

	public void setValidar(Boolean validar) {
		this.validar = validar;
	}

	@Column(name = "msg", length = 100)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "blanco", nullable = false)
	public Boolean getBlanco() {
		return this.blanco;
	}

	public void setBlanco(Boolean blanco) {
		this.blanco = blanco;
	}

	@Column(name = "expresion_si")
	public String getExpresionSi() {
		return this.expresionSi;
	}

	public void setExpresionSi(String expresionSi) {
		this.expresionSi = expresionSi;
	}

	@Column(name = "expresion_a")
	public String getExpresionA() {
		return this.expresionA;
	}

	public void setExpresionA(String expresionA) {
		this.expresionA = expresionA;
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

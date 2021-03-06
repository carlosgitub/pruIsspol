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
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name = "cuenta", schema = "persona", catalog = "siisspolweb")
public class Cuenta implements java.io.Serializable {

	private Integer idCuenta;
	private TipoCuenta tipoCuenta;
	private Integer idBanco;
	private long numero;
	private Integer isspol;
	private Boolean eliminado;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<CuentaBancaria> cuentaBancarias = new HashSet<CuentaBancaria>(0);

	public Cuenta() {
	}

	public Cuenta(Integer idCuenta, TipoCuenta tipoCuenta, Integer idBanco, long numero, Integer isspol,
			Boolean eliminado, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo) {
		this.idCuenta = idCuenta;
		this.tipoCuenta = tipoCuenta;
		this.idBanco = idBanco;
		this.numero = numero;
		this.isspol = isspol;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Cuenta(Integer idCuenta, TipoCuenta tipoCuenta, Integer idBanco, long numero, Integer isspol,
			Boolean eliminado, String creacionUsuario, Date creacionFecha, String creacionEquipo,
			String modificaUsuario, Date modificaFecha, String modificaEquipo, Set<CuentaBancaria> cuentaBancarias) {
		this.idCuenta = idCuenta;
		this.tipoCuenta = tipoCuenta;
		this.idBanco = idBanco;
		this.numero = numero;
		this.isspol = isspol;
		this.eliminado = eliminado;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.cuentaBancarias = cuentaBancarias;
	}

	@Id

	@Column(name = "id_cuenta", unique = true, nullable = false)
	public Integer getIdCuenta() {
		return this.idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_cuenta", nullable = false)
	public TipoCuenta getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	@Column(name = "id_banco", nullable = false)
	public Integer getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	@Column(name = "numero", nullable = false)
	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Column(name = "isspol", nullable = false)
	public Integer getIsspol() {
		return this.isspol;
	}

	public void setIsspol(Integer isspol) {
		this.isspol = isspol;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<CuentaBancaria> getCuentaBancarias() {
		return this.cuentaBancarias;
	}

	public void setCuentaBancarias(Set<CuentaBancaria> cuentaBancarias) {
		this.cuentaBancarias = cuentaBancarias;
	}

}

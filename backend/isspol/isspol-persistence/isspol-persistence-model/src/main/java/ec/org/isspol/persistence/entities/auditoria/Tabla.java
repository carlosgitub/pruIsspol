package ec.org.isspol.persistence.entities.auditoria;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tabla generated by hbm2java
 */
@Entity
@Table(name = "tabla", schema = "auditoria", catalog = "siisspolweb")
public class Tabla implements java.io.Serializable {

	private Integer idTabla;
	private String nombre;
	private String nombreBdd;
	private Boolean auditar;
	private Boolean auditarInsertar;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;
	private Set<Rastro> rastros = new HashSet<Rastro>(0);
	private Set<Columna> columnas = new HashSet<Columna>(0);

	public Tabla() {
	}

	public Tabla(Integer idTabla, String nombre, String nombreBdd, Boolean auditar, Boolean auditarInsertar,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.idTabla = idTabla;
		this.nombre = nombre;
		this.nombreBdd = nombreBdd;
		this.auditar = auditar;
		this.auditarInsertar = auditarInsertar;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	public Tabla(Integer idTabla, String nombre, String nombreBdd, Boolean auditar, Boolean auditarInsertar,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo, Set<Rastro> rastros, Set<Columna> columnas) {
		this.idTabla = idTabla;
		this.nombre = nombre;
		this.nombreBdd = nombreBdd;
		this.auditar = auditar;
		this.auditarInsertar = auditarInsertar;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
		this.rastros = rastros;
		this.columnas = columnas;
	}

	@Id

	@Column(name = "id_tabla", unique = true, nullable = false)
	public Integer getIdTabla() {
		return this.idTabla;
	}

	public void setIdTabla(Integer idTabla) {
		this.idTabla = idTabla;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "nombre_bdd", nullable = false, length = 50)
	public String getNombreBdd() {
		return this.nombreBdd;
	}

	public void setNombreBdd(String nombreBdd) {
		this.nombreBdd = nombreBdd;
	}

	@Column(name = "auditar", nullable = false)
	public Boolean getAuditar() {
		return this.auditar;
	}

	public void setAuditar(Boolean auditar) {
		this.auditar = auditar;
	}

	@Column(name = "auditar_insertar", nullable = false)
	public Boolean getAuditarInsertar() {
		return this.auditarInsertar;
	}

	public void setAuditarInsertar(Boolean auditarInsertar) {
		this.auditarInsertar = auditarInsertar;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tabla")
	public Set<Rastro> getRastros() {
		return this.rastros;
	}

	public void setRastros(Set<Rastro> rastros) {
		this.rastros = rastros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tabla")
	public Set<Columna> getColumnas() {
		return this.columnas;
	}

	public void setColumnas(Set<Columna> columnas) {
		this.columnas = columnas;
	}

}

package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SistemaAmbiente generated by hbm2java
 */
@Entity
@Table(name = "sistema_ambiente", schema = "comun", catalog = "siisspolweb")
public class SistemaAmbiente implements java.io.Serializable {

	private SistemaAmbienteId id;
	private String server;
	private String database;
	private String user;
	private String password;
	private String creacionUsuario;
	private Date creacionFecha;
	private String creacionEquipo;
	private String modificaUsuario;
	private Date modificaFecha;
	private String modificaEquipo;

	public SistemaAmbiente() {
	}

	public SistemaAmbiente(SistemaAmbienteId id, String server, String database, String user, String password,
			String creacionUsuario, Date creacionFecha, String creacionEquipo, String modificaUsuario,
			Date modificaFecha, String modificaEquipo) {
		this.id = id;
		this.server = server;
		this.database = database;
		this.user = user;
		this.password = password;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
		this.creacionEquipo = creacionEquipo;
		this.modificaUsuario = modificaUsuario;
		this.modificaFecha = modificaFecha;
		this.modificaEquipo = modificaEquipo;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "ambiente", column = @Column(name = "ambiente", nullable = false, length = 2)),
			@AttributeOverride(name = "sistema", column = @Column(name = "sistema", nullable = false, length = 2)) })
	public SistemaAmbienteId getId() {
		return this.id;
	}

	public void setId(SistemaAmbienteId id) {
		this.id = id;
	}

	@Column(name = "server", nullable = false, length = 100)
	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	@Column(name = "database", nullable = false, length = 100)
	public String getDatabase() {
		return this.database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Column(name = "user", nullable = false, length = 100)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

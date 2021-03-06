package ec.org.isspol.persistence.entities.comun;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UbicacionGeograficaMigracion generated by hbm2java
 */
@Entity
@Table(name = "ubicacion_geografica_migracion", schema = "comun", catalog = "siisspolweb")
public class UbicacionGeograficaMigracion implements java.io.Serializable {

	private UbicacionGeograficaMigracionId id;

	public UbicacionGeograficaMigracion() {
	}

	public UbicacionGeograficaMigracion(UbicacionGeograficaMigracionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tipoNivel", column = @Column(name = "tipo_nivel", nullable = false)),
			@AttributeOverride(name = "codOriginal", column = @Column(name = "cod_original", nullable = false)),
			@AttributeOverride(name = "codUbicacion", column = @Column(name = "cod_ubicacion", nullable = false)),
			@AttributeOverride(name = "creacionUsuario", column = @Column(name = "creacion_usuario", nullable = false, length = 20)),
			@AttributeOverride(name = "creacionFecha", column = @Column(name = "creacion_fecha", nullable = false, length = 23)),
			@AttributeOverride(name = "creacionEquipo", column = @Column(name = "creacion_equipo", nullable = false, length = 20)),
			@AttributeOverride(name = "modificaUsuario", column = @Column(name = "modifica_usuario", nullable = false, length = 20)),
			@AttributeOverride(name = "modificaFecha", column = @Column(name = "modifica_fecha", nullable = false, length = 23)),
			@AttributeOverride(name = "modificaEquipo", column = @Column(name = "modifica_equipo", nullable = false, length = 20)) })
	public UbicacionGeograficaMigracionId getId() {
		return this.id;
	}

	public void setId(UbicacionGeograficaMigracionId id) {
		this.id = id;
	}

}

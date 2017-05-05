package ec.org.isspol.persistence.entities.auditoria;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RastroPkId generated by hbm2java
 */
@Embeddable
public class RastroPkId implements java.io.Serializable {

	private Integer idRastro;
	private Integer idColumna;

	public RastroPkId() {
	}

	public RastroPkId(Integer idRastro, Integer idColumna) {
		this.idRastro = idRastro;
		this.idColumna = idColumna;
	}

	@Column(name = "id_rastro", nullable = false)
	public Integer getIdRastro() {
		return this.idRastro;
	}

	public void setIdRastro(Integer idRastro) {
		this.idRastro = idRastro;
	}

	@Column(name = "id_columna", nullable = false)
	public Integer getIdColumna() {
		return this.idColumna;
	}

	public void setIdColumna(Integer idColumna) {
		this.idColumna = idColumna;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RastroPkId))
			return false;
		RastroPkId castOther = (RastroPkId) other;

		return ((this.getIdRastro() == castOther.getIdRastro()) || (this.getIdRastro() != null
				&& castOther.getIdRastro() != null && this.getIdRastro().equals(castOther.getIdRastro())))
				&& ((this.getIdColumna() == castOther.getIdColumna()) || (this.getIdColumna() != null
						&& castOther.getIdColumna() != null && this.getIdColumna().equals(castOther.getIdColumna())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdRastro() == null ? 0 : this.getIdRastro().hashCode());
		result = 37 * result + (getIdColumna() == null ? 0 : this.getIdColumna().hashCode());
		return result;
	}

}

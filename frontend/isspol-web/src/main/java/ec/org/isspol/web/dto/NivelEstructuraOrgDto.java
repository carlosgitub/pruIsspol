package ec.org.isspol.web.dto;

/**
 * Created by santiago.yacelga on 4/24/2017.
 */
public class NivelEstructuraOrgDto {

    private Integer idNivelEstructuraOrg;

    private String descripcion;

    private String iconoCss;

    private short largoCodigo;

    public Integer getIdNivelEstructuraOrg() {
        return idNivelEstructuraOrg;
    }

    public void setIdNivelEstructuraOrg(Integer idNivelEstructuraOrg) {
        this.idNivelEstructuraOrg = idNivelEstructuraOrg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIconoCss() {
        return iconoCss;
    }

    public void setIconoCss(String iconoCss) {
        this.iconoCss = iconoCss;
    }

    public short getLargoCodigo() {
        return largoCodigo;
    }

    public void setLargoCodigo(short largoCodigo) {
        this.largoCodigo = largoCodigo;
    }
}

package ec.org.isspol.web.dto;

import java.util.Date;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */
public class AuditEntityDto {

    private String creacionUsuario;

    private Date creacionFecha;

    private String creacionEquipo;

    private String modificaUsuario;

    private Date modificaFecha;

    private String modificaEquipo;

    private Boolean eliminado;

    public String getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(String creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }

    public Date getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Date creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    public String getCreacionEquipo() {
        return creacionEquipo;
    }

    public void setCreacionEquipo(String creacionEquipo) {
        this.creacionEquipo = creacionEquipo;
    }

    public String getModificaUsuario() {
        return modificaUsuario;
    }

    public void setModificaUsuario(String modificaUsuario) {
        this.modificaUsuario = modificaUsuario;
    }

    public Date getModificaFecha() {
        return modificaFecha;
    }

    public void setModificaFecha(Date modificaFecha) {
        this.modificaFecha = modificaFecha;
    }

    public String getModificaEquipo() {
        return modificaEquipo;
    }

    public void setModificaEquipo(String modificaEquipo) {
        this.modificaEquipo = modificaEquipo;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
}

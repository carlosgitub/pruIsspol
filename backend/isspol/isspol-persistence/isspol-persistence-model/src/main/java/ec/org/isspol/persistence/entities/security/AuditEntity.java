package ec.org.isspol.persistence.entities.security;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */

@SuppressWarnings("serial")
@MappedSuperclass
public class AuditEntity implements Serializable {
    private  static final  long serialVersionUID= 1L;

    @Column(name = "creacion_usuario", nullable = false, length = 20)
    private String creacionUsuario;

    @Column(name = "creacion_fecha", nullable = false, length = 23)
    private Date creacionFecha;

    @Column(name = "creacion_equipo", nullable = false, length = 20)
    private String creacionEquipo;

    @Column(name = "modifica_usuario", nullable = false, length = 20)
    private String modificaUsuario;

    @Column(name = "modifica_fecha", nullable = false, length = 23)
    private Date modificaFecha;

    @Column(name = "modifica_equipo", nullable = false, length = 20)
    private String modificaEquipo;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado;

    @Transient
    Exception exception;


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

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}

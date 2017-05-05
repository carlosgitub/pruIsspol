package ec.org.isspol.persistence.entities.security.dto;

/**
 * Created by Paul Salgado on 24/04/2017.
 */
public class DatosPersonaUsuario {
    private Integer AI_IDPERSONASUBTIPO;
    private String AS_IDUSUARIO;
    private String AS_CORREO;
    private String AS_APELLIDOPATERNO;
    private Integer RETURN_VALUE;
    private String AS_NOMBRES;
    private String AS_APELLIDOMATERNO;
    private String AS_MSJ;

    public Integer getAI_IDPERSONASUBTIPO() {
        return AI_IDPERSONASUBTIPO;
    }

    public void setAI_IDPERSONASUBTIPO(Integer AI_IDPERSONASUBTIPO) {
        this.AI_IDPERSONASUBTIPO = AI_IDPERSONASUBTIPO;
    }

    public String getAS_IDUSUARIO() {
        return AS_IDUSUARIO;
    }

    public void setAS_IDUSUARIO(String AS_IDUSUARIO) {
        this.AS_IDUSUARIO = AS_IDUSUARIO;
    }

    public String getAS_CORREO() {
        return AS_CORREO;
    }

    public void setAS_CORREO(String AS_CORREO) {
        this.AS_CORREO = AS_CORREO;
    }

    public String getAS_APELLIDOPATERNO() {
        return AS_APELLIDOPATERNO;
    }

    public void setAS_APELLIDOPATERNO(String AS_APELLIDOPATERNO) {
        this.AS_APELLIDOPATERNO = AS_APELLIDOPATERNO;
    }

    public Integer getRETURN_VALUE() {
        return RETURN_VALUE;
    }

    public void setRETURN_VALUE(Integer RETURN_VALUE) {
        this.RETURN_VALUE = RETURN_VALUE;
    }

    public String getAS_NOMBRES() {
        return AS_NOMBRES;
    }

    public void setAS_NOMBRES(String AS_NOMBRES) {
        this.AS_NOMBRES = AS_NOMBRES;
    }

    public String getAS_APELLIDOMATERNO() {
        return AS_APELLIDOMATERNO;
    }

    public void setAS_APELLIDOMATERNO(String AS_APELLIDOMATERNO) {
        this.AS_APELLIDOMATERNO = AS_APELLIDOMATERNO;
    }

    public String getAS_MSJ() {
        return AS_MSJ;
    }

    public void setAS_MSJ(String AS_MSJ) {
        this.AS_MSJ = AS_MSJ;
    }
}

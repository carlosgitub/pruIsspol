package ec.org.isspol.persistence.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by carlos.calo on 26/04/2017.
 */
@Entity
@Table(name = "politica_clave", schema = "seguridad", catalog = "siisspolweb")
public class PoliticaClave extends AuditEntity implements Serializable {

    @Id
    @Column(name = "id_politica_clave")
    private Integer idPoliticaClave;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "permite_cambio")
    private Boolean permiteCambio;

    @Column(name = "requiere_cambio")
    private Boolean requiereCambio;

    @Column(name = "tiempo_validez_token")
    private Integer tiempoValidezToken;

    @Column(name = "verificacion_sintetica")
    private Boolean verificacionSintetica;

    @Column(name = "minimo_longitud")
    private Integer minimoLongitud;

    @Column(name = "minimo_minuscula")
    private Integer minimoMinuscula;

    @Column(name = "minimo_mayuscula")
    private Integer minimoMayuscula;

    @Column(name = "minimo_numero")
    private Integer minimoNumero;

    @Column(name = "minimo_simbolo")
    private Integer minimoSimbolo;

    @Column(name = "habilitar_hitorial")
    private Boolean habilitarHistorial;

    @Column(name = "tamano_historial")
    private Integer tamanoHistorial;

    @Column(name = "habilitar_expiracion")
    private Boolean habilitarExpiracion;

    @Column(name = "tiempo_validez_clave")
    private Integer tiemporValidezClave;

    @Column(name = "habilitar_bloqueo")
    private Boolean habilitarBloqueo;

    @Column(name = "numero_intento")
    private Integer numeroIntento;

    @Column(name = "tiempo_bloqueo")
    private Integer tiempoBloqueo;

    @Column(name = "defecto")
    private Boolean defecto;

    public PoliticaClave(Integer idPoliticaClave, String descripcion, Boolean permiteCambio, Boolean requiereCambio, Integer tiempoValidezToken,
                         Boolean verificacionSintetica, Integer minimoLongitud, Integer minimoMinuscula, Integer minimoMayuscula, Integer minimoNumero,
                         Integer minimoSimbolo, Boolean habilitarHistorial, Integer tamanoHistorial, Boolean habilitarExpiracion, Integer tiemporValidezClave,
                         Boolean habilitarBloqueo, Integer numeroIntento, Integer tiempoBloqueo) {
        this.idPoliticaClave = idPoliticaClave;
        this.descripcion = descripcion;
        this.permiteCambio = permiteCambio;
        this.requiereCambio = requiereCambio;
        this.tiempoValidezToken = tiempoValidezToken;
        this.verificacionSintetica = verificacionSintetica;
        this.minimoLongitud = minimoLongitud;
        this.minimoMinuscula = minimoMinuscula;
        this.minimoMayuscula = minimoMayuscula;
        this.minimoNumero = minimoNumero;
        this.minimoSimbolo = minimoSimbolo;
        this.habilitarHistorial = habilitarHistorial;
        this.tamanoHistorial = tamanoHistorial;
        this.habilitarExpiracion = habilitarExpiracion;
        this.tiemporValidezClave = tiemporValidezClave;
        this.habilitarBloqueo = habilitarBloqueo;
        this.numeroIntento = numeroIntento;
        this.tiempoBloqueo = tiempoBloqueo;
    }

    public Integer getIdPoliticaClave() {
        return idPoliticaClave;
    }

    public void setIdPoliticaClave(Integer idPoliticaClave) {
        this.idPoliticaClave = idPoliticaClave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPermiteCambio() {
        return permiteCambio;
    }

    public void setPermiteCambio(Boolean permiteCambio) {
        this.permiteCambio = permiteCambio;
    }

    public Boolean getRequiereCambio() {
        return requiereCambio;
    }

    public void setRequiereCambio(Boolean requiereCambio) {
        this.requiereCambio = requiereCambio;
    }

    public Integer getTiempoValidezToken() {
        return tiempoValidezToken;
    }

    public void setTiempoValidezToken(Integer tiempoValidezToken) {
        this.tiempoValidezToken = tiempoValidezToken;
    }

    public Boolean getVerificacionSintetica() {
        return verificacionSintetica;
    }

    public void setVerificacionSintetica(Boolean verificacionSintetica) {
        this.verificacionSintetica = verificacionSintetica;
    }

    public Integer getMinimoLongitud() {
        return minimoLongitud;
    }

    public void setMinimoLongitud(Integer minimoLongitud) {
        this.minimoLongitud = minimoLongitud;
    }

    public Integer getMinimoMinuscula() {
        return minimoMinuscula;
    }

    public void setMinimoMinuscula(Integer minimoMinuscula) {
        this.minimoMinuscula = minimoMinuscula;
    }

    public Integer getMinimoMayuscula() {
        return minimoMayuscula;
    }

    public void setMinimoMayuscula(Integer minimoMayuscula) {
        this.minimoMayuscula = minimoMayuscula;
    }

    public Integer getMinimoNumero() {
        return minimoNumero;
    }

    public void setMinimoNumero(Integer minimoNumero) {
        this.minimoNumero = minimoNumero;
    }

    public Integer getMinimoSimbolo() {
        return minimoSimbolo;
    }

    public void setMinimoSimbolo(Integer minimoSimbolo) {
        this.minimoSimbolo = minimoSimbolo;
    }

    public Boolean getHabilitarHistorial() {
        return habilitarHistorial;
    }

    public void setHabilitarHistorial(Boolean habilitarHistorial) {
        this.habilitarHistorial = habilitarHistorial;
    }

    public Integer getTamanoHistorial() {
        return tamanoHistorial;
    }

    public void setTamanoHistorial(Integer tamanoHistorial) {
        this.tamanoHistorial = tamanoHistorial;
    }

    public Boolean getHabilitarExpiracion() {
        return habilitarExpiracion;
    }

    public void setHabilitarExpiracion(Boolean habilitarExpiracion) {
        this.habilitarExpiracion = habilitarExpiracion;
    }

    public Integer getTiemporValidezClave() {
        return tiemporValidezClave;
    }

    public void setTiemporValidezClave(Integer tiemporValidezClave) {
        this.tiemporValidezClave = tiemporValidezClave;
    }

    public Boolean getHabilitarBloqueo() {
        return habilitarBloqueo;
    }

    public void setHabilitarBloqueo(Boolean habilitarBloqueo) {
        this.habilitarBloqueo = habilitarBloqueo;
    }

    public Integer getNumeroIntento() {
        return numeroIntento;
    }

    public void setNumeroIntento(Integer numeroIntento) {
        this.numeroIntento = numeroIntento;
    }

    public Integer getTiempoBloqueo() {
        return tiempoBloqueo;
    }

    public void setTiempoBloqueo(Integer tiempoBloqueo) {
        this.tiempoBloqueo = tiempoBloqueo;
    }

    public Boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }
}

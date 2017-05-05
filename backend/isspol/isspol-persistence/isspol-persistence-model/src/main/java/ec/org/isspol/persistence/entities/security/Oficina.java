package ec.org.isspol.persistence.entities.security;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Empresa;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Provincia;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Oficina generated by hbm2java
 */
@Entity
@Table(name = "oficina", schema = "seguridad", catalog = "siisspolweb")
public class Oficina extends AuditEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_oficina", unique = true, nullable = false)
    private Integer idOficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_oficina", nullable = false)
    private TipoOficina tipoOficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habilitado", nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_supervisor")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_provincia", nullable = false)
    private Provincia provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_canton", nullable = false)
    private Canton canton;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "codigo_2", nullable = false, length = 5)
    private String codigo2;

    @Column(name = "tel_codigo_area", length = 3)
    private String telCodigoArea;

    @Column(name = "tel_codigo_region", length = 3)
    private String telCodigoRegion;

    @Column(name = "otro_telefono", length = 100)
    private String otroTelefono;

    @Column(name = "codigo_3", unique = true, length = 20)
    private String codigo3;

    @Column(name = "latitud", precision = 53, scale = 0)
    private Double latitud;

    @Column(name = "longitud", precision = 53, scale = 0)
    private Double longitud;

    @Column(name = "codigo_rep_org", length = 4)
    private String codigoRepOrg;

    @Column(name = "codigo_sep", length = 6)
    private String codigoSep;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "oficina")
    private Set<UsuarioOficina> usuarioOficinas = new HashSet<UsuarioOficina>(0);

    public Integer getIdOficina() {
        return this.idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public TipoOficina getTipoOficina() {
        return this.tipoOficina;
    }

    public void setTipoOficina(TipoOficina tipoOficina) {
        this.tipoOficina = tipoOficina;
    }


    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public Sucursal getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    public Provincia getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }


    public Canton getCanton() {
        return this.canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getCodigo2() {
        return this.codigo2;
    }

    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }


    public String getTelCodigoArea() {
        return this.telCodigoArea;
    }

    public void setTelCodigoArea(String telCodigoArea) {
        this.telCodigoArea = telCodigoArea;
    }


    public String getTelCodigoRegion() {
        return this.telCodigoRegion;
    }

    public void setTelCodigoRegion(String telCodigoRegion) {
        this.telCodigoRegion = telCodigoRegion;
    }


    public String getOtroTelefono() {
        return this.otroTelefono;
    }

    public void setOtroTelefono(String otroTelefono) {
        this.otroTelefono = otroTelefono;
    }


    public String getCodigo3() {
        return this.codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }


    public Double getLatitud() {
        return this.latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }


    public Double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }


    public String getCodigoRepOrg() {
        return this.codigoRepOrg;
    }

    public void setCodigoRepOrg(String codigoRepOrg) {
        this.codigoRepOrg = codigoRepOrg;
    }


    public String getCodigoSep() {
        return this.codigoSep;
    }

    public void setCodigoSep(String codigoSep) {
        this.codigoSep = codigoSep;
    }


    public Set<UsuarioOficina> getUsuarioOficinas() {
        return this.usuarioOficinas;
    }

    public void setUsuarioOficinas(Set<UsuarioOficina> usuarioOficinas) {
        this.usuarioOficinas = usuarioOficinas;
    }

}

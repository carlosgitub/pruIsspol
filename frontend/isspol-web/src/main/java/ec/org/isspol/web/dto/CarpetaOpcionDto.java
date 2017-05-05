package ec.org.isspol.web.dto;

import java.util.List;

public class CarpetaOpcionDto {

    private Integer id;
    private String label;
    private Integer idCarpetaOpcionPadre;
    private String nombreCarpetaOpcionPadre;
    private Integer idIcono;
    private String icono;
    private Integer idCarpetaOpcion;
    private String nombre;
    private String descripcion;
    private Integer orden;
    private String codigo;
    private Integer nivel;
    private String objeto;
    private String parametro;
    private String tipoAbrir;
    private Boolean visible;
    private List<CarpetaOpcionDto> children;

    public CarpetaOpcionDto() {}

    public CarpetaOpcionDto(Integer id, String label)
    {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIdCarpetaOpcionPadre() {
        return idCarpetaOpcionPadre;
    }

    public void setIdCarpetaOpcionPadre(Integer idCarpetaOpcionPadre) {
        this.idCarpetaOpcionPadre = idCarpetaOpcionPadre;
    }

    public String getNombreCarpetaOpcionPadre() {
        return nombreCarpetaOpcionPadre;
    }

    public void setNombreCarpetaOpcionPadre(String nombreCarpetaOpcionPadre) {
        this.nombreCarpetaOpcionPadre = nombreCarpetaOpcionPadre;
    }

    public Integer getIdIcono() {
        return idIcono;
    }

    public void setIdIcono(Integer idIcono) {
        this.idIcono = idIcono;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Integer getIdCarpetaOpcion() {
        return idCarpetaOpcion;
    }

    public void setIdCarpetaOpcion(Integer idCarpetaOpcion) {
        this.idCarpetaOpcion = idCarpetaOpcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getTipoAbrir() {
        return tipoAbrir;
    }

    public void setTipoAbrir(String tipoAbrir) {
        this.tipoAbrir = tipoAbrir;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public List<CarpetaOpcionDto> getChildren() {
        return children;
    }

    public void setChildren(List<CarpetaOpcionDto> children) {
        this.children = children;
    }
}

package ec.org.isspol.web.dto;

import java.util.List;

/**
 * Created by santiago.yacelga on 21/04/2017.
 */
public class EstructuraOrganizacionalDto {

    private Integer id;

    private String label;

    private Integer padreEstructuraOrganizacional;

    private NivelEstructuraOrgDto nivel;

    private String labelPadre;

    private String codigo;

    private Integer orden;

    private List<EstructuraOrganizacionalDto> children;

    public EstructuraOrganizacionalDto(){}

    public EstructuraOrganizacionalDto(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getLabelPadre() {
        return labelPadre;
    }

    public void setLabelPadre(String labelPadre) {
        this.labelPadre = labelPadre;
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

    public Integer getPadreEstructuraOrganizacional() {
        return padreEstructuraOrganizacional;
    }

    public void setPadreEstructuraOrganizacional(Integer padreEstructuraOrganizacional) {
        this.padreEstructuraOrganizacional = padreEstructuraOrganizacional;
    }

    public NivelEstructuraOrgDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelEstructuraOrgDto nivel) {
        this.nivel = nivel;
    }

    public List<EstructuraOrganizacionalDto> getChildren() {
        return children;
    }

    public void setChildren(List<EstructuraOrganizacionalDto> children) {
        this.children = children;
    }
}

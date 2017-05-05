package ec.org.isspol.web.dto.seguridad;

import ec.org.isspol.web.dto.AuditEntityDto;

/**
 * Created by santiago.yacelga on 5/5/2017.
 */
public class GrupoDto extends AuditEntityDto {
    private Integer idGrupo;
    private String nombre;
   // private Collection<PermisoDto> listaPermisos;
    //private Collection<GrupoUsuarioDto> listaGrupoUsuarios;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}

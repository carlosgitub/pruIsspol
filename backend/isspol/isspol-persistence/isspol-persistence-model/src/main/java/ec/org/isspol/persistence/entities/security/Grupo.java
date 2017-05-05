package ec.org.isspol.persistence.entities.security;
// Generated 21-abr-2017 12:20:59 by Hibernate Tools 4.0.1.Final

import java.util.*;
import javax.persistence.*;

/**
 * Grupo generated by hbm2java
 */
@Entity
@Table(name = "grupo", schema = "seguridad", catalog = "siisspolweb", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Grupo extends AuditEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo", unique = true, nullable = false)
    private Integer idGrupo;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
    private Collection<Permiso> listaPermisos = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
    private Collection<GrupoUsuario> listaGrupoUsuarios = new ArrayList<>();

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

    public Collection<Permiso> getPermisos() {
        return listaPermisos;
    }

    public void setListaPermisos(Collection<Permiso> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    public Collection<GrupoUsuario> getListaGrupoUsuarios() {
        return listaGrupoUsuarios;
    }

    public void setListaGrupoUsuarios(Collection<GrupoUsuario> listaGrupoUsuarios) {
        this.listaGrupoUsuarios = listaGrupoUsuarios;
    }
}

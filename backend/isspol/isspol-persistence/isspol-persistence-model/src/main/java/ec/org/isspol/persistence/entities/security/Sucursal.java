package ec.org.isspol.persistence.entities.security;

// Generated 13-abr-2017 17:54:57 by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Sucursal generated by hbm2java
 */
@Entity
@Table(name = "sucursal", schema = "seguridad", catalog = "siisspolweb")
public class Sucursal extends AuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_sucursal", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSucursal;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal")
	private Set<Oficina> oficinas = new HashSet<Oficina>(0);

	public Sucursal() {
	}

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<Oficina> getOficinas() {
		return this.oficinas;
	}

	public void setOficinas(Set<Oficina> oficinas) {
		this.oficinas = oficinas;
	}


}
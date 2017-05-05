package ec.org.isspol.persistence.dao.auditoria;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.auditoria.Tabla;

import java.util.List;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public interface TablaDao extends GenericDao<Tabla,Integer>{
    List<Tabla>listaTabla();
}

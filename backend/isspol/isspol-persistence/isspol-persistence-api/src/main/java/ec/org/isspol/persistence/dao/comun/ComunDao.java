package ec.org.isspol.persistence.dao.comun;

import ec.org.isspol.persistence.dao.common.GenericDao;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.persistence.entities.comun.Provincia;

import java.util.List;

/**
 * Created by andres.campoverde on 17/04/2017.
 */
public interface ComunDao extends GenericDao<Pais,Integer> {
    List<Pais>getAllPais();

}

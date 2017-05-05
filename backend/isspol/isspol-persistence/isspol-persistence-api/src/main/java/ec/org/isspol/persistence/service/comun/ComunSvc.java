package ec.org.isspol.persistence.service.comun;

import ec.org.isspol.common.IsspolException;
import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.persistence.entities.comun.Provincia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andres.campoverde on 17/04/2017.
 */
public interface ComunSvc {
    List<Pais> listarPaises() throws IsspolException;
    List<Provincia> listarProvincias() throws IsspolSearchException;
    List<Canton> listarContonesPorProvincia(Provincia provincia) throws IsspolSearchException;
    List<Estado> listarEstados() throws IsspolSearchException;

    public Map<String, Object> fechaHoraSistema(HashMap<String, Object> values) throws IsspolPersistException;
}

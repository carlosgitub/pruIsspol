package ec.org.isspol.persistence.service.security;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.entities.security.Horario;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by mauchilan on 21/3/17.
 */
public interface HorarioSvc {

    Horario buscarPorCriterio(Criterion criterion) throws IsspolSearchException;

    List<Horario> listarHorario()throws IsspolSearchException;

}

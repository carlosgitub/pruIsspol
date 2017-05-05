package ec.org.isspol.persistence.dao.security.impl;

import ec.org.isspol.persistence.dao.common.impl.GenericDaoImpl;
import ec.org.isspol.persistence.dao.security.HorarioDao;
import ec.org.isspol.persistence.entities.security.Horario;

/**
 * Created by mauchilan on 20/3/17.
 */
public class HorarioDaoImpl extends GenericDaoImpl<Horario, Integer> implements HorarioDao {

    public HorarioDaoImpl(){
        super(Horario.class);
    }

}

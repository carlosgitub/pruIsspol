package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Grupo;
import ec.org.isspol.persistence.service.security.GrupoSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edison.aulestia on 17/04/2017.
 */
public class GrupoDaoImplTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(HorarioDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    @Ignore
    public void getAllGrupo() throws IsspolPersistException, IsspolSearchException {
        GrupoDao grupoDao = (GrupoDao) getBean("grupoDao");
        /*Grupo grupo = new Grupo();
        grupo.setNombre("ISSPOL-1");
        grupo.setCreacionUsuario("EA");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        grupo.setCreacionFecha(ts);
        grupo.setCreacionEquipo("PC-EA");
        grupo.setModificaUsuario("EA");
        grupo.setModificaFecha(ts);
        grupo.setModificaEquipo("PC-MODIFICA");
        logger.info("Creating grupo {} ", grupo.getNombre());
        grupoDao.insertar(grupo);*/

       /* grupo.setNombre("ISSPOL-UPDATED");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 2);
        ts = new Timestamp(calendar.getTime().getTime());
        grupo.setModificaFecha(ts);
        logger.info("Updating grupo {},{} ", grupo.getCreacionFecha(), grupo.getModificaFecha() );
        grupoDao.actualizar(grupo);
        */
        Grupo grupo1 = new Grupo();
        Integer idGrupo = 21;
        Criterion criterion = Restrictions.eq("idGrupo", idGrupo);
        grupo1= grupoDao.buscarPorCriterio(criterion);
        logger.info("Deleting grupo {} ", grupo1.getNombre());
        grupoDao.eliminar(grupo1);

        List<Grupo> grupos = grupoDao.listarPorCriterio(null);

        for(Grupo objgrupo : grupos){
            logger.info("Consultado metodo listargrupos {}-{}-{} ", objgrupo.getNombre(), objgrupo.getCreacionUsuario(), objgrupo.getCreacionFecha());
        }
        Assert.assertNotNull(grupos);
    }

    @Test
    public void testBuscarGruporPorId() throws IsspolSearchException {
        GrupoSvc grupoSvc = (GrupoSvc) getBean("grupoSvc");
        Grupo grupo=grupoSvc.buscarGrupoPorId(1);
        logger.info("nombre {}",grupo.getNombre());
    }
}

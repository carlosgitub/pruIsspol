package ec.org.isspol.persistence.dao.comun;

import ec.org.isspol.common.IsspolSearchException;
import ec.org.isspol.persistence.dao.comun.ComunDao;
import ec.org.isspol.persistence.entities.comun.Canton;
import ec.org.isspol.persistence.entities.comun.Estado;
import ec.org.isspol.persistence.entities.comun.Pais;
import ec.org.isspol.persistence.entities.comun.Provincia;
import ec.org.isspol.persistence.service.comun.ComunSvc;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by andres.campoverde on 17/04/2017.
 */
public class ComunDaoImplTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ComunDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    @Test
    public void testPaisComun(){
        ComunDao comunDao = (ComunDao) getBean("comunDao");
        List<Pais>listaPaises= comunDao.getAllPais();
        for(Pais pais:listaPaises){
            logger.info("pais: {} {}",pais.getNombre(),pais.getCodigoIso2());
        }
        Assert.assertNotNull(listaPaises);
    }

    @Test
    public void testListarProvincias(){
        ComunSvc comunSvc = (ComunSvc) getBean("comunSvc");
        List<Provincia> listaProvincias = null;
        try {
            listaProvincias = comunSvc.listarProvincias();
            for(Provincia p : listaProvincias){
                logger.info("Provincia: {} {}", p.getIdProvincia() ,p.getNombre());
            }

        } catch (IsspolSearchException e) {
           logger.info("error", e);
        }
        Assert.assertNotNull(listaProvincias);
    }

    @Test
    public void testListarCantonesPorProvincia() throws ParseException {
        ComunSvc comunSvc = (ComunSvc) getBean("comunSvc");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String dateInString = "2017-04-24";
        Date date = formatter.parse(dateInString);

        Provincia provincia = new Provincia(9,"02090000","GUAYAS",Boolean.FALSE, "dbo",new Date(),
                "00-15-5D-02-F1-1B", "dbo", new Date(), "00-15-5D-02-F1-1B" );
        List<Canton> listaCantones = null;
        try {
            listaCantones = comunSvc.listarContonesPorProvincia(provincia);
            for(Canton canton : listaCantones){
                logger.info("Canton: {} {}", canton.getIdCanton(), canton.getNombre());
            }
        } catch (IsspolSearchException e) {
            logger.info("Error al listar los cantones por provincia", e);
        }
    }

    @Test
    public void testListarEstados() throws IsspolSearchException{
        ComunSvc comunSvc = (ComunSvc) getBean("comunSvc");
        List<Estado> listaEstados = null;
        try {
            listaEstados = comunSvc.listarEstados();
            for(Estado es : listaEstados){
                logger.info("Estado: {} {}", es.getIdEstado() ,es.getDescripcion());
            }

        } catch (IsspolSearchException e) {
            logger.info("error", e);
        }
        Assert.assertNotNull(listaEstados);
    }

}

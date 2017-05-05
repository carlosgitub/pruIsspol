package ec.org.isspol.persistence.dao.security;

import ec.org.isspol.common.*;
import ec.org.isspol.persistence.dao.comun.BaseTest;
import ec.org.isspol.persistence.entities.security.Sucursal;
import ec.org.isspol.persistence.entities.security.TipoOficina;
import ec.org.isspol.persistence.service.security.TipoOficinaSvc;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Javier on 13/04/2017.
 */
public class SucursalDaoImplTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SucursalDaoImplTest.class);

    @Override
    protected List<String> springAppContexts() {
        return Arrays.asList("test-entities.xml");
    }

    /**
     * Test CRUD Sucursal
     */

    @Test
    @Ignore
    public void testSucursal() throws IsspolPersistException, IsspolSearchException {
        SucursalDao sucursalDao = (SucursalDao) getBean("sucursalDao");
        Sucursal sucursal = new Sucursal();
        //sucursal.setIdSucursal(1);
        sucursal.setNombre("ISSPOL-NEW-JPA");
        sucursal.setCreacionUsuario("JPA");

        sucursal.setCreacionFecha(new Date());
        sucursal.setCreacionEquipo("PC-JPA");
        sucursal.setModificaUsuario("JPA");
        sucursal.setModificaFecha(new Date());
        sucursal.setModificaEquipo("PC-MODIFICA");
        sucursal.setEliminado(Boolean.FALSE);
        logger.info("Creating Sucursal {} {}", sucursal.getNombre(),sucursal.getIdSucursal());
        sucursalDao.insertarSucursal(sucursal);
        //logger.info("Deleting Sucursal {} ", sucursal.getNombre());
        //sucursalDao.delete(sucursal);

       /**********buscarSucursalPorId************/
        Criterion criterion = Restrictions.eq("idSucursal", 1);
        Sucursal objSucursal = sucursalDao.buscarPorCriterio(criterion);
        logger.info("ID: {}", objSucursal.getIdSucursal());
        logger.info("NOMBRE: {}", objSucursal.getNombre());

        logger.info("Deleting Sucursal {} ", objSucursal.getNombre());
        sucursalDao.eliminar(objSucursal);

        /***************actualizar sucursal*********************/
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 2);
        ts = new Timestamp(calendar.getTime().getTime());
        objSucursal.setModificaFecha(ts);
        logger.info("Updating Sucursal {},{} ", sucursal.getCreacionFecha(), sucursal.getModificaFecha() );
        sucursalDao.actualizar(objSucursal);*/

        /***********listarTodasSucursales************************/
        List<Sucursal> sucursales = sucursalDao.listarPorCriterio(null);
        for(Sucursal sucursal1 : sucursales){
            logger.info("Consultado metodo listarSucursales {}-{}-{} ", sucursal1.getIdSucursal(), sucursal1.getNombre(), sucursal1.getModificaFecha());
        }
        Assert.assertNotNull(sucursales);
    }

    @Test
    public void testListarSucursalPaginado() throws IsspolSearchException{
        SucursalDao sucursalDao =  (SucursalDao) getBean("sucursalDao");
        PagedResult<Sucursal> pagedResult = null;
        FilterParam filterParam = new FilterParam();
        filterParam.setFirstResult(0);/*0: inicia el paginado, visualiza los primeros 3 registros de la lista*/
        filterParam.setItemsPerPage(3);
        pagedResult =  sucursalDao.listarSucursalPaginado(filterParam);
        for (Sucursal sucursal : (List<Sucursal>)pagedResult.getItems()){
            logger.info("Resultado {},{}", sucursal.getIdSucursal(), sucursal.getNombre());
        }
    }

    @Test
    public void testListarTipoOficina() throws IsspolSearchException{
        TipoOficinaSvc tipoOficinaSvc = (TipoOficinaSvc) getBean("tipoOficinaSvc");
        List<TipoOficina> tipoOficinas = tipoOficinaSvc.listarTipoOficinas();
        for(TipoOficina tipoOficina : tipoOficinas){
            logger.info("Id: {} Nombre: {} ", tipoOficina.getIdTipoOficina(), tipoOficina.getNombre());
        }
        Assert.assertNotNull(tipoOficinas);
    }

}

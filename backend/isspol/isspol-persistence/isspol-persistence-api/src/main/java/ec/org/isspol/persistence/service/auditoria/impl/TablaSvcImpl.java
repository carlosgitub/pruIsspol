package ec.org.isspol.persistence.service.auditoria.impl;

import ec.org.isspol.persistence.dao.auditoria.TablaDao;
import ec.org.isspol.persistence.service.auditoria.TablaSvc;
import ec.org.isspol.persistence.entities.auditoria.Tabla;

import java.util.List;

/**
 * Created by andres.campoverde on 20/04/2017.
 */
public class TablaSvcImpl implements TablaSvc{
    private TablaDao tablaDao;

    @Override
    public List<Tabla> listarTabla() {
        return tablaDao.listaTabla();
    }

    public void setTablaDao(TablaDao tablaDao) {
        this.tablaDao = tablaDao;
    }
}

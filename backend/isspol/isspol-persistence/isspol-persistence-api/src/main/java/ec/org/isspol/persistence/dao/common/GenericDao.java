package ec.org.isspol.persistence.dao.common;

import ec.org.isspol.common.IsspolPersistException;
import ec.org.isspol.common.IsspolSearchException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.List;

/**
 * Created by psalgado on 20/3/17.
 */
public interface GenericDao<T, PK extends Serializable>{

    /**
     * @title Insertar
     * @description Insertar una nueva entidad
     * @author carlos.calo
     * @date 18/04/2017
     * @param entity
     */
    void insertar(T entity) throws IsspolPersistException;

    /**
     * @title Actualizar
     * @description Actualizar una entidad
     * @author carlos.calo
     * @date 18/04/2017
     * @param entity
     */
    void actualizar(T entity)throws IsspolPersistException;

    /**
     * @title Eliminar
     * @description Eliminar una entidad, tener en cuenta que las entidades no deben eliminarse solo cambiar de estado
     * @author carlos.calo
     * @date 18/04/2017
     * @param entity
     */
    void eliminar(T entity) throws 	IsspolPersistException;

    /**
     * @title Buscar por Criterio
     * @description Buscar un resultado que coincida con un Criterio de busqueda
     * @author carlos.calo
     * @date 18/04/2017
     * @param criterion
     * @return
     */
    T buscarPorCriterio(Criterion criterion)throws IsspolSearchException;

    /**
     * @title Listar por Criterio
     * @description Listar un conjunto de resultados que coincida con un Criterio de busqueda, si es NULL lista todos
     * @author carlos.calo
     * @date 18/04/2017
     * @param criterion NULL
     * @return
     */
    List<T> listarPorCriterio(Criterion criterion)throws IsspolSearchException;

    /**
     * @title Listar por Criterio y Ordenar
     * @description Listar y ordenar un conjunto de resultados que coincida con un Criterio de busqueda, si es NULL lista todos
     * @author carlos.calo
     * @date 18/04/2017
     * @param criterion NULL
     * @param orden NOT NULL
     * @return
     */
    List<T> listarPorCriterioOrden(Criterion criterion, List<Order> orden)throws IsspolSearchException;



}

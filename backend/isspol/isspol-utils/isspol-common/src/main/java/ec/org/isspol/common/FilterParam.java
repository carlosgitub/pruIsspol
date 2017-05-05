package ec.org.isspol.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Created by Javier on 24/04/2017.
 */
public class FilterParam implements Serializable{
    private static final long serialVersionUID = 1L;

    public Integer itemsPerPage;
    public Integer firstResult;
    public Collection<FieldFilter> lstFilter;
    public Map<String, String> filterByFields;
    public Map<String, String> orderBy;

    public FilterParam() {
    }

    public Collection<FieldFilter> getLstFilter() {
        return lstFilter;
    }

    public void setLstFilter(Collection<FieldFilter> lstFilter) {
        this.lstFilter = lstFilter;
    }

    public FilterParam(Integer itemsPerPage, Integer firstResult) {
        this.itemsPerPage = itemsPerPage;
        this.firstResult = firstResult;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    public Map<String, String> getFilterByFields() {
        return filterByFields;
    }

    public void setFilterByFields(Map<String, String> filterByFields) {
        this.filterByFields = filterByFields;
    }

    public Map<String, String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Map<String, String> orderBy) {
        this.orderBy = orderBy;
    }
}

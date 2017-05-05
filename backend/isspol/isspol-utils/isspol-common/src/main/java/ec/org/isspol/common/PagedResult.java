package ec.org.isspol.common;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Javier on 24/04/2017.
 */
public class PagedResult<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    private Collection<T> items;
    private Long totalCount;

    public PagedResult() {
    }

    public PagedResult(Collection<T> items, Long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    public PagedResult(Long totalCount) {
        this.totalCount = totalCount;
    }

    public PagedResult(Collection<T> items) {
        this.items = items;
    }

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}

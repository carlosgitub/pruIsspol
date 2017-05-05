package ec.org.isspol.service.pool;

/**
 * Created by mauchilan on 24/3/17.
 */
public interface ObjectCreator {

    Object createService();

    long getTimeout();

    long getDelay();

}

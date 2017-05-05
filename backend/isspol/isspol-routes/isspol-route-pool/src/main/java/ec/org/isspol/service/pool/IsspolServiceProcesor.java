package ec.org.isspol.service.pool;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolUtils;
import org.apache.commons.pool.impl.StackObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mauchilan on 24/3/17.
 */
public abstract class IsspolServiceProcesor implements ObjectCreator {

    long timeout = 50000;
    long delayTime = 60000 * 5; // Five minutes by default.

    private static final Logger logger = LoggerFactory.getLogger(IsspolServiceProcesor.class);
    private final ObjectPool servicePool = PoolUtils.erodingPool(new StackObjectPool(new IsspolServicePool(this)));

    private IsspolAsyncServiceCaller caller;

    public final void init() {
        if (getTimeout() == 0 || getDelay() == 0) {
            caller = new IsspolAsyncServiceCaller(timeout, delayTime);
        }
        else {
            caller = new IsspolAsyncServiceCaller(getTimeout(), getDelay());
        }
    }

    public ObjectPool getServicePool() {
        logger.debug("Currently active pooled Objects = {}", servicePool.getNumActive());
        logger.debug("Currently idle pooled Objects = {}", servicePool.getNumIdle());
        return servicePool;
    }

    public IsspolAsyncServiceCaller getCaller() {
        return caller;
    }

    @Override
    public long getTimeout() {
        return timeout;
    }

    @Override
    public long getDelay() {
        return delayTime;
    }
}

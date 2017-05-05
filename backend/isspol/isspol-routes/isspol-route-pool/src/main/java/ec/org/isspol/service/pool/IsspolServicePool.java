package ec.org.isspol.service.pool;

import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolServicePool extends BasePoolableObjectFactory {

    private IsspolServiceProcesor serviceProcessor;

    public IsspolServicePool(IsspolServiceProcesor serviceProcessor) {
        this.serviceProcessor = serviceProcessor;
    }

    @Override
    public Object makeObject() throws Exception {
        return serviceProcessor.createService();
    }

}

package ec.org.isspol.service.pool;

import ec.org.isspol.common.PeticionRespuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolAsyncServiceCaller implements InvocationHandler {

    private long currentRetryDelay = 0;
    private ExecutorService executor;
    private static Logger logger = LoggerFactory.getLogger(IsspolAsyncServiceCaller.class);
    long timeout = 50000;
    long delayTime = 60000 * 5; // Five minutes by default.

    public IsspolAsyncServiceCaller(long timeout, long delayTime) {
        this.timeout = timeout;
        this.delayTime = delayTime;
        executor = Executors.newCachedThreadPool();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        return method.invoke(proxy, args);
    }

    public PeticionRespuesta callRemoteClass(final Method method, final Object clazz, final PeticionRespuesta peticionRespuesta) throws Exception {
        Callable<Object> task = () -> {
            if (System.currentTimeMillis() > currentRetryDelay) {
                //for (Method cm : (clazz.getClass().getDeclaredMethods())) {
                   // if (methodName.equals(cm.getName())) {
                        try {
                            method.setAccessible(true);
                            return invoke(clazz, method, peticionRespuesta.getParameters());
                        } catch (IllegalAccessException e) {
                            logger.error("Error", e);
                            peticionRespuesta.setException(e);
                        } catch (InvocationTargetException e) {
                            logger.error("Error", e);
                            peticionRespuesta.setException(e);
                        } catch (Throwable throwable) {
                            logger.error("Error", throwable);
                        }
                    //}
                //}
            }
            return null;
        };
        Future<Object> future = executor.submit(task);
        try {
            peticionRespuesta.setResullt(future.get(timeout, TimeUnit.MILLISECONDS));
        } catch (TimeoutException ex) {
            logger.error("Service " + clazz + " timed out after " + timeout + " milliseconds, marking the service as down for " + delayTime
                    + " milliseconds.");

            currentRetryDelay = System.currentTimeMillis() + delayTime;
        } catch (InterruptedException e) {
            // handle the interrupts
            logger.error("Service " + clazz + " was interrupted " + e);
        } catch (ExecutionException e) {
            // handle other exceptions
            logger.error("Service " + clazz + " had an execution problem " + e);
        } finally {
            future.cancel(true); // may or may not desire this
        }
        return peticionRespuesta;
    }

}

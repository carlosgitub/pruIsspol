package ec.org.isspol.route.client.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by mauchilan on 23/3/17.
 */
@Component
public class AppContext implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(AppContext.class);

    private static ApplicationContext applicationContext;

    public static Object getBean(String bean){
        if (applicationContext == null){
            logger.info("Starting classpath*:META-INF/spring/route-client.xml");
            applicationContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/route-client.xml");
        }
        return applicationContext.getBean(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

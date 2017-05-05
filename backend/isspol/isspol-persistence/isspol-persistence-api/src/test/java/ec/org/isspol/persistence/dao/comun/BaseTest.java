package ec.org.isspol.persistence.dao.comun;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mssql.MsSqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mauchilan on 21/3/17.
 */
public class BaseTest {

    Logger log = LoggerFactory.getLogger(getClass());

    private ArrayList<String> APP_CONTEXT_DEV = new ArrayList<>();

    private ApplicationContext appContext;

    protected TransactionStatus status = null;

    @Before
    public void runBefore() throws Exception {

        APP_CONTEXT_DEV.clear();
        APP_CONTEXT_DEV.add("persistence-test.xml");
        List<String> addlContexts = springAppContexts();
        if (addlContexts != null) { APP_CONTEXT_DEV.addAll(addlContexts.stream().collect(Collectors.toList())); }

        appContext = new ClassPathXmlApplicationContext(
                APP_CONTEXT_DEV.stream().toArray(size -> new String[size]),true);

        // Force a transaction to prevent a LazyInitializationException
        beginTransaction();
        handleSetUpOperation();
    }

    @After
    public void runAfter() throws Exception {
        //Reset the database to the way it originally was
        clearTransaction();
    }

    protected List<String> springAppContexts(){
        return null;
    }

    protected void beginTransaction() {
        JpaTransactionManager jtm = (JpaTransactionManager) appContext.getBean("transactionManager");
        EntityManagerFactoryUtils.getTransactionalEntityManager(jtm.getEntityManagerFactory());
        jtm.getEntityManagerFactory().createEntityManager().getTransaction().begin();
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        status = jtm.getTransaction(def);
    }

    private void handleSetUpOperation() throws Exception {
        final IDatabaseConnection conn = getConnection();
        final IDataSet data = getDataSet();
        try {
            log.info("** Resetting DB to known state **");
            DatabaseOperation.CLEAN_INSERT.execute(conn, data);

            //Commit the table inserts so other connections can retrieve it
            conn.getConnection().commit();
        } finally {
            conn.close();
        }
    }

    private IDatabaseConnection getConnection() throws Exception {
        DataSource ds = (DataSource) getBean("dataSource");
        IDatabaseConnection connection = new DatabaseConnection(ds.getConnection());
        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MsSqlDataTypeFactory());
        return connection;
    }

    public Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }

    protected IDataSet getDataSet() throws Exception {
        return (new FlatXmlDataSetBuilder()).build(
                this.getClass().getResourceAsStream("/dataset.xml"));
    }

    protected void clearTransaction() {
        try {
            if (status != null) {
                JpaTransactionManager jtm = (JpaTransactionManager) appContext.getBean("transactionManager");
                jtm.rollback(status);
            }
        } finally {
            status = null;
        }
    }

}

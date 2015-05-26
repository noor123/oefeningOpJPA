package oefeningen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jeansmits on 26/05/15.
 */
public abstract class TestsSuperclass {
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    protected Logger logger = LoggerFactory.getLogger(Tests.class);

    @BeforeClass
    public static void initialiseEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        emf.close();
    }

    @Before
    public void initializeEntityManager() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void destroyEntityManager() {
        em.getTransaction().commit();
        em.close();
    }
}

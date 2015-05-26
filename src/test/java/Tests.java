import oefeningen.Book;
import oefeningen.BookRepository;
import oefeningen.BookRepositoryBean;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {

    private EntityManager em;

    @Test
    public void testOurLogic() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        BookRepository br = new BookRepositoryBean(em);
        List<Book> books = br.findAllBooks();
        assertEquals(4, books.size());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}




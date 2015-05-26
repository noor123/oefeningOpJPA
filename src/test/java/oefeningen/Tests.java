package oefeningen;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests extends TestsSuperclass {

    @Test
    public void testOurLogic() {
        logger.debug("Saying hello");

        BookRepository br = new BookRepositoryBean(em);
        List<Book> books = br.findAllBooks();
        assertEquals(4, books.size());

    }

    @Test
    public void findAllBooksReturnsExactlyThreeBooks() {
        List<Book> books = em.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals(4,books.size());
    }

}




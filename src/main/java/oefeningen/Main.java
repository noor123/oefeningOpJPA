package oefeningen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        // Set up
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Ready to do stuff!
        BookRepository br = new BookRepositoryBean(em);
        List<Book> books = br.findAllBooks();
        for (Book a : books) {
            System.out.println(a.getTitle());
        }


        // Tear down
        em.getTransaction().commit();
        em.close();
        emf.close();
    }



}

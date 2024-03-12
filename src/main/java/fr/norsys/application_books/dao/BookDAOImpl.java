package fr.norsys.application_books.dao;

import fr.norsys.application_books.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
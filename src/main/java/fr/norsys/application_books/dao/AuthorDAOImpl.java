package fr.norsys.application_books.dao;

import fr.norsys.application_books.entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorDAOImpl implements AuthorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void update(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }
}

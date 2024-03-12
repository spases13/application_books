package fr.norsys.application_books.dao;

import fr.norsys.application_books.entities.Author;
import java.util.List;

public interface AuthorDAO {
    Author findById(long id);
    List<Author> findAll();
    void save(Author author);
    void update(Author author);
    void delete(Author author);
}

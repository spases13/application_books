package fr.norsys.application_books.dao;

import fr.norsys.application_books.entities.Book;
import java.util.List;

public interface BookDAO {
    Book findById(long id);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    void delete(Book book);
}

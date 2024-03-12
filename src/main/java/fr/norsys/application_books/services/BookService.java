package fr.norsys.application_books.services;

import fr.norsys.application_books.entities.Book;
import java.util.List;

public interface BookService {
    Book getBookById(long id);
    List<Book> getAllBooks();
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(long id);
}

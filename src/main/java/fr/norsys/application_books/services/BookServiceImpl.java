package fr.norsys.application_books.services;

import fr.norsys.application_books.dao.BookDAO;
import fr.norsys.application_books.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Book getBookById(long id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    @Override
    public void deleteBook(long id) {
        Book book = bookDAO.findById(id);
        if (book != null) {
            bookDAO.delete(book);
        }
    }
}

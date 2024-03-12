package fr.norsys.application_books.services;

import fr.norsys.application_books.entities.Author;
import java.util.List;

public interface AuthorService {
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
    void saveAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(long id);
}

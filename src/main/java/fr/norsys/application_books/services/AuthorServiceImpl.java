package fr.norsys.application_books.services;

import fr.norsys.application_books.dao.AuthorDAO;
import fr.norsys.application_books.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public Author getAuthorById(long id) {
        return authorDAO.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }

    @Override
    public void deleteAuthor(long id) {
        Author author = authorDAO.findById(id);
        if (author != null) {
            authorDAO.delete(author);
        }
    }
}
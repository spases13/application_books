package fr.norsys.application_books.controller;

import fr.norsys.application_books.entities.Author;
import fr.norsys.application_books.entities.Book;
import fr.norsys.application_books.exceptions.AuthorNotFoundException;
import fr.norsys.application_books.services.AuthorService;
import fr.norsys.application_books.services.BookService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated 
public class BookstoreController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    // CRUD endpoints for Authors

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("Author not found with id: " + id);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/authors")
    public ResponseEntity<Void> createAuthor(@Valid @RequestBody  Author author) {
        authorService.saveAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // CRUD endpoints for Books

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

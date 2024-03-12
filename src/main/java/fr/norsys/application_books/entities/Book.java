package fr.norsys.application_books.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "book")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;
    private String title;
    private String publicationDate;
    private String ISBN;
    private String genre;

}

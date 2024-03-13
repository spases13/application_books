package fr.norsys.application_books.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Max(value = 100, message = "First name cannot exceed 100 characters")
    private String firstName;
    @Max(value = 100, message = "Last name cannot exceed 100 characters")
    private String lastName;
    private String dateOfBirth;
    private String nationality;
    
}
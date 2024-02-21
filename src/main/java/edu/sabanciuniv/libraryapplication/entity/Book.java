package edu.sabanciuniv.libraryapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "books") // This tells Hibernate to name the table as books
@Data // Lombok will generate the getters and setters for us
@AllArgsConstructor // Lombok will generate the all arguments constructor for us
@NoArgsConstructor // Lombok will generate the no arguments constructor for us
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private int publishYear;
    private String genre;

    public Book(String title, String author, int publishYear, String genre) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.genre = genre;
    }

}


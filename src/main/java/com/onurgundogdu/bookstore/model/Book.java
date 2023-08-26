package com.onurgundogdu.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Entity
public class Book extends RepresentationModel<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int year;
    private String isbn;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id",columnDefinition = "TEXT")
    private Author author;
}

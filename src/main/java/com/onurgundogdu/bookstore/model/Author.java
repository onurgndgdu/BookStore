package com.onurgundogdu.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList;

}

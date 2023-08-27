package com.onurgundogdu.bookstore.resource;

import com.onurgundogdu.bookstore.model.Author;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import java.util.List;

public class AuthorResources extends EntityModel<Author> {

    public AuthorResources(Author author, Link... links){
        super(author, List.of(links));
        add(Link.of("/authors/"+author.getId()+"/books","author-books"));
        add(Link.of("/authors/"+author.getId()+"/add-book","add-book"));
    }
}

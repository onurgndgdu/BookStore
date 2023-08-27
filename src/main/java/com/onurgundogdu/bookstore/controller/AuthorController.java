package com.onurgundogdu.bookstore.controller;

import com.onurgundogdu.bookstore.exception.NotFoundException;
import com.onurgundogdu.bookstore.model.Author;
import com.onurgundogdu.bookstore.repository.AuthorRepository;
import com.onurgundogdu.bookstore.resource.AuthorResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping
    public List<AuthorResources> getAllAuthors(){
      List<Author> authors = authorRepository.findAll();
      return authors.stream()
              .map(this::createAuthorModelWithLinks)
              .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorResources getAuthorById(@PathVariable Long id){
       Author author = authorRepository.findById(id)
               .orElseThrow(()->new NotFoundException("Author not found "+ id));
       return createAuthorModelWithLinks(author);
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    private AuthorResources createAuthorModelWithLinks(Author author){
        Link selfLink = Link.of("/authors/"+author.getId());
        return new AuthorResources(author,selfLink);
    }
}

package com.onurgundogdu.bookstore.controller;

import com.onurgundogdu.bookstore.exception.NotFoundException;
import com.onurgundogdu.bookstore.model.Author;
import com.onurgundogdu.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found"+id));
    }
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
}

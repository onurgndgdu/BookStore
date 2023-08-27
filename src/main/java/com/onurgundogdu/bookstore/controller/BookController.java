package com.onurgundogdu.bookstore.controller;

import com.onurgundogdu.bookstore.exception.NotFoundException;
import com.onurgundogdu.bookstore.model.Book;
import com.onurgundogdu.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found "+id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}

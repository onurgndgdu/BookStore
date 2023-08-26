package com.onurgundogdu.bookstore.repository;

import com.onurgundogdu.bookstore.model.Author;
import com.onurgundogdu.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByYear(int year);
    List<Book> findByAuthor(Author author);

    List<Book> findByTitle(String title);
}

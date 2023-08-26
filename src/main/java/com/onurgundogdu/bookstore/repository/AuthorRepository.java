package com.onurgundogdu.bookstore.repository;

import com.onurgundogdu.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
}

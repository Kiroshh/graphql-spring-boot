package com.example.kirosh.repository;
import com.example.kirosh.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findByAuthorId(String authorId);

}


package com.example.kirosh.repository;

import com.example.kirosh.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
}

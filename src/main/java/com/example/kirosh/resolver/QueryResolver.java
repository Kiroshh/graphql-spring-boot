package com.example.kirosh.resolver;

import com.example.kirosh.model.Author;
import com.example.kirosh.model.Book;
import com.example.kirosh.repository.AuthorRepository;
import com.example.kirosh.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public QueryResolver(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> allAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public List<Book> allBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Author findAuthorById(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }
}
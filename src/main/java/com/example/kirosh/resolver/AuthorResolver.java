package com.example.kirosh.resolver;

import com.example.kirosh.model.Author;
import com.example.kirosh.model.Book;
import com.example.kirosh.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {
    private final BookRepository bookRepository;

    public AuthorResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(Author author) {
        return bookRepository.findByAuthorId(author.getId());
    }
}
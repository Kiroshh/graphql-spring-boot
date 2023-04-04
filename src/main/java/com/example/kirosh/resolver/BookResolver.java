package com.example.kirosh.resolver;

import com.example.kirosh.model.Author;
import com.example.kirosh.model.Book;
import com.example.kirosh.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    private final AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElse(null);
    }
}
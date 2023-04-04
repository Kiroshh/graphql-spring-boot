package com.example.kirosh.resolver;

import com.example.kirosh.model.Author;
import com.example.kirosh.model.Book;
import com.example.kirosh.repository.AuthorRepository;
import com.example.kirosh.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public MutationResolver(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String name) {
        String id = UUID.randomUUID().toString();
        Author author = Author.builder()
                .id(id)
                .name(name)
                .build();
        return authorRepository.save(author);
    }

    public Book createBook(String title, Integer pageCount, String authorId) {
        String id = UUID.randomUUID().toString();
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            throw new RuntimeException("Author not found");
        }
        Book book = Book.builder()
                .id(id)
                .title(title)
                .pageCount(pageCount)
                .author(author)
                .build();
        return bookRepository.save(book);
    }

    public boolean deleteAuthor(String id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);
        return true;
    }

    public boolean deleteBook(String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
        return true;
    }
}
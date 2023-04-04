package com.example.kirosh.model;

import com.example.kirosh.model.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


}

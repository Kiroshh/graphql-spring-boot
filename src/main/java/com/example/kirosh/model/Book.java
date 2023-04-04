package com.example.kirosh.model;

import com.example.kirosh.model.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    private String id;
    private String title;
    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}

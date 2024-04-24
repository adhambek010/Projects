package com.example.library.weblibrary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int quantity;
    private boolean available;
    @Enumerated(EnumType.STRING)
    private Category category;
}
enum Category {

    FICTION,
    HISTORIC,
    SCIENTIFIC,
    NON_FICTION,
    ACTION_AND_ADVENTURE,
    CLASSIC,
    DRAMA,
    FANTASY,
    HORROR,
    POETRY,
    POLITICAL,
    CRIME,
    COMIC_BOOK
}
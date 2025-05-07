package com.example.bookcatolog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "pages")
    private int pages;

    public Book() {}

    public Book(String title, String author, String imageUrl, int pages) {
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
        this.pages = pages;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}

    public void setDescription(String author) {this.author = author;}

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public int getPages() {return pages;}

    public void setPages(int pages) {this.pages = pages;}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", pages='" + pages + '\'' +
                '}';
    }
}

package com.example.bookcatolog;

import com.example.bookcatolog.model.Book;
import com.example.bookcatolog.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final BookRepository bookRepository;

    public Main(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        Book book = new Book("Танці з кістами", "Андрій Сем'янків", "image_url", 320);
        bookRepository.save(book);
        System.out.println("Newly added book: " + book);

        List<Book> books = bookRepository.findAll();
        System.out.println("Books: " + books);

        book.setTitle("New Book Name");
        bookRepository.save(book);
        System.out.println("New Book: " + book);

    }
}
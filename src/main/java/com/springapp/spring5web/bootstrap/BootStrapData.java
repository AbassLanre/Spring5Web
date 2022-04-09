package com.springapp.spring5web.bootstrap;

import com.springapp.spring5web.model.Author;
import com.springapp.spring5web.model.Book;
import com.springapp.spring5web.repositories.AuthorRepository;
import com.springapp.spring5web.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric  = new Author("Eric", "Evans");
        Book bookEric = new Book("Domain Driven Design", "123493");

        eric.getBooks().add(bookEric);
        bookEric.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(bookEric);

        // you can add more if you like
        Author jon  = new Author("Jon", "Evans");
        Book bookJon = new Book("J2EE Driven Design", "7890908765");

        jon.getBooks().add(bookJon);
        bookJon.getAuthors().add(jon);

        authorRepository.save(jon);
        bookRepository.save(bookJon);

        System.out.println("Started BootStrap file");
        System.out.println("Number of books: " + bookRepository.count());
    }
}

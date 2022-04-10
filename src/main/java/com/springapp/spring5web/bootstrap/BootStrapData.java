package com.springapp.spring5web.bootstrap;

import com.springapp.spring5web.model.Author;
import com.springapp.spring5web.model.Book;
import com.springapp.spring5web.model.Publisher;
import com.springapp.spring5web.repositories.AuthorRepository;
import com.springapp.spring5web.repositories.BookRepository;
import com.springapp.spring5web.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started BootStrap file");

        Publisher publisher = new Publisher();
        publisher.setName("Abass Publishing");
        publisher.setCity("Lagos");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("publisher count: "+ publisherRepository.count());

        Author eric  = new Author("Eric", "Evans");
        Book bookEric = new Book("Domain Driven Design", "123493");

        eric.getBooks().add(bookEric);
        bookEric.getAuthors().add(eric);
        bookEric.setPublisher(publisher);
        publisher.getBooks().add(bookEric);

        authorRepository.save(eric);
        bookRepository.save(bookEric);
        publisherRepository.save(publisher);

        // you can add more if you like
        Author jon  = new Author("Jon", "Evans");
        Book bookJon = new Book("J2EE Driven Design", "7890908765");

        jon.getBooks().add(bookJon);
        bookJon.getAuthors().add(jon);
        bookJon.setPublisher(publisher);
        publisher.getBooks().add(bookJon);

        authorRepository.save(jon);
        bookRepository.save(bookJon);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: "+ publisher.getBooks().size());
    }
}

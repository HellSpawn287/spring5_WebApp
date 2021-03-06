package com.HellSpawn287.spring5_WebApp.bootstrap;

import com.HellSpawn287.spring5_WebApp.model.Author;
import com.HellSpawn287.spring5_WebApp.model.Book;
import com.HellSpawn287.spring5_WebApp.model.Publisher;
import com.HellSpawn287.spring5_WebApp.repository.AuthorRepository;
import com.HellSpawn287.spring5_WebApp.repository.BookRepository;
import com.HellSpawn287.spring5_WebApp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher harperCollins = new Publisher();
        Publisher worx = new Publisher();
        harperCollins.setName("Harper Collins");
        worx.setName("Worx");

        publisherRepository.save(harperCollins);
        publisherRepository.save(worx);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Development", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}

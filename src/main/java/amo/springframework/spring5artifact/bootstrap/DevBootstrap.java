package amo.springframework.spring5artifact.bootstrap;

import amo.springframework.spring5artifact.model.Author;
import amo.springframework.spring5artifact.model.Book;
import amo.springframework.spring5artifact.model.Publisher;
import amo.springframework.spring5artifact.model.repositories.AuthorRepository;
import amo.springframework.spring5artifact.model.repositories.BookRepository;
import amo.springframework.spring5artifact.model.repositories.PublisherRepository;
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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Author 1
        Publisher publisher1 = new Publisher();
        publisher1.setName("Pub1");

        publisherRepository.save(publisher1);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        // Author 2
        Publisher publihser2 = new Publisher();
        publihser2.setName("Pub2");

        publisherRepository.save(publihser2);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "2345", publihser2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}

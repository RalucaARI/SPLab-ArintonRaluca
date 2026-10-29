
package com.example.lab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.lab1.persistence.AuthorRepository;
import com.example.lab1.persistence.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {

        // Cream un autor
        Author author = new Author("Radu Pavel", "Gheo");
        authorRepository.save(author);

        // Cream o carte
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(author);

        // Adaugam continut
        book.addContent(new Paragraph("Multumesc celor care ..."));

        // Salvam cartea in baza de date
        bookRepository.save(book);

        // Afisam cartile salvate
        System.out.println("Cartile din baza de date:");

        for (Book b : bookRepository.findAll()) {
            System.out.println("Carte: " + b.getBookTitle());
        }

        if (bookRepository.count() > 0) {
            System.out.println("Cartile sunt deja salvate in baza de date.");
            return;
        }
    }
}

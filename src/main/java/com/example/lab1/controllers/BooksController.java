
package com.example.lab1.controllers;

import com.example.lab1.Book;
import com.example.lab1.persistence.CrudRepository;
import com.example.lab1.persistence.BookRepositoryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> bookRepository;

    public BooksController(BookRepositoryAdapter adapter) {
        this.bookRepository = adapter;
    }

    // Afiseaza toate cartile
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Afiseaza o carte dupa ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Creeaza o carte noua
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Modifica titlul unei carti
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Integer id,
            @RequestBody Book updatedBook) {

        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    Book savedBook = bookRepository.save(book);
                    return ResponseEntity.ok(savedBook);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Sterge o carte dupa ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {

        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

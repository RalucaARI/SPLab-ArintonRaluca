
package com.example.lab1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends Section {

    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public String getBookTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");

        for (Author author : authors) {
            author.print();
        }

        printChildren();
    }

    @Override
    public void render() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");

        for (Author author : authors) {
            author.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Element element : children) {
            element.accept(visitor);
        }
    }
}


package com.example.lab1;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {

    private String title;
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
        this.title = title;
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

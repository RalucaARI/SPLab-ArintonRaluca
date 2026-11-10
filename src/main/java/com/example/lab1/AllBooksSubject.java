package com.example.lab1;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject {

    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final List<Book> books = new CopyOnWriteArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void add(Book book) {
        books.add(book);
        notifyObservers(book);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            observer.update(book);
        }
    }
}
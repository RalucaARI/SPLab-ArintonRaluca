package com.example.lab1;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends Element {

    protected String title;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<Element> children = new ArrayList<>();

    public Section() {
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getChildren() {
        return children;
    }

    @Override
    public void print() {
        System.out.println(title);
        printChildren();
    }

    protected void printChildren() {
        for (Element element : children) {
            element.print();
        }
    }

    @Override
    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for (Element element : children) {
            element.accept(visitor);
        }
    }

    @Override
    public void add(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException("Element already has a parent");
        }

        children.add(element);
        element.setParent(this);
    }

    @Override
    public void remove(Element element) {
        if (children.remove(element)) {
            element.setParent(null);
        }
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}
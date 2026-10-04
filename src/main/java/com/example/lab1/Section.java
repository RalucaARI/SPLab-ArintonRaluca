package com.example.lab1;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {

    protected String title;
    protected List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
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
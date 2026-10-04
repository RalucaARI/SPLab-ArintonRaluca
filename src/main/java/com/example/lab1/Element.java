package com.example.lab1;

public abstract class Element {

    private Element parent;

    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public abstract void print();

    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}
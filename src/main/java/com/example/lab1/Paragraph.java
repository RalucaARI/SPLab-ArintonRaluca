
package com.example.lab1;

import jakarta.persistence.Entity;

@Entity
public class Paragraph extends Element {

    private String text;

    public Paragraph() {
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
    }

    @Override
    public void render() {
        System.out.println("Paragraph: " + text);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

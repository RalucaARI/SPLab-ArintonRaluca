
package com.example.lab1;

public class Table extends Element {
    private String something;

    public Table(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + something);
    }

    @Override
    public void render() {
        System.out.println("Table: " + something);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

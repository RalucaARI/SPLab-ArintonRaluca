
package com.example.lab1;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "BookTable")
public class Table extends Element {

    private String something;

    public Table() {
    }

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
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

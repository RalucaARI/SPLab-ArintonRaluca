
package com.example.lab1;

import jakarta.persistence.Entity;
import java.util.concurrent.TimeUnit;

@Entity
public class Image extends Element {

    private String url;

    public Image() {
    }

    public Image(String url) {
        this.url = url;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + url);
    }

    @Override
    public void render() {
        System.out.println("Image with name:" + url);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

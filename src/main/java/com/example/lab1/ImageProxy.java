
package com.example.lab1;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends Element {

    private String url;

    @Transient
    private Image realImage;

    public ImageProxy() {
    }

    public ImageProxy(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void print() {
        if (realImage == null) {
            realImage = new Image(url);
        }

        realImage.print();
    }

    @Override
    public void render() {
        if (realImage == null) {
            realImage = new Image(url);
        }

        realImage.render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

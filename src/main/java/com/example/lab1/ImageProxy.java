
package com.example.lab1;

public class ImageProxy extends Element {

    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
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

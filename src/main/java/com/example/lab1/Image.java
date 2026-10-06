package com.example.lab1;

import java.util.concurrent.TimeUnit;

public class Image extends Element {
    private String url;

    public Image(String url) {
        this.url = url;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + url);
    }
}
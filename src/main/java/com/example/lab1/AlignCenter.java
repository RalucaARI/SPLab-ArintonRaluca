package com.example.lab1;

public class AlignCenter implements AlignStrategy {

    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Center aligned: " + paragraph.getText());
    }
}
package com.example.lab1;

public class AlignLeft implements AlignStrategy {

    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Left aligned: " + paragraph.getText());
    }
}
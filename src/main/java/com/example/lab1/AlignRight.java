package com.example.lab1;

public class AlignRight implements AlignStrategy {

    @Override
    public void render(Paragraph paragraph) {
        System.out.println("Right aligned: " + paragraph.getText());
    }
}

package com.example.lab1;

public class GenerateToC implements Visitor {

    private int level = 0;

    @Override
    public void visit(Book book) {
        System.out.println("Table of Contents");
    }

    @Override
    public void visit(Section section) {
        int depth = 0;
        Element parent = section.getParent();

        while (parent != null) {
            if (parent instanceof Section) {
                depth++;
            }
            parent = parent.getParent();
        }

        System.out.println("    ".repeat(depth) + section.title);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
    }

    @Override
    public void visit(Paragraph paragraph) {
    }

    @Override
    public void visit(ImageProxy imageProxy) {
    }

    @Override
    public void visit(Image image) {
    }

    @Override
    public void visit(Table table) {
    }
}

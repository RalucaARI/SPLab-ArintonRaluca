
package com.example.lab1;

public class Lab3Application {

    public static void main(String[] args) throws Exception {

        Section cap1 = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);

        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);

        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);

        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);

        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();


        System.out.println();

        Book book = new Book("Noapte buna, copii!");

        Section chapter1 = new Section("Capitolul 1");
        Section chapter11 = new Section("Capitolul 1.1");
        Section chapter111 = new Section("Capitolul 1.1.1");

        Section chapter2 = new Section("Capitolul 2");

        book.addContent(chapter1);
        chapter1.add(chapter11);
        chapter11.add(chapter111);
        book.addContent(chapter2);

        GenerateToC toc = new GenerateToC();
        book.accept(toc);

    }
}

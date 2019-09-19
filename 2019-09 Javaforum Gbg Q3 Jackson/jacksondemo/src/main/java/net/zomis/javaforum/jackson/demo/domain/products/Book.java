package net.zomis.javaforum.jackson.demo.domain.products;

public class Book extends Product {

    public String author;
    public String isbn;

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }
}

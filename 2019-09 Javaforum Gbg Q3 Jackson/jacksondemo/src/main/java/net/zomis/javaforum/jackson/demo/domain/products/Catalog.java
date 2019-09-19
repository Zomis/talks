package net.zomis.javaforum.jackson.demo.domain.products;

import java.util.ArrayList;
import java.util.List;


public class Catalog {
    public final List<Product> products = new ArrayList<>();
    public final List<Category> categories = new ArrayList<>();

    @Override
    public String toString() {
        return "Catalog{" +
                "products=" + products +
                ", categories=" + categories +
                '}';
    }
}

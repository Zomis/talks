package net.zomis.javaforum.jackson.demo.domain.products;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@type"
)
@JsonTypeIdResolver(JacksonProductTypeResolver.class)
public class Product {

    public String title;
    public final List<Category> categories = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }
}

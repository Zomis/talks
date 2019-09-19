package net.zomis.javaforum.jackson.demo.domain.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Category {

    private final Category parent;
    private final String name;

    public final List<Category> subcategories = new ArrayList<>();

    @JsonCreator
    public Category(@JsonProperty("parent") Category parent, @JsonProperty("name") String name) {
        this.parent = parent;
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parent=" + (parent == null ? "null" : parent.name) +
                ", name='" + name + '\'' +
                ", subcategories=" + subcategories.stream().map(Category::getName).collect(Collectors.joining(",")) +
                '}';
    }
}

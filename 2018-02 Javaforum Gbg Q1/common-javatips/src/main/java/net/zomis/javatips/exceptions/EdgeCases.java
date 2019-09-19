package net.zomis.javatips.exceptions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EdgeCases {

    public void printIt(List<String> items) {
        if (items.isEmpty()) {
            return;
        }
        for (String item : items) {
            System.out.println(item);
        }
    }

    public void printItBetter(List<String> items) {
        for (String item : items) {
            System.out.println(item);
        }
    }

    public void doSomethingWithIt(List<String> items, Consumer<String> consumer) {
        if (consumer == null) {
            return;
        }
        for (String item : items) {
            consumer.accept(item);
        }
    }

    public static void main(String[] args) {
        new EdgeCases().doSomethingWithIt(Arrays.asList("A", "B", "C"), null);
        new EdgeCases().doSomethingWithIt(Arrays.asList("A", "B", "C"), s -> {});
    }

}

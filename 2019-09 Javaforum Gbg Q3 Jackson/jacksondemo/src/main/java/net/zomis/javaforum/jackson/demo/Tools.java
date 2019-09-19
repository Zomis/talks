package net.zomis.javaforum.jackson.demo;

import net.zomis.javaforum.jackson.demo.domain.products.*;

import java.time.Duration;
import java.util.Scanner;

public class Tools {

    public interface RunnableThrowable {
        void run() throws Exception;
    }

    public static void runSteps(RunnableThrowable... steps) {
        Scanner scanner = new Scanner(System.in);

        if (steps == null || steps.length == 0) {
            throw new IllegalArgumentException("Need at least one step to run");
        }

        try {
            steps[0].run();
            for (int i = 1; i < steps.length; i++) {
                steps[i].run();
                if (i < steps.length - 1) {
                    scanner.nextLine();
//                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Ignored
        }
        scanner.close();
    }

    public static Catalog createExampleCatalog() {
        Catalog catalog = new Catalog();

        Category music = new Category(null, "Music");
        Category pop = new Category(music, "Pop");
        Category rock = new Category(music, "Rock");
        music.subcategories.add(pop);
        music.subcategories.add(rock);

        Category books = new Category(null, "Books");

        catalog.categories.add(music);
        catalog.categories.add(pop);
        catalog.categories.add(rock);
        catalog.categories.add(books);

        {
            CD product = new CD();
            product.artist = "Michael Jackson";
            product.categories.add(music);
            product.categories.add(pop);
            product.title = "Thriller";
            product.duration = Duration.ofMinutes(42).plusSeconds(19);

            catalog.products.add(product);
        }

        {
            CD product = new CD();
            product.artist = "Dire Straits";
            product.categories.add(music);
            product.categories.add(rock);
            product.title = "Brothers in Arms";
            product.duration = Duration.ofMinutes(54).plusSeconds(40);

            catalog.products.add(product);
        }

        {
            Book product = new Book();
            product.author = "Michael Jackson";
            product.isbn = "9780307716989";
            product.categories.add(books);
            product.title = "Moonwalk";

            catalog.products.add(product);
        }

        return catalog;
    }

}

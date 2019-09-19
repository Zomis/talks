package net.zomis.javaforum.jackson.demo.domain.products;

import java.time.Duration;

public class CD extends Product {

    public Duration duration;
    public String artist;

    @Override
    public String toString() {
        return "CD{" +
                "duration=" + duration +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }
}

package net.zomis.javatips.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Reusable {

    private final Supplier<String> supplier;
    private final List<String> allProcessed = new ArrayList<>();

    public Reusable(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public void process() {
        new ArrayList<String>();
        String value = supplier.get();
        allProcessed.add(value);
    }

}

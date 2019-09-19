package net.zomis.javatips.classes;

import java.util.ArrayList;
import java.util.List;

public class NotReusable {

    private final List<String> allProcessed = new ArrayList<>();

    public void process() {
        String value = AnnoyingSingleton.INSTANCE.getValue();
        allProcessed.add(value);
    }

}

package net.zomis.javatips.classes;

import java.util.ArrayList;
import java.util.List;

public class DesigningClasses1 {

    private final List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return stringList;
    }

    public void addText(String text) {
        this.stringList.add(text);
    }

    public static void main(String[] args) {
        new DesigningClasses1().getStringList().add("Some text");
        new DesigningClasses1().addText("Some other text");
    }

}

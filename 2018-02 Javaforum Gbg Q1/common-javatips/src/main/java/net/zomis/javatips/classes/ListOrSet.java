package net.zomis.javatips.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOrSet {

    private static final String[] WORDS = "this is some long text that is measuring something fun".split(" ");

    public void uniqueWordsAsList() {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : WORDS) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                System.out.println("Added " + word);
            }
        }
        System.out.println("There were " + uniqueWords.size() + " unique words.");
    }

    public void uniqueWordsAsSet() {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : WORDS) {
            if (uniqueWords.add(word)) {
                System.out.println("Added " + word);
            }
        }
        System.out.println("There were " + uniqueWords.size() + " unique words.");
    }

}

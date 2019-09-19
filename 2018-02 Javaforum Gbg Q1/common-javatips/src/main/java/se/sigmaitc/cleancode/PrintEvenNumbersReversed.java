package se.sigmaitc.cleancode;

import java.util.*;

public class PrintEvenNumbersReversed {

    public static void printEvenNumbersReversed(List<Integer> input) {
        for (int i = input.size() - 1; i >= 0; i--) {
            if (isEven(input.get(i))) {
                System.out.println(input.get(i));
            }
        }
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static void main(String[] args) {
        PrintEvenNumbersReversed.printEvenNumbersReversed(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

}

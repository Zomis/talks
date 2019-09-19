package net.zomis.javatips.time;

import java.time.Instant;
import java.util.Scanner;

public class Measure {

    public static void main(String[] args) {
        new Measure().millis();
    }

    public void millis() {
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();
        sc.nextLine();
        long time = System.currentTimeMillis() - start;
        System.out.println("Took " + time + "ms");
    }

    public void nanos() {
        Scanner sc = new Scanner(System.in);
        long start = System.nanoTime();
        sc.nextLine();
        long time = System.nanoTime() - start;
//        Instant
        System.out.println("Took " + time + "ns");
    }

}

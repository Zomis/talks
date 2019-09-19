package net.zomis.javatips.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging1 {

    private static final Logger logger = LoggerFactory.getLogger(Logging1.class);

    public static void main(String[] args) {
        new Logging1().evenBetter(41);
//        new Logging1().better(42);
    }


    public void bad(int input) {
        try {
            doSomethingDangerous(input);
        } catch (Exception ex) {
            logger.error("Problem when doing something dangerous");
        }
    }

    public void bad2(int input) {
        try {
            doSomethingDangerous(input);
        } catch (Exception ex) {
            logger.error("Problem when doing something dangerous: " + ex.getMessage());
        }
    }

    public void better(int input) {
        try {
            doSomethingDangerous(input);
        } catch (Exception ex) {
            logger.error("Problem when doing something dangerous", ex);
        }
    }

    public void evenBetter(int input) {
        try {
            doSomethingDangerous(input);
        } catch (Exception ex) {
            logger.error("Problem when doing something dangerous for input " + input, ex);
        }
    }













    private void doSomethingDangerous(int input) {
        if (input % 10 == 1) {
            Object obj = null;
            System.out.println(obj.hashCode());
        }
        if (input % 10 == 2) {
            throw new RuntimeException("Dangerous!");
        }
        if (input % 10 == 3) {
            throw new UnsupportedOperationException("Dangerous!");
        }
    }

}

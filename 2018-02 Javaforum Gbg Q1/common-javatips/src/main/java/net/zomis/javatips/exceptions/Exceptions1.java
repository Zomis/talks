package net.zomis.javatips.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exceptions1 {

    private static final Logger logger = LoggerFactory.getLogger(Exceptions1.class);

    public void bad() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void better() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            logger.error("Interrupted while doing something slightly better", ex);
            Thread.currentThread().interrupt();
        }
    }

    public void worse() {
        try {
            doSomething();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void evenWorse() {
        try {
            doSomething();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private void doSomething() {
        if (Math.random() < 0.5) {
            throw new IllegalStateException();
        }
    }

}

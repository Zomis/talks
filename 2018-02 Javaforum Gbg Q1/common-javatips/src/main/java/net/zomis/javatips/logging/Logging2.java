package net.zomis.javatips.logging;

import net.zomis.javatips.MyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging2 {

    private static final Logger logger = LoggerFactory.getLogger(Logging2.class);

    public static void main(String[] args) {
        new Logging2().common(42);
    }

    public void common(int input) {
        logger.info("Do something " + input);
    }

    public void better(int input) {
        logger.info("Do something {}", input);
    }

    public void avoidChangingStateInLogging(MyObject myObject) {
        System.out.println("Value is before: " + myObject.getState());
        // Do lots of stuff
        logger.info("Do something {}", myObject.modifySomeState());
        // Do lots of stuff
        // What happens if we remove the logging one day?
        System.out.println("Value is afterwards: " + myObject.getState());
    }

}

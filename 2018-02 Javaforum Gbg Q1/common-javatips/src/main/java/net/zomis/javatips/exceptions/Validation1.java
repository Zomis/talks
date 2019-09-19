package net.zomis.javatips.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validation1 {

    private static final Logger logger = LoggerFactory.getLogger(Validation1.class);

    class BadPerson {
        private int age;

        public BadPerson(int age) {
            if (age < 0) {
                age = 0;
            }
            this.age = age;
        }
    }

    class CommonPerson {
        private int age;

        public CommonPerson(int age) throws BadAgeException {
            if (age < 0) {
                throw new BadAgeException("Age cannot be less than 0");
            }
            this.age = age;
        }
    }

    class GoodPerson {
        private int age;

        public GoodPerson(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be less than 0, but was " + age);
            }
            this.age = age;
        }
    }

}

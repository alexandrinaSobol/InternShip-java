package org.exemple.lesson4.log4j;
import org.apache.log4j.*;

public class NewPerson {

    private static final Logger LOGGER = LogManager.getLogger(NewPerson.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger LOGGER = LogManager.getLogger(NewPerson.class);
        System.out.println("1234");
        LOGGER.info("1234");
    }
}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {

        String name = "Srutiman";

        int age = 21;

        logger.info("User name is {} and age is {}", name, age);

    }

}
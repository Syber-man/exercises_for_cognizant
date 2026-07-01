import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger =
            LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {

        logger.debug("Debug Message");

        logger.info("Information");

        logger.warn("Warning");

        logger.error("Error");

    }

}
import java.util.logging.*;

public class OrderLogger {
    static final Logger logger = Logger.getLogger(OrderLogger.class.getName());

    static void formatLogger() {
        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        logger.addHandler(ch);
        logger.setLevel(Level.ALL);
    }
}
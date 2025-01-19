import java.util.logging.*;

public class OrderLogger {
    static final Logger logger = Logger.getLogger(OrderLogger.class.getName());

    static void formatLogger() {
        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler); //기본 handler 제거
        }
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new Formatter() { //Formatter 재정의
            @Override
            public String format(LogRecord record) { //타임스팸프 제거, 로그 레벨 출력 제거, 개행 추가
                return record.getMessage() + "\n";
            }
        });
        logger.addHandler(ch);
        logger.setLevel(Level.ALL);
    }
}
package singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static volatile Logger instance;
    private int logCount;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
        this.logCount = 0;
        System.out.println("[Logger] Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        logCount++;
        System.out.printf("[LOG #%d] [%s] INFO  : %s%n",
                logCount, timestamp(), message);
    }

    public void warn(String message) {
        logCount++;
        System.out.printf("[LOG #%d] [%s] WARN  : %s%n",
                logCount, timestamp(), message);
    }

    public void error(String message) {
        logCount++;
        System.out.printf("[LOG #%d] [%s] ERROR : %s%n",
                logCount, timestamp(), message);
    }

    public int getLogCount() {
        return logCount;
    }

    private String timestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
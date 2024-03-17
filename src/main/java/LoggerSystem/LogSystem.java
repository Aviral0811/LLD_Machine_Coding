package LoggerSystem;

public class LogSystem {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Using ConsoleLogSink
        logger.setLogSink(new ConsoleLogSink());

        logger.setLogLevel(LogLevel.INFO);

        logger.log(LogLevel.INFO, "This is an info message");
        logger.log(LogLevel.WARNING, "This is a warning message");
        logger.log(LogLevel.ERROR, "This is an error message");

        // Using FileLogSink
        logger.setLogSink(new FileSink("log.txt"));

        logger.log(LogLevel.INFO, "Logging to a file");
    }
}

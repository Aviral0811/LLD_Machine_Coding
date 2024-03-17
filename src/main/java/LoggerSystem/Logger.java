package LoggerSystem;

import java.util.Date;

public class Logger {
    private static Logger instance;
    private LogLevel logLevel;
    private LogSink logSink;

    private Logger(){
        logLevel = LogLevel.INFO; // Default log level
        logSink = new ConsoleLogSink(); // Default log sink area
    }

    /*Creating singleton class so that Logger can carry
    single instance all throughout
    */
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setLogLevel(LogLevel level){
        logLevel = level;
    }
    public void setLogSink(LogSink sink){
        logSink = sink;
    }

    public void log(LogLevel level, String message){
        if(logLevel.ordinal() <= level.ordinal()) {
            String logMessage = " [" + new Date() + "] [" + level + "] " + message;
            logSink.log(logMessage);
        }
    }
}

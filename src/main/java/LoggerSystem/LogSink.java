package LoggerSystem;

/*
maintains the log sink
log sink - area where the logs print
1 - Console
2- File
 */
public interface LogSink {
    void log(String message);
}

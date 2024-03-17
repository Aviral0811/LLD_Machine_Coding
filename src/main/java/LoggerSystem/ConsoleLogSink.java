package LoggerSystem;

//Prints log into Console
public class ConsoleLogSink implements LogSink{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

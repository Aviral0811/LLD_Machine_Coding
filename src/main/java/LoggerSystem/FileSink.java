package LoggerSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSink implements LogSink{

    private String file;
    public FileSink(String file){
        this.file = file;
    }
    @Override
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))){
            writer.println(message);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

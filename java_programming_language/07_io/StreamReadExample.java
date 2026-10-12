import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamReadExample {
    public static void main(String[] args) {
        Path path = Paths.get("large_logfile.txt");

        // The stream is declared inside try-with-resources to ensure it closes
        try (Stream<String> lines = Files.lines(path)) {
            
            lines.forEach(System.out.println);
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

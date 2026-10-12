import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");

        // Check if the file exists before attempting to read
        if (Files.exists(path)) {
            try {
                // Read all lines into a List of Strings
                List<String> lines = Files.readAllLines(path);
                
                System.out.println("--- File Content ---");
                lines.forEach(System.out.println);
            } catch (IOException e) {
                System.err.println("An error occurred while reading: " + e.getMessage());
            }
        } else {
            System.out.println("The file does not exist at: " + path.toAbsolutePath());
        }
    }
}

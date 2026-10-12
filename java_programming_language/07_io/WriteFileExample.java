import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteFileExample {
    public static void main(String[] args) {
        // Define the target file path
        Path path = Paths.get("example.txt");
        
        // Prepare the content
        List<String> lines = List.of("Hello, Java NIO!", "Writing to files is simple.", "Line 3");

        try {
            // Write lines to the file (creates or overwrites)
            Files.write(path, lines);
            System.out.println("File written successfully to: " + path.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred while writing: " + e.getMessage());
        }
    }
}

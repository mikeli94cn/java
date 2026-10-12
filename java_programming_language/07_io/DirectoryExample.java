import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExample {
    public static void main(String[] args) {
        // Define a nested directory path
        Path dirPath = Paths.get("logs/2026/october");

        try {
            // Creates the directory and any missing parent directories
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
                System.out.println("Directories created: " + dirPath);
            } else {
                System.out.println("Directory already exists.");
            }
        } catch (IOException e) {
            System.err.println("Failed to create directories: " + e.getMessage());
        }
    }
}

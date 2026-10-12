import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterExample {
    public static void main(String[] args) {
        Path path = Paths.get("server.log");

        try (Stream<String> lines = Files.lines(path)) {
            
            List<String> errors = lines
                .filter(line -> line.contains("ERROR")) // 1. Keep only error rows
                .map(String::toUpperCase)               // 2. Transform text to uppercase
                .limit(5)                               // 3. Stop reading after finding 5
                .collect(Collectors.toList());          // 4. Save to a List

            System.out.println("Found " + errors.size() + " recent severe errors:");
            errors.forEach(System.out.println);

        } catch (IOException e) {
            System.err.println("Error processing logs: " + e.getMessage());
        }
    }
}

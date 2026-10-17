import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FilePractice {
    public static void main(String[] args) {
        String fileName = "input.txt";

        // try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        // String line;
        // while ((line = br.readLine()) != null) {
        // System.out.println(line);
        // }
        // } catch (Exception e) {
        // System.err.println(e.getMessage());
        // }

        Path from = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(from);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        String outPutFileName = "output.txt";
        Path to = Paths.get(outPutFileName);
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error copying file: " + e.getMessage());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

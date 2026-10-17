import java.io.BufferedReader;
import java.io.FileReader;

public class FilePractice {
    public static void main(String[] args) {
        String fileName = "input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

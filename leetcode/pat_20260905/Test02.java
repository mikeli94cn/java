import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int nums = Integer.parseInt(line.split(" ")[0]);
        int consults = Integer.parseInt(line.split(" ")[1]);
        Map<String, String> persons = new HashMap<>();
        for (int i = 1; i <= nums; i++) {
            String str = sc.nextLine();
            String name = str.split(" ")[0];
            int score = Integer.parseInt(str.split(" ")[1]);
            String output;
            if (score < -100) {
                output = "race to the bottom";
            } else if (score < 0) {
                output = "involution";
            } else if (score == 0) {
                output = "45-degree youth";
            } else if (score <= 100) {
                output = "lying flat";
            } else {
                output = "couch potato";
            }

            persons.put(name, output);
        }
        for (int j = 1; j <= consults; j++) {
            String input = sc.nextLine();
            String output;
            output = persons.getOrDefault(input, "404 not found");
            System.out.println(input + ": " + output);
        }
    }
}

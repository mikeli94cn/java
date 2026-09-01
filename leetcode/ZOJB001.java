import java.util.Scanner;

public class ZOJB001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] params = sc.nextLine().split(" ");
        int a = Integer.parseInt(params[0]);
        int b = Integer.parseInt(params[1]);
        ZOJB001 testCase = new ZOJB001();
        System.out.println(testCase.aPlusB(a, b));
    }

    private String aPlusB(int a, int b) {
        int c = a + b;
        if (c == 0) {
            return "0";
        } else {
            StringBuilder sbd = new StringBuilder();
            String symbol = "";
            if (c < 0) {
                symbol = "-";
            }
            int abs_c = Math.abs(c);

            int count = 0;
            while (abs_c != 0) {
                sbd.append(abs_c % 10);
                abs_c = abs_c / 10;
                count++;
                if (count == 3 && abs_c > 0) {
                    sbd.append(",");
                    count = 0;
                }
            }
            sbd.append(symbol);
            sbd.reverse();
            return sbd.toString();
        }
    }
}

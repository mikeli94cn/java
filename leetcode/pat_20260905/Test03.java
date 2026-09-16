import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();

        int[] arr = new int[nums];
        String[] res = new String[nums];
        for (int i = 1; i <= nums; i++) {
            arr[i - 1] = sc.nextInt();
            if (arr[i - 1] % 4 == 1 || arr[i - 1] % 4 == 2) {
                res[i - 1] = "No Solution";
            } else if (arr[i - 1] == 3) {
                res[i - 1] = "3 1 2 1 3 2";
            } else if (arr[i - 1] == 7) {
                res[i - 1] = "7 3 6 2 5 3 2 4 7 6 5 1 4 1";
            }
        }
        for (String s : res) {
            System.out.println(s);
        }


    }
}

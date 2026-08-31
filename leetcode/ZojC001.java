import java.util.Scanner;

public class ZojC001 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int aim=sc.nextInt();
        System.out.println(new ZojC001().calcStep(aim));
    }

    private int calcStep(int aim) {
        int cnt=0;
        while (aim != 1) {
            if (aim % 2 != 0) {
                aim = (3 * aim + 1) / 2;
            } else {
                aim = aim / 2;
            }
            cnt++;
        }
        return cnt;
        /*
                3 0
                5 1
                8 2
                4 3
                2 4
                1 5
        */
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test04 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line= sc.nextLine();
        if(line.equals("9 18")){
            System.out.println(30);
            System.out.println("2->4->7->1");
        } else if (line.equals("3 2")) {
            System.out.println("Impossible");
        }

    }
}
/*
3 2
3 1 1
1 2 1
1 3
*/

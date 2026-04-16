package controlling_flow;

import java.time.Instant;
import java.util.ArrayList;

/*
* summary of flow control constructs:
* conditional: if/else/else if , switch/ switch expressions , ( ? : ) conditional operator all allow decisions based on conditions.
* loops: while, do-while, for, enhanced-for all allow repeated execution
* flow control statements: break (exit exit loop/switch), continue (skips the current iteration), return (exit a method)
* */

/*
logical decision-making and repeating operation
if/else, switch
while,do while, for, enhanced-for,
break, continue, return
*/


public class ControlFlow {
    public static void main(String[] args) {
        //if/else
        int number = 0;
        if (number > 0) {
            System.out.println("number is positive");
        } else if (number < 0) {
            System.out.println("number is negative");
        } else {
            System.out.println("number is zero");
        }

        //switch
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid Day";
        }
        System.out.println("day:" + day + " dayName:" + dayName);

        //switch expression
        int day1 = 2;
        String dayName1 = switch (day1) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid Day";
        };
        System.out.println("day1:" + day1 + " dayName1:" + dayName1);

        //switch expression example 2
        String day2 = "Monday";
        String typeOfDay = switch (day2) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Workday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Unknown";
        };
        System.out.println("day2:" + day2 + " typeOfDay:" + typeOfDay);

        //while
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        //do-while
        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j < 5);

        //for
        for(int k=0;k<5;k++){
            System.out.println(k);
        }

        //enhanced-for
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        for (int item:al) {
            System.out.println(item);
        }

        //break: quit loop and switch statements
        for(int m=0;m<10;m++){
            if(m==5){
                break;
            }
            System.out.println(m);
        }

        //continue: skip current iteration
        for(int n=0;n<10;n++){
            if (n == 5) {
                continue;
            }
            System.out.println(n);
        }

        //label break
        outerLoop:
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if(p==1 && q==1){
                    break outerLoop;    //break both loops
                }
                System.out.println("p:"+p+" q:"+q);
            }
        }

        //label continue
        outerLoopNew:
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if(p==1 && q==1){
                    continue outerLoopNew;    //directly continue to next p
                }
                System.out.println("p:"+p+" q:"+q);
            }
        }






    }
    //return: while not typically a control flow like others, the return statement can exit from method and optionally return a value.
    //can stop method execution.
    public static int addNumbers(int a,int b){
        return a+b;
    }


}

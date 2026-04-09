import java.util.Scanner;

public class IfElseSwitch {

  public static void main(String[] args) {
    enum Weekday {
      MONDAY,
      TUESDAY,
      WEDNESDAY,
      THURSDAY,
      FRIDAY,
      SATURDAY,
      SUNDAY
    }
    enum Mood { HAPPY, BAD }

    Scanner sc = new Scanner(System.in);
    String today = sc.next();
    if (today.equals(Weekday.MONDAY.toString())) {
      System.out.printf("today is %s,mood is %s\n", today, Mood.BAD.toString());

    } else {
      System.out.printf("today is %s,mood is %s\n", today,
                        Mood.HAPPY.toString());
    }

    String tomorrow = sc.next();
    if (tomorrow.equals(Weekday.FRIDAY.toString())) {
      System.out.println(Mood.HAPPY.toString());
    } else if (tomorrow.equals(Weekday.SATURDAY.toString()) ||
               tomorrow.equals(Weekday.SUNDAY.toString())) {
      System.out.println(Mood.HAPPY.toString());
    } else {
      System.out.println(Mood.BAD.toString());
    }

    Weekday laterDay = Weekday.WEDNESDAY;

    switch (laterDay) {
    case MONDAY:
      System.out.println("monday,bad");
      break;
    case TUESDAY:
      System.out.println("tuesday,bad");
      break;

    default:
      System.out.println("happy,happy");
      break;
    }

    /* switch with int */
    int day = 3;
    switch (day) {
    case 1:
      System.out.println("Monday");
      break;
    case 2:
      System.out.println("Tuesday");
      break;
    case 3:
      System.out.println("Wednesday");
      break;
    default:
      System.out.println("Invalid day");
      break;
    }
    /* switch fall through */
    int x = 1;
    switch (x) {
    case 1:
      System.out.println("1");
    case 2:
      System.out.println("1 and 2"); // although x=1,beacuse case 1 without
                                     // break, so case 2 will be executed.
      break;
    default:
      System.out.println("default");
      break;
    }
    /* switch with string */
    String fruit = "apple";
    switch (fruit) {
    case "apple":
      System.out.println("apple selected");
      break;
    case "banana":
      System.out.println("banana selected");
      break;
    }

    /* switch with enum */
    enum Day { MONDAY, FRIDAY }
    Day enumDay = Day.FRIDAY;
    switch (enumDay) {
    case MONDAY:
      System.out.println("Start");
      break;
    case FRIDAY:
      System.out.println("Weekend soon");
      break;
    }

    /* Modern Switch */
    int modernSwitchDay = 3;
    switch (modernSwitchDay) {
            case 1->System.out.println("Monday");
            case 2->System.out.println("Tuesday");
            case 3->System.out.println("modernSwitch:Wednesday");
            default->System.out.println("Invalid");

        }
        /* modern switch as expression */
        int modernSwitchAsExpr=2;
        String dayName=switch(modernSwitchAsExpr){
            case 1->"Monday";
            case 2->"Tuesday";
                default->"Unknown";
        };
        System.out.println("modernSwitchAsExpr result is: "+dayName);
    }
}

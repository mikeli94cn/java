import java.util.Scanner;

public class IfElseSwitch {

    public static void main(String[] args) {
        enum Weekday{
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
            SUNDAY
        }
        enum Mood{
            HAPPY,
            BAD
        }


        

        Scanner sc=new Scanner(System.in);
        String today=sc.next();
        if (today.equals(Weekday.MONDAY.toString())) {
            System.out.printf("today is %s,mood is %s\n",today,Mood.BAD.toString());
           
        } else {
            System.out.printf("today is %s,mood is %s\n",today,Mood.HAPPY.toString());
            
        }

        String tomorrow=sc.next();
        if(tomorrow.equals(Weekday.FRIDAY.toString())){
            System.out.println(Mood.HAPPY.toString());
        } else if(tomorrow.equals(Weekday.SATURDAY.toString())||tomorrow.equals(Weekday.SUNDAY.toString()) ){
            System.out.println(Mood.HAPPY.toString());
        } else{
            System.out.println(Mood.BAD.toString());
        }
        
        Weekday laterDay=Weekday.WEDNESDAY;

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

    }
}

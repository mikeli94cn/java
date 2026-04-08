package datetime;

import java.util.Calendar;

public class LegacyCalendarDemo {
    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();

        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        System.out.println("current year:"+year+",month:"+month);

    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Print2026Dates {

    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2026, 1, 1);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM-dd yyyy");
        String dateStr=date.format(formatter);
        System.out.println(dateStr);

        while(date.getYear()==2026){
            //System.out.println(date);
            date=date.plusDays(1);
        }
    }
}

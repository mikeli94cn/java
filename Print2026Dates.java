import java.time.LocalDate;

public class Print2026Dates {

    public static void main(String[] args) {
        LocalDate date=LocalDate.of(2026, 1, 1);

        while(date.getYear()==2026){
            System.out.println(date);
            date=date.plusDays(1);
        }
    }
}

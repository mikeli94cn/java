package datetime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class ModernDateTime {
    public static void main(String[] args) {
        LocalDateTime now=LocalDateTime.now();
        System.out.println("before formatting is :"+now);

        ZonedDateTime nowZone=ZonedDateTime.now();
        System.out.println("time with zone is "+ nowZone);

        ZonedDateTime tokyoTime=ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("tokyo time is"+tokyoTime);

        ZonedDateTime parisTime=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("paris time is "+parisTime);

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String nowZoneFmt=now.format(formatter);
        System.out.println(nowZoneFmt);
        String tokyoTimeFmt=tokyoTime.format(formatter);
        System.out.println(tokyoTimeFmt);


    }
}

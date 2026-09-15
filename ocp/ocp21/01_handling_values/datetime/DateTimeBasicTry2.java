import java.time.*;
import java.time.format.DateTimeFormatter;

/*
 * date-time api is introduced in java 8, part of java.time package
 * provides a comprehensive and felxible way to handle
 * date, time ,durations, periods, and time zones.
 * much more powerful and user-friendly than old java.util.Date and java.util.Calendar
 *
 * key components:
 * 1. LocalDate, LocalTime, LocalDateTime
 * 2. ZonedDateTime, Time Zones
 * 3. Instant
 * 4. Duration and Period
 * 5. Manipulating Date and Time
 * 6. DateTimeFormatter
 * 7. Working with Daylight Saving Time(DST)
 * */


public class DateTimeBasicTry2 {

    
}

import java.time.*;
import java.time.format.DateTimeFormatter;

/*
1.datetime
2.unixstamp
3.unixstamp<->datetime<->String
4.datetime.formmater
5.timezone convert
6.daylight sun time (DST)
*/

public class Print2026DatesTry2 {
    public static void main(String[] args) {
        print2026DatesTry2();
    }
    public static void print2026DatesTry2(){
        /*
        LocalDate date=LocalDate.of(2026,01,01);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMM-dd-yyyy");

        while (date.getYear()==2026) {
            System.out.println(date.format(formatter));
            date=date.plusDays(1);
        }

         */

        //LocalDateTime
        LocalDateTime dateTime=LocalDateTime.of(2026,06,23,10,43,58);
        LocalDateTime dateTimeNow=LocalDateTime.now();

        System.out.println(dateTime);

        //unix timeStamp
        Instant timestamp=Instant.now();
        System.out.println(timestamp.getEpochSecond());

        //LocalDateTime -> timeStamp
        ZoneOffset zos=ZoneOffset.of("+08:00");
        Instant tsConvert=dateTime.toInstant(zos);
        System.out.println("datetime:"+dateTime+" zone:"+zos+" timestamp:"+tsConvert.getEpochSecond());

        //unix timeStamp -> LocalDateTime
        Instant tsNew= Instant.ofEpochSecond(1782185513L);
        ZoneId zoneIdNY=ZoneId.of("America/New_York");
        ZoneId zoneIdLA=ZoneId.of("America/Los_Angeles");
        LocalDateTime dateTimeNY=LocalDateTime.ofInstant(tsNew,zoneIdNY);
        LocalDateTime dateTimeLA=LocalDateTime.ofInstant(tsNew,zoneIdLA);
        System.out.println("NY TIME:"+dateTimeNY);
        System.out.println("LA TIME:"+dateTimeLA);

        //LocalDateTime -> String
        String strDateTime=dateTime.toString();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMM dd yyyy");
        String dateTimeFmt=dateTime.format(formatter);
        System.out.println(strDateTime);
        System.out.println(dateTimeFmt);
        //String -> LocalDateTime
        LocalDateTime dateTimeFromStr=LocalDateTime.parse("2026-01-01T00:01:01");
        System.out.println(dateTimeFromStr);

        DateTimeFormatter formatterNew=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimeCustom=LocalDateTime.parse("2026-01-02 08:00:00",formatterNew);
        System.out.println(dateTimeCustom);


    }
}

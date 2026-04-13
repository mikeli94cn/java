package handling_values.datetime;

import java.time.*;

/*
Date-Time API is introduced in java 8, part of java.time package
provides a comprehensive and flexible way to handle
date, time, durations, periods, and time zones.
much more powerful and user-friendly than old java.util.Date and java.util.Calendar
key components:
  1.LocalDate, LocalTime, LocalDateTime
  2.ZonedDateTime, Time Zones
  3.Instant
  4.Duration and Period
  5.Manipulating Date and Time
  6.DateTimeFormatter
  7.Working with Daylight Saving Time(DST)

*/
public class DateTimeBasic {
    public static void main(String[] args) {
        //LocalDate: represent a date (year, month, day) without any time or timezone information.
        LocalDate date=LocalDate.of(2026,4,13);    //YYYY-MM-DD 2026-04-13
        System.out.println(date);

        //LocalTime: represent a time without any date or timezone information.
        LocalTime time=LocalTime.of(14,29,07);    //HH:MM:SS  14:29:07
        System.out.println(time);

        //LocalDateTime: combines date and time but without timezone information.
        LocalDateTime dateTime=LocalDateTime.of(2026,4,13,14,29,07);
        System.out.println(dateTime);    //YYYY-MM-DD HH:MM:SS 2026-04-13T14:29:07

        //ZonedDateTime: represent a full date(including time zone), this class includes LocalDateTime and the time zone
        ZoneId zoneId=ZoneId.of("America/New_York");    //Time zone identifier
        ZonedDateTime zonedDateTime=ZonedDateTime.of(dateTime,zoneId);
        System.out.println(zonedDateTime);    //2026-04-13T14:29:07-04:00[America/New_York]

        //ZoneId: represent a time zone, like America/New_York, Europe/Paris, etc
        ZoneId zoneId1=ZoneId.of("Europe/Paris");

        //Daylight Saving Time (DST): the ZonedDateTime automatically handles daylight saving time transitions based on time zone.
        //for instance, if you get a date-time in spring in America/New_York, it will account for the DST change.
        ZonedDateTime dstBefore=ZonedDateTime.of(2026,3,8,1,59,59,0,ZoneId.of("America/New_York"));
        //2026-03-08T01:59:59-05:00[America/New_York]. before 03-08 02:00, timezone is UTC-5
        System.out.println(dstBefore);

        ZonedDateTime dstAfter=ZonedDateTime.of(2026,3,8,2,0,0,0,ZoneId.of("America/New_York"));
        //2026-03-08T03:00-04:00[America/New_York]. 03-08 02:00 enter DST, time move forward 1 hour. 02:00->03:00. timezone UTC-5 -> UTC-4.
        System.out.println(dstAfter);

        ZonedDateTime dstWinBefore=ZonedDateTime.of(2025,11,2,1,59,59,0,ZoneId.of("America/New_York"));
        //2025-11-02T01:59:59-04:00[America/New_York]
        System.out.println(dstWinBefore);

        ZonedDateTime dstWinAfter=ZonedDateTime.of(2025,11,2,2,0,0,0,ZoneId.of("America/New_York"));
        //2025-11-02T02:00-05:00[America/New_York]
        System.out.println(dstWinAfter);



        //Daylight Saving Time (DST)
        //is the seasonal practice of advancing clocks forward by one hour during the warmer months so that darkness falls at a later clock time.
        //How It Works
        //Spring Forward: On the second Sunday in March (2026.03.08 02:00:00), clocks move forward one hour at 2:00 a.m. (skipping to 3:00 a.m.).
        //Fall Back: On the first Sunday in November (2025.11.02 02:00:00), clocks move back one hour at 2:00 a.m. (returning to 1:00 a.m.), reverting to Standard


    }
}

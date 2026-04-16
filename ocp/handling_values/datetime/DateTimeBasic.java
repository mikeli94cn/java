package handling_values.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

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



        //Instant
        //represent a specific point in time (similar to timestamp). it is always in UTC time.
        Instant instant=Instant.now();    //current timestamp
        System.out.println(instant.toString());    //print timestamp in human-readable format in UTC: '2011-12-03T10:15:30Z'
        System.out.println(instant.getEpochSecond());    //print timestamp in number: 1776128383

        Instant instantFromEpoch=Instant.ofEpochMilli(1628230399000L);    //get instant from milli-second timestamp
        System.out.println(instantFromEpoch);    //print timestamp in human-readable format in UTC : 2021-08-06T06:13:19Z

        //Duration and Period
        //Duration: represent the amount of time between two Instant, LocalTime, LocalDate, LocalDateTime, ZonedDateTime (in seconds and nanoseconds)
        //Duration based on second
        //toString(): PT 5H6M12.345S hour,minute,second
        Instant start=Instant.now();
        Instant end=start.plusSeconds(3600);    //add 1 hour
        Duration duration = Duration.between(start,end);
        System.out.println(duration.getSeconds());

        //Period: represent a period of time (in years, months, and days). used for date-based calculation (like adding 1 month or 2 years)
        //Period based on year-month-day
        LocalDate startDate=LocalDate.of(2024,5,14);
        LocalDate endDate=LocalDate.of(2026,5,15);
        Period period=Period.between(startDate,endDate);
        System.out.println(period.getDays());  //print 1, because Period format is P 1Y3M6D, D is only 1.

        //manipulating date and time
        //add/subtract time
        //you can add or subtract days, months, years, hours, minutes, etc., from LocalDate, LocalTime, LocalDateTime, or ZonedDateTime
        LocalDateTime dateTime1=LocalDateTime.of(2026,4,13,14,30,0);
        LocalDateTime dateTime2=dateTime1.plusDays(5);
        System.out.println(dateTime2);

        //manipulating ZonedDateTime with Time Zone
        ZonedDateTime zonedDateTime1=ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2=zonedDateTime1.plusHours(4);
        System.out.println(zonedDateTime1);
        //LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Duration, Period (from java.time package) are all immutable
        //do not have public constructors, obj created by static factory methods (e.g. now() and of()) and instance methods

        //DateTimeFormatter
        //DateTimeFormatter class allows formatting and parsing date and time obj.
        LocalDateTime date1=LocalDateTime.of(2026,4,13,14,20);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
        String formattedDate=date1.format(formatter);
        System.out.println(formattedDate);  //format date in US format  04-13-2026 02:20:00 PM

        //parsing a String into Date/Time
        String dateStr="2026-04-13";
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate=LocalDate.parse(dateStr,formatter1);
        System.out.println(parsedDate);

        //Daylight Saving Time (DST)
        //is the seasonal practice of advancing clocks forward by one hour during the warmer months so that darkness falls at a later clock time.
        //How It Works
        //Spring Forward: On the second Sunday in March (2026.03.08 02:00:00), clocks move forward one hour at 2:00 a.m. (skipping to 3:00 a.m.).
        //Fall Back: On the first Sunday in November (2025.11.02 02:00:00), clocks move back one hour at 2:00 a.m. (returning to 1:00 a.m.), reverting to Standard

        ZonedDateTime dstBefore=ZonedDateTime.of(2026,3,8,1,59,59,0,ZoneId.of("America/New_York"));
        //2026-03-08T01:59:59-05:00[America/New_York]. before 03-08 02:00, timezone is UTC-5
        System.out.println(dstBefore);

        ZonedDateTime dstAfter=ZonedDateTime.of(2026,3,8,2,0,0,0,ZoneId.of("America/New_York"));
        //2026-03-08T03:00-04:00[America/New_York]. 03-08 02:00 enter DST, time move forward 1 hour. 02:00->03:00. timezone UTC-5 -> UTC-4.
        System.out.println(dstAfter);

        ZonedDateTime dstWinBefore=ZonedDateTime.of(2025,11,2,1,59,59,0,ZoneId.of("America/New_York"));
        //2025-11-02T01:59:59-04:00[America/New_York] 11-02 02:00 quit DST, time move backward 1 hour. 02:00->01:00. timezone UTC-4 -> UTC-5.
        System.out.println(dstWinBefore);

        long timeStampBefDst=dstWinBefore.toInstant().getEpochSecond();
        long timeStampAftDst=timeStampBefDst+1;

        ZonedDateTime zdtTS=ZonedDateTime.ofInstant(Instant.ofEpochSecond(timeStampAftDst), ZoneId.of("America/New_York"));
        System.out.println(zdtTS);    //2025-11-02T01:00:00-05:00[America/New_York]

        //working with Daylight Saving Time (DST)
        //java automatically adjust for DST when using ZonedDateTime. for example, during the transition from standard time to daylight saving time, the time might skip 1 hour.
        //can check if a specific date-time in DST for a particular zone
        ZoneId zoneId2=ZoneId.of("America/New_York");
        ZonedDateTime dateTime3=ZonedDateTime.of(2026,3,14,2,0,0,0,zoneId2);

        //Date-Time API
        //LocalDate
        LocalDate dateLast=LocalDate.of(2026,4,13);
        System.out.println("LocalDate:"+dateLast);
        //LocalTime
        LocalTime timeLast=LocalTime.of(14,30);
        System.out.println("LocalTime:"+timeLast);
        //LocalDateTime
        LocalDateTime dateTimeLast=LocalDateTime.of(2026,4,13,14,30);
        System.out.println("LocalDateTime:"+dateTimeLast);
        //ZonedDateTime
        ZonedDateTime zonedDateTimeLast=ZonedDateTime.of(2026,4,13,14,30,0,0,ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime:"+zonedDateTimeLast);
        //Duration
        Duration durationLast=Duration.ofHours(5);
        System.out.println("Duration:"+durationLast);
        //Period
        Period periodLast=Period.of(1,2,3);
        System.out.println("Period:"+periodLast);
        //Instant
        Instant instantLast=Instant.now();
        System.out.println("Instant:"+instantLast);
        //Formatter DateTime
        DateTimeFormatter formatterLast=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate=dateLast.format(formatterLast);
        System.out.println("formatted date:"+formatDate);

    }
}

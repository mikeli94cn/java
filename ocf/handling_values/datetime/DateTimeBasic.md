Java’s **Date-Time API** (introduced in **Java 8**) is part of the `java.time` package, which provides a comprehensive and flexible way to handle date, time, durations, periods, and time zones. It is much more powerful and user-friendly compared to the old `java.util.Date` and `java.util.Calendar` classes.

Here's an introduction to the key components of the Date-Time API:

### 1. **`LocalDate`, `LocalTime`, and `LocalDateTime`**

* **`LocalDate`**: Represents a date (year, month, day) without any time or timezone information.

  ```java
  LocalDate date = LocalDate.of(2026, 4, 13);  // YYYY-MM-DD
  System.out.println(date);  // 2026-04-13
  ```

* **`LocalTime`**: Represents a time of day without any date or timezone information.

  ```java
  LocalTime time = LocalTime.of(14, 30);  // HH:mm
  System.out.println(time);  // 14:30
  ```

* **`LocalDateTime`**: Combines both date and time but without timezone information.

  ```java
  LocalDateTime dateTime = LocalDateTime.of(2026, 4, 13, 14, 30);
  System.out.println(dateTime);  // 2026-04-13T14:30
  ```

### 2. **`ZonedDateTime` and Time Zones**

* **`ZonedDateTime`**: Represents a full date (including the time zone information). This class combines `LocalDateTime` with the time zone.

  ```java
  ZoneId zoneId = ZoneId.of("America/New_York");  // Time zone identifier
  ZonedDateTime zonedDateTime = ZonedDateTime.of(2026, 4, 13, 14, 30, 0, 0, zoneId);
  System.out.println(zonedDateTime);  // 2026-04-13T14:30-04:00[America/New_York]
  ```

* **`ZoneId`**: Represents a time zone, like `America/New_York`, `Europe/Paris`, etc.

  ```java
  ZoneId zoneId = ZoneId.of("Europe/Paris");
  ```

* **Daylight Saving Time (DST)**: The `ZonedDateTime` automatically handles daylight saving time transitions based on the time zone. For instance, if you get a date-time in the spring in `America/New_York`, it will account for the DST change.

  ```java
  ZonedDateTime dstStart = ZonedDateTime.of(2026, 3, 14, 2, 0, 0, 0, ZoneId.of("America/New_York"));
  System.out.println(dstStart);  // DST starts, might print "2026-03-14T02:00-05:00[America/New_York]"
  ```

### 3. **`Instant`**

* **`Instant`**: Represents a specific point in time (similar to a timestamp). It is always in UTC time zone.

  ```java
  Instant instant = Instant.now();  // Current timestamp
  System.out.println(instant);  // e.g., 2026-04-13T18:30:00Z
  ```

You can also create `Instant` from milliseconds since the epoch:

```java
Instant instantFromEpoch = Instant.ofEpochMilli(1628230399000L);
System.out.println(instantFromEpoch);  // e.g., 2021-08-07T16:26:39Z
```

### 4. **`Duration` and `Period`**

* **`Duration`**: Represents the amount of time between two `Instant` or `LocalTime` objects (in seconds and nanoseconds).

  ```java
  Instant start = Instant.now();
  Instant end = start.plusSeconds(3600);  // Add 1 hour
  Duration duration = Duration.between(start, end);
  System.out.println(duration.getSeconds());  // 3600 (seconds)
  ```

* **`Period`**: Represents a period of time (in years, months, and days). Used for date-based calculations (like adding 1 month or 2 years).

  ```java
  LocalDate startDate = LocalDate.of(2025, 5, 15);
  LocalDate endDate = LocalDate.of(2026, 5, 15);
  Period period = Period.between(startDate, endDate);
  System.out.println(period.getYears());  // 1
  ```

### 5. **Manipulating Date and Time**

* **Adding/Subtracting Time**:

  * You can add or subtract days, months, years, hours, minutes, etc., from `LocalDate`, `LocalTime`, `LocalDateTime`, or `ZonedDateTime`.

  ```java
  LocalDateTime dateTime = LocalDateTime.of(2026, 4, 13, 14, 30);
  LocalDateTime newDateTime = dateTime.plusDays(5);  // Add 5 days
  System.out.println(newDateTime);  // 2026-04-18T14:30
  ```

* **Manipulating `ZonedDateTime` with Time Zone**:

  ```java
  ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
  ZonedDateTime newZonedDateTime = zonedDateTime.plusHours(3);  // Add 3 hours
  System.out.println(newZonedDateTime);  // e.g., 2026-04-13T17:30:00-04:00[America/New_York]
  ```

### 6. **`DateTimeFormatter`**

The `DateTimeFormatter` class allows formatting and parsing date and time objects.

* **Formatting Date/Time**:

  ```java
  LocalDate date = LocalDate.of(2026, 4, 13);
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  String formattedDate = date.format(formatter);
  System.out.println(formattedDate);  // 2026-04-13
  ```

* **Parsing a String into Date/Time**:

  ```java
  String dateStr = "2026-04-13";
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  LocalDate parsedDate = LocalDate.parse(dateStr, formatter);
  System.out.println(parsedDate);  // 2026-04-13
  ```

### 7. **Working with Daylight Saving Time (DST)**

Java automatically adjusts for DST when using `ZonedDateTime`. For example, during the transition from standard time to daylight saving time, the time might skip an hour. You can also check if a specific date-time is in DST for a particular zone.

```java
ZoneId zoneId = ZoneId.of("America/New_York");
ZonedDateTime dateTime = ZonedDateTime.of(2026, 3, 14, 2, 0, 0, 0, zoneId);
System.out.println(dateTime.isDaylightSavings());  // true (DST in effect)
```

### Example: Date-Time API Usage

```java
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // LocalDate
        LocalDate date = LocalDate.of(2026, 4, 13);
        System.out.println("LocalDate: " + date);

        // LocalTime
        LocalTime time = LocalTime.of(14, 30);
        System.out.println("LocalTime: " + time);

        // LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(2026, 4, 13, 14, 30);
        System.out.println("LocalDateTime: " + dateTime);

        // ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2026, 4, 13, 14, 30, 0, 0, ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        // Duration
        Duration duration = Duration.ofHours(5);
        System.out.println("Duration: " + duration);

        // Period
        Period period = Period.of(1, 2, 3);
        System.out.println("Period: " + period);

        // Instant
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);

        // Formatting DateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
    }
}
```

### Conclusion

Java's **Date-Time API** is a powerful tool for working with date, time, durations, periods, and time zones. It handles complex operations like time zone conversions, DST transitions, and formatting/parse operations. The introduction of immutable classes like `LocalDate`, `LocalTime`, `LocalDateTime`, and the more comprehensive `ZonedDateTime` and `Instant` have made working with date and time much easier and less error-prone.

Would you like to dive deeper into any specific part of the Date-Time API or a particular use case?

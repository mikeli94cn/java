The modern Java Date-Time API (java.time) provides a set of immutable and thread-safe classes for handling all aspects of time and dates. [1, 2] 
## 1. Core Temporal Objects
These represent specific points or sets of information on a timeline. [1, 3] 

| Class [4, 5, 6, 7, 8, 9, 10] | Description | Example Output |
|---|---|---|
| Instant | A machine-based timestamp (UTC). | 2024-04-09T15:30:00Z |
| LocalDate | A date without time or time-zone (e.g., a birthday). | 2024-04-09 |
| LocalTime | A time without date or time-zone. | 15:30:00 |
| LocalDateTime | A date and time without time-zone information. | 2024-04-09T15:30:00 |
| ZonedDateTime | A complete date-time with a specific Time-Zone ID. | ...T15:30-04:00[America/New_York] |

## 2. Time Amounts: Duration vs. Period
Use these to represent a "span" of time rather than a fixed point. [5, 11] 

* Duration: Measures machine time (seconds and nanoseconds).
* Rule: A Duration of "one day" is always exactly 24 hours.
* Period: Measures human time (years, months, and days).
* Rule: Adding a Period of "one day" to a ZonedDateTime accounts for Daylight Saving Time (DST); it might result in a 23 or 25-hour shift depending on the zone's rules. [5, 12, 13] 

## 3. Handling Time-Zones and DST
To handle Daylight Saving Time, you must use ZonedDateTime with a specific ZoneId (e.g., ZoneId.of("Europe/Paris")). [14, 15] 

* ZonedDateTime automatically manages DST transitions.
* OffsetDateTime (e.g., +05:30) does not support DST because it represents a fixed numerical offset rather than a geographic region with changing rules. [9, 15, 16, 17] 

## Code Demo
```
import java.time.*;import java.time.temporal.ChronoUnit;
public class DateTimeExample {
    public static void main(String[] args) {
        // 1. Instant (UTC)
        Instant now = Instant.now();

        // 2. ZonedDateTime with DST Handling
        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zdt = ZonedDateTime.now(newYork);

        // 3. Duration vs Period Example
        LocalDate start = LocalDate.of(2024, 1, 1);
        LocalDate end = LocalDate.of(2025, 1, 1);
        
        Period period = Period.between(start, end); // 1 year
        Duration duration = Duration.ofHours(48);   // Exactly 48 hours

        // 4. DST Transition Demo (Clocks "Spring Forward")
        LocalDateTime springForward = LocalDateTime.of(2024, 3, 10, 1, 59);
        ZonedDateTime before = springForward.atZone(newYork);
        ZonedDateTime after = before.plusMinutes(2); 
        // Result skips from 01:59 to 03:01 because of DST!
        
        System.out.println("Before DST: " + before);
        System.out.println("After 2 mins: " + after);
    }
}
```

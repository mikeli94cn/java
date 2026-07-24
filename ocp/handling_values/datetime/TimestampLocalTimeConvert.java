import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TimestampLocalTimeConvert {
    public static void main(String[] args) {
        //1.get input timestamp
        System.out.println("please input your timestamp");
        Scanner sc = new Scanner(System.in);
        String strTimeStamp = sc.nextLine();
        boolean tsIsSecond;
        long longTimestamp;

        if (strTimeStamp.length() == 10) {
            tsIsSecond = true;
            longTimestamp = Long.parseLong(strTimeStamp);
        } else if (strTimeStamp.length() == 13) {
            tsIsSecond = false;
            longTimestamp = Long.parseLong(strTimeStamp);
        } else {
            System.out.println("input illegal, program end");
            return;
        }

        //2.print common zone
        Map<Integer, String> mostCommonZoneId = new HashMap<>();
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "UTC");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Singapore");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/New_York");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Los_Angeles");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Europe/London");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Tokyo");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Australia/Darwin");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Australia/Sydney");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Argentina/Buenos_Aires");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Africa/Cairo");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Anchorage");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Sao_Paulo");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Dhaka");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Africa/Harare");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/St_Johns");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Chicago");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Shanghai");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Africa/Addis_Ababa");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Europe/Paris");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Indiana/Indianapolis");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Kolkata");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Pacific/Apia");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Yerevan");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Pacific/Auckland");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Karachi");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Phoenix");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "America/Puerto_Rico");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Pacific/Guadalcanal");
        mostCommonZoneId.put(mostCommonZoneId.size() + 1, "Asia/Ho_Chi_Minh");

        int count = 0;
        for (Map.Entry<Integer, String> entry : mostCommonZoneId.entrySet()) {
            System.out.printf(entry.getKey() + " " + entry.getValue());
            count++;
            if (count % 3 == 0) {
                System.out.print("\n");
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();

        //3.get zone
        System.out.println("please input the zone you choose, input the number before zone, input number");
        int num = sc.nextInt();
        String myZone;
        if (num <= mostCommonZoneId.size()) {
            myZone = mostCommonZoneId.get(num);
        } else {
            System.out.println("input a number beyond the scope, program end");
            return;
        }

        //4.print zoned_time
        Instant timestamp;
        if (tsIsSecond) {
            timestamp = Instant.ofEpochSecond(longTimestamp);
        } else {
            timestamp = Instant.ofEpochMilli(longTimestamp);
        }
        ZonedDateTime zdt = ZonedDateTime.ofInstant(timestamp, ZoneId.of(myZone));

        System.out.println("the timestamp " + strTimeStamp + " correspond to UTC time is : " + timestamp);
        System.out.println("convert into the choose Zone " + myZone + " time is : " + zdt);
    }
}

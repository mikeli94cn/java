/*
 * hour angle: hour*30 + minute*0.5
 * minute angle : minute*6
 * diff angle=math.max(hour angle, minute angle)-math.min(hour angle, minute angle)
 * if diff angle>180 turn 360-diff angle
 *
 * attention: accurancy
 * */

import java.util.Formatter;


public class LeetCode1344 {
    public static void main(String[] args) {
        //int hour=12,minutes=30;
        //int hour=3,minutes=30;
        int hour=3,minutes=15;
        System.out.println(angleClock(hour, minutes));
    }


    public static double angleClock(int hour, int minutes){
        double hourAgl=hour*30+minutes*0.5;
        double minuteAgl=minutes*6;
        double diffAgl=Math.max(hourAgl, minuteAgl)-Math.min(hourAgl, minuteAgl);
        diffAgl=(diffAgl>180)?(360-diffAgl):diffAgl;
        return diffAgl;
    }
}

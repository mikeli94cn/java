package javalife.javapl.chapter1;

public class PointTest {
    public static void main(String[] args) {    
        Point lowerLeft=new Point();
        Point upperRight=new Point();
        Point middlePoint=new Point();

        lowerLeft.x=0.0;
        lowerLeft.y=0.0;

        upperRight.x=1280.0;
        upperRight.y=1024.0;

        middlePoint.x=640.0;
        middlePoint.y=512.0;

        double d=lowerLeft.distance(upperRight);
        double d1=middlePoint.distance(Point.origin);
        double d2=lowerLeft.distance(Point.origin);
        System.out.println(d);
        System.out.println(d1);
        System.out.println(d2);
    }
}

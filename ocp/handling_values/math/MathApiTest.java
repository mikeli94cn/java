package math;

/*
## key mathmetical constants
* Math.PI
* Math.E
* Math.TAU

## common mathmetical method
|category|method|desc|
|---|---|---|
|basic|abs(x)|return absolute (positive) x|
|basic|max(x,y)|return the bigger|
|basic|min(x,y)|return the smaller|
|root|sqrt(x)|return the positive square root|
|power|pow(base,exp)|base^exp|
|rounding|ceil(x)|up to nearest whole number (return double)|
|rounding|floor(x)|down to nearest whole number (return double)|
|rounding|round(x)|rounds to nearest int or long (standard .5 rounding)
|trig|sin(rad)|sin function, input radians|
|trig|cos(rad)|cos function, input radians|
|trig|toRadians(deg)|convert degrees to radians|
|random|random()|returns a double between 0.0 (inclusive) and 1.0 (exclusive)|

## overflow protection(exact methods)
* Math.addExact(int x, int y)
* Math.substractExact(int x, int y)
* Math.multiplyExact(int x, int y)
 */

public class MathApiTest {
    public static void main(String[] args) {
        double hypotenuse=Math.sqrt(Math.pow(3,2)+Math.pow(4,2));  //5.0

        int absoluteValue=Math.abs(-10);  //10


        System.out.println(Math.ceil(7.1));  //double 8.0
        System.out.println(Math.floor(7.9));  //double 7.0
        System.out.println(Math.round(7.5));  //int 7

        Double tempD=Math.random()*100;
        int randomNum=tempD.intValue()+1;  // int scope [1,100]

        double area=Math.PI*Math.pow(5,2);  // constants
    }
}

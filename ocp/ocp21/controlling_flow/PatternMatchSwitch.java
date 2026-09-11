package controlling_flow;

/*
 * what is pattern matching?
 * pattern matching enhances the switch statement, allow you to check the type of the obj, and extract its components
 * */

public class PatternMatchSwitch {
    public static void main(String[] args) {
        //pattern match with type
        Object obj = "Hello";
        //Object obj=null;
        switch (obj) {
            case null-> System.out.println("object is null");    //traditionally, passing null to a switch will throw a NullPointerException.
            //now, you can explicitly handle null as a label with the block
            case Integer i -> System.out.println("it is an integer:" + i);
            case String s -> System.out.println("it is a String:" + s);
            case Double d -> System.out.println("it is a double:" + d);
            default -> System.out.println("unknown type");
        }
        /*
         * key points:
         * type patterns: the case Integer i -> is a pattern that matches an Integer and simultaneously bind it to variable i
         * if the obj type matches the pattern: String, Integer, Double, the corresponding block is executed.
         * the default case handled any unmatched types.
         * */
        //## 2. Guarded Patterns (the when clause)
        //You can refine a case by adding a boolean condition using the when keyword. This allows you to combine type checking and value logic in a single, readable line.
        Object objMulti = "yes";
        switch (objMulti) {
            case String s when s.equalsIgnoreCase("YES") -> System.out.println("You said yes!");
            case String s when s.length() > 10 -> System.out.println("That's a long string.");
            case String s -> System.out.println("It's just a normal string: " + s);
            default -> System.out.println("Not a string");
        }



        //matching with pattern variables
        //match records and destructure objects using the pattern matching syntax.
        //this allows matching based on fields within an object (such as record components or class fields)

        //using pattern matching to match records.
        //here, the Point(int x,int y) pattern not only checks if the object is a Point, but also destructure it, binding x and y to respective components of record.
        record Point(int x, int y) {

        }

        Object objPt=new Point(3,4);

        switch (objPt){
            case Point(int x,int y)-> System.out.println("point with x="+x+" y="+y);
            default -> System.out.println("unknown type");
        }

        //switch expressions and pattern matching
        //pattern matching can be used with switch expressions, return a value.
        Object objPatMat=2.718;

        String result=switch (objPatMat){
            case null-> "null";
            case Integer i -> "it is an integer:" + i;
            case Double d -> "it is a double:" + d;
            case String s -> "it is a string:" + s;
            default -> "unknown type";
        };
        System.out.println(result);

        /* summary
        switch
        traditional switch :
            1.case break statement
            2.case multiple value
        modern switch :
            1.-> statement
            2.-> multiple value
            3.-> return value

        pattern matching
        1.type
        2.record components and class fields
        */
    }
}

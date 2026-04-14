package controlling_flow;

/*
* what is pattern matching?
* pattern matching enhances the switch statement, allow you to check the type of the obj, and extract its components
* */

public class PatternMatchSwitch {
    public static void main(String[] args) {
        //pattern match with type
        Object obj = "Hello";
        switch (obj) {
            case Integer                i -> System.out.println("it is an integer:" + i);
            case String                s -> System.out.println("it is a String:" + s);
            case Double                d -> System.out.println("it is a double:" + d);
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
        Object objMulti=42;
        switch (objMulti) {
            case String s when s.equalsIgnoreCase("YES") -> System.out.println("You said yes!");
            case String s when s.length() > 10 ->     System.out.println("That's a long string.");
            case String s ->    System.out.println("It's just a normal string: " + s);
                default -> System.out.println("Not a string");
        }

    }
}

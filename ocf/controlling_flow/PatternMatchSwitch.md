In Java 21, [Pattern Matching for switch](https://openjdk.org/jeps/441) (JEP 441) finalized a major evolution of the switch construct. It moves beyond simple equality checks to let you inspect the type and structure of an object. [1, 2, 3, 4] 
## 1. Switching on Types
Previously, switch was limited to primitives, enums, and Strings. Now, you can switch on any reference type. When a type matches, Java automatically casts the object to a local "pattern variable" for you to use immediately. [5, 6, 7, 8, 9] 
```java
static String formatter(Object obj) {
    return switch (obj) {
        case Integer i -> String.format("int %d", i);
        case Long l    -> String.format("long %d", l);
        case Double d  -> String.format("double %f", d);
        case String s  -> String.format("String %s", s);
        default        -> obj.toString();
    };
}
```
## 2. Guarded Patterns (the when clause)
You can refine a case by adding a boolean condition using the when keyword. This allows you to combine type checking and value logic in a single, readable line. [1, 5, 10, 11] 
```java
static void testString(Object obj) {
    switch (obj) {
        case String s when s.equalsIgnoreCase("YES") -> 
            System.out.println("You said yes!");
        case String s when s.length() > 10 -> 
            System.out.println("That's a long string.");
        case String s -> 
            System.out.println("It's just a normal string: " + s);
        default -> System.out.println("Not a string");
    }
}
```
## 3. Null Handling
Traditionally, passing null to a switch would throw a NullPointerException. You can now explicitly handle null as a case label within the block. [5, 9, 12, 13] 
```java
switch (obj) {
    case null     -> System.out.println("Object is null");
    case String s -> System.out.println("It's a string");
    default       -> System.out.println("Something else");
}
```
## 4. Key Rules for Modern Switch

* Exhaustiveness: If using a switch expression or pattern matching, the compiler ensures you have covered all possible values (often requiring a default case).
* Order Matters: Specific types must come before more general types. For example, case String s must come before case Object o, or the compiler will flag "unreachable code".
* Dominance: An unguarded pattern (e.g., case String s) "dominates" a guarded one (e.g., case String s when s.length() > 5). You must put the guarded case first to ensure it can actually be reached. [1, 13, 14, 15] 

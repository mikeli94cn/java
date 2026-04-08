package primtivewrapper;
/*
In Java, type conversion occurs when you assign a value of one data type to another. There are two main types: Widening (automatic) and Narrowing (manual). [1, 2, 3, 4, 5]
## 1. Widening Casting (Automatic)
This happens when you convert a smaller type to a larger type. Since there is no risk of losing data, Java handles this automatically. [6, 7, 8, 9]

* Order: byte → short → char → int → long → float → double
* Example:

int myInt = 9;double myDouble = myInt; // Automatic casting: int to double (9.0)

[10, 11, 12, 13, 14]

## 2. Narrowing Casting (Manual)
This happens when you convert a larger type to a smaller type. Because you might lose precision (e.g., dropping decimals) or overflow, you must perform this manually using parentheses. [15, 16, 17, 18, 19]

* Order: double → float → long → int → char → short → byte
* Example:

double myDouble = 9.78d;int myInt = (int) myDouble; // Manual casting: double to int (result is 9)

[20, 21, 22, 23, 24]

## 3. Numeric Promotion in Expressions
When performing math with different types, Java promotes the smaller types to match the largest type in the expression to prevent data loss. [25, 26]

* int + double = double
* byte + byte = int (Java promotes small integers to int during arithmetic for efficiency). [27, 28]

## 4. String Conversions
To move between Strings and primitives, you use the Wrapper classes we discussed earlier: [29, 30, 31]

| Conversion [32, 33, 34, 35, 36] | Method | Example |
|---|---|---|
| String to Int | Integer.parseInt() | int x = Integer.parseInt("10"); |
| String to Double | Double.parseDouble() | double d = Double.parseDouble("3.14"); |
| Int to String | String.valueOf() | String s = String.valueOf(10); |

## 5. Reference Type Casting (Objects)
In Object-Oriented programming, you can cast between parent and child classes: [37]

* Upcasting: Casting a child to a parent (Automatic).
* Downcasting: Casting a parent to a child (Manual; requires instanceof check to avoid ClassCastException). [38, 39, 40, 41]

Object obj = "Hello";      // Upcasting (Automatic)
String str = (String) obj; // Downcasting (Manual)


In Java, casting is the process of converting a value from one data type to another. Since Java is a strongly typed language, it distinguishes between conversions that are "safe" (no data loss) and those that are "risky" (potential data loss).
Casting is generally divided into two categories: Primitive Casting and Reference (Object) Casting.
------------------------------
## 1. Primitive Casting
This involves the 8 basic data types (int, double, char, etc.).
## A. Widening Casting (Implicit/Automatic)
Converting a smaller type to a larger type. Java does this automatically because there is no risk of losing information.

* Path: byte → short → char → int → long → float → double
* Example:

int myInt = 100;double myDouble = myInt; // Automatic casting: 100.0


## B. Narrowing Casting (Explicit/Manual)
Converting a larger type to a smaller type. You must place the type in parentheses (type) before the value because data (like decimals or magnitude) might be lost.

* Path: double → float → long → int → char → short → byte
* Example:

double myDouble = 9.78;int myInt = (int) myDouble; // Manual casting: 9 (decimal .78 is lost)


------------------------------
## 2. Reference Casting (Objects)
This involves classes and inheritance. You can only cast between objects that have an is-a relationship (inheritance).
## A. Upcasting (Automatic)
Casting a subtype to a supertype. This is always safe.

String text = "Hello";
Object obj = text; // Upcasting: String is an Object

## B. Downcasting (Manual)
Casting a supertype back to a subtype. This is risky because the object might not actually be of that specific subtype at runtime.

Object obj = "Hello";
String str = (String) obj; // Manual casting

------------------------------
## 3. The instanceof Operator (Safety First)
To avoid a ClassCastException during downcasting, you should always check the type first. Since Java 16, you can use Pattern Matching to check and cast in one step:

Object obj = "Java";
// Modern approach (Java 16+)if (obj instanceof String s) {
    System.out.println(s.toUpperCase()); // 's' is already cast to String here
}
// Traditional approachif (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}

## 4. Key Limitations

* Boolean: You cannot cast a boolean to any other primitive type (and vice versa).
* Incompatible Classes: You cannot cast between unrelated classes (e.g., casting a String to an Integer will cause a compile error).

In Java, type conversion and casting both refer to changing a value from one data type to another, but they differ in how they are performed and the direction of the data move. [1, 2]
## Summary of Differences

| Feature [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] | Type Conversion (Widening) | Type Casting (Narrowing) |
|---|---|---|
| Performed By | Automatic (done by the Java compiler) | Manual (done by the programmer) |
| Direction | Smaller type to a larger type | Larger type to a smaller type |
| Data Safety | Safe: No data loss occurs | Risky: May lead to data loss or truncation |
| Syntax | No extra syntax required | Requires the casting operator () |
| Common Alias | Implicit Conversion | Explicit Conversion |

## Key Differences

* Automation vs. Manual Control: Type conversion (widening) is [automatic](https://www.w3schools.com/java/java_type_casting.asp) because Java knows the destination type can safely hold the source value. Casting (narrowing) requires you to explicitly tell the compiler you are aware of the potential data loss.
* Compatible Types: Automatic conversion only works between [compatible](https://www.geeksforgeeks.org/c/difference-between-type-casting-and-type-conversion/) data types (e.g., numeric to numeric). Casting is often used to force a conversion when the compiler would otherwise throw an error, such as moving from a [double to an int](https://www.theknowledgeacademy.com/blog/type-casting-in-java/).
* Object Hierarchy: In Object-Oriented Programming, converting a subclass to a superclass is automatic (upcasting), while converting a superclass to a specific subclass requires a manual cast (downcasting). [3, 8, 10, 15, 16, 17, 18]







*/

public class ConversionCasting {
}

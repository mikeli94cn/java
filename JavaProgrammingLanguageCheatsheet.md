# Java Programming Language Cheatsheet

Java is a **high-level, object-oriented, strongly typed, garbage-collected language** that runs on the **JVM (Java Virtual Machine)**.

Basic execution model:

```
.java source code
        |
        v
     javac compiler
        |
        v
   .class bytecode
        |
        v
       JVM
        |
        v
 Native machine code
```

---

# 1. Basic Java Program Structure

```java
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Compile:

```bash
javac HelloWorld.java
```

Run:

```bash
java HelloWorld
```

---

# 2. Comments

```java
// Single line comment

/*
   Multi-line comment
*/

/**
 * JavaDoc comment
 */
```

---

# 3. Primitive Data Types

| Type      |           Size | Example        |
| --------- | -------------: | -------------- |
| `byte`    |          8-bit | `byte b=10;`   |
| `short`   |         16-bit | `short s=100;` |
| `int`     |         32-bit | `int x=1000;`  |
| `long`    |         64-bit | `long n=100L;` |
| `float`   |         32-bit | `3.14f`        |
| `double`  |         64-bit | `3.14`         |
| `char`    | 16-bit Unicode | `'A'`          |
| `boolean` |     true/false | `true`         |

Example:

```java
int age = 30;
double price = 19.99;
char grade = 'A';
boolean active = true;
```

---

# 4. Variables

Declaration:

```java
int x;
```

Initialization:

```java
int x = 10;
```

Constant:

```java
final double PI = 3.14159;
```

Type inference (Java 10+):

```java
var name = "Java";
var number = 100;
```

---

# 5. Operators

## Arithmetic

```java
+
-
*
/
%
```

Example:

```java
int result = 10 / 3;
```

---

## Comparison

```java
==
!=
>
<
>=
<=
```

---

## Logical

```java
&&
||
!
```

Example:

```java
if(age >=18 && age <=65)
{
}
```

---

## Bitwise

```java
&
|
^
~
<<
>>
>>>
```

---

## Assignment

```java
=
+=
-=
*=
/=
```

---

# 6. Control Flow

## if / else

```java
if(score >= 60)
{
    System.out.println("Pass");
}
else
{
    System.out.println("Fail");
}
```

---

## switch

Traditional:

```java
switch(day)
{
    case 1:
        System.out.println("Monday");
        break;

    default:
        System.out.println("Unknown");
}
```

Modern switch expression:

```java
String result = switch(day)
{
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Unknown";
};
```

---

## for Loop

```java
for(int i=0;i<10;i++)
{
    System.out.println(i);
}
```

---

## enhanced for loop

```java
int[] nums={1,2,3};

for(int n: nums)
{
    System.out.println(n);
}
```

---

## while

```java
while(condition)
{

}
```

---

## do-while

```java
do
{

}
while(condition);
```

---

# 7. Classes and Objects

Class:

```java
class Person {

    String name;
    int age;

    void sayHello()
    {
        System.out.println("Hello");
    }
}
```

Object:

```java
Person p = new Person();

p.name="Tom";
p.age=20;

p.sayHello();
```

---

# 8. Constructors

Default constructor:

```java
class Person {

    Person()
    {
        System.out.println("Created");
    }
}
```

Parameterized constructor:

```java
class Person {

    String name;

    Person(String name)
    {
        this.name=name;
    }
}
```

---

# 9. Access Modifiers

| Modifier    | Accessible           |
| ----------- | -------------------- |
| `public`    | everywhere           |
| `protected` | package + subclasses |
| default     | same package         |
| `private`   | same class           |

Example:

```java
public class Account {

    private double balance;

}
```

---

# 10. Static Keyword

Static belongs to the class.

```java
class Counter {

    static int count=0;

}
```

Access:

```java
Counter.count;
```

Static method:

```java
static void hello()
{
}
```

---

# 11. final Keyword

Variable:

```java
final int MAX=100;
```

Method:

```java
final void run()
{
}
```

Class:

```java
final class MathUtils
{
}
```

---

# 12. Inheritance

Parent:

```java
class Animal {

    void eat()
    {
    }
}
```

Child:

```java
class Dog extends Animal {

    void bark()
    {
    }
}
```

Usage:

```java
Dog d=new Dog();

d.eat();
d.bark();
```

---

# 13. Method Overloading

Same name, different parameters:

```java
class Calculator {

    int add(int a,int b)
    {
        return a+b;
    }

    double add(double a,double b)
    {
        return a+b;
    }
}
```

---

# 14. Method Overriding

Child changes parent behavior:

```java
class Animal {

    void sound()
    {
        System.out.println("sound");
    }
}


class Dog extends Animal {

    @Override
    void sound()
    {
        System.out.println("bark");
    }
}
```

---

# 15. Abstract Class

```java
abstract class Shape {

    abstract void draw();

}
```

Implementation:

```java
class Circle extends Shape {

    void draw()
    {
        System.out.println("circle");
    }
}
```

---

# 16. Interface

Define contract:

```java
interface Flyable {

    void fly();

}
```

Implementation:

```java
class Bird implements Flyable {

    public void fly()
    {
        System.out.println("Flying");
    }
}
```

---

# 17. Polymorphism

Parent reference:

```java
Animal a = new Dog();

a.sound();
```

Runtime chooses:

```
Dog.sound()
```

---

# 18. Encapsulation

Private fields + methods:

```java
class BankAccount {

    private double balance;


    public double getBalance()
    {
        return balance;
    }

}
```

---

# 19. Arrays

Declaration:

```java
int[] numbers;
```

Creation:

```java
numbers=new int[5];
```

Initialization:

```java
int[] a={1,2,3,4};
```

Length:

```java
a.length;
```

---

# 20. String

Strings are immutable.

```java
String name="Java";
```

Common methods:

```java
name.length();

name.charAt(0);

name.substring(1);

name.equals("Java");

name.contains("av");
```

---

# 21. StringBuilder

Mutable string:

```java
StringBuilder sb=new StringBuilder();

sb.append("Hello");

sb.append(" Java");

System.out.println(sb);
```

---

# 22. Wrapper Classes

Primitive → Object

| Primitive | Wrapper |
| --------- | ------- |
| int       | Integer |
| long      | Long    |
| double    | Double  |
| boolean   | Boolean |

Example:

```java
Integer x=100;
```

Autoboxing:

```java
Integer a=10;
int b=a;
```

---

# 23. Exception Handling

Try/catch:

```java
try
{
    int x=10/0;
}
catch(Exception e)
{
    System.out.println(e);
}
finally
{
    System.out.println("Done");
}
```

---

## Throw exception

```java
throw new RuntimeException("Error");
```

---

## Custom Exception

```java
class MyException extends Exception
{

}
```

---

# 24. Generics

Type-safe programming:

```java
List<String> names=new ArrayList<>();

names.add("Tom");
```

Generic class:

```java
class Box<T>
{
    T value;
}
```

---

# 25. Collections Framework

Package:

```java
java.util
```

---

## List

Ordered, allows duplicates.

```java
List<String> list=new ArrayList<>();

list.add("A");
list.add("B");
```

Common:

* ArrayList
* LinkedList
* Vector

---

## Set

No duplicates.

```java
Set<Integer> set=new HashSet<>();

set.add(10);
```

Common:

* HashSet
* TreeSet
* LinkedHashSet

---

## Map

Key-value pairs.

```java
Map<String,Integer> map=new HashMap<>();

map.put("Tom",20);

map.get("Tom");
```

Common:

* HashMap
* TreeMap
* LinkedHashMap

---

## Queue

```java
Queue<String> q=new LinkedList<>();

q.offer("A");

q.poll();
```

---

# 26. Lambda Expression

Java 8+

```java
(a,b)->a+b
```

Example:

```java
List<Integer> nums=List.of(1,2,3);

nums.forEach(
    n -> System.out.println(n)
);
```

---

# 27. Stream API

Functional processing:

```java
numbers.stream()
       .filter(x->x>10)
       .map(x->x*2)
       .forEach(System.out::println);
```

Common operations:

| Operation | Purpose           |
| --------- | ----------------- |
| filter    | select            |
| map       | transform         |
| reduce    | aggregate         |
| collect   | create collection |

---

# 28. Date and Time API

Java 8+

```java
LocalDate date =
    LocalDate.now();

LocalTime time =
    LocalTime.now();

LocalDateTime dt =
    LocalDateTime.now();
```

---

# 29. File I/O

Modern API:

```java
import java.nio.file.*;

Path path =
Paths.get("data.txt");

String text =
Files.readString(path);
```

---

# 30. Threads

Create thread:

```java
Thread t =
new Thread(
    () -> System.out.println("run")
);

t.start();
```

---

## ExecutorService

```java
ExecutorService pool =
Executors.newFixedThreadPool(4);

pool.submit(() -> {
    System.out.println("Task");
});

pool.shutdown();
```

---

# 31. Virtual Threads (Java 21)

```java
Thread.startVirtualThread(
    () -> {
        System.out.println("Virtual");
    }
);
```

---

# 32. JVM Memory Model

```
JVM

+----------------+
| Heap           |
| Objects        |
+----------------+

+----------------+
| Stack          |
| Method frames  |
+----------------+

+----------------+
| Metaspace      |
| Class metadata |
+----------------+
```

---

# 33. Java Modules (Java 9+)

module-info.java:

```java
module com.example.app {

    exports com.example.api;

    requires java.sql;

}
```

---

# 34. Annotations

Built-in:

```java
@Override
@Deprecated
@SuppressWarnings
```

Custom:

```java
@interface MyAnnotation
{
}
```

---

# 35. Reflection

Inspect classes at runtime:

```java
Class<?> c =
String.class;

System.out.println(
c.getName()
);
```

---

# 36. Common Java Packages

| Package           | Purpose      |
| ----------------- | ------------ |
| `java.lang`       | core classes |
| `java.util`       | collections  |
| `java.io`         | old I/O      |
| `java.nio`        | modern I/O   |
| `java.net`        | networking   |
| `java.time`       | date/time    |
| `java.sql`        | database     |
| `java.concurrent` | concurrency  |

---

# 37. Java Development Tools

| Tool       | Purpose         |
| ---------- | --------------- |
| `javac`    | compiler        |
| `java`     | launcher        |
| `jar`      | package         |
| `javadoc`  | documentation   |
| `jconsole` | monitoring      |
| `jstack`   | thread dump     |
| `jmap`     | memory analysis |

---

# 38. Java Learning Roadmap

```
1. Syntax
   |
2. OOP
   |
3. Classes / Interfaces
   |
4. Exceptions
   |
5. Generics
   |
6. Collections
   |
7. Lambda + Streams
   |
8. File I/O
   |
9. Networking
   |
10. Concurrency
   |
11. JVM Internals
   |
12. Frameworks
       |
       +-- Spring
       +-- Hibernate
       +-- Netty
```

---

# Java Philosophy in One Sentence

> **Java hides machine details behind the JVM and provides a rich object-oriented ecosystem so developers can build large, portable, maintainable systems.**

Compared with C:

| C                  | Java                               |
| ------------------ | ---------------------------------- |
| Close to hardware  | JVM abstraction                    |
| Manual memory      | Garbage collection                 |
| Structs            | Classes                            |
| Pointers           | References                         |
| Manual libraries   | Rich standard library              |
| System programming | Enterprise/application programming |

Java's biggest contributions to programming are:

* portable bytecode ("write once, run anywhere")
* mature object-oriented programming model
* automatic memory management
* large standard library
* enterprise ecosystem
* modern concurrency (especially virtual threads in Java 21+)

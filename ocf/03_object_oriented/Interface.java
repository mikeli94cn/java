Let’s walk through **interfaces in Java**—how to create/use them, what **functional interfaces** are, and how **default, static, and private methods** work.

---

# 🔹 1. What is an Interface?

👉 An **interface** defines a contract (what a class *can do*), not how it does it.

```java id="i1v9m0"
interface Flyable {
    void fly();   // abstract method (implicitly public)
}
```

---

## ✅ Implementing an Interface

```java id="b6k4xt"
class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird flying");
    }
}
```

---

## Usage (Polymorphism)

```java id="zv3x8p"
Flyable f = new Bird(); // reference type = interface
f.fly();
```

✔ Promotes loose coupling
✔ Enables polymorphism

---

# 🔹 2. Key Characteristics

* Methods are **public abstract** by default
* Fields are **public static final** (constants)

```java id="8b0m5y"
interface Config {
    int MAX = 100; // constant
}
```

---

# 🔹 3. Default Methods (Java 8)

👉 Allow interfaces to have **method implementations**

---

## Example

```java id="k4o8l3"
interface Flyable {
    void fly();

    default void land() {
        System.out.println("Landing...");
    }
}
```

---

## Usage

```java id="l6r7p2"
class Bird implements Flyable {
    public void fly() {
        System.out.println("Flying");
    }
}
```

```java id="m2n9q1"
new Bird().land(); // uses default method
```

---

## Why default methods?

* Add new functionality without breaking existing classes
* Backward compatibility

---

# 🔹 4. Static Methods in Interfaces

👉 Belong to the interface, not instances

---

## Example

```java id="s8u2c7"
interface MathUtil {
    static int add(int a, int b) {
        return a + b;
    }
}
```

---

## Usage

```java id="d4w3k8"
int result = MathUtil.add(1, 2);
```

---

## Key Point

* Cannot call via object
* Must use interface name

---

# 🔹 5. Private Methods in Interfaces (Java 9)

👉 Used to **share code inside interface**

---

## Example

```java id="h5q7x1"
interface Logger {

    default void info(String msg) {
        log("INFO", msg);
    }

    default void error(String msg) {
        log("ERROR", msg);
    }

    private void log(String level, String msg) {
        System.out.println(level + ": " + msg);
    }
}
```

---

✔ Avoid code duplication
✔ Internal helper methods

---

# 🔹 6. Functional Interfaces

👉 Interface with **exactly ONE abstract method**

---

## Example

```java id="w9p3n6"
@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}
```

---

## Using Lambda

```java id="q1r6s8"
Calculator add = (a, b) -> a + b;
System.out.println(add.compute(2, 3));
```

---

## Built-in Functional Interfaces

* Runnable → `void run()`
* Callable → returns value
* Function
* Predicate

---

# 🔹 7. Interface vs Abstract Class

| Feature              | Interface                   | Abstract Class          |
| -------------------- | --------------------------- | ----------------------- |
| Multiple inheritance | ✅ Yes                       | ❌ No                    |
| Fields               | constants only              | instance fields allowed |
| Methods              | abstract + default + static | all types               |
| Constructor          | ❌ No                        | ✅ Yes                   |

---

# 🔹 8. Multiple Interfaces (Powerful Feature)

```java id="h7k3n2"
interface A { void a(); }
interface B { void b(); }

class C implements A, B {
    public void a() {}
    public void b() {}
}
```

✔ Java supports multiple inheritance via interfaces

---

# 🔹 9. Default Method Conflict

---

## Problem

```java id="n4k7y1"
interface A {
    default void hello() { System.out.println("A"); }
}

interface B {
    default void hello() { System.out.println("B"); }
}
```

---

## Fix

```java id="p9t6x3"
class C implements A, B {
    public void hello() {
        A.super.hello(); // choose one
    }
}
```

---

# 🔹 10. Real-World Example

---

## Payment System

```java id="u5r1w7"
interface Payment {
    void pay(int amount);

    default void log() {
        System.out.println("Processing payment...");
    }
}
```

---

## Implementations

```java id="x8y2k9"
class CreditCard implements Payment {
    public void pay(int amount) {
        System.out.println("Card: " + amount);
    }
}
```

---

## Usage

```java id="z3m6q1"
Payment p = new CreditCard();
p.log();
p.pay(100);
```

---

# 🔹 11. Best Practices

---

## ✅ DO:

* Use interfaces for **abstraction**
* Use **functional interfaces** with lambdas
* Use **default methods carefully**
* Keep interfaces small (Single Responsibility)

---

## ❌ DON'T:

* Put too much logic in interfaces
* Abuse default methods
* Create “fat” interfaces

---

# 🔥 Final Mental Model

```text
Interface = contract (what to do)
Class     = implementation (how to do)
```

---

# ✅ Final Summary

* Interfaces define **behavior contracts**
* Support:

  * Abstract methods
  * Default methods (Java 8)
  * Static methods
  * Private helper methods (Java 9)
* Functional interfaces enable **lambda expressions**
* Enable **polymorphism and multiple inheritance**

---

If you want, I can next:

* Show **how interfaces are used in Spring (very important)**
* Or explain **lambda + streams deeply with functional interfaces** 🚀

Let’s bring together several **advanced OOP concepts in Java** into one clear, practical guide:
inheritance (including **abstract**, **sealed**, and **records**), method overriding, polymorphism, type differences, casting, and modern pattern matching.

---

# 🔹 1. Inheritance (Core Idea)

👉 One class **inherits** from another using `extends`

```java
class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Bark");
    }
}
```

---

## Usage

```java
Dog d = new Dog();
d.sound(); // inherited
d.bark();
```

---

# 🔹 2. Abstract Classes

👉 Cannot be instantiated; meant to be extended

```java
abstract class Animal {
    abstract void sound();  // no implementation
}
```

---

## Implementation

```java
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

---

## Key Points

* Can have abstract + concrete methods
* Enforces subclasses to implement behavior

---

# 🔹 3. Sealed Classes (Java 17+)

👉 Restrict which classes can extend a class

---

## Example

```java
sealed class Shape permits Circle, Square {}

final class Circle extends Shape {}
final class Square extends Shape {}
```

---

## Why use sealed?

* Controlled inheritance
* Safer hierarchies
* Better pattern matching support

---

# 🔹 4. Records (as OOP Types)

👉 Immutable data classes

```java
record Person(String name, int age) {}
```

---

## Use with inheritance?

* Records **cannot extend classes**
* But can implement interfaces

```java
interface Printable {
    void print();
}

record User(String name) implements Printable {
    public void print() {
        System.out.println(name);
    }
}
```

---

# 🔹 5. Method Overriding

👉 Subclass provides its own implementation

---

## Example

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

---

## Rules

* Same method signature
* Cannot reduce visibility
* Can use `@Override` (recommended)

---

# 🔹 6. Overriding Object Class Methods

All classes inherit from:

* Object

---

## Common methods to override

---

### 🔸 `toString()`

```java
class User {
    String name;

    public String toString() {
        return "User: " + name;
    }
}
```

---

### 🔸 `equals()`

```java
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;

    User u = (User) o;
    return name.equals(u.name);
}
```

---

### 🔸 `hashCode()`

```java
public int hashCode() {
    return name.hashCode();
}
```

---

# 🔹 7. Polymorphism

👉 Same reference → different behavior

---

## Example

```java
Animal a = new Dog();
a.sound();  // calls Dog's version
```

---

## Key Idea

* Method resolved at **runtime**

---

# 🔹 8. Object Type vs Reference Type

---

## Example

```java
Animal a = new Dog();
```

* **Reference type** → `Animal`
* **Object type** → `Dog`

---

## Important

```java
a.sound();  // OK (defined in Animal)
a.bark();   // ❌ not accessible
```

---

# 🔹 9. Type Casting

---

## 🔸 Upcasting (safe, automatic)

```java
Animal a = new Dog();
```

---

## 🔸 Downcasting (unsafe, explicit)

```java
Dog d = (Dog) a;
d.bark();
```

---

## ❌ Wrong casting

```java
Animal a = new Animal();
Dog d = (Dog) a; // 💥 ClassCastException
```

---

# 🔹 10. instanceof Operator

👉 Check object type before casting

---

## Example

```java
if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.bark();
}
```

---

# 🔹 11. Pattern Matching with instanceof (Modern Java)

👉 Combines check + cast

---

## Example

```java
if (a instanceof Dog d) {
    d.bark();  // no cast needed
}
```

---

✔ Cleaner
✔ Safer

---

# 🔹 12. Pattern Matching with switch (Java 21)

---

## Example

```java
static void handle(Shape s) {
    switch (s) {
        case Circle c -> System.out.println("Circle");
        case Square sq -> System.out.println("Square");
    }
}
```

---

✔ Works great with **sealed classes**
✔ Exhaustive checking

---

# 🔹 13. Putting It All Together

---

## Example

```java
sealed abstract class Shape permits Circle, Square {
    abstract double area();
}

final class Circle extends Shape {
    double radius;

    Circle(double r) { this.radius = r; }

    double area() { return Math.PI * radius * radius; }
}

final class Square extends Shape {
    double side;

    Square(double s) { this.side = s; }

    double area() { return side * side; }
}
```

---

## Polymorphism + Pattern Matching

```java
Shape s = new Circle(2);

if (s instanceof Circle c) {
    System.out.println(c.area());
}
```

---

## Switch (modern)

```java
switch (s) {
    case Circle c -> System.out.println(c.area());
    case Square sq -> System.out.println(sq.area());
}
```

---

# 🔹 14. Best Practices

---

## ✅ DO:

* Use `@Override`
* Prefer **polymorphism over casting**
* Use **sealed classes for controlled hierarchies**
* Use **pattern matching instead of manual casting**

---

## ❌ DON'T:

* Overuse downcasting
* Break encapsulation
* Use `instanceof` excessively (design smell if overused)

---

# 🔥 Final Mental Model

```text
Inheritance → reuse structure
Abstract   → enforce behavior
Sealed     → restrict hierarchy
Override   → customize behavior
Polymorphism → runtime flexibility
Casting    → access specific type
instanceof → safe type check
Pattern matching → modern, clean type handling
```

---

# ✅ Final Summary

* **Inheritance** builds relationships
* **Abstract classes** define contracts
* **Sealed classes** control extensions
* **Records** represent immutable data
* **Polymorphism** enables flexible behavior
* **Object vs reference type** affects access
* **Casting & instanceof** ensure safe usage
* **Pattern matching** simplifies modern Java code

---

If you want, I can next:

* Show **real-world Spring examples using polymorphism + sealed classes**
* Or give **interview questions with tricky casting scenarios** 🚀

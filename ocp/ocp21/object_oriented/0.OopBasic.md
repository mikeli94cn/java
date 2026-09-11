Object-Oriented Programming (OOP) is the core design philosophy of Java. It organizes code around **objects** (data + behavior) instead of just functions.

Let’s go through the key concepts clearly and practically.

---

# 🔹 1. What is OOP?

👉 OOP = modeling real-world entities as **objects**

Each object has:

* **State** (fields/variables)
* **Behavior** (methods/functions)

---

## Example

```java
class Car {
    String brand;   // state

    void drive() {  // behavior
        System.out.println("Driving...");
    }
}
```

---

# 🔹 2. The 4 Core OOP Concepts

---

# 🧱 1. Encapsulation

👉 **Hide internal data and expose controlled access**

---

## Example

```java
class User {
    private String name;  // hidden

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

## Why?

* Protect data
* Control modification
* Improve maintainability

---

# 🧬 2. Inheritance

👉 **Reuse code by extending another class**

---

## Example

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

---

## Usage

```java
Dog d = new Dog();
d.eat();   // inherited
d.bark();
```

---

## Benefits

* Code reuse
* Hierarchical design

---

# 🎭 3. Polymorphism

👉 **Same interface, different behavior**

---

## 🔹 Method Overriding (runtime polymorphism)

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

## 🔹 Method Overloading (compile-time)

```java
class MathUtil {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

---

## Why?

* Flexibility
* Extensibility

---

# 🧩 4. Abstraction

👉 **Hide implementation, show only essential features**

---

## Using abstract class

```java
abstract class Shape {
    abstract double area();
}
```

---

## Using interface

```java
interface Flyable {
    void fly();
}
```

---

## Implementation

```java
class Bird implements Flyable {
    public void fly() {
        System.out.println("Flying...");
    }
}
```

---

# 🔹 3. Class vs Object

---

## Class

👉 Blueprint

```java
class Person {
    String name;
}
```

---

## Object

👉 Instance of class

```java
Person p = new Person();
p.name = "Mike";
```

---

# 🔹 4. Additional Important Concepts

---

## 🔸 Constructor

```java
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}
```

---

## 🔸 `this` keyword

Refers to current object

---

## 🔸 `super` keyword

Access parent class

```java
super.eat();
```

---

## 🔸 Access Modifiers

| Modifier    | Access             |
| ----------- | ------------------ |
| `private`   | class only         |
| `default`   | package            |
| `protected` | package + subclass |
| `public`    | everywhere         |

---

# 🔹 5. Composition (Very Important)

👉 Prefer **has-a** over **is-a**

---

## Example

```java
class Engine {}

class Car {
    Engine engine;  // has-a
}
```

✔ More flexible than inheritance

---

# 🔹 6. Real-World Example

```java
interface Payment {
    void pay();
}

class CreditCard implements Payment {
    public void pay() {
        System.out.println("Pay with card");
    }
}

class PayPal implements Payment {
    public void pay() {
        System.out.println("Pay with PayPal");
    }
}
```

👉 Polymorphism:

```java
Payment p = new CreditCard();
p.pay();
```

---

# 🔹 7. Benefits of OOP

* Modularity
* Reusability
* Maintainability
* Scalability
* Real-world modeling

---

# 🔹 8. Common Mistakes

❌ Overusing inheritance
❌ Not using encapsulation
❌ Breaking abstraction
❌ God classes (too many responsibilities)

---

# ✅ Final Summary

* **Encapsulation** → protect data
* **Inheritance** → reuse code
* **Polymorphism** → flexible behavior
* **Abstraction** → hide complexity

👉 OOP helps you write **clean, reusable, scalable code**

---

If you want, I can next:

* Show **OOP design patterns (like Factory, Singleton)**
* Or give **interview questions with tricky examples** 🚀

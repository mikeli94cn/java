/*
Static factory methods are an important design technique in Java. They are often used instead of constructors to create objects in a more flexible and expressive way.

---

# 🔹 What is a Static Factory Method?

A **static factory method** is a `static` method that returns an instance of a class.

### Example:

```java
class User {
    private String name;

    private User(String name) {   // private constructor
        this.name = name;
    }

    public static User create(String name) {
        return new User(name);
    }
}
```

Usage:

```java
User u = User.create("Mike");
```

---

# 🔹 Why not just use constructors?

Constructors are limited:

* Must have the same name as the class
* Always create a new object
* Cannot return different subtypes
* Hard to give meaningful names

Static factory methods solve these problems.

---

# 🔹 Advantages of Static Factory Methods

## 1. ✅ Have meaningful names

```java
User u = User.createWithName("Mike");
User guest = User.createGuest();
```

Much clearer than:

```java
new User("Mike");
```

---

## 2. 🔁 Can control object creation (reuse instances)

```java
class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

---

## 3. 🔄 Can return different types

```java
interface Shape {}

class Circle implements Shape {}
class Square implements Shape {}

class ShapeFactory {
    public static Shape getShape(String type) {
        if (type.equals("circle")) return new Circle();
        else return new Square();
    }
}
```

---

## 4. 🚫 Can hide constructors

```java
class Utility {
    private Utility() {} // prevent instantiation

    public static void doSomething() {
        System.out.println("Hello");
    }
}
```

---

## 5. ⚡ Can improve performance

Example from Java standard library:

* Integer

```java
Integer a = Integer.valueOf(10);
Integer b = Integer.valueOf(10);
```

This may reuse cached objects instead of creating new ones.

---

# 🔹 Common Naming Conventions

| Method Name     | Meaning                     |
| --------------- | --------------------------- |
| `of()`          | Create from multiple values |
| `valueOf()`     | Type conversion             |
| `getInstance()` | Return existing instance    |
| `newInstance()` | Always create new object    |
| `create()`      | General creation            |
| `from()`        | Convert from another type   |

---

# 🔹 Real Examples in Java

### String

* String

```java
String s = String.valueOf(123);
```

---

### Collections

* List

```java
List<String> list = List.of("A", "B", "C");
```

---

### Optional

* Optional

```java
Optional<String> opt = Optional.of("hello");
Optional<String> empty = Optional.empty();
```

---

# 🔹 When should you use them?

Use static factory methods when:

* You want **better readability**
* You need **control over object creation**
* You want **immutability or caching**
* You want to **hide implementation details**

---

# 🔹 When NOT to use?

* If the class is very simple and constructors are enough
* If users expect `new` for clarity

---

# ✅ Final Summary

* Static factory methods = `static` methods that return objects
* More flexible than constructors
* Allow naming, caching, subtype return, and encapsulation
* Widely used in Java standard libraries

---

If you want, I can next:

* Compare **static factory vs builder pattern**
* Or show **interview-style questions about it** 👍

*/

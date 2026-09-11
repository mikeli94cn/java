
In Java, `var` is used for **local variable type inference**—it lets the compiler automatically determine the variable’s type from the assigned value.

---

# 🔹 What is `var`?

Introduced in **Java 10**, `var` is **not a keyword for dynamic typing**. Java is still **statically typed**.

👉 It just means:

> “Let the compiler infer the type for me.”

---

# 🔹 Basic Usage

```java
var name = "Mike";   // String
var age = 25;        // int
var price = 10.5;    // double
```

The compiler treats them as:

```java
String name = "Mike";
int age = 25;
double price = 10.5;
```

---

# 🔹 Where you CAN use `var`

## ✅ 1. Local variables (inside methods)

```java
public void test() {
    var message = "Hello";
}
```

---

## ✅ 2. Loop variables

```java
for (var i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

## ✅ 3. Enhanced for-loop

```java
var list = java.util.List.of("A", "B", "C");

for (var item : list) {
    System.out.println(item);
}
```

---

## ✅ 4. Try-with-resources

```java
try (var in = new java.io.FileInputStream("file.txt")) {
    // use in
}
```

---

# 🔹 Where you CANNOT use `var`

## ❌ 1. Fields (class variables)

```java
class Test {
    var x = 10;  // ❌ compile error
}
```

---

## ❌ 2. Method parameters

```java
void print(var x) { }  // ❌ not allowed
```

---

## ❌ 3. Return types

```java
var getValue() { }  // ❌ not allowed
```

---

## ❌ 4. Without initialization

```java
var x;  // ❌ must initialize
```

---

## ❌ 5. With `null` only

```java
var x = null;  // ❌ compiler can't infer type
```

---

# 🔹 Important Notes

## ⚠️ 1. Type is decided at compile time

```java
var x = 10;  // int
x = "hello"; // ❌ error
```

---

## ⚠️ 2. Not dynamic typing (unlike JavaScript)

Java still enforces strict types.

---

## ⚠️ 3. Readability matters

Bad:

```java
var x = getData(); // what is x?
```

Better:

```java
List<String> x = getData();
```

---

# 🔹 When to use `var`

## ✅ Good use cases

* When type is obvious:

```java
var list = new java.util.ArrayList<String>();
```

* Long or complex types:

```java
var map = new java.util.HashMap<String, java.util.List<Integer>>();
```

---

## ❌ Avoid when

* It reduces readability
* Type is unclear
* Public API (always use explicit types)

---

# 🔹 Real Example

```java
public static void main(String[] args) {
    var numbers = java.util.List.of(1, 2, 3);

    for (var n : numbers) {
        System.out.println(n);
    }
}
```

---

# 🔹 Summary

* `var` = **type inference for local variables**
* Introduced in **Java 10**
* Still **statically typed**
* Improves readability (if used correctly)
* Should be used **carefully, not everywhere**

---

If you want, I can also:

* Compare `var` with **C++ `auto`**
* Or give **best practices + interview traps** 👍


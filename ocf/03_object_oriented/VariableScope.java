Let’s connect several important OOP concepts into one coherent picture:
**variable scopes → encapsulation → immutability → `var` (type inference)**

---

# 🔹 1. Variable Scope in Java

👉 **Scope = where a variable is visible and usable**

---

## 🧍 1. Local Variables (method scope)

```java id="u9i4gq"
void method() {
    int x = 10;   // local variable
}
```

✔ Exists only inside the method
✔ Stored in stack
✔ Must be initialized before use

---

## 🧱 2. Instance Variables (object scope)

```java id="8w0g2v"
class User {
    String name;   // instance variable
}
```

✔ Belong to each object
✔ Stored in heap

---

## 🏢 3. Static Variables (class scope)

```java id="y4b64k"
class User {
    static int count;  // static variable
}
```

✔ Shared across all objects
✔ One copy per class

---

## 🔥 Scope Summary

| Type     | Scope        | Lifetime           |
| -------- | ------------ | ------------------ |
| Local    | Method/block | Until method ends  |
| Instance | Object       | Until object is GC |
| Static   | Class        | Until program ends |

---

# 🔹 2. Encapsulation

👉 **Hide internal data, expose controlled access**

---

## ❌ Bad Design (no encapsulation)

```java id="w7u9l0"
class User {
    public String name;  // directly accessible
}
```

---

## ✅ Good Design (encapsulation)

```java id="z8w6r3"
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

## 🎯 Benefits

* Protect data integrity
* Control modifications
* Improve maintainability

---

## 🔒 Validation Example

```java id="gntq54"
public void setAge(int age) {
    if (age < 0) throw new IllegalArgumentException();
    this.age = age;
}
```

---

# 🔹 3. Immutable Objects

👉 Object whose **state cannot change after creation**

---

## ✅ Example (Immutable Class)

```java id="d3sf6c"
final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

---

## 🔥 Key Rules

1. Class is `final`
2. Fields are `private final`
3. No setters
4. Defensive copies (for mutable fields)

---

## 🧠 Why Immutable?

* Thread-safe (no synchronization needed)
* Predictable behavior
* Safe to share

---

## ⚠️ Defensive Copy Example

```java id="2nqkqf"
class Person {
    private final List<String> items;

    public Person(List<String> items) {
        this.items = new ArrayList<>(items); // copy
    }

    public List<String> getItems() {
        return new ArrayList<>(items); // return copy
    }
}
```

---

## 💡 Built-in Example

* String is immutable

---

# 🔹 4. Using `var` (Local Variable Type Inference)

👉 Introduced in **Java 10**

---

## ✅ Example

```java id="scs47m"
var name = "Mike";   // String
var age = 25;        // int
```

---

## ⚠️ Important Rules

---

## ❌ Cannot use without initialization

```java id="7jnnmp"
var x;  // ❌ error
```

---

## ❌ Cannot use for fields

```java id="g0jfnk"
class Test {
    var x = 10; // ❌
}
```

---

## ❌ Cannot use with null

```java id="2h9jrb"
var x = null; // ❌
```

---

## 🧠 Type is still static

```java id="eq4rqa"
var x = 10;   // int
x = "hello";  // ❌ error
```

---

# 🔹 5. Combining Concepts (Real Example)

---

## Encapsulation + Immutability + var

```java id="q1ptfz"
final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

---

## Usage

```java id="9e4t0b"
var user = new User("Mike");  // type inferred

System.out.println(user.getName());
```

---

# 🔹 6. Scope + var Example

```java id="jqzmb5"
public void process() {
    var count = 10;  // local variable

    if (count > 5) {
        var message = "Large"; // block scope
        System.out.println(message);
    }

    // message NOT visible here
}
```

---

# 🔹 7. Best Practices

---

## ✅ DO:

* Use `private` fields (encapsulation)
* Prefer immutable objects
* Use `var` when type is obvious
* Keep variable scope as small as possible

---

## ❌ DON'T:

* Expose fields directly
* Use `var` when it hurts readability
* Create mutable shared state
* Use large variable scopes

---

# 🔥 Final Mental Model

```text
Scope        → where variable exists
Encapsulation → who can access it
Immutability → whether it can change
var          → how type is declared
```

---

# ✅ Final Summary

* **Scope**

  * Local / Instance / Static define visibility & lifetime
* **Encapsulation**

  * Use `private` + getters/setters
* **Immutability**

  * `final` fields + no setters = thread-safe objects
* **var**

  * Simplifies local variable declarations

---

If you want, I can next:

* Show **real bugs caused by bad encapsulation / mutability**
* Or give **interview-level tricky questions on scope & var** 🚀

Let’s walk through this in a **clear, practical, OOP-focused way**: how to declare/instantiate objects (including nested classes) and how the **object lifecycle** works in Java.

---

# 🔹 1. Declaring and Instantiating Objects

## ✅ Basic Class and Object

```java
class Person {
    String name;

    void sayHello() {
        System.out.println("Hello, " + name);
    }
}
```

### Create object

```java
Person p = new Person();  // declaration + instantiation
p.name = "Mike";
p.sayHello();
```

---

## 🧠 What happens internally?

```java
Person p = new Person();
```

Steps:

1. Memory allocated on **heap**
2. Constructor runs
3. Reference (`p`) stored on **stack**
4. `p` points to the object

---

# 🔹 2. Nested Class Objects

Java supports **nested classes** (class inside class).

---

## 🔸 2.1 Static Nested Class

```java
class Outer {
    static class Inner {
        void show() {
            System.out.println("Static nested class");
        }
    }
}
```

### Instantiate

```java
Outer.Inner obj = new Outer.Inner();
obj.show();
```

✔ No need for outer instance

---

## 🔸 2.2 Non-Static Inner Class

```java
class Outer {
    class Inner {
        void show() {
            System.out.println("Inner class");
        }
    }
}
```

### Instantiate

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.show();
```

✔ Requires outer object

---

## 🔸 2.3 Anonymous Class

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Anonymous class");
    }
};
```

✔ Used for quick implementations

---

## 🔸 2.4 Local Inner Class

```java
void method() {
    class Local {
        void display() {
            System.out.println("Local class");
        }
    }
    new Local().display();
}
```

---

# 🔹 3. Object Lifecycle in Java

---

# 🧬 1. Creation

```java
Person p = new Person();
```

* Object created in **heap memory**
* Constructor initializes it

---

# 🔁 2. Using the Object

```java
p.sayHello();
```

* Object is **alive and reachable**

---

# 🔄 3. Reassigning References

```java
Person p1 = new Person();
Person p2 = new Person();

p1 = p2;
```

👉 Now:

* `p1` and `p2` point to SAME object
* Old object of `p1` becomes **unreachable**

---

## Visualization

Before:

```
p1 → Object A
p2 → Object B
```

After:

```
p1 → Object B
p2 → Object B
Object A → ❌ unreachable
```

---

# 🗑️ 4. Garbage Collection (GC)

👉 Java automatically deletes **unreachable objects**

---

## Example

```java
Person p = new Person();
p = null;  // object becomes unreachable
```

✔ Eligible for GC

---

## When does GC run?

* Automatically (JVM decides)
* Not guaranteed immediately

---

## ❗ Important Notes

* You **cannot force GC**
* `System.gc()` is just a suggestion
* Objects are collected when:

  * No references exist

---

# 🔹 4. Common Lifecycle Scenarios

---

## ✅ Case 1: Multiple references

```java
Person p1 = new Person();
Person p2 = p1;
```

✔ Object NOT eligible for GC (still referenced)

---

## ❌ Case 2: Lost reference

```java
Person p = new Person();
p = new Person();
```

👉 First object becomes garbage

---

## 🔁 Case 3: Method scope

```java
void test() {
    Person p = new Person();
}
```

👉 After method ends → eligible for GC

---

# 🔹 5. finalize() (Deprecated Concept)

```java
protected void finalize() {
    System.out.println("Cleaning up");
}
```

⚠️ Deprecated / NOT recommended
👉 Use:

* Try-with-resources
* AutoCloseable

---

# 🔹 6. Best Practices

---

## ✅ DO:

* Keep references clear
* Use local variables (auto GC)
* Prefer immutability

---

## ❌ DON'T:

* Rely on GC timing
* Use `finalize()`
* Keep unused references

---

# 🔹 7. Memory Model (Simple View)

```
Stack (references)        Heap (objects)
------------------        ----------------
p  ---------------------> Person Object
```

---

# 🔹 8. Real Example Combining Everything

```java
class Outer {
    static class Inner {
        void show() {
            System.out.println("Hello");
        }
    }
}

public class Demo {
    public static void main(String[] args) {

        Outer.Inner obj = new Outer.Inner(); // create
        obj.show();                          // use

        obj = null;                          // eligible for GC
    }
}
```

---

# ✅ Final Summary

* **Object creation** → `new` allocates memory in heap
* **Reference** → stored in stack
* **Nested classes**:

  * Static → no outer instance
  * Inner → requires outer instance
* **Lifecycle**:

  1. Created
  2. Used
  3. Reference reassigned/lost
  4. Garbage collected
* **GC** → automatic, based on reachability

---

If you want, I can next:

* Show **JVM memory model deeper (heap, stack, metaspace)**
* Or give **tricky interview questions about object lifecycle** 🚀

Let’s focus on **method overloading in Java**, including **var-args methods**, with clear rules, examples, and common pitfalls.

---

# 🔹 1. What is Method Overloading?

👉 **Same method name, different parameter list**

Java decides which method to call at **compile time** (compile-time polymorphism).

---

## ✅ Basic Example

```java id="8ep3hx"
class MathUtil {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

## Usage

```java id="68ph2x"
MathUtil m = new MathUtil();

m.add(1, 2);       // calls int version
m.add(1.5, 2.5);   // calls double version
```

---

# 🔹 2. Rules for Overloading

---

## ✅ Must differ by:

* Number of parameters
* OR type of parameters
* OR order of parameters

---

## ❌ Cannot differ only by return type

```java id="44y0tz"
int add(int a, int b) { return 0; }
double add(int a, int b) { return 0; } // ❌ compile error
```

---

# 🔹 3. Examples of Overloading

---

## 🔸 Different number of parameters

```java id="5q5n6y"
void print(int a) {}
void print(int a, int b) {}
```

---

## 🔸 Different types

```java id="wsq4d1"
void print(int a) {}
void print(String s) {}
```

---

## 🔸 Different order

```java id="9cbd7k"
void print(int a, String b) {}
void print(String b, int a) {}
```

---

# 🔹 4. Var-args (Variable Arguments)

👉 Allows passing **any number of arguments**

---

## Syntax

```java id="9d53g1"
void method(int... nums) {}
```

---

## Example

```java id="ddpq2h"
class SumUtil {

    int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }
}
```

---

## Usage

```java id="9j2y6v"
SumUtil s = new SumUtil();

s.sum();             // 0
s.sum(1);            // 1
s.sum(1, 2, 3);      // 6
```

---

# 🔹 5. How Var-args Works Internally

```java id="y7b68w"
sum(1, 2, 3);
```

👉 becomes:

```java id="y0d9dz"
sum(new int[]{1, 2, 3});
```

---

# 🔹 6. Overloading with Var-args

---

## Example

```java id="5t6hhw"
void print(int a) {
    System.out.println("Single int");
}

void print(int... nums) {
    System.out.println("Varargs");
}
```

---

## Usage

```java id="c2r6r1"
print(10);       // calls single int (more specific)
print(1, 2, 3);  // calls varargs
```

---

## 🔥 Rule:

👉 Java chooses **most specific method**

---

# 🔹 7. Important Rules for Var-args

---

## ✅ Only one var-arg parameter allowed

```java id="z6td3y"
void test(int... a) {}        // OK
void test(int... a, int... b) {} // ❌
```

---

## ✅ Must be last parameter

```java id="6e66u7"
void test(int a, int... b) {} // OK
void test(int... a, int b) {} // ❌
```

---

# 🔹 8. Overloading Ambiguity (Common Pitfall)

---

## ❌ Ambiguous call

```java id="7klxnl"
void test(int... a) {}
void test(int a, int... b) {}

test(1); // ❌ ambiguous
```

---

## ❗ Why?

* Both methods match
* Compiler cannot decide

---

# 🔹 9. Var-args vs Array

---

## Equivalent

```java id="x9nt6k"
void test(int[] arr) {}
void test(int... arr) {}
```

---

## Difference

* Var-args is more flexible:

```java id="8v3gls"
test(1, 2, 3);        // works
test(new int[]{1,2}); // also works
```

---

# 🔹 10. Real-World Example

---

## Logging utility

```java id="f6y9qb"
class Logger {

    void log(String... messages) {
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}
```

---

## Usage

```java id="9l8hgs"
logger.log("Start");
logger.log("User", "logged in", "successfully");
```

---

# 🔹 11. Best Practices

---

## ✅ DO:

* Use var-args for flexible APIs
* Keep overloads clear and unambiguous
* Prefer specific methods over generic ones

---

## ❌ DON'T:

* Create confusing overload combinations
* Mix too many var-arg overloads
* Rely on ambiguous method resolution

---

# 🔥 Key Concept: Method Resolution Order

Java chooses method based on:

1. Exact match
2. Primitive widening (`int → long`)
3. Autoboxing (`int → Integer`)
4. Var-args

---

## Example

```java id="y7q03f"
void test(int x) {}
void test(long x) {}
void test(Integer x) {}
void test(int... x) {}
```

```java id="y9i0kt"
test(10); // chooses int (best match)
```

---

# ✅ Final Summary

* **Overloading** = same method name, different parameters
* **Var-args** = flexible number of arguments
* Must be:

  * last parameter
  * only one
* Java picks **most specific method**
* Avoid ambiguity

---

If you want, I can next:

* Show **method overriding vs overloading (very important difference)**
* Or give **tricky interview questions on method resolution** 🚀

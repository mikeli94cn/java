Let’s go through these **core Java annotations** in a practical, developer-focused way. These are all from `java.lang`, so you use them **without importing** in most cases.

---

# 1. What Are Annotations?

Annotations are **metadata**—they don’t directly change logic, but they:

* Help the compiler catch errors
* Improve readability
* Influence tools/frameworks

---

# 2. `@Override`

### ✅ Purpose

Indicates that a method **overrides a superclass method**.

---

### Example

```java
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}
```

---

### ❗ Why it matters

```java
class Dog extends Animal {
    @Override
    void speek() {  // typo!
        System.out.println("Dog barks");
    }
}
```

👉 Compile error:

* Method does NOT override → catches bug early

---

### ✅ Best Practice

Always use `@Override` when overriding methods.

---

# 3. `@FunctionalInterface`

### ✅ Purpose

Marks an interface as a **functional interface** (used with lambdas).

---

### Example

```java
@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}
```

---

### ❗ Compile-time enforcement

```java
@FunctionalInterface
interface Bad {
    void a();
    void b(); // ❌ ERROR: more than one abstract method
}
```

---

### With Lambda

```java
Calculator add = (a, b) -> a + b;
```

---

### ✅ Why use it?

* Prevent accidental extra methods
* Improves readability
* Makes intent clear

---

# 4. `@Deprecated`

### ✅ Purpose

Marks something as **obsolete** (should not be used).

---

### Example

```java
@Deprecated
void oldMethod() {
    System.out.println("Old method");
}
```

---

### Usage warning

```java
oldMethod(); // ⚠ compiler warning
```

---

### Better version (since Java 9)

```java
@Deprecated(since = "1.5", forRemoval = true)
void oldMethod() {}
```

---

### ✅ When to use

* Replacing APIs
* Phasing out old methods

---

# 5. `@SuppressWarnings`

### ✅ Purpose

Tells compiler to **ignore specific warnings**

---

### Example

```java
@SuppressWarnings("unchecked")
List list = new ArrayList();
```

---

### Common values

| Warning       | Meaning          |
| ------------- | ---------------- |
| "unchecked"   | raw types        |
| "deprecation" | deprecated usage |
| "unused"      | unused variables |
| "rawtypes"    | raw types        |

---

### Example

```java
@SuppressWarnings({"unchecked", "rawtypes"})
List list = new ArrayList();
```

---

### ❗ Important

Use carefully:

* Don’t hide real problems

---

# 6. `@SafeVarargs`

### ✅ Purpose

Suppresses warnings for **unsafe varargs usage with generics**

---

### Problem Example

```java
static <T> void printAll(T... items) {
    for (T item : items) {
        System.out.println(item);
    }
}
```

⚠ Compiler warning:

* "Possible heap pollution from parameterized vararg type"

---

### Solution

```java
@SafeVarargs
static <T> void printAll(T... items) {
    for (T item : items) {
        System.out.println(item);
    }
}
```

---

### ❗ Restrictions

You can only use `@SafeVarargs` on:

* `static` methods
* `final` methods
* `private` methods (Java 9+)

---

### Why needed?

Because Java generics use:

> **Type erasure**

This can cause runtime issues with varargs + generics.

---

# 7. Putting It All Together

```java
@FunctionalInterface
interface Processor<T> {
    T process(T input);
}

class Demo {

    @Deprecated(since = "1.0", forRemoval = true)
    static void oldMethod() {}

    @SafeVarargs
    static <T> void printAll(T... items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Processor<String> upper = s -> s.toUpperCase();

        @SuppressWarnings("deprecation")
        String result = upper.process("hello");

        System.out.println(result);

        printAll("A", "B", "C");
    }
}
```

---

# 8. Key Differences (Quick Table)

| Annotation             | Purpose                        | Compile-Time Effect     |
| ---------------------- | ------------------------------ | ----------------------- |
| `@Override`            | Ensure method override         | Error if not overriding |
| `@FunctionalInterface` | Enforce single abstract method | Error if violated       |
| `@Deprecated`          | Mark old API                   | Warning when used       |
| `@SuppressWarnings`    | Ignore warnings                | Suppresses warnings     |
| `@SafeVarargs`         | Safe generic varargs           | Removes varargs warning |

---

# 9. Mental Model

* `@Override` → **correctness**
* `@FunctionalInterface` → **lambda safety**
* `@Deprecated` → **API lifecycle**
* `@SuppressWarnings` → **compiler control**
* `@SafeVarargs` → **generic safety**

---

# 10. Interview Insights

### ❓ Why use `@Override`?

→ Prevent subtle bugs (method signature mismatch)

---

### ❓ Difference: `@SuppressWarnings` vs `@SafeVarargs`

* `@SuppressWarnings` → general suppression
* `@SafeVarargs` → specifically for **generic varargs safety**

---

### ❓ Can `@FunctionalInterface` have default methods?

✅ Yes

```java
@FunctionalInterface
interface A {
    void run();

    default void log() {}
}
```

---

If you want, I can go further into:

* Custom annotations (very important in Spring)
* Annotation processing
* How annotations work internally (reflection & bytecode)

Just tell me 👍

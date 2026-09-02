In Java, an **`enum` (enumeration)** is a special type used to define a fixed set of constants.

---

# 🧠 Basic enum declaration

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

👉 This creates a type `Day` with predefined values.

---

# ✅ Using the enum

```java
public class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        System.out.println(today);
    }
}
```

---

# ⚙️ Enum inside a class

```java
class Main {
    enum Level {
        LOW, MEDIUM, HIGH
    }

    public static void main(String[] args) {
        Level l = Level.HIGH;
        System.out.println(l);
    }
}
```

---

# 🔁 Using enum in switch

```java
Day day = Day.FRIDAY;

switch (day) {
    case MONDAY:
        System.out.println("Start of week");
        break;
    case FRIDAY:
        System.out.println("Almost weekend!");
        break;
}
```

---

# 🚀 Enum with fields and constructor (advanced)

Enums can behave like classes:

```java
enum Level {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

---

# 📍 Use it:

```java
System.out.println(Level.HIGH.getValue());  // 3
```

---

# ✨ Enum with methods

```java
enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    };

    public abstract int apply(int a, int b);
}
```

---

# 🔑 Key points

* Enum = fixed set of constants
* Type-safe (better than using `int` or `String`)
* Can have:

  * fields
  * constructors
  * methods

---

# 🧩 Simple idea

👉 Enum = “a **group of named constant values**”

---




In Java, you **don’t compare an enum directly with a string**. Instead, you convert one side so both are the same type.

Here are the correct ways 👇

---

# ✅ 1. Convert enum → String (most common)

Use `.name()`:

```java
enum Day {
    MONDAY, TUESDAY
}

String input = "MONDAY";

if (Day.MONDAY.name().equals(input)) {
    System.out.println("Match");
}
```

👉 `.name()` returns `"MONDAY"`

---

# ✅ 2. Convert String → enum (better approach)

Use `valueOf()`:

```java
String input = "MONDAY";

Day day = Day.valueOf(input);

if (day == Day.MONDAY) {
    System.out.println("Match");
}
```

👉 This is **preferred** because:

* Type-safe
* Cleaner comparisons (`==`)

---

# ⚠️ Handle invalid strings

`valueOf()` throws an error if the string is invalid:

```java
try {
    Day day = Day.valueOf(input);
} catch (IllegalArgumentException e) {
    System.out.println("Invalid value");
}
```

---

# ✅ 3. Case-insensitive comparison

```java
Day day = Day.valueOf(input.toUpperCase());
```

---

# 🚫 Wrong way (don’t do this)

```java
if (Day.MONDAY == "MONDAY")  // ❌ invalid
```

👉 Enum ≠ String

---

# 🧠 Best practice

✔ Convert **String → enum**, then compare enums:

```java
if (Day.valueOf(input.toUpperCase()) == Day.MONDAY) {
    // good
}
```

---

# 🔑 Summary

| Method           | Use                  |
| ---------------- | -------------------- |
| `enum.name()`    | enum → string        |
| `Enum.valueOf()` | string → enum (best) |
| `==`             | compare enums        |

---



In Java, an **`enum` (enumeration)** is a special type used to represent a **fixed set of constant values** in a clean and type-safe way.

---

# 🧠 What is an enum?

An enum defines a group of named constants:

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}
```

👉 Here, `Day` can only be one of those values—nothing else.

---

# ✅ Why use enum?

Instead of using strings or integers like:

```java
String day = "MONDAY";   // error-prone
```

You use:

```java
Day day = Day.MONDAY;   // safe and clear
```

✔ Prevents invalid values
✔ Improves readability
✔ Type-safe

---

# 📦 Basic usage

```java
public class Main {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;

        System.out.println(today);
    }
}
```

---

# 🔁 Enum in switch

```java
switch (today) {
    case MONDAY:
        System.out.println("Start of week");
        break;
    case FRIDAY:
        System.out.println("Weekend soon!");
        break;
}
```

---

# ⚙️ Enum is more than constants

In Java, enums are actually **special classes**.

---

## 🧩 Enum with fields and constructor

```java
enum Level {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

---

## 📍 Use it:

```java
System.out.println(Level.HIGH.getValue());  // 3
```

---

# 🚀 Enum with methods

```java
enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    };

    public abstract int apply(int a, int b);
}
```

---

# 🔍 Useful built-in methods

| Method      | Description             |
| ----------- | ----------------------- |
| `values()`  | returns all enum values |
| `valueOf()` | convert string → enum   |
| `name()`    | get name as string      |
| `ordinal()` | position (0, 1, 2…)     |

Example:

```java
for (Day d : Day.values()) {
    System.out.println(d);
}
```

---

# ⚠️ Important notes

* Enum constants are **implicitly `public static final`**
* You **cannot create new enum values at runtime**
* Constructors are **private by default**

---

# 🧩 Simple mental model

👉 Enum = **a fixed list of named constants with optional behavior**

---

# 🔑 Summary

* Used to represent **limited set of values**
* Safer than strings or integers
* Can include fields, methods, and logic
* Acts like a **class with predefined instances**




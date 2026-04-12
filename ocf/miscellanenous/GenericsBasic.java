Generics are one of the most important features in Java—they give you **type safety, reusability, and cleaner APIs**. Let’s build a solid mental model and then go deep into **wildcards**, which is where most confusion happens.

---

# 1. What Are Generics?

Generics allow you to write **type-parameterized code**.

### Without generics (unsafe)

```java
List list = new ArrayList();
list.add("Hello");
list.add(123); // allowed 😱

String s = (String) list.get(1); // runtime error
```

---

### With generics (safe)

```java
List<String> list = new ArrayList<>();
list.add("Hello");
// list.add(123); ❌ compile-time error

String s = list.get(0);
```

---

# 2. Generic Classes

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

Usage:

```java
Box<String> box = new Box<>();
box.set("Hello");

String s = box.get();
```

---

# 3. Generic Methods

```java
public class Util {
    public static <T> void print(T value) {
        System.out.println(value);
    }
}
```

Usage:

```java
Util.print("Hello");
Util.print(123);
```

---

# 4. Multiple Type Parameters

```java
class Pair<K, V> {
    K key;
    V value;
}
```

---

# 5. Bounded Type Parameters

### Upper bound (`extends`)

```java
class NumberBox<T extends Number> {
    T value;
}
```

👉 Only allows:

* Integer
* Double
* etc.

---

# 6. Wildcards (Core Topic)

Wildcards are used when **you don’t know the exact type**.

---

## 6.1 Unbounded Wildcard `<?>`

```java
List<?> list;
```

* Can hold any type
* But you **can’t add elements** (except `null`)

---

## 6.2 Upper Bounded Wildcard `<? extends T>`

```java
List<? extends Number> list;
```

👉 Means:

* List of **Number OR subclasses**
* Could be:

  * `List<Integer>`
  * `List<Double>`

---

### Read-only behavior

```java
void printNumbers(List<? extends Number> list) {
    for (Number n : list) {
        System.out.println(n);
    }

    // list.add(10); ❌ NOT allowed
}
```

---

## 6.3 Lower Bounded Wildcard `<? super T>`

```java
List<? super Integer> list;
```

👉 Means:

* List of **Integer OR its parents**
* Could be:

  * `List<Integer>`
  * `List<Number>`
  * `List<Object>`

---

### Write-friendly behavior

```java
void addNumbers(List<? super Integer> list) {
    list.add(10); // ✅ allowed
}
```

---

# 7. PECS Principle (VERY IMPORTANT)

> **PECS = Producer Extends, Consumer Super**

| Case           | Use       |
| -------------- | --------- |
| Producing data | `extends` |
| Consuming data | `super`   |

---

### Example

```java
// Producer (read)
void read(List<? extends Number> list) {}

// Consumer (write)
void write(List<? super Integer> list) {}
```

---

# 8. Why Not Just Use `<T>`?

Compare:

```java
void method(List<Number> list)
```

❌ Cannot accept:

* `List<Integer>`
* `List<Double>`

---

But:

```java
void method(List<? extends Number> list)
```

✅ Accepts all subclasses

---

# 9. Important Limitation (Invariance)

```java
List<Integer> ints = new ArrayList<>();
List<Number> nums = ints; // ❌ NOT allowed
```

👉 Generics are **invariant** in Java.

---

# 10. Type Erasure (CRITICAL CONCEPT)

At runtime:

```java
List<String>
List<Integer>
```

👉 Both become:

```java
List
```

This is called:

> **Type Erasure**

---

### Consequences

❌ Cannot do:

```java
if (list instanceof List<String>) {} // ERROR
```

❌ Cannot create:

```java
new T(); // ERROR
```

---

# 11. Generic Arrays Problem

```java
T[] arr = new T[10]; // ❌ not allowed
```

👉 Because arrays + generics = unsafe

---

# 12. Real Example (Very Important)

```java
import java.util.*;

public class Demo {

    public static void printAll(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
    }

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 2, 3);
        List<Number> nums = new ArrayList<>();

        printAll(ints);  // ✅
        addIntegers(nums); // ✅
    }
}
```

---

# 13. Wildcard vs Type Parameter

### Wildcard

```java
void process(List<?> list)
```

### Type parameter

```java
<T> void process(List<T> list)
```

👉 Use:

* `<?>` → when type is irrelevant
* `<T>` → when type is reused

---

# 14. Common Interview Questions

---

### ❓ Difference: `extends` vs `super`

| Feature   | `extends`  | `super`      |
| --------- | ---------- | ------------ |
| Direction | subclasses | superclasses |
| Read      | ✅          | limited      |
| Write     | ❌          | ✅            |

---

### ❓ Why can’t we add to `List<? extends T>`?

Because actual type is unknown:

```java
List<? extends Number> list;
```

Could be:

* `List<Integer>`
* `List<Double>`

👉 Adding is unsafe.

---

### ❓ Why generics?

* Compile-time safety
* No casting
* Better APIs

---

# 15. Mental Model (Final)

| Concept         | Meaning               |
| --------------- | --------------------- |
| `<T>`           | exact type            |
| `<?>`           | unknown type          |
| `<? extends T>` | read-only (producer)  |
| `<? super T>`   | write-only (consumer) |

---

# 16. One-Line Intuition

* `extends` → **I will read from it**
* `super` → **I will write to it**

---

# If you want next level

I can go deeper into:

* Generic type inference (compiler behavior)
* Writing your own generic collections
* Advanced bounds (`<T extends Comparable<T>>`)
* How generics are used in Streams API

Just tell me 👍

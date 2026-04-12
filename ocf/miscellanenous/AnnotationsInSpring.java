Custom annotations are where Java really starts to feel powerful—especially if you’ve seen frameworks like Spring. Let’s build a **deep but practical understanding**.

---

# 1. What is a Custom Annotation?

A **custom annotation** is a way to define your own metadata:

```java
@interface MyAnnotation {
}
```

👉 You can then use it like:

```java
@MyAnnotation
class Test {}
```

---

# 2. Basic Structure

```java
public @interface MyAnnotation {
    String value();
}
```

Usage:

```java
@MyAnnotation("hello")
class Demo {}
```

---

# 3. Annotation Elements (Attributes)

Annotations can have **fields (called elements)**:

```java
public @interface Author {
    String name();
    int year();
}
```

Usage:

```java
@Author(name = "Mike", year = 2026)
class Book {}
```

---

### Default Values

```java
public @interface Version {
    int number() default 1;
}
```

Usage:

```java
@Version
class App {}
```

---

# 4. Meta-Annotations (VERY IMPORTANT)

These define how your annotation behaves.

---

## 4.1 `@Target`

Where the annotation can be used:

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface LogExecutionTime {}
```

Common targets:

| Type      | Meaning         |
| --------- | --------------- |
| TYPE      | class/interface |
| METHOD    | method          |
| FIELD     | field           |
| PARAMETER | parameter       |

---

## 4.2 `@Retention`

When annotation is available:

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {}
```

| Policy  | Meaning                  |
| ------- | ------------------------ |
| SOURCE  | removed at compile       |
| CLASS   | kept in bytecode         |
| RUNTIME | available via reflection |

👉 Most frameworks use **RUNTIME**

---

## 4.3 `@Documented`

Include annotation in Javadoc:

```java
@Documented
public @interface MyAnnotation {}
```

---

## 4.4 `@Inherited`

Allows subclasses to inherit annotation:

```java
@Inherited
public @interface Role {}
```

---

# 5. Real Example (Important)

## Step 1: Define Annotation

```java
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
```

---

## Step 2: Use Annotation

```java
class Service {

    @Log("Executing task")
    public void doWork() {
        System.out.println("Working...");
    }
}
```

---

## Step 3: Process Annotation (Reflection)

```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        Service service = new Service();

        Method method = service.getClass().getMethod("doWork");

        if (method.isAnnotationPresent(Log.class)) {
            Log log = method.getAnnotation(Log.class);
            System.out.println("LOG: " + log.value());
        }

        method.invoke(service);
    }
}
```

---

### Output

```text
LOG: Executing task
Working...
```

---

# 6. Key Idea: Annotations + Reflection

Annotations by themselves do nothing.

👉 They become powerful when combined with:

* Reflection
* Frameworks
* Annotation processors

---

# 7. Repeatable Annotations (Advanced)

```java
import java.lang.annotation.*;

@Repeatable(Tags.class)
@interface Tag {
    String value();
}

@interface Tags {
    Tag[] value();
}
```

Usage:

```java
@Tag("fast")
@Tag("stable")
class App {}
```

---

# 8. Built-in Example You Already Know

```java
@Override
public String toString() {
    return "Demo";
}
```

👉 The compiler processes `@Override`

---

# 9. Real-World Usage (Frameworks)

Frameworks like:

* Spring Framework
* Hibernate

Use annotations like:

```java
@Component
@Service
@Autowired
@Entity
```

👉 These are just **custom annotations + reflection**

---

# 10. Practical Mini Example (Validation)

### Define annotation

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {}
```

---

### Use it

```java
class User {
    @NotNull
    String name;
}
```

---

### Validate

```java
import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (value == null) {
                    throw new RuntimeException(field.getName() + " cannot be null");
                }
            }
        }
    }
}
```

---

# 11. Best Practices

### ✅ Use `RUNTIME` only if needed

Reflection has cost

---

### ✅ Keep annotations simple

Avoid complex logic inside them

---

### ✅ Use meaningful names

```java
@NotNull   // good
@A         // bad
```

---

### ✅ Combine with frameworks

Don’t reinvent what Spring already provides

---

# 12. Mental Model

| Concept    | Meaning        |
| ---------- | -------------- |
| Annotation | metadata       |
| Retention  | when available |
| Target     | where used     |
| Reflection | how it's read  |

---

# 13. Interview-Level Insight

### ❓ Do annotations execute code?

❌ No — they only provide metadata

---

### ❓ How does Spring use annotations?

* Scans classes
* Reads annotations via reflection
* Applies behavior dynamically

---

### ❓ Difference: SOURCE vs RUNTIME

* SOURCE → compile-time tools
* RUNTIME → frameworks & reflection

---

# 14. Big Picture

Custom annotations enable:

* Declarative programming
* Cleaner code
* Framework magic

---

If you want next level, I can show:

* How Spring implements `@Autowired`
* Build a mini dependency injection framework using annotations
* Annotation processing (APT) at compile time

Just tell me 👍

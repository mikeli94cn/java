Exception handling in Java is a mechanism to deal with **runtime errors** in a controlled way, so your program doesn’t crash unexpectedly. Java provides several constructs: `try`, `catch`, `finally`, `try-with-resources`, **multi-catch**, and **custom exceptions**.

---

# 1. **Basic Exception Handling: `try-catch-finally`**

### Structure:

```java
try {
    // code that may throw an exception
} catch (ExceptionType e) {
    // handle exception
} finally {
    // always executes (optional)
}
```

### Example:

```java
public class Example {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This always runs.");
        }
    }
}
```

### Key Points:

* `try`: wrap risky code
* `catch`: handle specific exceptions
* `finally`: always runs (cleanup, closing resources)

---

# 2. **Multiple `catch` Blocks**

You can handle different exceptions differently:

```java
try {
    String str = null;
    System.out.println(str.length()); // NullPointerException
} catch (NullPointerException e) {
    System.out.println("Null value!");
} catch (Exception e) {
    System.out.println("General exception!");
}
```

⚠️ Order matters: **child exceptions must come before parent exceptions**

---

# 3. **Multi-Catch (Java 7+)**

Handle multiple exception types in a single `catch` block:

```java
try {
    int[] arr = new int[5];
    arr[10] = 100; // ArrayIndexOutOfBoundsException
} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
    System.out.println("Handled multiple exceptions: " + e);
}
```

### When to use:

* When handling logic is the same for multiple exceptions

---

# 4. **`finally` Block**

The `finally` block executes **no matter what**:

* Exception occurs or not
* Even if `return` is used (almost always)

```java
try {
    System.out.println("Try block");
} finally {
    System.out.println("Finally block always executes");
}
```

---

# 5. **`try-with-resources` (Java 7+)**

Used to **automatically close resources** (like files, streams, DB connections).

### Example:

```java
import java.io.*;

public class Example {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("IO error occurred");
        }
    }
}
```

### Key Points:

* Resources must implement `AutoCloseable`
* No need for `finally` to close resources
* Cleaner and safer

---

# 6. **Throwing Exceptions**

You can explicitly throw exceptions using `throw`:

```java
public void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18+");
    }
}
```

---

# 7. **Declaring Exceptions with `throws`**

Used in method signatures to indicate possible exceptions:

```java
public void readFile() throws IOException {
    FileReader file = new FileReader("file.txt");
}
```

* Forces caller to handle or propagate the exception

---

# 8. **Custom Exceptions**

You can define your own exception types by extending `Exception` or `RuntimeException`.

### Checked Exception (extends `Exception`)

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

Usage:

```java
public void validate(int age) throws InvalidAgeException {
    if (age < 18) {
        throw new InvalidAgeException("Age is too low");
    }
}
```

---

### Unchecked Exception (extends `RuntimeException`)

```java
class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
```

* No need to declare with `throws`

---

# 9. **Checked vs Unchecked Exceptions**

| Type      | Example                | Checked by Compiler? | Must Handle? |
| --------- | ---------------------- | -------------------- | ------------ |
| Checked   | `IOException`          | ✅ Yes                | ✅ Yes        |
| Unchecked | `NullPointerException` | ❌ No                 | ❌ No         |

---

# 10. **Best Practices**

### ✅ Catch specific exceptions

```java
catch (IOException e) { }
```

❌ Avoid:

```java
catch (Exception e) { }
```

---

### ✅ Don’t ignore exceptions

```java
catch (Exception e) {
    e.printStackTrace(); // or logging
}
```

---

### ✅ Use try-with-resources for I/O

---

### ✅ Don’t overuse exceptions for normal logic

---

# 11. **Complete Example**

```java
import java.io.*;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Demo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {

            String line = br.readLine();

            if (line == null) {
                throw new CustomException("File is empty");
            }

            System.out.println(line);

        } catch (IOException | CustomException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Execution finished");
        }
    }
}
```

---

# ✅ Summary

* `try-catch-finally`: core exception handling
* **Multi-catch**: handle multiple exceptions in one block
* **try-with-resources**: automatic resource management
* `throw` / `throws`: create and propagate exceptions
* **Custom exceptions**: define domain-specific errors

---

If you want, I can next explain **exception hierarchy (Throwable, Error, Exception)** or show **real-world patterns (like retry, wrapping exceptions, logging strategies)**.

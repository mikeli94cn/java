Let’s go through the **basics of Java Logging API** in a clear, practical, and structured way. The built-in logging system in Java is:

> **`java.util.logging` (JUL)** — included in the JDK (no extra dependencies)

---

# 1. What is Logging?

Logging is used to:

* Track program execution
* Debug issues
* Record errors and system events

Instead of:

```java
System.out.println("Debug info");
```

You use logging:

```java
logger.info("Debug info");
```

👉 Benefits:

* Configurable levels (INFO, WARNING, etc.)
* Can write to files, console, remote systems
* Can be turned on/off without changing code

---

# 2. Core Components of Java Logging

### 1. Logger

Main entry point

```java
Logger logger = Logger.getLogger(MyClass.class.getName());
```

---

### 2. Log Levels

| Level   | Description        |
| ------- | ------------------ |
| SEVERE  | Serious failure    |
| WARNING | Potential problem  |
| INFO    | General info       |
| CONFIG  | Configuration info |
| FINE    | Detailed debug     |
| FINER   | More detailed      |
| FINEST  | Very detailed      |

---

### 3. Handlers

Decide **where logs go**

Examples:

* ConsoleHandler → console
* FileHandler → file

---

### 4. Formatters

Control **log output format**

---

# 3. Basic Example

```java
import java.util.logging.Logger;

public class Main {
    private static final Logger logger =
        Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Application started");
        logger.warning("This is a warning");
        logger.severe("Something went wrong");
    }
}
```

---

# 4. Logging Levels in Practice

```java
logger.setLevel(Level.ALL);

logger.finest("Very detailed");
logger.finer("More detailed");
logger.fine("Debug");
logger.info("Info");
logger.warning("Warning");
logger.severe("Error");
```

👉 Important:

* Default level is usually `INFO`
* Lower levels (FINE, etc.) won’t show unless configured

---

# 5. Using Parameters (Better Practice)

```java
logger.log(Level.INFO, "User {0} logged in", username);
```

Instead of:

```java
logger.info("User " + username + " logged in");
```

👉 Why?

* Avoids unnecessary string creation if log is disabled

---

# 6. Exception Logging

```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    logger.log(Level.SEVERE, "Exception occurred", e);
}
```

👉 This prints:

* Message
* Stack trace

---

# 7. File Logging Example

```java
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger("MyLogger");

        FileHandler fileHandler = new FileHandler("app.log");
        logger.addHandler(fileHandler);

        fileHandler.setFormatter(new SimpleFormatter());

        logger.info("Logging to file");
    }
}
```

---

# 8. Custom Formatting

```java
fileHandler.setFormatter(new Formatter() {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ": " + record.getMessage() + "\n";
    }
});
```

---

# 9. Configuration via properties file

You can configure logging without code:

**logging.properties**

```
.level=INFO
java.util.logging.ConsoleHandler.level=INFO
java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter
```

Run with:

```
-Djava.util.logging.config.file=logging.properties
```

---

# 10. Logger Hierarchy

```java
Logger logger = Logger.getLogger("com.example.app");
```

* Loggers form a **tree structure**
* Child loggers inherit parent settings

Example:

```
com
 └── example
      └── app
```

---

# 11. Best Practices

### ✅ Use class name for logger

```java
Logger.getLogger(MyClass.class.getName());
```

---

### ✅ Don’t use System.out.println

* Not configurable
* Not production-ready

---

### ✅ Use appropriate levels

* `INFO` → normal operations
* `WARNING` → suspicious
* `SEVERE` → failures

---

### ✅ Avoid heavy string concatenation

Use:

```java
logger.log(Level.INFO, "Value: {0}", value);
```

---

# 12. Limitations of java.util.logging

This is important in real-world projects:

JUL is often replaced by:

* Log4j
* Logback
* SLF4J

👉 Why?

* Better performance
* Better configuration
* More flexible

---

# 13. Simple Mental Model

| Component | Role        |
| --------- | ----------- |
| Logger    | writes logs |
| Level     | importance  |
| Handler   | destination |
| Formatter | appearance  |

---

# 14. Quick Real-World Example

```java
import java.util.logging.*;

public class App {
    private static final Logger logger =
        Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("App started");

        try {
            simulateWork();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred", e);
        }
    }

    static void simulateWork() {
        throw new RuntimeException("Failure");
    }
}
```

---

# If you want next steps

I can go deeper into:

* How logging works inside **Spring Boot**
* Using **SLF4J + Logback (industry standard)**
* Async logging & performance
* Structured logging (JSON logs)

Just tell me 👍

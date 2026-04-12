Great—this is what most real-world Java apps (especially Spring Boot) actually use:

> **SLF4J + Logback**

Think of it like:

* **SLF4J** = *API (facade)* → what your code calls
* **Logback** = *implementation* → does the real logging work

---

# 1. Why SLF4J + Logback?

### Problems with `java.util.logging`

* Hard to configure
* Not flexible
* Poor ecosystem

### Why this combo?

* Clean abstraction (SLF4J)
* Fast + powerful backend (Logback)
* Industry standard (used by Spring)

---

# 2. Architecture (Important)

```text
Your Code → SLF4J → Logback → Console/File/Other outputs
```

👉 Key idea:
You **code against SLF4J**, not Logback directly.

---

# 3. Add Dependencies

### Maven

```xml
<dependencies>
    <!-- SLF4J API -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.9</version>
    </dependency>

    <!-- Logback implementation -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.4.14</version>
    </dependency>
</dependencies>
```

👉 `logback-classic` includes:

* Logback core
* SLF4J binding

---

# 4. Basic Usage (SLF4J API)

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger =
        LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.warn("Warning message");
        logger.error("Error occurred");
    }
}
```

---

# 5. Logging Levels (SLF4J)

| Level | Use           |
| ----- | ------------- |
| ERROR | failures      |
| WARN  | problems      |
| INFO  | normal flow   |
| DEBUG | debugging     |
| TRACE | very detailed |

---

# 6. Parameterized Logging (VERY IMPORTANT)

```java
String username = "Mike";

// Good
logger.info("User {} logged in", username);

// Bad
logger.info("User " + username + " logged in");
```

👉 Why?

* Avoids string creation if level is disabled
* Better performance

---

# 7. Logging Exceptions

```java
try {
    int x = 10 / 0;
} catch (Exception e) {
    logger.error("Exception occurred", e);
}
```

---

# 8. Logback Configuration (logback.xml)

Create file: `src/main/resources/logback.xml`

---

## Basic Example

```xml
<configuration>

    <!-- Console Appender -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss} [%thread] %-5level %logger - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Root Logger -->
    <root level="INFO">
        <appender-ref ref="CONSOLE"/>
    </root>

</configuration>
```

---

## Output Example

```text
21:30:15 [main] INFO  App - Application started
```

---

# 9. File Logging Example

```xml
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>app.log</file>
    <encoder>
        <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level %logger - %msg%n</pattern>
    </encoder>
</appender>

<root level="INFO">
    <appender-ref ref="CONSOLE"/>
    <appender-ref ref="FILE"/>
</root>
```

---

# 10. Log Rotation (Production Important)

```xml
<appender name="ROLLING" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>app.log</file>

    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>logs/app.%d{yyyy-MM-dd}.log</fileNamePattern>
        <maxHistory>7</maxHistory>
    </rollingPolicy>

    <encoder>
        <pattern>%d %-5level %logger - %msg%n</pattern>
    </encoder>
</appender>
```

👉 Keeps logs for 7 days.

---

# 11. Logger Hierarchy

```java
Logger logger = LoggerFactory.getLogger("com.example.service");
```

Hierarchy:

```text
com
 └── example
      └── service
```

Configure specific package:

```xml
<logger name="com.example" level="DEBUG"/>
```

---

# 12. Best Practices

### ✅ Always use SLF4J API

```java
Logger logger = LoggerFactory.getLogger(MyClass.class);
```

---

### ✅ Use parameterized logs

```java
logger.debug("Value = {}", value);
```

---

### ✅ Use correct levels

* INFO → business flow
* DEBUG → development
* ERROR → failures

---

### ✅ Avoid logging in tight loops

* Can hurt performance

---

### ✅ Never log sensitive data

* Passwords
* Tokens

---

# 13. Common Pitfalls

### ❌ Multiple logging frameworks conflict

Example:

* Log4j + Logback together → conflicts

---

### ❌ Missing binding

Error:

```text
SLF4J: No SLF4J providers were found
```

👉 Means:

* No implementation (like Logback) found

---

# 14. Spring Boot Note

If you use Spring Boot:

* It **already includes Logback**
* You just use:

```java
private static final Logger log =
    LoggerFactory.getLogger(MyClass.class);
```

---

# 15. Mental Model (Final)

| Layer    | Role                        |
| -------- | --------------------------- |
| SLF4J    | API (what you code against) |
| Logback  | Engine (does the work)      |
| Appender | Output (console/file)       |
| Encoder  | Format                      |

---

# If you want to go deeper

Next useful topics:

* Async logging (huge performance boost)
* MDC (Mapped Diagnostic Context for tracing requests)
* Structured logging (JSON logs for ELK stack)
* How Spring Boot auto-configures logging

Just tell me 👍

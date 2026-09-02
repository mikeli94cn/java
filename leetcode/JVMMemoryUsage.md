To print how much memory your Java program is using, you can use the `Runtime` class.

Java provides:

```java
Runtime.getRuntime()
```

which gives information about JVM memory.

---

## ✅ Basic example: print JVM memory usage

```java
public class MemoryDemo {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();

        System.out.println("Total memory: " + totalMemory / 1024 / 1024 + " MB");
        System.out.println("Free memory : " + freeMemory / 1024 / 1024 + " MB");
        System.out.println("Used memory : " + usedMemory / 1024 / 1024 + " MB");
        System.out.println("Max memory  : " + maxMemory / 1024 / 1024 + " MB");
    }
}
```

Example output:

```text
Total memory: 16 MB
Free memory : 12 MB
Used memory : 4 MB
Max memory  : 4096 MB
```

---

# 🧠 Meaning of each value

| Method                     | Meaning                           |
| -------------------------- | --------------------------------- |
| `totalMemory()`            | Current memory allocated by JVM   |
| `freeMemory()`             | Free memory inside allocated heap |
| `totalMemory - freeMemory` | Approximate used heap memory      |
| `maxMemory()`              | Maximum heap JVM can use          |

---

# ✅ Measure memory used by a piece of code

Example:

```java
public class MemoryTest {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();

        long before = rt.totalMemory() - rt.freeMemory();

        // Code you want to measure
        int[] array = new int[10_000_000];

        long after = rt.totalMemory() - rt.freeMemory();

        System.out.println(
            "Memory used: " +
            (after - before) / 1024 / 1024 +
            " MB"
        );
    }
}
```

Possible output:

```text
Memory used: 38 MB
```

---

# ⚠️ Force garbage collection before measuring

Because unused objects may not have been cleaned:

```java
System.gc();

long before =
    Runtime.getRuntime().totalMemory()
    - Runtime.getRuntime().freeMemory();
```

However:

```java
System.gc();
```

is only a **request**. JVM may ignore it.

---

# ✅ More accurate JVM memory monitoring (Java 8+)

Using `MemoryMXBean`:

```java
import java.lang.management.*;

public class MemoryInfo {

    public static void main(String[] args) {

        MemoryMXBean memory =
            ManagementFactory.getMemoryMXBean();

        long heapUsed =
            memory.getHeapMemoryUsage().getUsed();

        System.out.println(
            "Heap used: " +
            heapUsed / 1024 / 1024 +
            " MB"
        );
    }
}
```

Example:

```text
Heap used: 3 MB
```

---

# 📌 For LeetCode / algorithm testing

Usually:

```java
long memoryBefore =
    Runtime.getRuntime().totalMemory()
    - Runtime.getRuntime().freeMemory();

// algorithm

long memoryAfter =
    Runtime.getRuntime().totalMemory()
    - Runtime.getRuntime().freeMemory();

System.out.println(
    "Memory: " +
    (memoryAfter - memoryBefore) / 1024 +
    " KB"
);
```

is enough.

---

# 🚀 For production Java applications

Use:

* **JVisualVM**
* **Java Mission Control (JMC)**
* **JConsole**
* **JFR (Java Flight Recorder)**

because they show:

* heap usage
* GC activity
* object allocation
* memory leaks

---

For **algorithm interviews (LeetCode style)**, `Runtime.getRuntime()` is usually the simplest way to estimate memory usage.

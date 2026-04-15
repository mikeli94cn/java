The **`java.nio.file` API (NIO.2)** is the modern way to work with files and directories in Java. It replaces many older `java.io.File` limitations and provides powerful, concise operations for **constructing, traversing, creating, reading, and writing paths**.

---

# 1. **Core Classes**

* `Path` → represents a file/directory path
* `Paths` → factory for creating `Path`
* `Files` → utility class for operations (read/write/copy/etc.)

---

# 2. **Constructing `Path` Objects**

### ✅ Using `Paths.get()`

```java
import java.nio.file.*;

Path path = Paths.get("data/file.txt");
```

### ✅ Using `Path.of()` (Java 11+ preferred)

```java
Path path = Path.of("data", "file.txt");
```

---

## 🔹 Absolute vs Relative Paths

```java
Path relative = Path.of("file.txt");
Path absolute = Path.of("/home/user/file.txt");
```

---

## 🔹 Path Operations

```java
Path path = Path.of("data/file.txt");

System.out.println(path.getFileName());  // file.txt
System.out.println(path.getParent());    // data
System.out.println(path.getRoot());      // / (Linux)
```

---

## 🔹 Normalize & Resolve

```java
Path p = Path.of("data/../file.txt").normalize(); // file.txt

Path base = Path.of("data");
Path full = base.resolve("file.txt"); // data/file.txt
```

---

# 3. **Creating Files and Directories**

```java
Path file = Path.of("test.txt");
Files.createFile(file);
```

```java
Path dir = Path.of("myDir");
Files.createDirectory(dir);
```

### Create nested directories

```java
Files.createDirectories(Path.of("a/b/c"));
```

---

# 4. **Checking File Properties**

```java
Path path = Path.of("test.txt");

System.out.println(Files.exists(path));
System.out.println(Files.isRegularFile(path));
System.out.println(Files.isDirectory(path));
System.out.println(Files.isReadable(path));
System.out.println(Files.isWritable(path));
```

---

# 5. **Reading Files**

---

## ✅ Read entire file (simple)

```java
String content = Files.readString(Path.of("test.txt"));
```

---

## ✅ Read all lines

```java
import java.util.List;

List<String> lines = Files.readAllLines(Path.of("test.txt"));
```

---

## ✅ Read using stream (large files)

```java
Files.lines(Path.of("test.txt"))
     .forEach(System.out::println);
```

---

# 6. **Writing Files**

---

## ✅ Write string

```java
Files.writeString(Path.of("test.txt"), "Hello World");
```

---

## ✅ Write multiple lines

```java
List<String> lines = List.of("Line1", "Line2");

Files.write(Path.of("test.txt"), lines);
```

---

## ✅ Append mode

```java
Files.writeString(
    Path.of("test.txt"),
    "Append text",
    StandardOpenOption.APPEND
);
```

---

# 7. **Copy, Move, Delete**

---

## Copy

```java
Files.copy(Path.of("source.txt"), Path.of("target.txt"));
```

---

## Move / Rename

```java
Files.move(Path.of("old.txt"), Path.of("new.txt"));
```

---

## Delete

```java
Files.delete(Path.of("test.txt"));
```

---

# 8. **Traversing Directories**

---

## ✅ List files (non-recursive)

```java
Files.list(Path.of("."))
     .forEach(System.out::println);
```

---

## ✅ Walk directory (recursive)

```java
Files.walk(Path.of("."))
     .forEach(System.out::println);
```

---

## ✅ Filter files

```java
Files.walk(Path.of("."))
     .filter(Files::isRegularFile)
     .forEach(System.out::println);
```

---

# 9. **File Attributes**

```java
import java.nio.file.attribute.*;

BasicFileAttributes attr =
    Files.readAttributes(path, BasicFileAttributes.class);

System.out.println(attr.size());
System.out.println(attr.creationTime());
System.out.println(attr.lastModifiedTime());
```

---

# 10. **WatchService (Directory Monitoring)**

Monitor file changes in real time:

```java
WatchService watchService =
    FileSystems.getDefault().newWatchService();

Path dir = Path.of(".");
dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

while (true) {
    WatchKey key = watchService.take();

    for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println("File created: " + event.context());
    }

    key.reset();
}
```

---

# 11. **Path vs File (Important)**

| Feature            | `File` (old)    | `Path` (NIO)    |
| ------------------ | --------------- | --------------- |
| API style          | object-oriented | functional/util |
| Operations         | limited         | rich (`Files`)  |
| Exception handling | weak            | strong          |
| Modern usage       | ❌               | ✅               |

---

# 12. **Best Practices**

### ✅ Use `Path.of()` instead of `new File()`

### ✅ Use `Files` utility methods

```java
Files.readString()
Files.writeString()
```

### ✅ Use streams for large files

```java
Files.lines()
```

---

### ❌ Avoid:

```java
new File("file.txt")
```

---

# 13. **Complete Example**

```java
import java.nio.file.*;
import java.util.*;

public class NioDemo {
    public static void main(String[] args) throws Exception {

        Path path = Path.of("example.txt");

        // Create file
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        // Write
        Files.writeString(path, "Hello NIO");

        // Read
        String content = Files.readString(path);
        System.out.println(content);

        // Traverse directory
        Files.walk(Path.of("."))
             .filter(Files::isRegularFile)
             .forEach(System.out::println);
    }
}
```

---

# 14. **Summary**

* `Path` → represents file/directory
* `Files` → performs operations
* Supports:

  * create, read, write
  * copy, move, delete
  * traverse directories
  * monitor changes

---

# ✅ Final Insight

👉 `java.nio.file` is:

* more powerful
* more concise
* more modern

👉 Always prefer it over `java.io.File` in real-world applications.

---

If you want, I can next explain:

* **FileChannel + Path integration (advanced NIO)**
* or **how file I/O is handled in Spring Boot (upload/download APIs)**

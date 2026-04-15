The **Java I/O API** (Input/Output) is used to **read and write data** from/to various sources such as files, memory, network, and streams. It is mainly provided by packages like:

* `java.io` (classic I/O)
* `java.nio` and `java.nio.file` (modern I/O, NIO = New I/O)

---

# 1. **Core Concept: Streams**

Java I/O is built around the concept of **streams**.

👉 A **stream** is a flow of data:

* **Input stream** → data coming *into* your program
* **Output stream** → data going *out* of your program

---

# 2. **Byte Streams vs Character Streams**

## 🔹 Byte Streams (`InputStream`, `OutputStream`)

* Handle **binary data** (images, files, etc.)

```java
InputStream in;
OutputStream out;
```

### Example:

```java id="q1u4k1"
import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        }
    }
}
```

---

## 🔹 Character Streams (`Reader`, `Writer`)

* Handle **text data (Unicode)**

```java
Reader reader;
Writer writer;
```

### Example:

```java id="86i39o"
import java.io.*;

public class CharStreamExample {
    public static void main(String[] args) throws IOException {
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output.txt")) {

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
        }
    }
}
```

---

# 3. **Buffered Streams (Performance Optimization)**

Buffered streams improve performance by reducing I/O operations.

### Example:

```java id="5wn7kz"
import java.io.*;

public class BufferedExample {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

---

# 4. **Common I/O Classes**

## Byte Streams

* `FileInputStream`
* `FileOutputStream`
* `BufferedInputStream`
* `BufferedOutputStream`

## Character Streams

* `FileReader`
* `FileWriter`
* `BufferedReader`
* `BufferedWriter`

---

# 5. **File Handling (`File` class)**

Represents file/directory paths.

```java id="qrwb1x"
import java.io.File;

File file = new File("test.txt");

System.out.println(file.exists());
System.out.println(file.getAbsolutePath());
```

---

# 6. **Modern I/O (NIO.2) – `java.nio.file`**

More powerful and flexible than `java.io`.

## Key Classes:

* `Path`
* `Paths`
* `Files`

---

## Example: Read File

```java id="0r7e3v"
import java.nio.file.*;
import java.io.IOException;

public class NIOExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("input.txt");

        String content = Files.readString(path);
        System.out.println(content);
    }
}
```

---

## Example: Write File

```java id="21d2o5"
Files.writeString(path, "Hello Java I/O");
```

---

## Example: Read All Lines

```java id="snl0o8"
List<String> lines = Files.readAllLines(path);
```

---

# 7. **Working with Directories**

```java id="9j2n4g"
Path dir = Paths.get("myDir");

Files.createDirectory(dir);
Files.list(dir).forEach(System.out::println);
```

---

# 8. **Serialization (Object I/O)**

Used to convert objects to bytes (save to file) and restore them later.

### Example:

```java id="0f7d0y"
import java.io.*;

class Person implements Serializable {
    String name;
}

public class SerializationExample {
    public static void main(String[] args) throws Exception {

        // Write object
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(new Person());
        }

        // Read object
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person p = (Person) ois.readObject();
        }
    }
}
```

---

# 9. **try-with-resources (Best Practice)**

Always use for I/O to automatically close resources:

```java id="6hsyxt"
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
}
```

---

# 10. **I/O vs NIO (Important Comparison)**

| Feature     | `java.io`    | `java.nio`             |
| ----------- | ------------ | ---------------------- |
| Style       | Stream-based | Buffer-based           |
| Blocking    | Blocking     | Non-blocking           |
| Performance | Lower        | Higher                 |
| File API    | Limited      | Rich (`Files`, `Path`) |

---

# 11. **When to Use What?**

### ✅ Use `java.io` when:

* Simple file operations
* Learning basics

### ✅ Use `java.nio.file` when:

* Modern applications
* Better performance
* File manipulation (copy, move, etc.)

---

# 12. **Best Practices**

### ✅ Use buffering

```java
BufferedReader, BufferedWriter
```

### ✅ Use `Files` (NIO) for simplicity

```java
Files.readString()
```

### ✅ Always close resources

→ use `try-with-resources`

---

### ❌ Avoid:

```java
FileReader + manual close
```

---

# 13. **Summary**

* **Streams** → core abstraction (input/output)
* **Byte streams** → binary data
* **Character streams** → text data
* **Buffered streams** → performance improvement
* **NIO (`Files`, `Path`)** → modern and preferred API
* **Serialization** → object persistence

---

If you want, I can next explain:

* **NIO internals (buffer, channel, selector)** ← very important for advanced Java
* or **file upload/download & I/O in Spring applications**

Using the **Java I/O API** to read and write **console and file data** is one of the most fundamental tasks in Java programming. This involves working with **streams**, which represent flows of data.

---

# 1. **Console I/O (Standard Input/Output)**

Java provides built-in streams:

* `System.in` → input (keyboard)
* `System.out` → output (console)
* `System.err` → error output

---

## 🔹 Reading from Console

### ✅ Using `Scanner` (Recommended)

```java
import java.util.Scanner;

public class ConsoleInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Hello " + name + ", age: " + age);
    }
}
```

---

### ✅ Using `BufferedReader` (More efficient)

```java
import java.io.*;

public class ConsoleBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter text: ");
        String input = br.readLine();

        System.out.println("You entered: " + input);
    }
}
```

---

## 🔹 Writing to Console

```java
System.out.println("Hello World");
System.out.print("No newline");
System.err.println("Error message");
```

---

# 2. **File I/O (Reading & Writing Files)**

---

## 🔹 Reading Files

### ✅ Using `FileInputStream` (byte stream)

```java
import java.io.*;

public class FileReadExample {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("input.txt")) {

            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        }
    }
}
```

---

### ✅ Using `BufferedReader` (best for text)

```java
import java.io.*;

public class FileBufferedRead {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br =
                 new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
```

---

## 🔹 Writing Files

### ✅ Using `FileOutputStream` (byte stream)

```java
import java.io.*;

public class FileWriteExample {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos =
                 new FileOutputStream("output.txt")) {

            String text = "Hello Java I/O";
            fos.write(text.getBytes());
        }
    }
}
```

---

### ✅ Using `BufferedWriter` (best for text)

```java
import java.io.*;

public class FileBufferedWrite {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw =
                 new BufferedWriter(new FileWriter("output.txt"))) {

            bw.write("Hello World");
            bw.newLine();
            bw.write("Second line");
        }
    }
}
```

---

# 3. **Append Mode (Important)**

```java
FileWriter fw = new FileWriter("output.txt", true); // append = true
```

---

# 4. **Binary File Example (Important)**

```java
import java.io.*;

public class BinaryExample {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("data.bin")) {
            fos.write(new byte[]{1, 2, 3, 4});
        }
    }
}
```

---

# 5. **try-with-resources (Best Practice)**

Automatically closes streams:

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
}
```

---

# 6. **Common I/O Classes Summary**

## Input

* `InputStream` (byte)
* `Reader` (char)
* `FileInputStream`
* `FileReader`
* `BufferedReader`
* `Scanner`

## Output

* `OutputStream` (byte)
* `Writer` (char)
* `FileOutputStream`
* `FileWriter`
* `BufferedWriter`
* `PrintWriter`

---

# 7. **PrintWriter (Convenient Output)**

```java
import java.io.*;

public class PrintWriterExample {
    public static void main(String[] args) throws IOException {
        try (PrintWriter pw = new PrintWriter("output.txt")) {
            pw.println("Hello");
            pw.printf("Number: %d%n", 100);
        }
    }
}
```

---

# 8. **Copy File Example (Classic Interview Question)**

```java
import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream in =
                 new BufferedInputStream(new FileInputStream("input.txt"));
             BufferedOutputStream out =
                 new BufferedOutputStream(new FileOutputStream("output.txt"))) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        }
    }
}
```

---

# 9. **Key Differences**

| Type              | Use Case                    |
| ----------------- | --------------------------- |
| Byte streams      | binary data (images, files) |
| Character streams | text data                   |
| Buffered streams  | performance optimization    |

---

# 10. **Best Practices**

### ✅ Use buffered streams

```java
BufferedReader, BufferedWriter
```

### ✅ Use try-with-resources

### ✅ Use character streams for text

---

### ❌ Avoid:

```java
FileInputStream for text files (inefficient)
```

---

# 11. **Summary**

* **Console I/O**

  * Input → `Scanner`, `BufferedReader`
  * Output → `System.out`

* **File I/O**

  * Read → `FileReader`, `BufferedReader`
  * Write → `FileWriter`, `BufferedWriter`

* **Streams**

  * Byte → binary data
  * Character → text data

---

If you want, I can next:

* show **NIO version of file I/O (Files.read/write)**
* or explain **how Java handles encoding (UTF-8, charset issues)** (very important in real projects)

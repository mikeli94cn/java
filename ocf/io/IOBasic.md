Java I/O (Input/Output) refers to the API for reading data from sources (like files or networks) and writing it to destinations. Java provides two primary packages for this: the original java.io and the modern, high-performance java.nio (New I/O). [1, 2, 3, 4, 5] 
## 1. The java.io Package (Legacy / Classic I/O)
This API uses Streams, which process data sequentially, one byte or character at a time. [6, 7] 

* Byte Streams: Best for binary data like images or audio.
* InputStream / OutputStream: The base abstract classes for all byte streams.
   * FileInputStream / FileOutputStream: Specific implementations for reading/writing file bytes.
* Character Streams: Best for text files; they handle Unicode characters automatically.
* Reader / Writer: The base abstract classes for character streams.
   * FileReader / FileWriter: Used specifically for text files.
* Buffering: Standard streams can be slow because they perform a system call for every single byte. Wrapping them in BufferedReader or BufferedOutputStream improves performance by handling data in larger chunks. [2, 6, 8, 9, 10, 11, 12] 

## 2. The java.nio Package (New I/O)
Introduced in Java 1.4, NIO focuses on high-speed, scalable I/O. [13, 14, 15] 

* Channels and Buffers: Instead of streams, NIO uses Channels (bi-directional paths) and Buffers (temporary storage blocks). Data is read from a channel into a buffer and processed in blocks, which is significantly faster for large data.
* Non-blocking I/O: Allows a single thread to manage multiple connections using a Selector, meaning the thread doesn't have to wait for data to be fully written or read before doing other work. [1, 7, 16, 17, 18] 

## 3. The java.nio.file (NIO.2) API
Introduced in Java 7, this modernized file handling and replaced many older java.io.File methods. [6, 19] 

* Path interface: A more flexible and consistent replacement for the File class.
* Files class: A utility class with dozens of methods for copying, moving, deleting, or reading entire files in one line. [6, 20, 21, 22] 

## Summary: Comparing I/O Models

| Feature [1, 16, 17, 23] | java.io (Classic) | java.nio (Modern) |
|---|---|---|
| Orientation | Stream-oriented (byte by byte) | Buffer-oriented (block by block) |
| Blocking | Synchronous/Blocking | Asynchronous/Non-blocking |
| Direction | Unidirectional (Input OR Output) | Bidirectional (Channels can do both) |
| Best For | Simple tasks, small files | High-performance, scalable servers |

## Code Demo: Reading a File (Modern Way)
```java
import java.nio.file.*;import java.io.IOException;import java.util.List;
public class ReadFile {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try {
            // NIO.2 makes reading simple text files a one-liner
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

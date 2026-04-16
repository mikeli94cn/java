In Java, the I/O API (java.io) uses the concept of Streams—a sequential flow of data from a source (input) to a destination (output). To handle different data types, Java provides two main stream hierarchies: Byte Streams (8-bit) for binary data and Character Streams (16-bit) for text. [1, 2, 3, 4] 
## 1. Console I/O
The System class provides three predefined stream variables for interacting with the console: [3, 5] 

* System.in: The standard input stream, typically connected to the keyboard.
* System.out: The standard output stream, typically used to display data on the console.
* System.err: The standard error stream, used for error messages. [3, 5] 

## Reading from Console
The most common and modern way to read console data is using the [Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) class, which can parse primitive types and strings. Alternatively, for high-performance reading, use [BufferedReader](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/BufferedReader.html). [6, 7, 8, 9] 
```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Enter text: ");
String input = sc.nextLine(); // Reads a full line of text
```
------------------------------
## 2. File I/O
File operations are handled by classes that connect directly to a file system. [5, 10] 

| Data Type [4, 10, 11, 12, 13] | Input (Reading) | Output (Writing) |
|---|---|---|
| Binary (Images, PDF) | FileInputStream | FileOutputStream |
| Text (.txt, .csv) | FileReader | FileWriter |

## Byte Streams vs. Character Streams [14] 

* Byte Streams: End in InputStream or OutputStream. They read raw 8-bit bytes and are essential for binary files where bit-level fidelity is required.
* Character Streams: End in Reader or Writer. They handle 16-bit Unicode and automatically manage character encoding (like UTF-8), making them the correct choice for human-readable text. [4, 15, 16, 17, 18] 

## Buffering for Performance
Unbuffered streams perform a system call for every byte/character, which is slow. Wrapping them in a Buffered Stream creates a memory buffer to handle data in larger chunks. [8, 14, 15] 
------------------------------
## 3. Practical Example: Reading and Writing a File
This example uses a character stream with buffering for efficiency. [8, 14] 
```java
import java.io.*;
public class FileStreamDemo {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // 1. Writing to a file (Character Stream)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Hello, Java I/O Streams!");
            writer.newLine();
            writer.write("Writing text data is easy.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Reading from a file (Character Stream)
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read from file: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
## 4. Important Best Practices

* Close Your Streams: Always close streams after use to free system resources. Using the try-with-resources statement (as shown above) ensures streams close automatically.
* Handle Exceptions: Most I/O methods throw IOException, which must be caught or declared. [14, 15, 18, 19] 

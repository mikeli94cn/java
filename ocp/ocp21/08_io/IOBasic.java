package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
   java i/o api (input/output) is used to read/write data from/to various sources
   such as files, memory, network, and streams
   main package: java.io, java.nio, java.nio.file

   1. core concepts: Streams
   java i/o is built around the concept of streams
   a stream is a flow of data
   input stream: input data
   output stream: output data

   2. byte streams vs character streams
   byte streams (InputStream, OutputStream) : handle binary data (image, file)
   character streams (Reader, Writer) : handle text data (Unicode)

   3.buffered streams (performance optimization)
   buffered streams improve performance by reducing i/o operations

   4.common i/o classes
   - byte streams
     - FileInputStream
     - FileOutputStream
     - BufferedInputStream
     - BufferedOutputStream
   - character streams
     - FileReader
     - FileWriter
     - BufferedReader
     - BufferedWriter

   5.file handling (File class) :
   represent file/directory paths

   6.modern io (nio.2) java.nio.file
   more powerful and flexible than java.io
   - key classes:
   - Path
   - Paths
   - Files


*/


public class IOBasic {
    public static void main(String[] args) {
        //byte stream: InputStream, OutputStream
        InputStream in;
        OutputStream out;

        try (FileInputStream fis = new FileInputStream("inputStream.txt");
             FileOutputStream fos = new FileOutputStream("outputStream.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException   e ) {
            e.printStackTrace();
        }
        //character stream: Reader, Writer
        Reader reader;
        Writer writer;

        try (FileReader fr = new FileReader("inputReader.txt");
             FileWriter fw = new FileWriter("outputWriter.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //buffered streams: better performance
        try (BufferedReader br = new BufferedReader(new FileReader("inputBufferReader.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //common class
        try (FileInputStream fis1 = new FileInputStream("inputStream.txt");
             FileOutputStream fos1 = new FileOutputStream("outputStream.txt");
             BufferedInputStream bis1 = new BufferedInputStream(fis1);
             BufferedOutputStream bos1 = new BufferedOutputStream(fos1);) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileReader fr1 = new FileReader("inputReader.txt");
             FileWriter fw1 = new FileWriter("outputWriter.txt");
             BufferedReader br1 = new BufferedReader(fr1);
             BufferedWriter bw1 = new BufferedWriter(fw1);) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //java.io.File
        File file = new File("inputStream.txt");
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

        //NIO.2 read file
        Path path = Paths.get("inputNio2.txt");
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //NIO.2 write file
        try {
            Files.writeString(path, "new io file!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //NIO.2 read_all_lines
        Path pathReadAll = Paths.get("inputNio2ReadAll.txt");
        try {
            List<String> lines = Files.readAllLines(pathReadAll);
            System.out.println(lines.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //working with directories
        Path dir = Paths.get("myDirectory");
        //Files.createDirectory(dir);
        try {
            Files.list(dir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //serialization (object i/o)
        //convert objects to bytes (save to file) and restore later

        class Person implements Serializable {
            String name;

            Person(String name) {
                this.name = name;
            }

            Person() {

            }
        }
        //write object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(new Person("serialization"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //read object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person p1 = (Person) ois.readObject();
            System.out.println("i am the restored object, my name is :" + p1.name);
        } catch ( IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //try-with-resources
        //always use for i/o to automatically close resources
        try (BufferedReader br=new BufferedReader(new FileReader("file.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*
        10.IO VS NIO
        |feature    |java.io     |java.nio    |
        |---        |---         |---         |
        |style      |stream based|buffer based|
        |blocking   |blocking    |non-blocking|
        |performance|lower       |higher      |
        |file api   |limited     |rich        |
         */

        /*
        when to use?
        - java.io
          - simple file operations
          - learning basics
        - java.nio.file
          - modern applications
          - better performance
          - file manipulation (copy, move, etc.)
         */

        /*
        best practice
        - using buffering
          - BufferedReader, BufferedWriter
        - using Files (NIO) for simplicity
          - Files.readString()
        - always close resources
          - use try-with-resources
        - avoid:
          - FileReader + manual close
         */

        /*
        summary
        - Streams: core abstraction (input/output)
        - byte streams: binary data
        - character streams: text data
        - buffered streams: performance improvement
        - NIO (Files, Path): modern and preferred API
        - serialization: object persistence
         */

        /*
        java.io (legacy / classic io)
        this api uses streams, which process data sequentially, one byte or character at a time.
        - byte streams: best for binary data like images or audio
          - inputStream/outputStream
            - FileInputStream/FileOutputStream
        - character streams: best for text files, Unicode character
          - Reader/Writer
            -FileReader/FileWriter

        - Buffering: Standard streams are slow because they handle one byte or character each time.
        wrapping them in BufferedReader, BufferedWriter, BufferedInputStream, BufferedOutputStream
        to improve performance by handing in large chunks.
         */

        /*
        java.nio (introduced in java 1.4, for high-speed, scalable io)
        - channels and buffers: instead of streams, nio uses channels (bi-directional paths) and buffers (temporary storage blocks).
        data is read from a channel into a buffer and processed in blocks, which is significantly faster for large data.
        - non-blocking io: allowing a single thread to manage multiple connections using a Selector, meaning the thread doesn't
        have to wait for data to be fully written or read before doing other work.
         */

        /*
        java.nio.file (introduced in java 7, modernized file handling and replaced many older java.io.File methods)
        Path interface: a more flexible and consistent replacement for File class
        Files class: a utility class with dozens of methods for copying, moving, deleting, or reading entire files in one line.
         */

        //reading a file (modern way)
        Path path2=Paths.get("google_example.txt");
        try{
            List<String> lines = Files.readAllLines(path2);
            lines.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

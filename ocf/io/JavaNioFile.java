The java.nio.file (NIO.2) API, introduced in Java 7, provides a robust and flexible way to interact with the file system using the Path interface and the Files utility class. [1, 2] 
## 1. Constructing Path Objects [1] 
A Path represents the location of a file or directory. Unlike the legacy File class, it is purely a programmatic representation and does not require the file to exist. [3, 4, 5] 

* Factory Methods: Use Path.of() (Java 11+) or Paths.get() to create instances.
* Relative vs. Absolute: You can define paths using absolute strings or by joining multiple components. [3, 5, 6, 7] 

Path absolute = Path.of("/var/logs/app.log");
Path relative = Paths.get("data", "examples", "file.txt"); // data/examples/file.txt

## 2. Traversing Directories
NIO.2 provides several ways to navigate directory structures depending on your needs:

* Files.list(Path): Returns a lazy Stream<Path> of entries in the immediate directory (non-recursive).
* Files.walk(Path): Recursively traverses the entire file tree, returning a Stream<Path> for depth-first search.
* Files.find(...): Similar to walk, but allows you to filter paths based on file attributes (like size or creation time) during the stream creation for better performance. [8, 9, 10, 11] 

## 3. Creating and Deleting
Use the static methods in the [Files class](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/io/File.html) to modify the file system. [12] 

* Files: Files.createFile(path) creates an empty file; fails if it already exists.
* Directories: Files.createDirectory(path) or Files.createDirectories(path) (to create parent folders as well).
* Cleanup: Files.delete(path) or Files.deleteIfExists(path). [6, 13, 14] 

## 4. Reading and Writing Data
NIO.2 simplifies file operations with high-level methods for common tasks. [2, 15] 

* Whole Files: Files.readAllLines(path) reads a text file into a List<String>, while Files.readAllBytes(path) is for binary data.
* Writing: Files.write(path, content.getBytes()) creates or overwrites a file with the provided data.
* Streams: Use Files.newBufferedReader(path) or Files.newBufferedWriter(path) for more control over character encoding and memory usage. [1, 16, 17, 18, 19] 

## 5. Accessing Path Properties
You can query metadata about a path directly or via the Files class. [3, 20] 

* Structure: path.getFileName(), path.getParent(), and path.getRoot().
* Verification: Files.exists(path), Files.isRegularFile(path), or Files.isDirectory(path).
* Metadata: Files.size(path) or Files.getLastModifiedTime(path). For a complete set of attributes in one call, use Files.readAttributes(path, BasicFileAttributes.class). [1, 5, 6, 9, 21] 

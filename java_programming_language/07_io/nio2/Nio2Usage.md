# how to check a file whether exists?

To check if a file exists using java.nio.file, use the Files.exists(Path) method.
Here is the exact code snippet to check for a file and handle the result safely:
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FileCheckExample {
    public static void main(String[] args) {
        // 1. Define the path to the file
        Path path = Paths.get("config.properties");

        // 2. Use Files.exists() to check
        if (Files.exists(path)) {
            System.out.println("The file exists! Proceeding with operations...");
        } else {
            System.out.println("The file does not exist at: " + path.toAbsolutePath());
        }
    }
}
```
## 💡 Pro-Tips for File Checking:

* The Opposite Check: If you want to explicitly check if a file is missing, use Files.notExists(path).
* Symlinks/Permissions: In rare cases, Files.exists() might return false if the file is there but your Java application lacks permission to see it. If absolute certainty is required regarding permissions, you can use Files.isReadable(path).

Would you like to see how to automatically create the file if it is missing, or are you ready to jump into the copying, moving, and deleting commands we discussed earlier?

# copying, moving, and deleting files using java.nio.file package
Here are the code demos for copying, moving, and deleting files using the recommended java.nio.file package.
All of these operations rely on the static utilities found in the Files class.

## 1. Copying a File
To copy a file, use Files.copy(). By default, if the target file already exists, Java will throw an exception. To overwrite it, use StandardCopyOption.REPLACE_EXISTING.
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class CopyFileDemo {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("backup_source.txt");

        try {
            // Copy file and overwrite target if it already exists
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully to: " + target);
        } catch (IOException e) {
            System.err.println("Copy failed: " + e.getMessage());
        }
    }
}
```

## 2. Moving / Renaming a File
To move a file (or rename it), use Files.move(). Like copying, you should pass REPLACE_EXISTING if you want to overwrite a destination file. You can also pass ATOMIC_MOVE to ensure the operation completes safely without interruption.
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
public class MoveFileDemo {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("archive/moved_source.txt");

        try {
            // Move file atomically and overwrite if target exists
            Files.move(source, target, 
                StandardCopyOption.REPLACE_EXISTING, 
                StandardCopyOption.ATOMIC_MOVE);
                
            System.out.println("File moved successfully to: " + target);
        } catch (IOException e) {
            System.err.println("Move failed: " + e.getMessage());
        }
    }
}
```

## 3. Deleting a File
For deletion, you have two main choices:

* Files.delete(path): Throws an exception if the file doesn't exist.
* Files.deleteIfExists(path): Returns true if deleted, or false if the file wasn't there (safest choice to avoid unnecessary crashes).
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class DeleteFileDemo {
    public static void main(String[] args) {
        Path target = Paths.get("old_file.txt");

        try {
            // Deletes the file safely if it exists
            boolean deleted = Files.deleteIfExists(target);
            
            if (deleted) {
                System.out.println("File was successfully deleted.");
            } else {
                System.out.println("Deletion skipped: File did not exist.");
            }
        } catch (IOException e) {
            // Triggers if you lack OS permissions or if it's a non-empty directory
            System.err.println("Delete failed: " + e.getMessage());
        }
    }
}
```
Would you like to explore how to delete or copy an entire folder structure (directories with contents), which requires walking the file tree, or are you ready to test these snippets in your project?


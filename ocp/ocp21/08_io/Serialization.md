Serialization is the process of converting an object's state into a byte stream, while Deserialization is the process of reconstructing the object from that byte stream. This is primarily used for saving objects to files or sending them over a network. [1, 2, 3, 4] 
## 1. Requirements for Serialization
For an object to be serialized, its class must implement the java.io.Serializable interface. [5] 

* Marker Interface: Serializable has no methods; it simply "marks" the class as eligible for serialization.
* serialVersionUID: A unique ID used during deserialization to verify that the sender and receiver of a serialized object have loaded classes that are compatible.
* Transient Keyword: If a field is marked as transient, it will not be serialized (useful for sensitive data like passwords or temporary cache). [6, 7, 8, 9, 10] 

## 2. Core Classes

* ObjectOutputStream: Contains the writeObject(Object obj) method to serialize an object to an underlying stream (like a file).
* ObjectInputStream: Contains the readObject() method to read the byte stream and recreate the object. [11, 12, 13, 14] 

------------------------------
## 3. Code Example: Serialize and De-serialize
```java
import java.io.*;
// 1. Implement Serializableclass User implements Serializable {
    private static final long serialVersionUID = 1L; // Best practice
    String name;
    transient String password; // This will NOT be saved

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
public class SerializationDemo {
    public static void main(String[] args) {
        User user = new User("Alice", "Secret123");
        String filename = "user.ser";

        // 2. Serialization (Writing Object)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(user);
            System.out.println("Object serialized!");
        } catch (IOException e) { e.printStackTrace(); }

        // 3. Deserialization (Reading Object)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            User savedUser = (User) in.readObject();
            System.out.println("Deserialized Name: " + savedUser.name);
            System.out.println("Deserialized Password (transient): " + savedUser.password); // Will be null
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }
}
```
## 4. Important Considerations

* Inheritance: If a superclass is serializable, all its subclasses are automatically serializable.
* Object Graphs: If your object contains references to other objects, those objects must also be Serializable, or a NotSerializableException will be thrown.
* Security: Native Java serialization is often criticized for security vulnerabilities. In modern enterprise applications, JSON or XML (using libraries like Jackson or Gson) is often preferred for data exchange. [15, 16, 17, 18, 19] 

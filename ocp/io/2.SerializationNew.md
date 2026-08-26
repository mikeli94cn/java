Serialization in Java is the process of **converting an object into a byte stream** so it can be:

* saved to a file
* sent over a network
* stored in memory

Deserialization is the reverse process: **reconstructing the object from the byte stream**.

---

# 1. **Basic Concept**

```text
Object → (Serialization) → Byte Stream → File / Network
Byte Stream → (Deserialization) → Object
```

Java provides built-in support via:

* `ObjectOutputStream` → serialize
* `ObjectInputStream` → deserialize

---

# 2. **Making a Class Serializable**

A class must implement the **marker interface** `Serializable`.

```java
import java.io.Serializable;

class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

👉 `Serializable` has **no methods** — it just marks the class.

---

# 3. **Serializing an Object (Write to File)**

```java
import java.io.*;

public class SerializeExample {
    public static void main(String[] args) throws IOException {

        Person p = new Person("Alice", 25);

        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream("person.dat"))) {

            oos.writeObject(p);
            System.out.println("Object serialized");
        }
    }
}
```

---

# 4. **Deserializing an Object (Read from File)**

```java
import java.io.*;

public class DeserializeExample {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream("person.dat"))) {

            Person p = (Person) ois.readObject();

            System.out.println(p.name + " " + p.age);
        }
    }
}
```

---

# 5. **Important Concepts**

---

## 🔹 `serialVersionUID`

Used for **version control** of serialized classes.

```java
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;
}
```

### Why important?

* Prevents `InvalidClassException`
* Ensures compatibility during deserialization

---

## 🔹 `transient` keyword

Fields marked `transient` are **NOT serialized**.

```java
class Person implements Serializable {
    String name;
    transient String password; // not saved
}
```

---

## 🔹 `static` fields

* Not serialized (belong to class, not object)

---

# 6. **Serialization of Object Graphs**

If an object contains other objects:

* All must implement `Serializable`

```java
class Address implements Serializable {
    String city;
}

class Person implements Serializable {
    Address address; // must also be Serializable
}
```

---

# 7. **Custom Serialization (Advanced)**

You can control serialization:

```java
private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
    // custom logic
}

private void readObject(ObjectInputStream ois)
        throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    // custom logic
}
```

---

# 8. **Example: Full Workflow**

```java
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Demo {
    public static void main(String[] args) throws Exception {

        // Serialize
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream("person.dat"))) {

            oos.writeObject(new Person("Bob", 30));
        }

        // Deserialize
        try (ObjectInputStream ois =
                 new ObjectInputStream(new FileInputStream("person.dat"))) {

            Person p = (Person) ois.readObject();
            System.out.println(p.name + " " + p.age);
        }
    }
}
```

---

# 9. **Common Exceptions**

| Exception                  | Cause                                 |
| -------------------------- | ------------------------------------- |
| `NotSerializableException` | class not implementing `Serializable` |
| `InvalidClassException`    | version mismatch                      |
| `ClassNotFoundException`   | class missing during deserialization  |

---

# 10. **Best Practices**

### ✅ Always define `serialVersionUID`

### ✅ Use `transient` for sensitive data

```java
transient String password;
```

### ✅ Use try-with-resources

---

### ❌ Avoid:

* Serializing large object graphs unnecessarily
* Using Java serialization for long-term storage (not stable across versions)

---

# 11. **Alternatives (Modern Practice)**

Java native serialization is often avoided in modern systems.

Better alternatives:

* JSON (Jackson, Gson)
* Protocol Buffers
* XML

👉 Why?

* More portable
* Language-independent
* Safer

---

# 12. **Summary**

* **Serialization** → object → byte stream
* **Deserialization** → byte stream → object
* Use:

  * `ObjectOutputStream`
  * `ObjectInputStream`
* Key concepts:

  * `Serializable`
  * `serialVersionUID`
  * `transient`

---

# ✅ Final Insight

👉 Java serialization is powerful but **mainly used for:**

* caching
* session storage
* internal Java communication

👉 For APIs and microservices:

* prefer **JSON / protobuf**

---

If you want, I can next:

* compare **Java serialization vs JSON (Jackson)**
* or show **real-world serialization in Spring Boot (REST APIs)**

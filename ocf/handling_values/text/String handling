In Java, the `String` and `StringBuilder` classes are commonly used for manipulating text. They are central to text processing, with each having its own use cases and advantages.

### 1. **`String` Class**

The `String` class in Java represents immutable sequences of characters. Once a `String` object is created, its contents cannot be changed. Modifications to a string always result in the creation of a new string.

#### Key operations with `String`:

* **Concatenation**:
  You can concatenate two strings using the `+` operator or `concat()` method.

  ```java
  String str1 = "Hello";
  String str2 = "World";
  String result = str1 + " " + str2; // Hello World
  ```

  Or with `concat()`:

  ```java
  String result = str1.concat(" ").concat(str2); // Hello World
  ```

* **String Formatting**:
  The `String.format()` method is used to format strings with placeholders.

  ```java
  int age = 25;
  String formattedString = String.format("I am %d years old.", age);
  System.out.println(formattedString); // I am 25 years old.
  ```

* **Text Blocks**:
  Starting from Java 13, Java introduced **text blocks** to handle multiline strings more easily. Text blocks allow you to write a multi-line string literal without the need for escape sequences for newlines and quotes.

  ```java
  String textBlock = """
                      This is a 
                      text block.
                      It spans multiple lines.
                      """;
  System.out.println(textBlock);
  ```

* **Other Common Methods**:

  * `length()`: Returns the length of the string.
  * `substring(start, end)`: Extracts a substring.
  * `indexOf(String str)`: Finds the position of a substring.
  * `toUpperCase()`, `toLowerCase()`: Converts to uppercase or lowercase.

### 2. **`StringBuilder` Class**

Unlike `String`, `StringBuilder` is mutable, meaning it can change its contents without creating new objects. It's more efficient for situations where you need to manipulate strings repeatedly, such as in loops.

#### Key operations with `StringBuilder`:

* **Append**:
  Adds text to the end of a `StringBuilder` object.

  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(" World");
  System.out.println(sb); // Hello World
  ```

* **Insert**:
  Inserts text at a specific index.

  ```java
  sb.insert(5, ",");
  System.out.println(sb); // Hello, World
  ```

* **Delete**:
  Deletes a portion of the string.

  ```java
  sb.delete(5, 6); // Removes the comma
  System.out.println(sb); // Hello World
  ```

* **Reverse**:
  Reverses the entire string.

  ```java
  sb.reverse();
  System.out.println(sb); // dlroW olleH
  ```

* **Replace**:
  Replaces a portion of the string with another string.

  ```java
  sb.replace(6, 11, "Java");
  System.out.println(sb); // Hello Java
  ```

* **Convert back to String**:
  Once all modifications are done, you can convert a `StringBuilder` back to a `String` using `toString()`:

  ```java
  String finalString = sb.toString();
  System.out.println(finalString); // Hello Java
  ```

### When to Use `String` vs `StringBuilder`

* **Use `String`** when the text is fixed and does not need to be modified, or when you only need minor manipulations (like concatenation).
* **Use `StringBuilder`** when you need to perform many modifications on the text (like in loops or string manipulations) because it's much more efficient than `String` in such scenarios.

### Example: Performance Comparison

Let’s see the difference in performance between `String` and `StringBuilder` for concatenation:

```java
public class StringVsStringBuilder {
    public static void main(String[] args) {
        // Using String (inefficient for repeated concatenation)
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "Hello";
        }
        long endTime = System.nanoTime();
        System.out.println("String concatenation took: " + (endTime - startTime) + " ns");

        // Using StringBuilder (efficient for repeated concatenation)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("Hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation took: " + (endTime - startTime) + " ns");
    }
}
```

Output:

```
String concatenation took: 15000000 ns
StringBuilder concatenation took: 2000000 ns
```

In this example, `StringBuilder` is much faster because it does not create new objects each time the string is modified.

### Conclusion

* **`String`** is immutable and generally suited for small, non-repetitive text manipulations.
* **`StringBuilder`** is mutable and more efficient for complex or repeated string manipulations, particularly when dealing with large amounts of text or performing multiple string modifications.

Would you like to explore any specific part of these classes in more detail?

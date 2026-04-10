In Java, text manipulation is primarily handled through the immutable String class, the mutable StringBuilder class, and the modern Text Block feature for multi-line content. [1, 2, 3] 
## 1. The String Class (Immutable)
Strings in Java are immutable, meaning once created, their content cannot be changed. Methods that appear to modify a string actually return a brand-new String object. [2, 4, 5] 

* Best For: Fixed text, small concatenations, and thread-safe operations.
* Key Methods: substring(), toUpperCase(), trim(), contains(), and replace().
* Performance Note: Using the + operator in a loop is inefficient because it creates multiple intermediate objects. [2, 4, 5, 6, 7] 

## 2. The StringBuilder Class (Mutable)
StringBuilder allows you to modify text in-place without creating new objects. It is significantly faster and more memory-efficient for frequent modifications. [3, 4, 8, 9] 

* Best For: Building strings inside loops or complex dynamic text generation.
* Key Methods: append(), insert(), delete(), and reverse().
* Thread Safety: It is not thread-safe; use StringBuffer if synchronization is required. [3, 5, 8, 10, 11] 

## 3. Text Blocks (Multi-line Strings)
Introduced as a standard feature in Java 15, [Text Blocks](https://openjdk.org/projects/amber/guides/text-blocks-guide) use triple quotes (""") to represent multi-line strings. [12, 13] 

* Benefits: Eliminates the need for most escape sequences (like \" or \n) and makes structured text like HTML, JSON, or SQL much more readable.
* Formatting: You can use the .formatted() method directly on a text block to inject variables. [14, 15, 16, 17, 18] 

## Code Demo

public class TextManipulation {
    public static void main(String[] args) {
        // 1. Text Block for multi-line data
        String json = """
                {
                    "name": "Java",
                    "type": "Language"
                }
                """;

        // 2. String manipulation (Creating new objects)
        String base = "  Hello World  ";
        String clean = base.trim().replace("World", "Java"); // "Hello Java"

        // 3. StringBuilder for efficient building (Mutable)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append("Iteration ").append(i).append("\n");
        }
        
        System.out.println("JSON:\n" + json);
        System.out.println("Cleaned String: " + clean);
        System.out.println("StringBuilder Result:\n" + sb.toString());
    }
}

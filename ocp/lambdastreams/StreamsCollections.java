The Streams API (introduced in Java 8) revolutionized how we handle collections. Instead of writing long for loops to filter or transform data, you describe what you want to do with the data using a functional approach.
## 1. The Stream Pipeline
A stream operation consists of three parts:

   1. Source: The collection or array (e.g., list.stream()).
   2. Intermediate Operations: These return a new stream and are lazy (they don't run until a terminal operation is called). Examples: filter(), map(), sorted().
   3. Terminal Operation: This triggers the processing and produces a result or a side-effect. Examples: collect(), forEach(), count(), reduce().

## 2. Common Stream Operations

| Operation | Purpose | Example |
|---|---|---|
| filter | Keep elements that match a condition. | .filter(n -> n > 10) |
| map | Transform each element into something else. | .map(String::toUpperCase) |
| sorted | Sort the elements. | .sorted() |
| distinct | Remove duplicate elements. | .distinct() |
| limit | Take only the first N elements. | .limit(5) |
| collect | Turn the stream back into a List, Set, or Map. | .collect(Collectors.toList()) |

------------------------------
## 3. Code Demo: From Loops to Streams
Imagine you have a list of names and you want to find names starting with "A", convert them to uppercase, sort them, and save them to a new list.
The Modern Stream Way:

import java.util.*;import java.util.stream.*;
public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna", "Alex");

        List<String> result = names.stream()
            .filter(name -> name.startsWith("A")) // Filter
            .map(String::toUpperCase)             // Transform
            .sorted()                             // Sort
            .collect(Collectors.toList());        // Terminate

        System.out.println(result); // [ALEX, ALICE, ANNA]
    }
}

## 4. Why use Streams?

* Declarative: The code reads like a sentence ("Filter this, then map that...").
* Parallelism: You can turn a regular stream into a parallel stream by simply calling .parallelStream(), allowing Java to use multiple CPU cores automatically.
* No Side Effects: Streams do not modify the original collection; they produce a new result.

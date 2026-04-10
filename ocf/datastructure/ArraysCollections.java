In Java, data is organized using Arrays for fixed-size storage and the Collections Framework (java.util) for dynamic, flexible structures. [1, 2, 3] 
## 1. Arrays (Fixed Size)
Arrays are basic containers with a set length. They store elements of the same type and use zero-based indexing. [4, 5, 6, 7, 8] 

* Create: int[] nums = {3, 1, 2}; or int[] nums = new int[3];.
* Retrieve/Update: Use brackets: int val = nums[0]; or nums[0] = 5;.
* Sort: Use the static [Arrays.sort()](https://www.w3schools.com/java/ref_arrays_sort.asp) method.

Arrays.sort(nums); // Result: [1, 2, 3]

[4, 9, 10, 11, 12] 

------------------------------
## 2. The Collections Framework (Dynamic)
Unlike arrays, collections grow and shrink automatically at runtime. [2, 13, 14, 15, 16] 

| Collection [1, 5, 17, 18, 19, 20, 21, 22] | Core Feature | Primary Implementation |
|---|---|---|
| List | Ordered, allows duplicates. | ArrayList |
| Set | Unordered, unique elements only. | HashSet |
| Map | Key-Value pairs; unique keys. | HashMap |
| Deque | Double-ended queue (add/remove from both ends). | ArrayDeque |

## Common Operations

| Action [18, 21, 23, 24, 25] | List / Set / Deque | Map |
|---|---|---|
| Add | .add(element) | .put(key, value) |
| Remove | .remove(element) | .remove(key) |
| Retrieve | .get(index) (List only) | .get(key) |
| Update | .set(index, element) (List only) | .put(existingKey, newValue) |

## Sorting Collections
To sort a List, use [Collections.sort()](https://www.geeksforgeeks.org/java/collections-sort-java-examples/) or the modern list.sort(null). [9, 26, 27] 

* Note: Set and Map are generally not sortable in-place. Use TreeSet or TreeMap if you need elements to stay sorted automatically. [1, 17, 28] 

------------------------------
## Code Demo: Working with Collections

import java.util.*;
public class CollectionExample {
    public static void main(String[] args) {
        // List: Ordered & Duplicate-friendly
        List<String> list = new ArrayList<>(List.of("C", "A", "B"));
        list.add("A");            // Adds duplicate
        Collections.sort(list);   // Result: [A, A, B, C]

        // Set: Unique elements only
        Set<String> set = new HashSet<>(list); // Result: [A, B, C] (removes duplicates)

        // Map: Key-Value pairs
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        String val = map.get(1);  // Retrieve by key

        // Deque: Fast add/remove at both ends
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Bottom");
        stack.push("Top");
        String popped = stack.pop(); // Returns "Top"
    }
}

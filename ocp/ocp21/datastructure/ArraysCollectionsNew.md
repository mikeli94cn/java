Working with **Arrays and Collections** is fundamental in Java for storing and manipulating groups of data. Java provides both **low-level arrays** and high-level **Collection Framework** structures like `List`, `Set`, `Map`, and `Deque`.

Let’s go step by step.

---

# 1. **Arrays (Basic Data Structure)**

### Creating Arrays

```java
int[] numbers = new int[5];          // fixed size
int[] nums = {1, 2, 3, 4, 5};       // initialization
```

### Access / Update

```java
System.out.println(nums[0]); // get element
nums[0] = 10;               // update
```

### Iterate

```java
for (int n : nums) {
    System.out.println(n);
}
```

### Sorting

```java
import java.util.Arrays;

Arrays.sort(nums); // ascending
```

⚠️ Arrays:

* Fixed size
* Can store primitives directly
* Less flexible than collections

---

# 2. **Collections Framework Overview**

Main interfaces:

```
Collection
├── List (ordered, allows duplicates)
├── Set (no duplicates)
└── Queue / Deque (FIFO / double-ended)

Map (separate hierarchy: key-value pairs)
```

---

# 3. **List (Ordered, Allows Duplicates)**

### Common implementations:

* `ArrayList` (most used)
* `LinkedList`

### Create List

```java
import java.util.*;

List<String> list = new ArrayList<>();
```

### Add / Insert

```java
list.add("Apple");
list.add("Banana");
list.add(1, "Orange"); // insert at index
```

### Retrieve

```java
System.out.println(list.get(0));
```

### Update

```java
list.set(0, "Mango");
```

### Remove

```java
list.remove("Banana"); // by value
list.remove(0);        // by index
```

### Iterate

```java
for (String item : list) {
    System.out.println(item);
}
```

### Sort

```java
Collections.sort(list); // natural order
```

---

# 4. **Set (No Duplicates)**

### Common implementations:

* `HashSet` (fast, no order)
* `LinkedHashSet` (insertion order)
* `TreeSet` (sorted)

### Create Set

```java
Set<Integer> set = new HashSet<>();
```

### Add

```java
set.add(1);
set.add(2);
set.add(2); // ignored (duplicate)
```

### Remove

```java
set.remove(1);
```

### Check / Retrieve

```java
System.out.println(set.contains(2));
```

### Iterate

```java
for (int n : set) {
    System.out.println(n);
}
```

### Sort (TreeSet)

```java
Set<Integer> sortedSet = new TreeSet<>(set);
```

---

# 5. **Map (Key-Value Pairs)**

### Common implementations:

* `HashMap` (fast, no order)
* `LinkedHashMap` (insertion order)
* `TreeMap` (sorted by key)

### Create Map

```java
Map<String, Integer> map = new HashMap<>();
```

### Put (Add / Update)

```java
map.put("Alice", 90);
map.put("Bob", 85);
map.put("Alice", 95); // update
```

### Retrieve

```java
System.out.println(map.get("Alice"));
```

### Remove

```java
map.remove("Bob");
```

### Iterate

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### Check

```java
map.containsKey("Alice");
map.containsValue(95);
```

---

# 6. **Deque (Double-Ended Queue)**

### Common implementation:

* `ArrayDeque`

### Create

```java
Deque<Integer> deque = new ArrayDeque<>();
```

### Add (both ends)

```java
deque.addFirst(1);
deque.addLast(2);
```

### Retrieve

```java
System.out.println(deque.getFirst());
System.out.println(deque.getLast());
```

### Remove

```java
deque.removeFirst();
deque.removeLast();
```

### Use as Stack (LIFO)

```java
deque.push(10);
deque.pop();
```

### Use as Queue (FIFO)

```java
deque.offer(20);
deque.poll();
```

---

# 7. **Sorting Collections**

### List Sorting

```java
Collections.sort(list); // natural order
```

### Custom Sorting

```java
list.sort((a, b) -> a.length() - b.length());
```

### Map Sorting (by key)

```java
Map<String, Integer> sortedMap = new TreeMap<>(map);
```

---

# 8. **Arrays vs Collections**

| Feature     | Array   | Collections     |
| ----------- | ------- | --------------- |
| Size        | Fixed   | Dynamic         |
| Performance | Faster  | Slight overhead |
| Flexibility | Low     | High            |
| Utilities   | Limited | Rich API        |

---

# 9. **Common Operations Summary**

| Operation | Array     | List | Set           | Map     | Deque |
| --------- | --------- | ---- | ------------- | ------- | ----- |
| Add       | ❌ (fixed) | ✅    | ✅             | ✅ (put) | ✅     |
| Remove    | ❌         | ✅    | ✅             | ✅       | ✅     |
| Update    | ✅         | ✅    | ❌             | ✅       | ❌     |
| Retrieve  | ✅         | ✅    | ⚠️ (no index) | ✅ (key) | ✅     |
| Sort      | ✅         | ✅    | TreeSet       | TreeMap | ❌     |

---

# 10. **Best Practices**

### ✅ Use `ArrayList` for most cases

### ✅ Use `HashSet` for uniqueness

### ✅ Use `HashMap` for key-value storage

### ✅ Use `Deque` instead of `Stack`

### ❌ Avoid:

```java
Vector, Hashtable, Stack  // legacy classes
```

---

# 11. **Complete Example**

```java
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        // List
        List<String> list = new ArrayList<>(List.of("C", "A", "B"));
        Collections.sort(list);
        System.out.println(list);

        // Set
        Set<Integer> set = new HashSet<>(Set.of(3, 1, 2));
        System.out.println(set);

        // Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        System.out.println(map);

        // Deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque);
    }
}
```

---

# ✅ Summary

* **Arrays**: fixed-size, fast, simple
* **List**: ordered, duplicates allowed
* **Set**: unique elements
* **Map**: key-value pairs
* **Deque**: flexible queue/stack

---

If you want, I can next explain:

* **internal implementations (ArrayList vs LinkedList)**
* **time complexity (Big-O) of operations**
* or **how collections are used in real frameworks like Spring**

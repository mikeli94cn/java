When you process data concurrently in Java, the goal is to **use multiple CPU cores safely and efficiently**. Two major tools for this are:

* **Concurrent collections**
* **Parallel streams**

Let’s go step by step.

---

# 🔹 1. Processing Collections Concurrently

## ❌ Problem with Normal Collections

```java
List<Integer> list = new ArrayList<>();
```

If multiple threads modify this:

```java
list.add(1);
```

👉 You can get:

* Data corruption
* Exceptions
* Lost updates

---

## ✅ Solution: Concurrent Collections

### 📦 ConcurrentHashMap

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

map.put("A", 1);
map.compute("A", (k, v) -> v + 1); // thread-safe
```

✔ Allows multiple threads
✔ High performance (no global lock)

---

### 📦 CopyOnWriteArrayList

```java
List<String> list = new CopyOnWriteArrayList<>();

list.add("A");
```

✔ Safe for concurrent reads
❌ Expensive for frequent writes

---

### 📦 Blocking Queues (Producer–Consumer)

```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

// Producer
queue.put(1);

// Consumer
int value = queue.take();
```

✔ Built-in thread coordination
✔ No manual locking

---

# 🔹 2. Parallel Streams

Java 8 introduced **parallel streams** for easy data parallelism.

---

## ✅ Basic Example

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

numbers.parallelStream()
       .forEach(System.out::println);
```

👉 Runs across multiple threads automatically

---

## 🔍 How It Works

* Uses **Fork/Join framework**
* Splits data into chunks
* Processes in parallel
* Merges results

---

# 🔹 3. Sequential vs Parallel

```java
numbers.stream()         // sequential
numbers.parallelStream() // parallel
```

Or:

```java
numbers.stream().parallel()
```

---

# 🔹 4. Real Example: Parallel Computation

```java
int sum = List.of(1,2,3,4,5)
    .parallelStream()
    .mapToInt(Integer::intValue)
    .sum();
```

✔ Automatically parallelized
✔ Clean and simple

---

# 🔹 5. ⚠️ Common Bugs with Parallel Streams

---

## 🔴 1. Shared Mutable State (VERY common)

### ❌ Wrong:

```java
List<Integer> result = new ArrayList<>();

numbers.parallelStream().forEach(n -> {
    result.add(n);  // NOT thread-safe
});
```

👉 Race condition!

---

## ✅ Fix: Use Collectors

```java
List<Integer> result =
    numbers.parallelStream()
           .collect(Collectors.toList());
```

✔ Thread-safe reduction

---

---

## 🔴 2. Non-Associative Operations

Parallel streams require **associative operations**

### ❌ Wrong:

```java
numbers.parallelStream()
       .reduce(0, (a, b) -> a - b); // incorrect
```

👉 Order matters → wrong result

---

## ✅ Correct:

```java
numbers.parallelStream()
       .reduce(0, Integer::sum);
```

---

---

## 🔴 3. Performance Misuse

Parallel is NOT always faster.

❌ Bad cases:

* Small datasets
* Heavy synchronization
* I/O-bound tasks

---

## ✅ Good cases:

* Large datasets
* CPU-bound tasks
* Independent operations

---

# 🔹 6. Combining Concurrent Collections + Parallel Streams

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

List<String> words = List.of("a", "b", "a", "c");

words.parallelStream().forEach(word -> {
    map.merge(word, 1, Integer::sum);
});
```

✔ Thread-safe
✔ Parallel counting

---

# 🔹 7. Advanced: Custom Thread Pool (Parallel Streams)

By default:

* Uses **common ForkJoinPool**

You can customize:

```java
ForkJoinPool pool = new ForkJoinPool(4);

pool.submit(() ->
    numbers.parallelStream().forEach(System.out::println)
).get();
```

---

# 🔹 8. Best Practices

---

## ✅ DO:

* Use **stateless operations**
* Use **collect() instead of shared mutation**
* Use **ConcurrentHashMap for shared data**
* Test performance before using parallel

---

## ❌ DON’T:

* Modify shared variables inside streams
* Use blocking I/O in parallel streams
* Assume parallel = faster

---

# 🔹 9. Simple Mental Model

* **Concurrent collections** → safe shared data
* **Parallel streams** → parallel computation
* Combine both → scalable systems

---

# ✅ Final Summary

* Use concurrent collections like:

  * `ConcurrentHashMap`
  * `CopyOnWriteArrayList`
* Use `parallelStream()` for easy parallelism
* Avoid shared mutable state
* Prefer functional-style operations (`map`, `reduce`, `collect`)
* Always consider performance trade-offs

---

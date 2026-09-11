Practicing these features in `jshell` is one of the fastest ways to become comfortable with modern Java. The key idea is:

```text
small experiments → immediate feedback → repetition
```

Below is a practical learning roadmap with exercises you can type directly into `jshell`.

---

# 🚀 Start JShell

```bash
jshell
```

For Java 21 preview features:

```bash
jshell --enable-preview
```

---

# 1️⃣ Practice Collections

Goal:

* understand List / Set / Map operations
* immutable vs mutable collections
* iteration and manipulation

---

# 🧪 Exercise 1 — Create Collections

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

Set<Integer> nums = Set.of(1, 2, 3);

Map<String, Integer> scores =
    Map.of("Alice", 90, "Bob", 85);
```

Inspect:

```java
names
scores
```

---

# 🧪 Exercise 2 — Mutable Collections

```java
var list = new ArrayList<String>();

list.add("Java");
list.add("Python");

list.remove("Python");

list
```

---

# 🧪 Exercise 3 — Loop Collections

```java
for (String s : list) {
    System.out.println(s);
}
```

---

# 🧪 Exercise 4 — Sorting

```java
var nums = new ArrayList<>(List.of(5,2,9,1));

Collections.sort(nums);

nums
```

---

# 🎯 Collection Skills to Practice

✅ List vs Set vs Map
✅ mutable vs immutable
✅ sorting
✅ iteration
✅ generics

---

# 2️⃣ Practice Streams

Streams are best learned interactively.

---

# 🧪 Exercise 1 — map()

```java
List.of(1,2,3,4)
    .stream()
    .map(x -> x * 2)
    .toList()
```

Result:

```text
[2, 4, 6, 8]
```

---

# 🧪 Exercise 2 — filter()

```java
List.of(1,2,3,4,5,6)
    .stream()
    .filter(x -> x % 2 == 0)
    .toList()
```

---

# 🧪 Exercise 3 — reduce()

```java
List.of(1,2,3,4)
    .stream()
    .reduce(0, Integer::sum)
```

---

# 🧪 Exercise 4 — sorting()

```java
List.of("ccc", "a", "bb")
    .stream()
    .sorted()
    .toList()
```

---

# 🧪 Exercise 5 — groupingBy()

```java
import java.util.stream.Collectors;

List.of("apple", "ape", "banana")
    .stream()
    .collect(Collectors.groupingBy(
        s -> s.charAt(0)
    ))
```

---

# 🎯 Stream Skills to Practice

✅ map
✅ filter
✅ reduce
✅ collect
✅ grouping
✅ sorting

---

# 3️⃣ Practice Lambdas

Lambdas become natural through repetition.

---

# 🧪 Exercise 1 — Simple Lambda

```java
(x) -> x * 2
```

---

# 🧪 Exercise 2 — Functional Interface

```java
Function<Integer,Integer> doubler =
    x -> x * 2;

doubler.apply(5)
```

---

# 🧪 Exercise 3 — Predicate

```java
Predicate<String> longName =
    s -> s.length() > 5;

longName.test("Java")
```

---

# 🧪 Exercise 4 — Comparator

```java
var names =
    new ArrayList<>(List.of("Bob","Alice","Tom"));

names.sort((a,b) -> a.length() - b.length());

names
```

---

# 🎯 Lambda Skills

✅ Function
✅ Predicate
✅ Consumer
✅ Supplier
✅ Comparator

---

# 4️⃣ Practice Records (Java 16+)

Records are GREAT in JShell.

---

# 🧪 Exercise 1 — Simple Record

```java
record Person(String name, int age) {}
```

Create:

```java
var p = new Person("Mike", 20);

p.name()
p.age()
```

---

# 🧪 Exercise 2 — Equality

```java
new Person("Mike",20)
    .equals(new Person("Mike",20))
```

---

# 🧪 Exercise 3 — toString()

```java
p
```

Automatic output:

```text
Person[name=Mike, age=20]
```

---

# 🎯 Record Skills

✅ immutable data
✅ auto-generated methods
✅ concise models

---

# 5️⃣ Practice Pattern Matching

Java 21 significantly improves this.

---

# 🧪 Exercise 1 — instanceof Pattern Matching

```java
Object obj = "hello";

if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

---

# 🧪 Exercise 2 — switch Pattern Matching

```java
Object obj = 123;

switch (obj) {
    case String s ->
        System.out.println("String: " + s);

    case Integer i ->
        System.out.println("Integer: " + i);

    default ->
        System.out.println("Unknown");
}
```

---

# 🧪 Exercise 3 — Record Pattern

Java 21 preview:

```java
record Point(int x, int y) {}

Object obj = new Point(3,4);

if (obj instanceof Point(int x, int y)) {
    System.out.println(x + y);
}
```

---

# 🎯 Pattern Matching Skills

✅ cleaner casting
✅ type-safe switch
✅ record destructuring

---

# 6️⃣ Practice Virtual Threads (Java 21)

This is one of the MOST important Java 21 features.

---

# 🧪 Exercise 1 — Simple Virtual Thread

```java
Thread.startVirtualThread(() -> {
    System.out.println("Hello virtual thread");
});
```

---

# 🧪 Exercise 2 — Many Threads

```java
for (int i = 0; i < 1000; i++) {
    Thread.startVirtualThread(() -> {
        System.out.println(Thread.currentThread());
    });
}
```

Traditional threads would be expensive.

---

# 🧪 Exercise 3 — Sleep

```java
Thread.startVirtualThread(() -> {
    try {
        Thread.sleep(1000);
        System.out.println("done");
    } catch (Exception e) {}
});
```

---

# 🧪 Exercise 4 — Executor

```java
try (var executor =
        Executors.newVirtualThreadPerTaskExecutor()) {

    for (int i = 0; i < 5; i++) {
        executor.submit(() -> {
            System.out.println(Thread.currentThread());
            return null;
        });
    }
}
```

---

# 🎯 Virtual Thread Skills

✅ lightweight concurrency
✅ executors
✅ blocking simplicity
✅ thread-per-request model

---

# 7️⃣ Practice Date/Time API

The modern `java.time` API is excellent in JShell.

---

# 🧪 Exercise 1 — Current Date

```java
import java.time.*;

LocalDate.now()
```

---

# 🧪 Exercise 2 — Current Time

```java
LocalTime.now()
```

---

# 🧪 Exercise 3 — Current DateTime

```java
LocalDateTime.now()
```

---

# 🧪 Exercise 4 — Add/Subtract

```java
LocalDate.now().plusDays(10)

LocalDate.now().minusMonths(2)
```

---

# 🧪 Exercise 5 — Formatting

```java
import java.time.format.*;

LocalDate.now()
    .format(DateTimeFormatter.ISO_DATE)
```

---

# 🧪 Exercise 6 — Parse String

```java
LocalDate.parse("2026-05-17")
```

---

# 🧪 Exercise 7 — Duration

```java
Duration.between(
    LocalTime.of(10,0),
    LocalTime.of(12,30)
)
```

---

# 🎯 Date/Time Skills

✅ LocalDate
✅ LocalTime
✅ LocalDateTime
✅ formatting
✅ parsing
✅ Duration/Period

---

# 8️⃣ Best Practice Method

The BEST way to learn:

---

# 🔁 Modify Existing Examples

Start with:

```java
.stream().map(...)
```

Then change:

* input
* filter
* collector
* comparator

Experiment continuously.

---

# 🔁 Predict Before Running

Before pressing Enter:

* guess output
* then verify

This builds intuition FAST.

---

# 🔁 Combine Features

Example:

```java
record User(String name, int age) {}

List.of(
    new User("Alice",20),
    new User("Bob",30)
)
.stream()
.filter(u -> u.age() > 20)
.map(User::name)
.toList()
```

This combines:

* records
* streams
* lambdas

Excellent practice.

---

# 9️⃣ Recommended Daily Routine

Spend:

```text
20–30 minutes/day
```

in JShell.

Practice:

1. collections
2. streams
3. lambdas
4. records
5. virtual threads

Small daily practice works VERY well.

---

# 🔟 Great Real-World Exercises

Try building mini problems:

✅ word counter
✅ CSV parser
✅ employee filtering
✅ concurrent downloader simulation
✅ task scheduler
✅ date calculator

---

# 🧠 Most Important Tip

Don’t just read examples.

Type them yourself in JShell:

* modify them
* break them
* fix them
* experiment

That’s where real understanding happens.

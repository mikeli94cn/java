Great—this is where concurrency gets *real*. Let’s look at **common real-world bugs**, why they happen, and how to fix them with proper Java concurrency tools.

---

# 🔴 1. Race Condition (Lost Updates)

## ❌ Bug Example

```java
class Counter {
    int count = 0;

    void increment() {
        count++;   // not atomic
    }
}
```

### What happens?

Two threads:

```
Thread A: read 0 → +1 → write 1
Thread B: read 0 → +1 → write 1
```

👉 Final result = **1 instead of 2**

---

## ✅ Fix 1: `synchronized`

```java
synchronized void increment() {
    count++;
}
```

---

## ✅ Fix 2 (Better): Atomic

* AtomicInteger

```java
AtomicInteger count = new AtomicInteger();

void increment() {
    count.incrementAndGet();
}
```

✔ Faster
✔ Lock-free

---

# 🔴 2. Check-Then-Act Bug

## ❌ Bug Example

```java
if (!map.containsKey("key")) {
    map.put("key", 1);
}
```

### Problem:

Two threads may both pass the check → duplicate work

---

## ✅ Fix: Use Concurrent API

* ConcurrentHashMap

```java
map.putIfAbsent("key", 1);
```

Or:

```java
map.computeIfAbsent("key", k -> 1);
```

✔ Atomic operation
✔ No race condition

---

# 🔴 3. Double-Checked Locking (Broken Singleton)

## ❌ Bug Example

```java
class Singleton {
    private static Singleton instance;

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // unsafe
                }
            }
        }
        return instance;
    }
}
```

### Problem:

* Instruction reordering → partially constructed object

---

## ✅ Fix: `volatile`

```java
class Singleton {
    private static volatile Singleton instance;

    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

---

## ✅ Better Fix:

```java
class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

✔ Simple
✔ Safe

---

# 🔴 4. Deadlock

## ❌ Bug Example

```java
synchronized (lock1) {
    synchronized (lock2) {
        // ...
    }
}

synchronized (lock2) {
    synchronized (lock1) {
        // ...
    }
}
```

### What happens?

* Thread A holds `lock1`, waits for `lock2`
* Thread B holds `lock2`, waits for `lock1`

👉 💥 Deadlock (both stuck forever)

---

## ✅ Fix 1: Lock Ordering

```java
// always lock in same order
synchronized (lock1) {
    synchronized (lock2) {
    }
}
```

---

## ✅ Fix 2: Try-lock

* ReentrantLock

```java
if (lock.tryLock()) {
    try {
        // do work
    } finally {
        lock.unlock();
    }
}
```

---

# 🔴 5. Visibility Problem

## ❌ Bug Example

```java
boolean running = true;

void stop() {
    running = false;
}

void loop() {
    while (running) {
        // may never stop!
    }
}
```

### Problem:

* Thread may cache `running` → never sees update

---

## ✅ Fix: `volatile`

```java
volatile boolean running = true;
```

✔ Guarantees visibility across threads

---

# 🔴 6. Thread-Unsafe Collections

## ❌ Bug Example

```java
List<Integer> list = new ArrayList<>();

// multiple threads modifying
list.add(1);
```

👉 May cause:

* Data corruption
* `ConcurrentModificationException`

---

## ✅ Fix: Concurrent Collection

* CopyOnWriteArrayList

```java
List<Integer> list = new CopyOnWriteArrayList<>();
```

Or:

```java
Collections.synchronizedList(new ArrayList<>());
```

---

# 🔴 7. Blocking Too Much (Performance Bug)

## ❌ Bad Code

```java
synchronized void process() {
    // long I/O operation
}
```

👉 Blocks all threads unnecessarily

---

## ✅ Fix: Reduce Lock Scope

```java
void process() {
    synchronized (this) {
        // only critical part
    }
    // do I/O outside lock
}
```

---

# 🔴 8. Thread Leak (Forgetting to Shutdown)

## ❌ Bug Example

```java
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.submit(task);
// forgot shutdown
```

👉 Threads never released

---

## ✅ Fix

```java
executor.shutdown();
```

Or:

```java
executor.shutdown();
executor.awaitTermination(1, TimeUnit.MINUTES);
```

---

# 🔥 Real-World Summary Table

| Bug                | Cause            | Fix                    |
| ------------------ | ---------------- | ---------------------- |
| Race condition     | Non-atomic ops   | Atomic / synchronized  |
| Check-then-act     | Non-atomic logic | Concurrent API         |
| Deadlock           | Circular locks   | Lock ordering          |
| Visibility issue   | CPU caching      | `volatile`             |
| Unsafe collections | Shared mutation  | Concurrent collections |
| Thread leak        | No shutdown      | Proper lifecycle       |

---

# ✅ Final Takeaways

* Most bugs come from **shared mutable state**
* Prefer:

  * Immutable objects
  * Atomic classes
  * Concurrent collections
* Use locks **carefully and minimally**
* Think: *“Can two threads break this?”*

---

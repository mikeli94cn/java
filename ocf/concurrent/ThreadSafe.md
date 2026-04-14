Java concurrent programming is not just about running tasks in parallel—it’s about doing so **safely**. The key goal is to prevent **race conditions**, **data corruption**, and **inconsistent state**.

Let’s break this into three core parts:

---

# 🔹 1. What is Thread-Safe Code?

A piece of code is **thread-safe** if:

> Multiple threads can execute it **correctly** without interfering with each other.

---

## ❌ Example: NOT Thread-Safe

```java
class Counter {
    int count = 0;

    void increment() {
        count++;   // NOT safe
    }
}
```

Problem:

* `count++` is **not atomic**
* Multiple threads may overwrite each other

---

## ✅ Thread-Safe Version

```java
class Counter {
    private int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

---

# 🔹 2. Ways to Achieve Thread Safety

---

## ✅ 1. Immutability (Best approach)

Objects that never change are **always thread-safe**

```java
final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

✔ No synchronization needed
✔ Safe by design

---

## ✅ 2. Synchronization (`synchronized`)

### Method-level:

```java
synchronized void increment() {
    count++;
}
```

### Block-level:

```java
void increment() {
    synchronized (this) {
        count++;
    }
}
```

✔ Simple
❌ Can reduce performance (blocking)

---

## ✅ 3. Volatile (visibility guarantee)

```java
volatile boolean running = true;
```

✔ Ensures **visibility across threads**
❌ Does NOT guarantee atomicity

---

# 🔹 3. Locking Mechanisms

More flexible than `synchronized`

---

## 🔐 ReentrantLock

* ReentrantLock

```java
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

### Advantages:

* Try-lock (non-blocking)
* Interruptible locking
* Fairness option

---

## 🔄 ReadWriteLock

* ReentrantReadWriteLock

```java
ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

lock.readLock().lock();   // multiple readers allowed
lock.writeLock().lock();  // exclusive
```

✔ Great for read-heavy systems

---

# 🔹 4. Atomic Classes (Lock-Free)

* AtomicInteger

```java
AtomicInteger counter = new AtomicInteger(0);

counter.incrementAndGet();
```

✔ Faster than locks
✔ Uses **CAS (Compare-And-Swap)**

---

# 🔹 5. Concurrent Collections

Thread-safe alternatives to standard collections:

---

## 📦 ConcurrentHashMap

* ConcurrentHashMap

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
```

✔ No global locking
✔ High performance

---

## Other useful ones:

* `CopyOnWriteArrayList`
* `BlockingQueue`

---

# 🔹 6. Thread Coordination Tools

---

## 🔢 CountDownLatch

* CountDownLatch

```java
CountDownLatch latch = new CountDownLatch(3);

latch.countDown();
latch.await();  // wait until zero
```

---

## 🔁 Semaphore

* Semaphore

```java
Semaphore sem = new Semaphore(2);

sem.acquire();
try {
    // limited access
} finally {
    sem.release();
}
```

---

# 🔹 7. Using Executor + Thread-Safe Design

```java
import java.util.concurrent.*;

class SafeCounter {
    private final AtomicInteger count = new AtomicInteger();

    void increment() {
        count.incrementAndGet();
    }

    int get() {
        return count.get();
    }
}

public class Demo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        SafeCounter counter = new SafeCounter();

        for (int i = 0; i < 100; i++) {
            executor.submit(counter::increment);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(counter.get());
    }
}
```

---

# 🔹 8. Best Practices

### ✅ Prefer:

* Immutability
* Atomic classes
* Concurrent collections
* High-level APIs (Executor, CompletableFuture)

---

### ❌ Avoid:

* Excessive `synchronized`
* Sharing mutable state unnecessarily
* Manual thread management when possible

---

# 🔹 9. Common Problems

* Race condition
* Deadlock (locks waiting on each other)
* Starvation (threads never get CPU)
* Livelock (threads keep reacting but no progress)

---

# ✅ Final Summary

* Thread safety = correct behavior under concurrency
* Use:

  * `synchronized` (simple)
  * Locks (flexible)
  * Atomic classes (fast)
  * Concurrent collections (scalable)
* Prefer **designing safe code**, not just fixing it

---

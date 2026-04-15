Threads are the foundation of **concurrency** in Java—allowing your program to execute multiple tasks **simultaneously** (or seemingly so).

Let’s build a clear, structured understanding.

---

# 1. **What is a Thread?**

A **thread** is a **lightweight unit of execution** inside a process.

```text
Process (Java Program)
 ├── Thread 1 (main)
 ├── Thread 2
 └── Thread 3
```

👉 Every Java program starts with a **main thread**

---

# 2. **Why Use Threads?**

### ✅ Benefits

* Parallel tasks (e.g., downloading + UI)
* Better CPU utilization
* Improved performance for I/O-bound tasks

---

# 3. **Creating Threads in Java**

---

## 🔹 Method 1: Extend `Thread`

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // starts new thread
    }
}
```

---

## 🔹 Method 2: Implement `Runnable` (Recommended)

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
```

---

## 🔹 Method 3: Lambda (Modern Java)

```java
Thread t = new Thread(() -> {
    System.out.println("Lambda thread");
});
t.start();
```

---

# 4. **Thread Lifecycle**

```text
NEW → RUNNABLE → RUNNING → BLOCKED/WAITING → TERMINATED
```

---

## 🔹 States in Java

* `NEW` → created
* `RUNNABLE` → ready to run
* `BLOCKED` → waiting for lock
* `WAITING` → waiting indefinitely
* `TIMED_WAITING` → waiting with timeout
* `TERMINATED` → finished

---

# 5. **Key Thread Methods**

| Method        | Description               |
| ------------- | ------------------------- |
| `start()`     | starts new thread         |
| `run()`       | task logic                |
| `sleep(ms)`   | pause thread              |
| `join()`      | wait for thread to finish |
| `interrupt()` | interrupt thread          |

---

## Example:

```java
Thread t = new Thread(() -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {}
});
t.start();
t.join(); // wait
```

---

# 6. **Thread Synchronization (Important)**

When multiple threads access shared data → **race conditions**

---

## 🔹 Problem Example

```java
int counter = 0;

counter++; // not atomic ❌
```

---

## 🔹 Solution: `synchronized`

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

---

## 🔹 Synchronized Block

```java
synchronized (this) {
    count++;
}
```

---

# 7. **Volatile Keyword**

Ensures **visibility** between threads:

```java
volatile boolean running = true;
```

👉 Guarantees:

* changes visible to all threads

---

# 8. **Thread Communication**

---

## 🔹 wait() / notify()

```java
synchronized (obj) {
    obj.wait();   // release lock and wait
    obj.notify(); // wake up thread
}
```

---

# 9. **Executor Framework (Modern Approach)**

Instead of manually managing threads:

```java
import java.util.concurrent.*;

ExecutorService executor =
    Executors.newFixedThreadPool(2);

executor.submit(() -> {
    System.out.println("Task executed");
});

executor.shutdown();
```

---

## 🔹 Benefits

* Thread pooling
* Better resource management
* Easier to use

---

# 10. **Callable vs Runnable**

| Feature      | Runnable | Callable |
| ------------ | -------- | -------- |
| Return value | ❌        | ✅        |
| Exception    | ❌        | ✅        |

```java
Callable<Integer> task = () -> 42;

Future<Integer> future = executor.submit(task);
System.out.println(future.get());
```

---

# 11. **Common Concurrency Issues**

---

## ❌ Race Condition

Multiple threads modify shared data

## ❌ Deadlock

Threads wait for each other forever

```text
Thread A → lock1 → waits lock2
Thread B → lock2 → waits lock1
```

---

## ❌ Starvation

Thread never gets CPU

---

# 12. **Best Practices**

### ✅ Use `ExecutorService` instead of raw threads

### ✅ Minimize shared mutable state

### ✅ Use synchronization carefully

### ✅ Prefer high-level APIs:

* `java.util.concurrent`
* `Locks`
* `ConcurrentHashMap`

---

# 13. **Modern Java Concurrency (Important)**

### 🔹 Virtual Threads (Project Loom, Java 21+)

```java
Thread.startVirtualThread(() -> {
    System.out.println("Virtual thread");
});
```

👉 Lightweight threads → massive scalability

---

# 14. **Simple Example**

```java
public class ThreadDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}
```

---

# 15. **Summary**

* Thread = unit of execution
* Create via:

  * `Thread`
  * `Runnable`
  * `ExecutorService` (best)
* Use synchronization for shared data
* Avoid common pitfalls (race conditions, deadlocks)
* Modern Java → **Virtual Threads**

---

# ✅ Final Insight

👉 Old way: manual thread management
👉 Modern way: **ExecutorService + Virtual Threads**

---

If you want, I can next explain:

* **Locks vs synchronized (ReentrantLock, ReadWriteLock)**
* or **complete concurrency roadmap for interviews (very useful)**

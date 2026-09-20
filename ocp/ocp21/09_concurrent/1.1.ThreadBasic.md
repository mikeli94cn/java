In Java, a thread is the smallest unit of execution within a program, acting like a "virtual CPU" that can run code independently. 

Multithreading allows your application to perform multiple tasks concurrently, which is essential for responsive UIs and high-performance backend systems. 
## 1. Creating and Starting Threads
There are three common ways to define a task for a thread.

* Extending Thread Class: You create a subclass and override the run() method.
* Usage: Only if you aren't already extending another class.
* Implementing Runnable Interface: Pass a Runnable instance to a Thread constructor.
* Usage: Preferred for better separation of concerns and to avoid single inheritance limitations.
* Implementing Callable Interface: Similar to Runnable, but can return a result and throw checked exceptions.
* Usage: Used with ExecutorService when you need a result (via a Future object).

Critical Note: Always call thread.start() to begin execution. Calling thread.run() directly just executes the code in the current thread without creating a new one. 

## 2. The Thread Lifecycle
A Java thread moves through specific states managed by the JVM: 

* NEW: The thread object is created but start() has not been called.
* RUNNABLE: The thread is ready to run and waiting for CPU time from the scheduler.
* BLOCKED: The thread is waiting to acquire a monitor lock held by another thread.
* WAITING: The thread is waiting indefinitely for another thread to perform an action (e.g., via wait() or join()).
* TIMED_WAITING: The thread waits for a specific duration (e.g., Thread.sleep(1000)).
* TERMINATED: The thread has finished its run() method or encountered an uncaught exception.

## 3. Thread Safety and Synchronization
When multiple threads access shared data, you must ensure thread safety to prevent data corruption.

* synchronized keyword: Ensures only one thread can access a specific method or block of code at a time.
* volatile keyword: Guarantees that changes to a variable are immediately visible to all other threads.
* Atomic Variables: Classes like AtomicInteger provide lock-free, thread-safe operations on single variables.
* Locks: The [java.util.concurrent.locks](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/package-summary.html) package offers advanced tools like ReentrantLock for more control than the synchronized keyword.

## 4. Modern Management: The Executor Framework
Instead of manually creating new Thread() objects for every task—which is inefficient—use the Executor Framework (java.util.concurrent) to manage Thread Pools.

* FixedThreadPool: Reuses a set number of threads for all tasks.
* CachedThreadPool: Creates new threads as needed and reuses idle ones.
* SingleThreadExecutor: Ensures all tasks run sequentially in a single background thread.

// Modern approach using an ExecutorService
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Running in a pool!"));
executor.shutdown(); // Always shut down your executor

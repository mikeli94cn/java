/*
 * Threads are the foundation of concurrency in java -- allowing your program
 * to execute multiple tasks simultaneously (or seemingly so).
 * let's build a clear, structured understanding.
 * */

/* 
 * what is a thread?
 * a thread is lightweight unit of execution inside a process.
 * 
 * process (java program)
 * |
 * `---thread 1 (main)
 * |
 * `---thread 2
 * |
 * `---thread 3
 * 
 * every java program starts with a main thread.
 * */

/*
 * why use threads?
 * benefits
 * - parallel tasks (e.g. downloading + ui)
 * - better cpu utilization
 * - improved performance for i/o-bound tasks
 *
 * */

/*
 * creating threads in java
 * method 1: extend Thread
 * method 2: implement Runnable (recommended)
 * method 3: Lambda (modern java)
 * */

/*
 * 4. thread lifecycle
 * NEW -> RUNNABLE -> RUNNING -> BLOCKED/WAITING -> TERMINATED
 *
 * states in java
 * NEW : created
 * RUNNABLE : ready to run
 * BLOCKED : waiting for lock
 * WAITING : waiting indefinitely
 * TIMED_WAITING : waiting with timeout
 * TERMINATED: finished
 *
 * */

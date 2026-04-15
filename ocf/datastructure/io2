Java **NIO (New I/O)** introduces a more powerful, scalable, and flexible model compared to traditional `java.io`. Its core idea is:

> **Data is processed using Buffers, transferred via Channels, and multiplexed using Selectors.**

Let’s break down the **internals: Buffer → Channel → Selector** clearly.

---

# 1. **Buffer (Data Container)**

## 🔧 What is a Buffer?

A **Buffer** is a container that holds data in memory for reading or writing.

👉 Unlike streams, NIO works with **blocks of data**, not one byte at a time.

---

## 🔹 Key Buffer Types

* `ByteBuffer` (most important)
* `CharBuffer`
* `IntBuffer`, etc.

---

## 🔹 Core Properties

Every buffer has:

| Property   | Meaning                 |
| ---------- | ----------------------- |
| `capacity` | total size              |
| `position` | current index           |
| `limit`    | boundary for read/write |

---

## 🔹 Lifecycle (VERY IMPORTANT)

```java id="xyr8jq"
ByteBuffer buffer = ByteBuffer.allocate(10);

// Write mode
buffer.put((byte) 1);
buffer.put((byte) 2);

// Switch to read mode
buffer.flip();

while (buffer.hasRemaining()) {
    System.out.println(buffer.get());
}
```

---

## 🔁 Buffer State Diagram

```id="3o48hz"
Write Mode:
position → grows
limit = capacity

flip()

Read Mode:
position resets to 0
limit = last written position
```

---

## 🔹 Key Methods

| Method     | Purpose             |
| ---------- | ------------------- |
| `put()`    | write data          |
| `get()`    | read data           |
| `flip()`   | switch write → read |
| `clear()`  | reset buffer        |
| `rewind()` | reread data         |

---

# 2. **Channel (Data Transport)**

## 🔧 What is a Channel?

A **Channel** represents a connection to:

* File
* Socket
* Network

👉 It moves data **between Buffer and external source**

---

## 🔹 Key Channel Types

* `FileChannel`
* `SocketChannel`
* `ServerSocketChannel`
* `DatagramChannel`

---

## 🔹 Example: FileChannel

```java id="pgv5ik"
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class ChannelExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("file.txt");
        FileChannel channel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer); // read into buffer

        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        channel.close();
    }
}
```

---

## 🔹 Key Features

| Feature            | Description                 |
| ------------------ | --------------------------- |
| Bidirectional      | can read & write            |
| Faster             | uses OS-level optimizations |
| Works with buffers | not streams                 |

---

## 🔹 Zero-Copy (Advanced)

```java id="0wmkdt"
channel.transferTo(0, channel.size(), targetChannel);
```

👉 Data transferred directly by OS (no user-space copy)

---

# 3. **Selector (Multiplexing Engine)**

## 🔧 What is a Selector?

A **Selector** allows **one thread** to manage **multiple channels**.

👉 This is the foundation of **non-blocking I/O**

---

## 🔹 Why Selector?

Traditional I/O:

```id="92y8lh"
1 thread per connection ❌ (not scalable)
```

NIO:

```id="dof8fa"
1 thread handles many connections ✅
```

---

## 🔹 How It Works

1. Create selector
2. Register channels
3. Wait for events
4. Handle ready channels

---

## 🔹 Example (Simplified)

```java id="9s3fd3"
import java.nio.channels.*;
import java.util.*;

Selector selector = Selector.open();

// Register channel
ServerSocketChannel server = ServerSocketChannel.open();
server.configureBlocking(false);
server.register(selector, SelectionKey.OP_ACCEPT);

// Event loop
while (true) {
    selector.select(); // blocks until event occurs

    Set<SelectionKey> keys = selector.selectedKeys();

    for (SelectionKey key : keys) {
        if (key.isAcceptable()) {
            // handle new connection
        } else if (key.isReadable()) {
            // handle read
        }
    }

    keys.clear();
}
```

---

## 🔹 SelectionKey Events

| Event        | Meaning                |
| ------------ | ---------------------- |
| `OP_ACCEPT`  | new connection         |
| `OP_CONNECT` | connection established |
| `OP_READ`    | ready to read          |
| `OP_WRITE`   | ready to write         |

---

# 4. **Blocking vs Non-Blocking**

## Blocking (Traditional I/O)

```id="51jb9o"
read() → waits until data arrives ❌
```

## Non-Blocking (NIO)

```id="4eqmzx"
read() → returns immediately ✅
```

---

# 5. **How They Work Together**

## 🔁 Full Flow

```id="y7pgn2"
Channel → reads data → Buffer
Buffer → processed by program
Buffer → writes → Channel
```

## With Selector:

```id="u0a5dz"
Selector monitors Channels
↓
Channel ready event
↓
Read into Buffer
↓
Process data
```

---

# 6. **Real-World Architecture**

### Traditional Server:

```id="6dy15x"
Client → Thread → Blocking I/O
```

### NIO Server:

```id="u5d6y9"
Clients → Channels → Selector → Single Thread
```

👉 Used in:

* High-performance servers
* Netty framework
* Reactive systems

---

# 7. **Key Advantages of NIO**

### ✅ Scalability

* Thousands of connections with few threads

### ✅ Performance

* Less context switching
* Better CPU usage

### ✅ Flexibility

* Non-blocking, async-like behavior

---

# 8. **When to Use NIO**

### ✅ Use NIO when:

* High concurrency (servers, networking)
* Real-time systems
* Frameworks (Netty, Spring WebFlux)

### ❌ Avoid NIO when:

* Simple file operations
* Small applications

---

# 9. **Common Pitfalls**

### ❌ Forgetting `flip()`

→ buffer won’t read correctly

### ❌ Not clearing selected keys

```java id="y0kfy1"
keys.clear(); // important
```

### ❌ Mixing blocking and non-blocking modes

---

# 10. **Summary**

| Component    | Role                      |
| ------------ | ------------------------- |
| **Buffer**   | stores data               |
| **Channel**  | transports data           |
| **Selector** | manages multiple channels |

---

# ✅ Final Insight

👉 **Stream I/O (java.io)** = simple, blocking, sequential
👉 **NIO** = buffer-based, non-blocking, scalable

---

If you want, I can next explain:

* **Netty architecture (built on NIO)**
* or give a **complete NIO chat server example** (very helpful for interviews)

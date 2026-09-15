# 📦 Java Modules (JPMS) — Complete Introduction

Java Modules were introduced in Java 9 as the:

# Java Platform Module System (JPMS)

Goal:

* better encapsulation
* reliable dependencies
* smaller runtime images
* stronger security

---

# 1️⃣ Why Modules Exist

Before Java 9:

```text id="whv4l1"
classpath = giant bucket of classes
```

Problems:

* dependency conflicts
* no strong encapsulation
* hard to know dependencies
* internal APIs exposed

Modules solve this.

---

# 2️⃣ What is a Module?

A module is:

```text id="0l70x4"
group of packages + dependency declaration
```

Each module contains:

* packages
* resources
* `module-info.java`

---

# 3️⃣ Basic Module Structure

```text id="kdf2si"
project/
 ├── src/
 │    └── com.example.app/
 │         ├── module-info.java
 │         └── com/example/app/Main.java
```

---

# 4️⃣ module-info.java

This is the module descriptor.

Example:

```java id="c7spt2"
module com.example.app {
}
```

---

# 5️⃣ Exporting Packages

By default:

```text id="j61zcf"
packages are strongly encapsulated
```

Other modules cannot access them unless exported.

---

## Example

```java id="g69ujd"
module com.example.app {
    exports com.example.service;
}
```

Now other modules can use:

```java id="qg6f3m"
com.example.service
```

---

# 6️⃣ Module Dependency (`requires`)

Suppose:

```text id="a6f0jf"
Module A uses Module B
```

Then:

```java id="3o7jsj"
module com.example.app {
    requires com.example.library;
}
```

Equivalent to:

```text id="tt6mxy"
import dependency
```

---

# 7️⃣ Complete Example

---

## Library Module

### module-info.java

```java id="rtn3ch"
module com.example.library {
    exports com.example.library.api;
}
```

### Service Class

```java id="slfjlwm"
package com.example.library.api;

public class GreetingService {
    public void hello() {
        System.out.println("Hello");
    }
}
```

---

## Application Module

### module-info.java

```java id="l4g6en"
module com.example.app {
    requires com.example.library;
}
```

### Main

```java id="5mqo2u"
package com.example.app;

import com.example.library.api.GreetingService;

public class Main {
    public static void main(String[] args) {
        new GreetingService().hello();
    }
}
```

---

# 8️⃣ Reflection & `opens`

This is VERY important for frameworks.

---

## Problem

Frameworks like:

* Spring
* Hibernate
* Jackson

use reflection:

```java id="3c3z9s"
field.setAccessible(true)
```

But modules block deep reflection by default.

---

# 9️⃣ `opens` Package for Reflection

```java id="l4kfcg"
module com.example.app {
    opens com.example.model;
}
```

Meaning:

* reflective access allowed
* runtime frameworks can inspect fields/methods

---

# 🔟 Difference: `exports` vs `opens`

| Keyword   | Purpose                    |
| --------- | -------------------------- |
| `exports` | normal compile-time access |
| `opens`   | reflection access          |

---

## Example

```java id="iqb9n5"
exports com.example.api;
opens com.example.entity;
```

---

# 1️⃣1️⃣ `opens` to Specific Module

More secure:

```java id="b8j8h0"
opens com.example.entity to com.fasterxml.jackson.databind;
```

Only Jackson can reflectively access it.

---

# 1️⃣2️⃣ Open Entire Module

```java id="byo9hh"
open module com.example.app {
}
```

Meaning:

```text id="tyqk8q"
all packages open for reflection
```

Common in Spring Boot.

---

# 1️⃣3️⃣ Transitive Dependencies

Suppose:

```text id="ovp7ze"
App → Library → Utils
```

Without transitive:

* App must require both

---

## Example

```java id="luh9yx"
module com.example.library {
    requires transitive com.example.utils;
}
```

Now:

```text id="mjlwm0"
app automatically sees utils
```

---

# 1️⃣4️⃣ Static Dependencies

Optional dependency:

```java id="8zc3xg"
requires static lombok;
```

Used only at compile time.

---

# 1️⃣5️⃣ Services in Java Modules

Java modules support:

```text id="jlwmze"
Service Provider Interface (SPI)
```

Very important in:

* JDBC
* logging
* plugins
* frameworks

---

# 1️⃣6️⃣ Service Consumer

Interface:

```java id="y0mr10"
package com.example.spi;

public interface MessageService {
    void send(String msg);
}
```

---

## Consumer Module

```java id="fd20sq"
module com.example.consumer {
    uses com.example.spi.MessageService;
}
```

`uses` means:

```text id="6cqf5n"
I want implementations of this service
```

---

# 1️⃣7️⃣ Service Provider

Implementation:

```java id="nnvhmx"
package com.example.provider;

import com.example.spi.MessageService;

public class EmailService implements MessageService {
    public void send(String msg) {
        System.out.println(msg);
    }
}
```

---

## Provider Module

```java id="7kl0cs"
module com.example.provider {
    requires com.example.spi;

    provides com.example.spi.MessageService
        with com.example.provider.EmailService;
}
```

---

# 1️⃣8️⃣ Loading Services

Using `ServiceLoader`.

```java id="a1q3m7"
ServiceLoader<MessageService> loader =
    ServiceLoader.load(MessageService.class);

for (MessageService s : loader) {
    s.send("Hello");
}
```

---

# 1️⃣9️⃣ Service Architecture Diagram

```text id="1t6o1l"
Consumer
   ↓ uses
Interface (SPI)
   ↑ provides
Provider
```

---

# 2️⃣0️⃣ Common Module Keywords

| Keyword      | Meaning             |
| ------------ | ------------------- |
| `module`     | define module       |
| `requires`   | dependency          |
| `exports`    | expose package      |
| `opens`      | reflection access   |
| `uses`       | consume service     |
| `provides`   | provide service     |
| `transitive` | expose dependency   |
| `static`     | optional dependency |

---

# 2️⃣1️⃣ Compilation

Compile modules:

```bash id="r3bjlwm"
javac -d out --module-source-path src $(find src -name "*.java")
```

Run:

```bash id="ly9bns"
java --module-path out -m com.example.app/com.example.app.Main
```

---

# 2️⃣2️⃣ Real-World Usage

---

## Spring Boot

Usually:

```text id="lxl7n4"
modules rarely used fully
```

Because Spring heavily uses reflection.

Often:

```java id="o5c8dw"
open module my.app {
}
```

---

## Large Enterprise Systems

Modules help:

* plugin systems
* internal API protection
* microservice libraries

---

## JDK Itself Uses Modules

Example:

```text id="jlwm4v"
java.base
java.sql
java.xml
```

---

# 2️⃣3️⃣ Common Problems

---

## Reflection Errors

```text id="jlwm7o"
InaccessibleObjectException
```

Fix:

```java id="t2nsjlwm"
opens com.example.model;
```

---

## Split Packages

Two modules cannot contain same package.

❌ Invalid:

```text id="zjcv8j"
com.example.util in two modules
```

---

## Cyclic Dependencies

❌ Illegal:

```text id="wqv7jq"
A requires B
B requires A
```

---

# 2️⃣4️⃣ Best Practices

✅ Export only public API packages
✅ Keep internals hidden
✅ Use `opens` only when needed
✅ Use services for plugin architecture
✅ Avoid giant “god modules”

---

# 📊 Modules vs Classpath

| Feature                | Classpath | Modules |
| ---------------------- | --------- | ------- |
| Encapsulation          | Weak      | Strong  |
| Dependency declaration | No        | Yes     |
| Reflection control     | No        | Yes     |
| Reliable configuration | No        | Yes     |
| Runtime optimization   | Limited   | Better  |

---

# 🎯 Most Important Concepts

If preparing for interviews or enterprise Java:

Focus on:

1. `module-info.java`
2. `requires`
3. `exports`
4. `opens`
5. `ServiceLoader`
6. reflection issues with frameworks

---

# 🧠 Easy Mental Model

Think of modules like:

```text id="5u0thm"
mini-project boundaries with explicit visibility rules
```

Instead of:

```text id="1q3lyp"
everything visible to everyone
```

---

# 🚀 Minimal Realistic Example

```java id="hfjlwm"
module my.app {
    requires java.sql;

    exports com.myapp.api;

    opens com.myapp.entity to
        com.fasterxml.jackson.databind;

    uses com.myapp.spi.PaymentService;
}
```

This says:

* depend on JDBC
* expose public API
* allow Jackson reflection
* consume payment plugins

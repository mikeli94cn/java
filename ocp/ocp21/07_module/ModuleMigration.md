# 📦 Java Compilation, JARs, Modules, Runtime Images, and Migration to JPMS

This topic covers the complete lifecycle of modern Java applications:

```text id="8rdc5u"
Source Code
   ↓
Compile
   ↓
JARs (modular/non-modular)
   ↓
Modules
   ↓
Runtime Images
   ↓
Migration from classpath to module-path
```

This is a core topic in modern Java (Java 9+).

---

# 1️⃣ Compiling Java Code

---

# Traditional Compilation (Non-Modular)

Suppose:

```text id="jlwmel"
src/
 └── Hello.java
```

### Hello.java

```java id="fyjlwm"
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

Compile:

```bash id="jlwm3m"
javac Hello.java
```

Produces:

```text id="jlwm9n"
Hello.class
```

Run:

```bash id="jlwmxp"
java Hello
```

---

# 2️⃣ Compiling Multiple Files

```bash id="jlwm5r"
javac -d out src/*.java
```

`-d out`
means:

```text id="kwt1f9"
place compiled classes into output directory
```

---

# 3️⃣ Classpath (Old Java Model)

Before Java 9:

```bash id="jlwmk3"
java -cp libs/*:out Main
```

Everything loaded from:

```text id="jlwm5x"
classpath
```

Problems:

* dependency conflicts
* no encapsulation
* unreliable configuration

---

# 4️⃣ Creating Non-Modular JARs

---

## Step 1 — Compile

```bash id="6mjlwm"
javac -d out src/*.java
```

---

## Step 2 — Create JAR

```bash id="9jlwmh"
jar cf app.jar -C out .
```

Options:

* `c` = create
* `f` = file

---

# 5️⃣ Executable Non-Modular JAR

Create manifest:

```text id="5nl7o9"
Main-Class: Hello
```

Build:

```bash id="jlwm9y"
jar cfm app.jar MANIFEST.MF -C out .
```

Run:

```bash id="5jlwmx"
java -jar app.jar
```

---

# 6️⃣ Introduction to Modular Compilation

Java 9 introduced:

# JPMS (Java Platform Module System)

Each module contains:

```text id="9jlwmw"
module-info.java
```

---

# 7️⃣ Modular Project Structure

```text id="qjlwmw"
src/
 └── com.example.app/
      ├── module-info.java
      └── com/example/app/Main.java
```

---

# 8️⃣ module-info.java

```java id="kjlwmw"
module com.example.app {
}
```

---

# 9️⃣ Compiling Modular Code

```bash id="jlwm5t"
javac \
  -d out \
  --module-source-path src \
  $(find src -name "*.java")
```

---

# 🔟 Running Modular Applications

```bash id="qjlwm9"
java \
  --module-path out \
  -m com.example.app/com.example.app.Main
```

Syntax:

```text id="2jlwmw"
-m module/mainClass
```

---

# 1️⃣1️⃣ Creating Modular JARs

---

## Compile

```bash id="jlwm7m"
javac -d out --module-source-path src \
$(find src -name "*.java")
```

---

## Create Modular JAR

```bash id="3jlwmh"
jar --create \
    --file app.jar \
    -C out/com.example.app .
```

---

# 1️⃣2️⃣ Inspect Modular JAR

```bash id="jlwm3k"
jar --describe-module --file app.jar
```

Shows:

* module name
* exports
* requires

---

# 1️⃣3️⃣ Difference: Modular vs Non-Modular JAR

| Feature               | Non-Modular | Modular                |
| --------------------- | ----------- | ---------------------- |
| module-info.java      | ❌           | ✅                      |
| Strong encapsulation  | ❌           | ✅                      |
| Explicit dependencies | ❌           | ✅                      |
| Works on classpath    | ✅           | ⚠️ usually module-path |
| JPMS aware            | ❌           | ✅                      |

---

# 1️⃣4️⃣ Module Path vs Classpath

---

## Classpath

```bash id="xjlwm8"
java -cp libs/* Main
```

Old mechanism.

---

## Module Path

```bash id="rjlwm3"
java --module-path mods
```

JPMS-aware loading.

---

# 1️⃣5️⃣ Unnamed Module

VERY important for migration.

---

## What is Unnamed Module?

All old classpath code belongs to:

```text id="rjlwm5"
unnamed module
```

Meaning:

* non-modular legacy code
* still works after Java 9

---

## Example

```bash id="hjlwm1"
java -cp legacy.jar Main
```

`legacy.jar` becomes part of unnamed module.

---

# 1️⃣6️⃣ Rules of Unnamed Module

Unnamed module:

* can access ALL exported packages
* can read named modules
* named modules CANNOT reliably depend on unnamed module

Think:

```text id="jlwm1p"
compatibility bridge for old applications
```

---

# 1️⃣7️⃣ Automatic Modules

Another migration feature.

---

## Problem

You have:

```text id="jlwm0o"
old third-party jar
```

without:

```text id="jlwm6n"
module-info.java
```

But you want to use module-path.

---

## Solution: Automatic Module

Put old JAR on:

```bash id="9jlwm4"
--module-path
```

Java automatically converts it into a module.

---

# 1️⃣8️⃣ Automatic Module Naming

Example:

```text id="rjlwm2"
mysql-connector.jar
```

Becomes automatic module name:

```text id="6jlwmx"
mysql.connector
```

Or explicit:

```text id="hjlwm7"
Automatic-Module-Name
```

in MANIFEST.MF.

---

# 1️⃣9️⃣ Using Automatic Modules

```bash id="djlwm8"
java \
  --module-path libs \
  -m my.app/com.example.Main
```

Old jars on module-path become automatic modules.

---

# 2️⃣0️⃣ Properties of Automatic Modules

Automatic modules:

* export all packages
* read all modules
* bridge old/new systems

Good for migration.

---

# 2️⃣1️⃣ Migration Strategy to Modules

This is VERY important.

---

# Step 1 — Existing Legacy App

```text id="4jlwmf"
classpath only
```

No modules.

---

# Step 2 — Move Libraries to Module Path

Old jars become:

```text id="3jlwm9"
automatic modules
```

---

# Step 3 — Add module-info.java

Gradually modularize your app.

---

# Step 4 — Replace Legacy Libraries

Replace incompatible jars with true modular libraries.

---

# 2️⃣2️⃣ Hybrid Migration Example

```text id="4jlwm0"
modular app
   ↓
automatic modules
   ↓
unnamed module
```

Java supports mixed environments.

---

# 2️⃣3️⃣ Runtime Images with jlink

One of the BEST module features.

---

## Problem

Shipping full JDK is large.

---

## Solution

Create custom runtime.

```bash id="jlwm0y"
jlink \
  --module-path $JAVA_HOME/jmods:mods \
  --add-modules com.example.app \
  --output myruntime
```

Produces:

```text id="jlwm4e"
minimal Java runtime
```

---

# 2️⃣4️⃣ Benefits of jlink

✅ Smaller distribution
✅ Faster startup
✅ Better containers
✅ Better security
✅ Only needed modules included

---

# 2️⃣5️⃣ Running Custom Runtime

```bash id="tjlwm5"
myruntime/bin/java \
  -m com.example.app/com.example.app.Main
```

---

# 2️⃣6️⃣ jmod Files

JDK modules stored as:

```text id="vjlwm6"
.jmod
```

Located in:

```text id="7jlwmz"
$JAVA_HOME/jmods
```

Used by:

* jlink
* runtime generation

---

# 2️⃣7️⃣ jdeps Tool

Analyze dependencies.

Example:

```bash id="8jlwm3"
jdeps app.jar
```

Useful for:

* migration
* detecting internal API usage
* module planning

---

# 2️⃣8️⃣ Common Migration Problems

---

## Reflection Errors

```text id="6jlwm1"
InaccessibleObjectException
```

Fix:

```java id="2jlwm9"
opens com.example.model;
```

---

## Split Packages

❌ Illegal in JPMS:

```text id="7jlwmn"
same package in multiple modules
```

---

## Cyclic Dependencies

❌ Invalid:

```text id="5jlwm8"
A requires B
B requires A
```

---

# 2️⃣9️⃣ Real-World Reality

Most enterprise apps today:

* still partially modular
* or use unnamed modules

Common approach:

```text id="6jlwm2"
Spring Boot + classpath
```

Full JPMS adoption is limited but growing.

---

# 3️⃣0️⃣ Practical Enterprise Usage

---

## Common Today

| Technology        | Typical Packaging |
| ----------------- | ----------------- |
| Spring Boot       | Fat JAR           |
| Microservices     | Docker + JAR      |
| Desktop apps      | jpackage + jlink  |
| Libraries         | Modular JAR       |
| Legacy enterprise | WAR               |

---

# 📊 Compilation & Packaging Summary

| Concept          | Meaning                   |
| ---------------- | ------------------------- |
| `javac`          | compile source            |
| classpath        | old dependency system     |
| module-path      | JPMS dependency system    |
| unnamed module   | legacy compatibility      |
| automatic module | old jar treated as module |
| modular jar      | jar with module-info      |
| jlink            | custom runtime image      |
| jdeps            | dependency analyzer       |

---

# 🧠 Easy Mental Model

---

## Before Java 9

```text id="0jlwm1"
Everything mixed together
```

---

## After Java 9

```text id="8jlwm4"
Explicit module boundaries
```

---

# 🎯 Most Important Interview Topics

Know these VERY well:

✅ classpath vs module-path
✅ unnamed vs automatic modules
✅ module-info.java
✅ jlink runtime images
✅ modular jar creation
✅ migration strategy

---

# 🚀 Minimal Modern Example

```java id="1jlwm0"
module my.app {
    requires java.sql;

    exports com.myapp.api;

    opens com.myapp.entity;
}
```

Compile:

```bash id="8jlwm7"
javac --module-source-path src -d out ...
```

Run:

```bash id="3jlwm1"
java --module-path out \
     -m my.app/com.myapp.Main
```

Create runtime:

```bash id="4jlwm7"
jlink --add-modules my.app ...
```

# ☕ Introduction to JShell

`jshell` is Java’s:

# REPL (Read-Eval-Print Loop)

Introduced in:

* Java 9

It lets you:

* write Java code interactively
* execute code immediately
* experiment quickly
* learn APIs
* test snippets without creating full projects

Similar to:

* Python shell
* Node.js REPL
* Scala REPL

---

# 1️⃣ Starting JShell

Open terminal:

```bash id="kqjj3q"
jshell
```

You’ll see:

```text id="a9d5yh"
|  Welcome to JShell
```

Now you can type Java directly.

---

# 2️⃣ First Example

```java id="jlwmk9"
System.out.println("Hello");
```

Output:

```text id="u0k3xh"
Hello
```

No:

* class
* main method
* compilation step

required.

---

# 3️⃣ Variables

```java id="jlwmn2"
int x = 10;
```

JShell shows:

```text id="jlwm5a"
x ==> 10
```

Use variable:

```java id="5jlwmk"
x + 5
```

Result:

```text id="qg0c5r"
$2 ==> 15
```

---

# 4️⃣ Methods

Define methods directly:

```java id="yjlwm8"
int add(int a, int b) {
    return a + b;
}
```

Call:

```java id="9jlwmv"
add(3, 4)
```

---

# 5️⃣ Classes

```java id="1jlwmc"
class Person {
    String name;

    Person(String n) {
        name = n;
    }
}
```

Create object:

```java id="3jlwm0"
new Person("Mike")
```

---

# 6️⃣ Imports

```java id="6jlwmp"
import java.util.*;
```

Example:

```java id="xjlwm7"
List<String> names = List.of("A", "B");
```

---

# 7️⃣ Multi-Line Input

JShell supports multi-line automatically:

```java id="qjlwm1"
for (int i = 0; i < 3; i++) {
    System.out.println(i);
}
```

---

# 8️⃣ Useful JShell Commands

Commands begin with:

```text id="wjlwm2"
/command
```

---

# 9️⃣ `/help`

```bash id="zjlwm5"
/help
```

Shows all commands.

---

# 🔟 `/list`

Shows entered snippets.

```bash id="rjlwm7"
/list
```

---

# 1️⃣1️⃣ `/vars`

Show variables.

```bash id="fjlwm1"
/vars
```

Example output:

```text id="vjlwm0"
int x = 10
```

---

# 1️⃣2️⃣ `/methods`

Show methods.

```bash id="2jlwmq"
/methods
```

---

# 1️⃣3️⃣ `/types`

Show declared classes/interfaces.

```bash id="hjlwm2"
/types
```

---

# 1️⃣4️⃣ `/imports`

Show imports.

```bash id="8jlwmn"
/imports
```

---

# 1️⃣5️⃣ `/edit`

Open external editor.

```bash id="9jlwm0"
/edit
```

Very useful for longer code.

---

# 1️⃣6️⃣ `/save`

Save session to file.

```bash id="xjlwm4"
/save session.jsh
```

---

# 1️⃣7️⃣ `/open`

Load script:

```bash id="tjlwm2"
/open session.jsh
```

---

# 1️⃣8️⃣ `/reset`

Clear state:

```bash id="5jlwm4"
/reset
```

Removes:

* variables
* methods
* imports

---

# 1️⃣9️⃣ `/exit`

Exit JShell:

```bash id="7jlwm3"
/exit
```

---

# 2️⃣0️⃣ Expression Results

JShell automatically stores results:

```java id="1jlwm4"
5 + 3
```

Output:

```text id="4jlwm8"
$1 ==> 8
```

Use:

```java id="6jlwm8"
$1 * 2
```

---

# 2️⃣1️⃣ Autocompletion

Press:

```text id="3jlwm4"
TAB
```

Example:

```text id="1jlwm6"
System.out.pr<TAB>
```

Expands to:

```text id="8jlwm6"
System.out.println
```

---

# 2️⃣2️⃣ Documentation Lookup

Type:

```text id="9jlwm6"
List.
```

Then TAB.

Shows methods.

---

# 2️⃣3️⃣ Running External Classes/JARs

Add classpath:

```bash id="7jlwm0"
jshell --class-path mylib.jar
```

or inside JShell:

```bash id="4jlwm3"
/env -class-path mylib.jar
```

---

# 2️⃣4️⃣ Using JShell with Maven Dependencies

Often:

```bash id="6jlwm4"
jshell --class-path target/classes:lib/*
```

Useful for:

* testing APIs
* debugging libraries

---

# 2️⃣5️⃣ JShell Startup Script

Create initialization script:

```text id="3jlwm5"
startup.jsh
```

Run:

```bash id="5jlwm1"
jshell startup.jsh
```

---

# 2️⃣6️⃣ JShell and Snippets

JShell stores:

* variables
* methods
* classes

as:

```text id="8jlwm0"
snippets
```

You can:

* redefine them
* overwrite them dynamically

---

# 2️⃣7️⃣ Redefinition Example

```java id="9jlwm7"
int x = 10;
```

Later:

```java id="2jlwm3"
int x = 20;
```

JShell updates it automatically.

---

# 2️⃣8️⃣ Exception Handling

Example:

```java id="3jlwm2"
int x = 10 / 0;
```

Shows:

```text id="1jlwm7"
ArithmeticException
```

Useful for quick debugging.

---

# 2️⃣9️⃣ JShell vs Java Program

| Feature                  | JShell | Traditional Java |
| ------------------------ | ------ | ---------------- |
| Immediate execution      | ✅      | ❌                |
| main method needed       | ❌      | ✅                |
| Best for experimentation | ✅      | ⚠️               |
| Best for production apps | ❌      | ✅                |
| Fast testing             | ✅      | ⚠️               |

---

# 3️⃣0️⃣ Real-World Uses

JShell is excellent for:

✅ Learning Java
✅ Testing APIs
✅ Trying Stream operations
✅ Exploring collections
✅ Debugging small logic
✅ Experimenting with new JDK features

---

# 3️⃣1️⃣ Example: Streams in JShell

```java id="4jlwm9"
List.of(1,2,3,4)
    .stream()
    .map(x -> x * 2)
    .toList()
```

Result:

```text id="6jlwm0"
[2, 4, 6, 8]
```

Very convenient.

---

# 3️⃣2️⃣ Example: Date API

```java id="7jlwm8"
import java.time.*;

LocalDate.now()
```

---

# 3️⃣3️⃣ Example: HTTP Client (Java 11+)

```java id="1jlwm8"
var client = java.net.http.HttpClient.newHttpClient();
```

Great for API experimentation.

---

# 3️⃣4️⃣ JShell and Preview Features

Enable preview features:

```bash id="5jlwm0"
jshell --enable-preview
```

Useful for testing:

* pattern matching
* string templates
* new Java language features

---

# 3️⃣5️⃣ JShell with Java 21

Especially useful for testing:

* virtual threads
* records
* switch pattern matching

Example:

```java id="9jlwm2"
Thread.startVirtualThread(() ->
    System.out.println("Hello")
);
```

---

# 3️⃣6️⃣ Important Limitation

JShell is NOT ideal for:

* large applications
* package-heavy projects
* build systems
* production deployment

It’s mainly:

```text id="8jlwm5"
interactive experimentation tool
```

---

# 🎯 Most Useful Commands

| Command    | Purpose        |
| ---------- | -------------- |
| `/help`    | help           |
| `/list`    | show snippets  |
| `/vars`    | show variables |
| `/methods` | show methods   |
| `/types`   | show classes   |
| `/edit`    | open editor    |
| `/save`    | save session   |
| `/open`    | load session   |
| `/reset`   | clear state    |
| `/exit`    | quit           |

---

# 🧠 Easy Mental Model

Think of JShell as:

```text id="0jlwm0"
interactive Java playground
```

instead of:

```text id="6jlwm6"
full compile-run-build cycle
```

---

# 🚀 Recommended Practice

Try these in JShell:

✅ Collections
✅ Streams
✅ Lambdas
✅ Records
✅ Pattern matching
✅ Virtual threads
✅ Date/Time API

You’ll learn Java MUCH faster interactively.

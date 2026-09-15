To move from a traditional setup to a modern Java deployment, you need to understand the bridge between the old Classpath and the new Module Path.
## 1. Compiling and Creating JARs
Java supports two types of JARs. The structure of the code determines which one you get.

* Non-Modular JARs: Standard JARs without a module-info.class. These are treated as being on the "Classpath."
* Modular JARs: A JAR that contains a module-info.class at its root. These are placed on the "Module Path."

Compilation Command:
```bash
# Modular: Needs to know where other modules are
javac -d out --module-path lib src/module-info.java src/com/me/App.java
# Non-Modular: Uses the classic classpath
javac -d out -cp lib src/com/me/App.java
```
------------------------------
## 2. Migration: Unnamed and Automatic Modules
If you are moving a legacy project to Java 9+, you don't have to modularize everything at once. Java provides two "compatibility" modes:
## The Unnamed Module (Bottom-Up)
When you place a JAR on the Classpath, it becomes part of the Unnamed Module.

* Visibility: It can read every other module on the module path.
* Access: No other named module can "require" it. This is basically "legacy mode."

## Automatic Modules (Top-Down)
When you place a non-modular JAR on the Module Path, Java automatically turns it into an Automatic Module.

* Name: Derived from the JAR filename (e.g., mysql-connector-java-8.0.jar becomes mysql.connector.java).
* Exports: It exports all its packages.
* Reads: It can read all other modules, including the Unnamed Module.
* Usage: You can now requires mysql.connector.java; in your own module-info.java.

------------------------------
## 3. Creating Runtime Images with jlink
As discussed previously, jlink creates a custom, stripped-down JRE.
Crucial Requirement: jlink cannot package Unnamed Modules or Automatic Modules. To use jlink, every single dependency in your project must be a fully modularized JAR.
```bash
jlink --module-path $JAVA_HOME/jmods:mlib \
      --add-modules my.module.name \
      --output my-app-runtime
```
------------------------------
## 4. Comparison Table: Deployment Modes

| Mode | Location | Module Type | Dependency Handling |
|---|---|---|---|
| Legacy | Classpath | Unnamed | Manual (Fat JARs / -cp) |
| Migration | Module Path | Automatic | Uses JAR name as Module name |
| Modern | Module Path | Named | Explicit requires and exports |

## Summary of the Migration Path

   1. Start with everything on the Classpath (Unnamed Module).
   2. Move third-party libraries to the Module Path one by one (Automatic Modules).
   3. Add a module-info.java to your own code to make it a Named Module.
   4. Once all dependencies are Named Modules, use jlink to create a lightweight distribution.

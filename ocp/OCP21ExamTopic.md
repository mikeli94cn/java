**Handling Date, Time, Text, Numeric and Boolean Values**
- Use primitives and wrapper classes. Evaluate arithmetic and boolean expressions, using the Math API and by applying precedence rules, type conversions, and casting.
- Manipulate text, including text blocks, using String and StringBuilder classes.
- Manipulate date, time, duration, period, instant and time-zone objects including daylight saving time using Date-Time API.

**Controlling Program Flow**
- Create program flow control constructs including if/else, switch statements and expressions, loops, and break and continue statements.

**Using Object-Oriented Concepts in Java**
- Declare and instantiate Java objects including nested class objects, and explain the object life-cycle including creation, reassigning references, and garbage collection.
- Create classes and records, and define and use instance and static fields and methods, constructors, and instance and static initializers.
- Implement overloaded methods, including var-arg methods.
- Understand variable scopes, apply encapsulation, and create immutable objects. Use local variable type inference.
- Implement inheritance, including abstract and sealed types as well as record classes. Override methods, including that of the Object class. Implement polymorphism and differentiate between object type and reference type. Perform reference type casting, identify object types using the instanceof operator, and pattern matching with the instanceof operator and the switch construct.
- Create and use interfaces, identify functional interfaces, and utilize private, static, and default interface methods.
- Create and use enum types with fields, methods, and constructors.

**Handling Exceptions**
- Handle exceptions using try/catch/finally, try-with-resources, and multi-catch blocks, including custom exceptions.

**Working with Arrays and Collections**
- Create arrays, List, Set, Map and Deque collections, and add, remove, update, retrieve and sort their elements.

**Working with Streams and Lambda expressions**
- Use Java object and primitive Streams, including lambda expressions implementing functional interfaces, to create, filter, transform, process, and sort data.
- Perform decomposition, concatenation, and reduction, and grouping and partitioning on sequential and parallel streams.

**Packaging and Deploying Java Code**
- Define modules and expose module content, including that by reflection, and declare module dependencies, define services, providers, and consumers.
- Compile Java code, create modular and non-modular jars, runtime images, and implement migration to modules using unnamed and automatic modules.

**Managing Concurrent Code Execution**
- Create both platform and virtual threads. Use both Runnable and Callable objects, manage the thread lifecycle, and use different Executor services and concurrent API to run tasks.
- Develop thread-safe code, using locking mechanisms and concurrent API.
- Process Java collections concurrently and utilize parallel streams.

**Using Java I/O API**
- Read and write console and file data using I/O streams.
- Serialize and de-serialize Java objects.
- Construct, traverse, create, read, and write Path objects and their properties using the java.nio.file API.

**Implementing Localization**
- Implement localization using locales and resource bundles. Parse and format messages, dates, times, and numbers, including currency and percentage values.

**Assume the following:**
- Missing package and import statements: If sample code do not include package or import statements, and the question does not explicitly refer to these missing statements, then assume that all sample code is in the same package, or import statements exist to support them.
- No file or directory path names for classes: If a question does not state the file names or directory locations of classes, then assume one of the following, whichever will enable the code to compile and run:
  - All classes are in one file
  - Each class is contained in a separate file, and all files are in one directory
- Unintended line breaks: Sample code might have unintended line breaks. If you see a line of code that looks like it has wrapped, and this creates a situation where the wrapping is significant (for example, a quoted String literal has wrapped), assume that the wrapping is an extension of the same line, and the line does not contain a hard carriage return that would cause a compilation failure.
- Code fragments: A code fragment is a small section of source code presented without its context. Assume that all necessary supporting code exists and that the supporting environment fully supports the correct compilation and execution of the code shown and its omitted environment.
- Descriptive comments: Take descriptive comments, such as "setter and getters go here," at face value. Assume that correct code exists, compiles, and runs successfully to create the described effect.

**Candidates are also expected to:**
- Understand the basics of Java Logging API.
- Use Annotations such as Override, FunctionalInterface, Deprecated, SuppressWarnings, and SafeVarargs.
- Use generics, including wildcards.

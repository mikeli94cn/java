Since Java 9, the Java Platform Module System (JPMS) changed how we pack and deploy code. It moves away from the "global classpath" to a structured system of modules defined by a module-info.java file. [1, 2, 3, 4, 5] 
## 1. Defining a Module
A module is a collection of packages and resources. To turn a project into a module, you place a module-info.java file in the root source directory. [6, 7, 8, 9, 10] 

module com.myapp.display {
    // Content here defines the module's behavior
}

## 2. Controlling Visibility (Exposing Content)
By default, everything in a module is private to that module, even if the classes are public. [11, 12] 

* exports: Allows other modules to use the public types in a specific package at compile-time and runtime.
* opens: Grants reflection-only access to a package. This is used for frameworks (like Spring, Hibernate, or Jackson) that need to look at private fields but don't need to link against the code normally. [13, 14, 15, 16, 17] 

module com.myapp.display {
    exports com.myapp.display.api;      // Others can code against these
    opens com.myapp.display.internal;   // Hidden, but accessible via Reflection
}

## 3. Declaring Dependencies
You must explicitly state which other modules your code needs. [18] 

* requires: Specifies a dependency on another module.
* requires transitive: Any module that requires your module will also automatically get a dependency on the transitive one.
* requires static: A "compile-time only" dependency (optional at runtime). [19, 20, 21, 22, 23] 

module com.myapp.main {
    requires com.myapp.display;
    requires java.sql; // Uses the standard SQL module
}

## 4. Services: Providers and Consumers
Modules allow for a Service Provider Interface (SPI) pattern, which decouples the interface from the implementation. [24, 25] 

* Service Interface: A common interface (e.g., MessageService).
* provides...with: The module containing the implementation declares it provides the service.
* uses: The consuming module declares it will look for implementations of that service. [26, 27, 28, 29] 

The Provider:

module com.myapp.provider {
    requires com.myapp.api;
    provides com.myapp.api.MessageService with com.myapp.provider.EmailServiceImpl;
}

The Consumer:

module com.myapp.main {
    requires com.myapp.api;
    uses com.myapp.api.MessageService; // Declares intent to use the service
}

At runtime, the consumer uses ServiceLoader.load(MessageService.class) to find all available implementations. [30] 
## 5. Packing and Deploying
Once modularized, you can use specialized tools for deployment: [31] 

* jar: Create "Modular JARs" which include the module-info.class.
* jlink: A powerful tool that creates a custom runtime image. It strips away unused parts of the JDK, leaving only the modules your app needs. This can reduce a 200MB+ JRE down to a ~40MB standalone folder.
* jpackage: Packages the jlink output into a native installer (.exe, .dmg, .deb). [32, 33, 34, 35, 36] 

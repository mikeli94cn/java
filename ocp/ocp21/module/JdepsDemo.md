The jdeps (Java Dependency Analysis Tool) is an essential command-line utility for migrating legacy projects to the module system. It statically analyzes your bytecode to identify dependencies on other libraries and JDK-internal APIs. [1, 2, 3] 
## 1. Analyzing Dependencies
Before generating a module descriptor, use jdeps to see what your project actually depends on. [2, 4] 

* Summary View: Use -s or --summary to get a high-level view of which modules or JARs your code uses.
* Dependency List: Use --list-deps to see a specific list of module dependencies and any references to [internal JDK APIs](https://docs.oracle.com/en/java/javase/24/migrate/preparing-migration.html?embed=1). [1, 5, 6, 7] 

# Basic summary analysis
jdeps -s my-legacy-app.jar
# List all module dependencies
jdeps --list-deps my-legacy-app.jar

## 2. Generating module-info.java [8] 
You can use jdeps to create a first draft of your module descriptor based on its static analysis. [9, 10] 

* --generate-module-info <dir>: Generates module-info.java files for the specified JARs and places them in the target directory.
* Requirements: All direct dependencies of the JAR must be present on the [module path](https://docs.oracle.com/en/java/javase/12/docs/specs/man/jdeps.html) during this process, or the generation will fail. [7, 9, 11, 12] 

# Generate module descriptors into an 'out' directory
jdeps --module-path lib --generate-module-info out my-legacy-app.jar

## 3. Injecting the Module Info
After generating the module-info.java, you often need to compile it and "inject" it back into your legacy JAR to make it a fully modular JAR. [4, 13] 

   1. Compile: Use javac with the --patch-module flag to compile the new module-info.java against your existing JAR.
   2. Update JAR: Use the jar uf command to add the compiled .class file to your archive. [4, 13] 

## Summary of common jdeps options

| Option [1, 3, 11, 13, 14, 15, 16] | Purpose |
|---|---|
| -jdkinternals | Finds dependencies on private/internal JDK APIs that may break in newer Java versions. |
| -v or -verbose | Prints all class-level dependencies for a deep-dive analysis. |
| -R or -recursive | Recursively traverses all dependencies for the entire project. |
| --ignore-missing-deps | Allows the tool to complete analysis even if some secondary JARs are missing. |

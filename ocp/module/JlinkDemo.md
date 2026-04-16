To create a standalone executable using jlink, you must have your code compiled into a module. This process creates a "custom JRE" that contains only the parts of Java your app actually uses.
## Step 1: Compile the Module
Assume your source code is in src and your module name is com.example.app.
```bash
# Compile the java files into a 'mods' directory
javac -d mods --module-source-path src $(find src -name "*.java")
```
## Step 2: Create a Modular JAR
Package the compiled code into a JAR file.
```bash
# Create the mlars directory for our library
mkdir mlib
# Package the code
jar --create --file mlib/app@1.0.jar \
    --main-class com.example.app.Main \
    -C mods/com.example.app .
```
## Step 3: Run jlink to Build the Image
This is where the magic happens. jlink will look at your module-info dependencies and pull in only the necessary JDK modules (like java.base, java.sql, etc.).
```bash
jlink --module-path mlib:$JAVA_HOME/jmods \
      --add-modules com.example.app \
      --launcher run-app=com.example.app \
      --output my-custom-runtime \
      --compress 2 \
      --no-header-files \
      --no-man-pages
```
What these flags do:

* --module-path: Tells jlink where to find your JARs and the JDK's own modules.
* --launcher: Creates a script (named run-app) inside the output folder to start your app.
* --compress 2: Reduces the size of the final image significantly.
* --no-header-files / --no-man-pages: Strips out development files you don't need for production.

## Step 4: Run the Standalone App
You can now zip the my-custom-runtime folder and send it to someone who does not have Java installed. They can run it using:
```bash
./my-custom-runtime/bin/run-app
```
## The Result
Instead of a massive 200MB+ JDK, your folder will likely be between 30MB and 50MB, containing only your code and the absolute minimum Java internals required to run it.

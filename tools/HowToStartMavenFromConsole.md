To run your Maven project directly from the console without an IDE, you can use either the Maven Exec plugin or a compiled JAR file.

Here are the two easiest ways to do it, depending on whether you want a quick run during development or a portable package. Make sure you are inside your project's root directory (the folder containing pom.xml) before running these commands.

Method 1: Use Maven directly (Easiest for development)

You can use the exec-maven-plugin to run your Main class directly from your source files. Run the following command in your terminal:
```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```
* What it does: It automatically compiles your code and launches your Main class with the correct classpath configuration.

Method 2: Package into an executable JAR (Best for distribution)

If you want to run your program independently like a production application, you should bundle it into a runnable JAR file.

Step 1: Update your pom.xml

Maven needs to know which class contains your main method. Add the maven-jar-plugin inside the <build><plugins> section of your pom.xml:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>org.example.Main</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Step 2: Build and run the app

Execute these two commands in your terminal:
```bash
# 1. Clean old builds and bundle your app into a JAR
mvn clean package

# 2. Run the generated JAR file from the target directory
java -jar target/your-artifact-id-version.jar
```
(Note: Replace your-artifact-id-version.jar with the actual name of the file Maven generates inside your target folder).

⚠️ A Note on file paths (data.txt and students.txt)

Because you are running from the terminal at the root directory, your current working directory is ..
* If your Java code reads data.txt or students.txt using relative file paths like new FileReader("data.txt"), it will look for them in your root folder. This matches your current setup perfectly!
* If you ever run the JAR file from inside the target folder (cd target && java -jar ...), your program will look for the text files inside target instead and might throw a FileNotFoundException. Always execute your terminal commands from the project root to keep paths consistent.
Does your project require any external dependencies (like database drivers or JSON parsers) listed in your pom.xml? If so, let me know, because Method 2 will require a slightly different plugin configuration to bundle those dependencies!

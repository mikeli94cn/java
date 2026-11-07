![Image](https://images.openai.com/static-rsc-4/D2dd6iWyuX4r__J9P_l8vp8twmyD4kkxDWRBY7dqtrLv2c5yVsc6iVJsR_XOuHWtS5A0fgShI3vd4XNjuq8PlIXtHIe4Dy6DezfFMolZ6DBCelunpzStphl24BYvKdAykA67wUtmAWvYA1mQbyP7-DxNCa0Za__tV76DDDCGgdDkZdEGD0niT2nV2iz4-FA5?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/RdwWmT-q2TWA7wl2BOvNEtKzqHyrrrrECZoTgbjb1URFPuH3Fpu2fVEtUjDaChF6p-ScK06ZaaIrpFNDDnt11UOpgR5pNzDaa-LcWq3zc7zNPxCI2tvwBiupJQ7SiWaDfZiv1YMi2EMx-A8aKTeUipewmibBJbaYxe22740uwig4DOrR6SDyPyjKMyWhdnX7?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/2zKsXBuzH7pLoARqf78Vb1ZnynUgBYZmDK5ElOw9jFUmLnfZi7QNn7EuXzKrS8JVriIo6UrhLnqAPNp7bHEb_4ys_W8rfja5lJUQcQ3Gv5FIgM5i54jc5dJnVoWZ5JbrCPu2WFPjWw2SXyIepVAWRlpZvbTos5Zev66F2Doc_mnQ6QKrTDOnl9FuZiHfkov-?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/t_tdpG7aHSBR60w1a8D3wDdLWiYfUi_0z0jscAbnHV_WPkJDMsoKzDoCKdcAMzbW-5sHdJl-oybWxfxRM4Ql0ypCUJLimD-qG-l0x58cBg1MbZbUTLokhXlmu_UVJ9KF5_GcX7TM1JcIrEMAjPT2ZzH8qWPoxKlwvcvungK02GcRGimsNtwDqdg9ePF_FidS?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/rYORszYdmnCWio9_rtvm5BrYEjayZy73h5WZ2UdDtJ8IrpZ3TE_awlN-zKXCasysZscrR8y7krCYoC-ea1ftyUhDDPP35iDiIng1_B2k3qcHfdiQVPLRel4uxG8BP_gjtBrY25xH3q0_P6LPulCfAexJvcwI-1t86uNeS99hQgMWTCUm1GWP8VV8jS7f7gzu?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/9HnUCfRQuyXLvPLsDT-keW1lDi_hjMV1OnQBV8S2T2GpyZv134CFOoYgDx8yq4E6DZVlfOnOf19awNpuL3WsnSXAA9yD2F72ulwN5XtXSrhMup4PYB1maN03FS2Eof1Zjh3F7rr3K6cr_3xbm9bDdSruqVyw-sVA86ZMaCrg_fA3WGYyp7gDxIMDfidyDqu-?purpose=fullsize)

# What is Maven?

**Maven** is a **Java build automation and project management tool**.

Its main purposes are:

1. **Compile Java code**
2. **Manage dependencies (external libraries)**
3. **Run tests**
4. **Package applications**
5. **Manage project lifecycle**
6. **Standardize project structure**

A simple definition:

> Maven is a tool that describes a Java project using a `pom.xml` file and automatically downloads libraries, builds, tests, and packages the project.

---

# 1. Why do we need Maven?

Imagine a Java project without Maven.

Your project:

```
MyApp
 |
 |-- src
 |    |
 |    |-- Main.java
 |
 |-- lib
      |
      |-- mysql-driver.jar
      |-- jackson.jar
      |-- log4j.jar
```

You manually need to:

* Download jar files
* Put them into `lib`
* Configure classpath
* Compile:

```bash
javac -cp mysql.jar Main.java
```

Problems:

* Where do I get the correct jar version?
* What if a library needs another library?
* How do team members keep the same environment?
* How do I build on a CI server?

Maven solves these problems.

---

# 2. Maven history

Java build tools evolved:

```
1995
 |
 Java released

2000
 |
 Ant
 |
 Manual build scripts

2004
 |
 Maven 1.0
 |
 Convention + dependency management

2010+
 |
 Maven widely used in enterprise Java

Today
 |
 Maven + Gradle
 |
 Spring Boot ecosystem
```

---

# 3. Maven core idea

Maven uses:

## Convention over configuration

Instead of telling Maven:

```
compile files from:
    src/java/main

put output into:
    target/classes
```

Maven already knows the standard structure.

You follow the convention:

```
project
 |
 +-- src
 |    |
 |    +-- main
 |    |     |
 |    |     +-- java
 |    |     |
 |    |     +-- resources
 |    |
 |    +-- test
 |          |
 |          +-- java
 |
 +-- pom.xml
```

---

# 4. The Maven project structure

A typical Maven project:

```
hello-world
|
|-- pom.xml
|
|-- src
    |
    |-- main
    |    |
    |    |-- java
    |    |
    |    |-- resources
    |
    |
    |-- test
         |
         |-- java
```

Meaning:

| Directory          | Purpose                 |
| ------------------ | ----------------------- |
| src/main/java      | Application source code |
| src/main/resources | Configuration files     |
| src/test/java      | Test code               |
| target             | Build output            |

---

# 5. The most important file: pom.xml

`pom.xml` means:

> Project Object Model

It describes your project.

Example:

```xml
<project>

    <modelVersion>
        4.0.0
    </modelVersion>


    <groupId>
        com.example
    </groupId>


    <artifactId>
        hello
    </artifactId>


    <version>
        1.0
    </version>


</project>
```

This identifies your project:

```
groupId:    com.example
artifactId: hello
version:    1.0
```

Together:

```
com.example:hello:1.0
```

This is called:

**Maven coordinate**

---

# 6. Dependency management

This is Maven's killer feature.

Suppose you want Jackson JSON library.

Without Maven:

```
Download jackson.jar

Download jackson-core.jar

Download jackson-annotations.jar

Configure classpath
```

With Maven:

```xml
<dependencies>

    <dependency>

        <groupId>
            com.fasterxml.jackson.core
        </groupId>

        <artifactId>
            jackson-databind
        </artifactId>

        <version>
            2.17.0
        </version>

    </dependency>

</dependencies>
```

Maven automatically:

```
pom.xml

    |
    |
Maven Central Repository

    |
    |
Download jars

    |
    |
Local repository
```

---

# 7. Maven repositories

Maven has three important places.

## 1. Local repository

On your computer:

```
~/.m2/repository
```

Example:

```
.m2
 |
 +-- repository
       |
       +-- org
           |
           +-- springframework
```

Downloaded libraries are cached here.

---

## 2. Central repository

The public Maven repository:

```
Developer

   |
   |
Maven Central

   |
   |
Libraries
```

Example:

* Spring Framework
* Jackson
* JUnit
* MySQL driver

---

## 3. Remote repository

Companies can have private repositories:

```
Company Maven Repository

        |
        |
 Internal libraries
```

---

# 8. Maven build lifecycle

Maven defines standard phases.

The important ones:

```
validate

   |
compile

   |
test

   |
package

   |
verify

   |
install

   |
deploy
```

---

## compile

Compile Java:

```
src/main/java

       |
       v

target/classes
```

Command:

```bash
mvn compile
```

---

## test

Run tests:

```bash
mvn test
```

Example:

```
JUnit tests
      |
      v
Success / Failure
```

---

## package

Create application package:

```bash
mvn package
```

Output:

```
target/

hello-1.0.jar
```

---

## install

Install your jar locally:

```bash
mvn install
```

Result:

```
your jar

    |
    v

~/.m2/repository
```

Other local projects can use it.

---

## deploy

Upload to remote repository:

```bash
mvn deploy
```

Usually used in companies.

---

# 9. Maven commands cheat sheet

| Command               | Meaning                 |
| --------------------- | ----------------------- |
| `mvn clean`           | Delete target directory |
| `mvn compile`         | Compile code            |
| `mvn test`            | Run tests               |
| `mvn package`         | Create jar/war          |
| `mvn install`         | Install locally         |
| `mvn dependency:tree` | Show dependencies       |
| `mvn clean package`   | Clean then build        |

---

# 10. Maven dependency tree

A project rarely has only one dependency.

Example:

Your project:

```
My Application

 |
 +-- Spring Boot

       |
       +-- Spring Core

       |
       +-- Jackson

       |
       +-- Tomcat
```

Maven manages this graph.

Command:

```bash
mvn dependency:tree
```

Output:

```
my-app

+- spring-boot-starter-web

   +- spring-web

   +- jackson

   +- tomcat
```

---

# 11. Maven plugins

Maven itself is small.

Most work is done by plugins.

Architecture:

```
Maven

 |
 |
 Plugins

 |
 +-- compiler plugin
 |
 +-- test plugin
 |
 +-- jar plugin
```

Example:

Compile plugin:

```xml
<plugin>

<artifactId>
maven-compiler-plugin
</artifactId>

</plugin>
```

---

# 12. Maven and Java version

You usually configure:

```xml
<properties>

    <maven.compiler.source>
        21
    </maven.compiler.source>

    <maven.compiler.target>
        21
    </maven.compiler.target>

</properties>
```

Meaning:

Compile with Java 21.

---

# 13. Maven and Spring Boot

Modern Java backend:

```
Spring Boot Project

        |
        |
      Maven

        |
        |
 Dependencies

        |
 --------------------
 |        |          |
Spring  Jackson   MySQL
```

Example:

Spring Boot dependency:

```xml
<dependency>

<groupId>
org.springframework.boot
</groupId>

<artifactId>
spring-boot-starter-web
</artifactId>

</dependency>
```

Maven downloads:

```
Spring MVC

Embedded Tomcat

Jackson JSON

Logging
```

automatically.

---

# 14. Maven vs npm vs pip

Your previous comparison with JavaScript and Python is very accurate.

| Java          | JavaScript   | Python           |
| ------------- | ------------ | ---------------- |
| Maven         | npm          | pip              |
| pom.xml       | package.json | requirements.txt |
| jar           | node_modules | site-packages    |
| Maven Central | npm registry | PyPI             |

Conceptually:

```
           Package Manager

                 |
 ------------------------------------------------
 |                    |                         |
 Maven              npm                       pip

 Java              JavaScript                Python
```

---

# 15. Maven vs Gradle

Modern Java has two major build tools.

|               | Maven       | Gradle        |
| ------------- | ----------- | ------------- |
| Configuration | XML         | Groovy/Kotlin |
| Style         | Declarative | Programmatic  |
| Learning      | Easier      | More flexible |
| Enterprise    | Very common | Growing       |
| Spring Boot   | Excellent   | Excellent     |

Example:

Maven:

```xml
<dependency>
...
</dependency>
```

Gradle:

```groovy
implementation 'org.springframework.boot:spring-boot-starter-web'
```

---

# 16. Fresh-hand Maven learning roadmap

For a beginner:

## Step 1: Understand project structure

Create:

```
src/main/java
pom.xml
```

Learn:

* groupId
* artifactId
* version

---

## Step 2: Learn dependency management

Practice adding:

* JUnit
* Jackson
* MySQL driver

---

## Step 3: Learn lifecycle

Master:

```
compile
test
package
install
```

---

## Step 4: Learn plugins

Understand:

* compiler plugin
* jar plugin
* Spring Boot plugin

---

## Step 5: Build a real project

Example:

```
Spring Boot REST API

       |
       |
     Maven

       |
       |
 PostgreSQL

       |
       |
 Docker
```

---

# The big picture

A Java developer's tool chain usually looks like:

```
                 Java Source Code

                        |
                        v

                    Maven

                        |
        --------------------------------
        |              |               |
   Dependency      Compile          Test

                        |
                        v

                      Jar

                        |
                        v

                Spring Boot Application

                        |
                        v

                    Production
```

For someone learning **Java backend + Spring Boot**, Maven is the bridge between "writing Java code" and "building professional Java applications". The next natural topic after Maven is **"Spring Boot project anatomy: pom.xml, application.properties, main class, controller, service, repository, and how Maven starts the application"**.

---

# How to Install Apache Maven on Ubuntu

**Apache Maven** is a build automation and dependency management tool primarily used for Java projects.

Since you are learning **Java, Spring Boot, Hibernate, and MySQL**, Maven is an important part of your development environment.

I recommend installing Maven using Ubuntu's **APT package manager**. It is the simplest method and works well for most Java projects.

## 1. Check whether Maven is already installed

Open a terminal (`Ctrl + Alt + T`) and execute:

```bash
mvn -version
```

If Maven is installed, you will see output similar to:

```text
Apache Maven 3.9.x
Maven home: /usr/share/maven
Java version: 21.0.x
Java home: /usr/lib/jvm/java-21-openjdk-amd64
OS name: "linux"
```

If Maven is not installed, Ubuntu may display:

```text
Command 'mvn' not found
```

---

## 2. Install Maven using APT (Recommended)

### Step 1: Verify Java installation

Maven requires a Java Development Kit (JDK).

Check your Java version:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

If you haven't installed Java yet, I recommend OpenJDK 21:

```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

### Step 2: Install Maven

Update Ubuntu's package index:

```bash
sudo apt update
```

Install Maven:

```bash
sudo apt install maven
```

APT automatically installs Maven and its required dependencies.

### Step 3: Verify Maven installation

```bash
mvn -version
```

Example output:

```text
Apache Maven 3.9.x
Maven home: /usr/share/maven
Java version: 21.0.x
Java home: /usr/lib/jvm/java-21-openjdk-amd64
```

The actual Maven version depends on your Ubuntu release.

**Congratulations! Maven is installed.**

---

## 3. Understand Maven's directory structure

When Maven is installed using APT, its files are typically located in:

```text
/usr/share/maven/
```

You can check the Maven executable:

```bash
which mvn
```

Typical output:

```text
/usr/bin/mvn
```

To inspect the actual executable:

```bash
readlink -f "$(which mvn)"
```

Maven also uses a local repository to store downloaded dependencies.

The default location is:

```text
~/.m2/repository/
```

For example:

```text
/home/user/.m2/
├── repository/
│   ├── org/
│   │   └── springframework/
│   ├── com/
│   │   └── mysql/
│   └── junit/
└── settings.xml
```

The `settings.xml` file is optional and may not exist until you create it.

**Important distinction:**

- `/usr/share/maven/` contains the Maven installation.
- `~/.m2/repository/` stores downloaded Java dependencies.
- `pom.xml` defines an individual Maven project.

---

## 4. Understand Maven and pom.xml

Maven uses a configuration file named `pom.xml`.

POM stands for **Project Object Model**.

It describes your project, including its dependencies, build configuration, and plugins.

For example:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>hello-maven</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>21</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
```

Three important identifiers are:

| Element | Meaning | Example |
|---|---|---|
| `groupId` | Organization or project group | `com.example` |
| `artifactId` | Project name | `hello-maven` |
| `version` | Project version | `1.0-SNAPSHOT` |

Together, these identify a Maven artifact.

---

## 5. Create your first Maven project

Let's create a simple Java project to verify that Maven works.

### Step 1: Create a project

Execute:

```bash
mkdir -p ~/JavaProjects
cd ~/JavaProjects
```

Generate a Maven project:

```bash
mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=hello-maven \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.5 \
  -DinteractiveMode=false
```

Maven will download the required archetype and generate the project.

An *archetype* is a template used to create a Maven project.

### Step 2: Examine the project structure

```bash
cd hello-maven
```

Your project will look similar to:

```text
hello-maven/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── App.java
    └── test/
        └── java/
            └── com/
                └── example/
                    └── AppTest.java
```

Maven follows a standard directory structure.

| Directory | Purpose |
|---|---|
| `src/main/java` | Java source code |
| `src/main/resources` | Application resources |
| `src/test/java` | Test source code |
| `src/test/resources` | Test resources |
| `target/` | Generated build output |

### Step 3: Compile the project

```bash
mvn compile
```

Maven compiles the Java source code.

Compiled classes are stored under:

```text
target/classes/
```

### Step 4: Run tests

```bash
mvn test
```

Maven executes the project's configured tests.

### Step 5: Package the project

```bash
mvn package
```

Maven compiles the project, runs tests, and packages the application.

The generated JAR will typically be:

```text
target/hello-maven-1.0-SNAPSHOT.jar
```

**Note:** A standard Maven JAR is not necessarily directly executable with `java -jar`. That requires an appropriate manifest and packaging configuration.

---

## 6. Essential Maven commands

Here are the commands you should learn first:

| Command | Purpose |
|---|---|
| `mvn -version` | Display Maven version |
| `mvn validate` | Validate project configuration |
| `mvn compile` | Compile source code |
| `mvn test` | Run tests |
| `mvn package` | Create JAR or WAR |
| `mvn clean` | Remove generated build files |
| `mvn clean package` | Clean and rebuild |
| `mvn install` | Install the artifact into the local repository |
| `mvn dependency:tree` | Display project dependencies |
| `mvn help:effective-pom` | Display the effective POM |

A typical development workflow is:

```bash
mvn clean package
```

For your Spring Boot application, you can also use:

```bash
mvn spring-boot:run
```

This command requires the Spring Boot Maven plugin to be configured.

---

## 7. Maven installation methods compared

There are three common ways to install Maven on Ubuntu.

| Method | Advantages | Disadvantages |
|---|---|---|
| APT | Simple, stable, automatic updates | Version may be older |
| Manual installation | Choose a specific Maven version | Requires manual configuration |
| SDKMAN! | Manage multiple Maven and Java versions | Additional tool required |

### Alternative: Install Maven using SDKMAN!

SDKMAN! is a version manager for JVM-related software.

It supports Java, Maven, Gradle, Kotlin, and other tools.

Install SDKMAN!:

```bash
curl -s "https://get.sdkman.io" | bash
```

As with other remote installation scripts, inspect the script before executing it if you want to verify its contents.

Restart your terminal, or initialize SDKMAN!:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Install Maven:

```bash
sdk install maven
```

Verify:

```bash
mvn -version
```

SDKMAN! can also install and manage multiple JDK versions.

Official documentation:

[SDKMAN!](https://sdkman.io?utm_source=chatgpt.com)

For your current development environment, **APT is sufficient**. You do not need SDKMAN! unless you want to manage multiple Maven versions.

---

## 8. Configure Maven for IntelliJ IDEA

Since you are using IntelliJ IDEA for Java development, you can configure Maven inside the IDE.

Open:

**Settings → Build, Execution, Deployment → Build Tools → Maven**

You can choose:

- **Bundled Maven:** Maven provided by IntelliJ IDEA.
- **External Maven:** Maven installed on Ubuntu.
- **Maven Wrapper:** Maven version specified by the project.

For an APT installation, the external Maven home directory is typically:

```text
/usr/share/maven
```

### What is Maven Wrapper?

The Maven Wrapper (`mvnw`) allows a project to use a specified Maven version without requiring every developer to install that version manually.

A typical Spring Boot project contains:

```text
student-management/
├── .mvn/
│   └── wrapper/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src/
```

On Ubuntu, you can execute:

```bash
./mvnw clean package
```

The wrapper downloads the configured Maven distribution when necessary.

**For team projects, I recommend using Maven Wrapper** because it helps maintain consistent Maven versions across different computers.

---

## 9. Configure a Maven mirror in China (Optional)

If your Ubuntu computer is located in mainland China, Maven Central downloads may sometimes be slow.

You can configure an Alibaba Cloud Maven mirror.

Create the Maven configuration directory:

```bash
mkdir -p ~/.m2
```

Open the configuration file:

```bash
nano ~/.m2/settings.xml
```

Add:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0
                              https://maven.apache.org/xsd/settings-1.2.0.xsd">

    <mirrors>
        <mirror>
            <id>aliyun-maven</id>
            <name>Aliyun Maven Mirror</name>
            <url>https://maven.aliyun.com/repository/public</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    </mirrors>

</settings>
```

This redirects requests for Maven Central artifacts to the Alibaba Cloud public Maven repository.

It does not necessarily mirror every other repository your project may use.

Official Maven configuration reference:

[Apache Maven Settings Reference](https://maven.apache.org/settings.html?utm_source=chatgpt.com)

---

## 10. My recommendation for your Java backend development

For your Spring Boot Student Management System, I recommend this environment:

| Component | Recommendation |
|---|---|
| Operating system | Ubuntu |
| Java | OpenJDK 21 |
| Build tool | Apache Maven 3.9.x or compatible |
| IDE | IntelliJ IDEA |
| Framework | Spring Boot |
| ORM | Hibernate / Spring Data JPA |
| Database | MySQL |
| Version control | Git |
| Deployment | Docker |

### Quick installation commands

If you already have OpenJDK installed, you only need:

```bash
sudo apt update
sudo apt install maven
```

Verify:

```bash
mvn -version
```

**One final point:** Maven is not a replacement for Java or IntelliJ IDEA. Java provides the language and runtime, IntelliJ IDEA provides the development environment, and Maven manages dependencies and automates building and testing your project.

You now have the essential tools for developing Java backend applications on Ubuntu.





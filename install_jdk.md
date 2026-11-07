# How to Install OpenJDK on Ubuntu

OpenJDK is the **free, open-source implementation of the Java Development Kit (JDK)**. It provides the tools needed to develop and run Java applications.

Since you are learning **Java, Spring Boot, Hibernate, and MySQL**, I recommend installing **OpenJDK 21 (LTS)** on Ubuntu.

Java 21 is a Long-Term Support (LTS) release and is widely used for backend development.

## 1. Check whether Java is already installed

Open a terminal (`Ctrl + Alt + T`) and execute:

```bash
java -version
```

Then check the Java compiler:

```bash
javac -version
```

If Java is not installed, Ubuntu may display:

```text
Command 'java' not found
```

If both commands display version information, Java may already be installed.

## 2. Install OpenJDK 21 (Recommended)

Ubuntu provides OpenJDK packages through its APT package manager.

**Step 1: Update the package index**

```bash
sudo apt update
```

**Step 2: Install OpenJDK 21**

```bash
sudo apt install openjdk-21-jdk
```

APT will automatically install the JDK and its required dependencies.

**Step 3: Verify installation**

```bash
java -version
```

Expected output (version numbers may differ):

```text
openjdk version "21.0.x"
OpenJDK Runtime Environment
OpenJDK 64-Bit Server VM
```

Check the compiler:

```bash
javac -version
```

Expected output:

```text
javac 21.0.x
```

Congratulations! You have installed OpenJDK.

---

## 3. Understand JDK vs JRE vs JVM

These three concepts are important for Java developers.

| Component | Full name | Purpose |
|---|---|---|
| JVM | Java Virtual Machine | Executes Java bytecode |
| JRE | Java Runtime Environment | Provides the environment to run Java applications |
| JDK | Java Development Kit | Provides tools to develop and run Java applications |

Their conceptual relationship is:

```text
JDK
 ├── Development Tools
 │    ├── javac
 │    ├── jar
 │    ├── javadoc
 │    └── jshell
 │
 └── Java Runtime
      ├── JVM
      └── Java Libraries
```

**Important:** Modern Java distributions generally do not provide a separate JRE directory inside the JDK, although the conceptual distinction remains useful.

For Spring Boot development, install the **JDK**, not just the runtime.

---

## 4. Find the OpenJDK installation directory

After installation, you can find the Java executable using:

```bash
readlink -f $(which java)
```

For OpenJDK 21 on a typical 64-bit Ubuntu PC, the output looks like:

```text
/usr/lib/jvm/java-21-openjdk-amd64/bin/java
```

Therefore, the JDK installation directory is:

```text
/usr/lib/jvm/java-21-openjdk-amd64
```

You can also list installed JDKs:

```bash
ls /usr/lib/jvm/
```

---

## 5. Configure JAVA_HOME

`JAVA_HOME` is an environment variable that tells applications where the JDK is installed.

Some development tools, including Maven and Gradle, may use this variable.

### Step 1: Open your Bash configuration

```bash
nano ~/.bashrc
```

### Step 2: Add these lines at the bottom

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

Make sure the directory matches your actual installation.

### Step 3: Apply the configuration

```bash
source ~/.bashrc
```

### Step 4: Verify

```bash
echo $JAVA_HOME
```

Expected:

```text
/usr/lib/jvm/java-21-openjdk-amd64
```

You can also execute:

```bash
echo $PATH
```

**Note:** Ubuntu normally configures Java executables automatically. Setting `JAVA_HOME` is useful for development, but not always required.

---

## 6. Install multiple JDK versions

Ubuntu allows multiple Java versions to coexist.

For example, you can install Java 17 and Java 21:

```bash
sudo apt install openjdk-17-jdk
sudo apt install openjdk-21-jdk
```

Both can remain installed.

To choose the default Java version:

```bash
sudo update-alternatives --config java
```

Ubuntu displays a list similar to:

```text
Selection    Path
---------------------------------------------
0            /usr/lib/jvm/java-21-openjdk-amd64/bin/java
1            /usr/lib/jvm/java-17-openjdk-amd64/bin/java
2            /usr/lib/jvm/java-21-openjdk-amd64/bin/java
```

Enter the number corresponding to your preferred version.

You should also configure the compiler:

```bash
sudo update-alternatives --config javac
```

**Important:** If you change the default JDK, update `JAVA_HOME` accordingly. Otherwise, your Java environment may contain conflicting versions.

---

## 7. Test OpenJDK with a Hello World program

Create a Java file:

```bash
nano HelloWorld.java
```

Enter:

```java
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, Ubuntu!");
    }

}
```

Save the file.

Compile it:

```bash
javac HelloWorld.java
```

This generates:

```text
HelloWorld.class
```

Run the program:

```bash
java HelloWorld
```

Expected output:

```text
Hello, Ubuntu!
```

Your Java development environment is working!

---

## 8. Which OpenJDK version should you choose?

Here is a comparison:

| Java version | Release | LTS | Recommendation |
|---|---|---|---|
| Java 8 | 2014 | Yes | Legacy applications |
| Java 11 | 2018 | Yes | Older enterprise projects |
| Java 17 | 2021 | Yes | Existing Spring Boot projects |
| Java 21 | 2023 | Yes | **Recommended for learning Spring Boot** |
| Java 25 | 2025 | Yes | New projects using newer Java features |

Ubuntu 24.04 supports OpenJDK 17, 21, and 25 through its package repositories. [Ubuntu Documentation](https://documentation.ubuntu.com/ubuntu-for-developers/reference/availability/java/?utm_source=chatgpt.com)

For additional information, see the [official Ubuntu OpenJDK package listings](https://packages.ubuntu.com/openjdk-21-jdk?utm_source=chatgpt.com).

### My recommendation for your Java backend development

I suggest this environment:

| Software | Recommended |
|---|---|
| Operating system | Ubuntu |
| JDK | OpenJDK 21 |
| IDE | IntelliJ IDEA |
| Build tool | Maven |
| Framework | Spring Boot |
| ORM | Hibernate / Spring Data JPA |
| Database | MySQL |
| Containerization | Docker |

This environment will support your Student Management System REST API project.

**One question:** Which Ubuntu version are you using?

You can check with:

```bash
lsb_release -a
```

For example, Ubuntu 22.04, 24.04, or 26.04.

I can then show you how to install and configure OpenJDK specifically for your Ubuntu version, including IntelliJ IDEA and Maven.

# 📦 Packaging and Deploying Java Code

Packaging and deployment are about turning your Java source code into something that can be:

* executed,
* distributed,
* installed,
* or run on servers/cloud platforms.

A typical flow is:

```text
.java source
    ↓
compile
    ↓
.class bytecode
    ↓
JAR/WAR/JMOD/native image
    ↓
deploy/run
```

---

# 1️⃣ Compilation Process

Java source files:

```java id="qj1ss6"
Hello.java
```

Compile with:

```bash id="yixf0z"
javac Hello.java
```

Produces:

```text
Hello.class
```

Run:

```bash id="3r5ijq"
java Hello
```

---

# 2️⃣ What is a JAR File?

JAR = Java ARchive

A `.jar` file packages:

* `.class` files
* resources
* metadata

into one distributable file.

Similar to:

* `.zip`
* `.exe` package
* `.dll` bundle

---

# 3️⃣ Creating a JAR

Suppose:

```text
src/
 └── Hello.java
```

Compile:

```bash id="ed88ya"
javac Hello.java
```

Create jar:

```bash id="nkj8bm"
jar cf hello.jar Hello.class
```

Options:

* `c` → create
* `f` → file

---

# 4️⃣ Executable JAR

To run directly:

```bash id="8oqdhu"
java -jar hello.jar
```

Need a `MANIFEST.MF`.

---

## Create Executable JAR

### Step 1 — Manifest

```text
Main-Class: Hello
```

⚠️ Must end with newline.

---

### Step 2 — Build

```bash id="4rks3x"
jar cfm hello.jar MANIFEST.MF Hello.class
```

Run:

```bash id="vs1q4o"
java -jar hello.jar
```

---

# 5️⃣ Standard Project Structure

Common Maven/Gradle layout:

```text
project/
 ├── src/
 │    ├── main/java
 │    ├── main/resources
 │    └── test/java
 ├── pom.xml
 └── build.gradle
```

---

# 6️⃣ Maven Packaging

## Maven Lifecycle

```text
validate
compile
test
package
install
deploy
```

Package:

```bash id="r7t1ut"
mvn package
```

Produces:

```text
target/app.jar
```

---

## Maven Example

```xml id="r04od0"
<packaging>jar</packaging>
```

Or web app:

```xml id="h7v08e"
<packaging>war</packaging>
```

---

# 7️⃣ Gradle Packaging

Build:

```bash id="i9o3qs"
gradle build
```

or:

```bash id="k11lj5"
./gradlew build
```

Output:

```text
build/libs/
```

---

# 8️⃣ Fat JAR / Uber JAR

Contains:

* your classes
* ALL dependencies

Very common in Spring Boot.

Run:

```bash id="6t2yze"
java -jar app.jar
```

---

## Spring Boot Example

```bash id="9qlz1r"
mvn spring-boot:repackage
```

or:

```bash id="n18pzt"
gradle bootJar
```

---

# 9️⃣ WAR Files (Web Applications)

WAR = Web Archive

Used for:

* Tomcat
* Jetty
* Jakarta EE servers

Contains:

* servlets
* JSP
* web resources

Structure:

```text
app.war
 ├── WEB-INF
 ├── classes
 └── lib
```

Deploy by copying into:

```text
tomcat/webapps/
```

---

# 🔟 JMOD (Java Modules)

Introduced with Java Platform Module System (JPMS).

```bash id="wjlwm3"
jmod create ...
```

Used for:

* modular runtime images
* advanced packaging

Less common in enterprise apps.

---

# 1️⃣1️⃣ jlink (Custom Runtime)

Create minimal Java runtime.

Instead of shipping full JDK:

```bash id="67e2bg"
jlink --add-modules java.base --output myruntime
```

Benefits:

* smaller size
* faster startup
* better containers

---

# 1️⃣2️⃣ jpackage (Native Installers)

Introduced in modern Java.

Creates:

* `.exe`
* `.msi`
* `.deb`
* `.rpm`
* macOS app bundles

Example:

```bash id="42vg5u"
jpackage \
  --name MyApp \
  --input target/ \
  --main-jar app.jar
```

---

# 1️⃣3️⃣ Docker Deployment

Very common today.

## Example Dockerfile

```dockerfile id="h2e9m4"
FROM eclipse-temurin:21

COPY app.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build:

```bash id="scotb6"
docker build -t myapp .
```

Run:

```bash id="khmjlwm"
docker run myapp
```

---

# 1️⃣4️⃣ Cloud Deployment

Java apps commonly deploy to:

* Kubernetes
* AWS
* Azure
* Google Cloud

Popular formats:

* Docker containers
* Spring Boot JARs

---

# 1️⃣5️⃣ CI/CD Pipelines

Typical deployment pipeline:

```text
Git Push
   ↓
Build
   ↓
Test
   ↓
Package
   ↓
Dockerize
   ↓
Deploy
```

Tools:

* Jenkins
* GitHub Actions
* GitLab CI
* ArgoCD

---

# 1️⃣6️⃣ Java Native Image (GraalVM)

Compile Java into native executable.

Benefits:

* instant startup
* lower memory
* ideal for microservices

Example:

```bash id="xxihkm"
native-image -jar app.jar
```

Tradeoff:

* harder reflection handling
* longer build time

---

# 1️⃣7️⃣ Real-World Enterprise Packaging

## Spring Boot

Usually:

```text
fat executable JAR
```

Run:

```bash id="p3j7f5"
java -jar app.jar
```

---

## Traditional Enterprise

Usually:

```text
WAR deployed to Tomcat
```

---

## Modern Cloud Native

Usually:

```text
Docker container
```

---

# 📊 Packaging Comparison

| Type         | Usage            | Run Style         |
| ------------ | ---------------- | ----------------- |
| JAR          | Standard apps    | `java -jar`       |
| Fat JAR      | Spring Boot      | Self-contained    |
| WAR          | Web servers      | Tomcat/Jetty      |
| JMOD         | Modules          | Advanced runtime  |
| Native Image | High performance | Native executable |
| Docker       | Cloud deployment | Container         |

---

# 🎯 Most Important Skills Today

For modern Java jobs, focus on:

1. Maven / Gradle
2. Executable JARs
3. Spring Boot packaging
4. Docker deployment
5. CI/CD basics
6. Kubernetes basics

---

# 🚀 Recommended Learning Order

```text
JAR
 → Maven/Gradle
 → Spring Boot fat JAR
 → Docker
 → Kubernetes
 → GraalVM
```

---

# 🧠 Interview Tip

Very common question:

> “Difference between JAR and WAR?”

### Answer:

* JAR:

  * standalone Java application
  * can run directly

* WAR:

  * web application archive
  * deployed into servlet container like Tomcat

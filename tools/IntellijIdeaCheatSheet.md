Here is a comprehensive, scannable cheatsheet for [IntelliJ IDEA](https://www.jetbrains.com/idea/) featuring the most essential shortcuts for both Windows/Linux and macOS.


## 🔍 Search & Navigation
Find files, classes, symbols, or actions across your entire project instantly.

| Action | Windows / Linux | macOS |
|---|---|---|
| Search Everywhere (Files, Actions, Symbols) | Shift Shift | ⇧ ⇧ |
| Find Action (Run any IDE command) | Ctrl + Shift + A | ⌘ + ⇧ + A |
| Go to Class | Ctrl + N | ⌘ + O |
| Go to File | Ctrl + Shift + N | ⌘ + ⇧ + O |
| Find in Files (Text search project) | Ctrl + Shift + F | ⌘ + ⇧ + F |
| Go to Declaration / Definition | Ctrl + B (or Ctrl + Click) | ⌘ + B (or ⌘ + Click) |
| Recent Files | Ctrl + E | ⌘ + E |


## ✍️ Editing & Code Generation
Write, format, and manipulate blocks of code quickly.

| Action | Windows / Linux | macOS |
|---|---|---|
| Show Context Actions (Quick-fix / Intentions) | Alt + Enter | ⌥ + Enter |
| Generate Code (Getters/Setters, Constructors) | Alt + Insert | ⌘ + N |
| Basic Code Completion | Ctrl + Space | ⌃ + Space |
| Reformat Code (Auto-indent) | Ctrl + Alt + L | ⌘ + ⌥ + L |
| Duplicate Current Line / Selection | Ctrl + D | ⌘ + D |
| Delete Line | Ctrl + Y | ⌘ + ⌫ |
| Comment / Uncomment Line | Ctrl + / | ⌘ + / |
| Extend / Shrink Selection | Ctrl + W / Ctrl + Shift + W | ⌥ + Up / ⌥ + Down |


## 🛠️ Refactoring
Safely modify structural code elements without breaking references.

| Action | Windows / Linux | macOS |
|---|---|---|
| Rename (File, Variable, Method, Class) | Shift + F6 | ⇧ + F6 |
| Extract Method | Ctrl + Alt + M | ⌘ + ⌥ + M |
| Extract Variable | Ctrl + Alt + V | ⌘ + ⌥ + V |
| Extract Constant | Ctrl + Alt + C | ⌘ + ⌥ + C |
| Inline Variable / Method | Ctrl + Alt + N | ⌘ + ⌥ + N |


## 🚀 Running & Debugging
Execute your application and diagnose errors line by line.

| Action | Windows / Linux | macOS |
|---|---|---|
| Run (Select configuration) | Alt + Shift + F10 | ⌃ + ⌥ + R |
| Run Current File | Shift + F10 | ⌃ + R |
| Debug Current File | Shift + F9 | ⌃ + D |
| Toggle Breakpoint | Ctrl + F8 | ⌘ + F8 |
| Step Over (Next line) | F8 | F8 |
| Step Into (Enter method) | F7 | F7 |
| Resume Program (Next breakpoint) | F9 | ⌥ + ⌘ + R |


## 🪟 Windows & Tool Panels
Jump between terminal, version control, and navigation sidebars.


* Project Tool Window: Alt + 1 (Windows/Linux) | ⌘ + 1 (macOS)
* Commit / Git Panel: Alt + 0 (Windows/Linux) | ⌘ + 0 (macOS)
* Terminal: Alt + F12 (Windows/Linux) | ⌥ + F12 (macOS)
* Hide All Windows (Max Editor): Ctrl + Shift + F12 (Windows/Linux) | ⌘ + ⇧ + F12 (macOS)
  

Would you like a printable PDF copy of these shortcuts, or are you looking for shortcuts tailored to a specific framework like Spring Boot or language like Java/Kotlin?

---
# How to Install IntelliJ IDEA on Ubuntu

**IntelliJ IDEA** is a powerful Java IDE developed by [JetBrains](https://www.jetbrains.com?utm_source=chatgpt.com). It is particularly popular for Java, Spring Boot, Hibernate, Maven, and enterprise backend development.

Since you are setting up Ubuntu for Java backend development, I strongly recommend IntelliJ IDEA as your primary Java IDE.

There are several ways to install IntelliJ IDEA on Ubuntu. My recommendation is **JetBrains Toolbox App** because it makes installing, updating, and managing IntelliJ IDEA versions easy.

## 1. Choose an IntelliJ IDEA edition

IntelliJ IDEA has two licensing options:

| Edition | Cost | Features |
|---|---|---|
| IntelliJ IDEA Free | Free | Core Java and Kotlin development |
| IntelliJ IDEA Ultimate | Paid subscription, with trial options | Advanced Spring, database, enterprise, and web development features |

JetBrains has unified its IntelliJ IDEA distribution starting with the 2025.3 release. The current product provides free core functionality and paid Ultimate features.

For your learning purposes, start with the **free edition**. You can upgrade to Ultimate if you need its advanced Spring Boot and database tools.

Official website:

[IntelliJ IDEA Downloads](https://www.jetbrains.com/idea/download/?utm_source=chatgpt.com)

---

## 2. Method 1: Install using JetBrains Toolbox (Recommended)

JetBrains Toolbox is an application manager for JetBrains IDEs.

It allows you to:
- Install IntelliJ IDEA.
- Update IntelliJ IDEA.
- Manage multiple IDE versions.
- Install other JetBrains products.
- Configure IDE versions and settings.

### Step 1: Download JetBrains Toolbox

Visit:

[JetBrains Toolbox App](https://www.jetbrains.com/toolbox-app/?utm_source=chatgpt.com)

Download the Linux version.

For most Intel and AMD computers, choose the Linux x86-64 package.

### Step 2: Extract the downloaded archive

Open your terminal:

```bash
cd ~/Downloads
```

Extract the archive:

```bash
tar -xzf jetbrains-toolbox-*.tar.gz
```

Enter the extracted directory:

```bash
cd jetbrains-toolbox-*/
```

Find the executable:

```bash
ls
```

You should see a file named something similar to:

```text
jetbrains-toolbox
```

### Step 3: Launch Toolbox

Execute:

```bash
./jetbrains-toolbox
```

Toolbox will launch its graphical interface.

### Step 4: Install IntelliJ IDEA

1. Find IntelliJ IDEA in the Toolbox application.
2. Click Install.
3. Wait for the download and installation to finish.
4. Click Launch.

You can now start IntelliJ IDEA.

### Important: Correct Toolbox launch command

JetBrains' current Linux installation instructions use:

```bash
./bin/jetbrains-toolbox
```

The Toolbox installation directory will typically be:

```text
~/.local/share/JetBrains/Toolbox/
```

Toolbox also creates an application launcher in Ubuntu's application menu. [JetBrains](https://www.jetbrains.com/help/idea/installation-guide.html?utm_source=chatgpt.com)

---

## 3. Method 2: Install IntelliJ IDEA using Snap

If you prefer a simple terminal installation, Ubuntu supports installing IntelliJ IDEA through Snap.

Execute:

```bash
sudo snap install intellij-idea --classic
```

After installation, launch it:

```bash
intellij-idea
```

This installs the unified IntelliJ IDEA product.

**Note:** JetBrains mentions that Snap installations can sometimes have performance and file-management issues. I therefore prefer Toolbox. [JetBrains](https://www.jetbrains.com/help/idea/installation-guide.html?utm_source=chatgpt.com)

---

## 4. Method 3: Install IntelliJ IDEA manually

You can also install IntelliJ IDEA directly from its official Linux archive.

### Step 1: Download the Linux version

Visit:

[IntelliJ IDEA Linux Download](https://www.jetbrains.com/idea/download/?os=linux&utm_source=chatgpt.com)

Download the `.tar.gz` archive matching your CPU architecture.

For most Intel and AMD computers, select x86-64.

### Step 2: Extract the archive

Open your terminal:

```bash
cd ~/Downloads
```

Extract it into `/opt`:

```bash
sudo tar -xzf idea-*.tar.gz -C /opt
```

### Step 3: Launch IntelliJ IDEA

Find the extracted directory:

```bash
ls /opt
```

Then launch:

```bash
/opt/idea-*/bin/idea.sh
```

This is a manual installation method. Do not extract a new version over an existing installation. [JetBrains](https://www.jetbrains.com/help/idea/installation-guide.html?utm_source=chatgpt.com)

---

## 5. Configure IntelliJ IDEA for Java development

After launching IntelliJ IDEA for the first time, complete its initial configuration.

### Step 1: Configure the JDK

Open:

**File → Project Structure → SDKs**

Click the `+` button and select JDK.

For your OpenJDK 21 installation, the directory should typically be:

```text
/usr/lib/jvm/java-21-openjdk-amd64
```

Verify your installed JDK:

```bash
ls /usr/lib/jvm/
```

### Step 2: Configure Maven

Open:

**Settings → Build, Execution, Deployment → Build Tools → Maven**

If you installed Maven through APT, its location is typically:

```text
/usr/share/maven
```

Alternatively, you can use the Maven Wrapper included in individual projects.

### Step 3: Create your first Java project

1. Select New Project.
2. Choose Java.
3. Select OpenJDK 21.
4. Choose Maven as the build system.
5. Enter your project name.
6. Click Create.

You are ready to develop Java applications!

---

## 6. Install useful IntelliJ IDEA plugins

For your Java backend development, I recommend exploring these tools:

| Plugin / Tool | Purpose |
|---|---|
| Spring Boot support | Spring Boot development |
| Maven integration | Dependency and build management |
| Database Tools | MySQL and database management |
| Git integration | Version control |
| Docker integration | Container management |
| Lombok | Reduce Java boilerplate |
| SonarQube for IDE | Code quality analysis |

Some advanced functionality, including advanced Spring and database tooling, requires an IntelliJ IDEA Ultimate subscription. [JetBrains](https://www.jetbrains.com/idea/download/?os=linux\&utm_source=chatgpt.com)

---

## 7. My recommendation for your Ubuntu environment

Here is the development environment I recommend:

| Software | Installation |
|---|---|
| OpenJDK 21 | APT |
| Maven | APT |
| IntelliJ IDEA | JetBrains Toolbox |
| Python 3 | APT |
| Node.js | NVM |
| Git | APT |
| VS Code | Microsoft APT repository |
| Docker | Docker APT repository |

Your Java development workflow will look like this:

```text
Ubuntu
  │
  ├── OpenJDK 21
  │
  ├── IntelliJ IDEA
  │     │
  │     ├── Maven
  │     ├── Spring Boot
  │     ├── Hibernate
  │     └── Git
  │
  ├── MySQL
  │     └── Docker
  │
  ├── Python 3
  │     └── Playwright
  │
  └── Node.js
        └── JavaScript / TypeScript
```

**My final suggestion:** Install IntelliJ IDEA through JetBrains Toolbox rather than Snap. It gives you a convenient way to manage IntelliJ IDEA and other JetBrains development tools.

You can use the free IntelliJ IDEA functionality for core Java development and decide later whether you need Ultimate for advanced Spring Boot development.



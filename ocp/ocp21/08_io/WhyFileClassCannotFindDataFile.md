The reason your Java program cannot find data.txt—even though they are in the exact same directory—is because Java does not look for files relative to where the source file or compiled class lives. 

Instead, it looks relative to the "Working Directory" of the running process.

When you run a program inside an IDE like IntelliJ IDEA or Eclipse, the default working directory is almost always the root folder of the project, not the source folder where your code sits.

## 🔍 How to Fix It Based on Your Project Setup
### 1. If you are using IntelliJ IDEA or Eclipse
Move your data.txt file out of the src/ or package folder and place it directly into the root folder of your project (the directory containing your .idea folder, pom.xml, or .project file).
```
📂 MyJavaProject  <-- Put data.txt HERE
├── 📂 .idea
├── 📂 src
│   └── Main.java
├── 📄 data.txt
└── 📄 pom.xml
```
### 2. If you are running from the Command Line
If you manually compile and run your code via the terminal, ensure your terminal path matches the file location:
```
# Navigate to the exact folder containing your code and file
cd /path/to/your/folder
# Compile and run
javac Main.java
java Main
```

## 🛠️ Pro-Tips to Diagnose and Fix the Path Dynamic
### Code Hack: Print your exact Working Directory
Add this quick snippet inside your main method before opening the scanner. 

It will output exactly where Java is currently looking for files on your hard drive:
```java
System.out.println("Java is looking for files in: " + System.getProperty("user.dir"));
```
Take the path printed by that line, drop your data.txt file into that exact folder, and the exception will disappear.
### The Bulletproof Fix: Use Absolute Paths
If you don't want to worry about changing working directories during local testing, pass the absolute path directly into your code:
```java
// On Windows:
File file = new File("C:\\Users\\YourName\\Documents\\MyProject\\data.txt");
// On macOS / Linux:
File file = new File("/Users/YourName/Documents/MyProject/data.txt");
```

Let me know:

* Are you running this code inside IntelliJ IDEA, VS Code, or the Terminal?
* What is your Operating System (Windows, macOS, or Linux)?

I can tell you the exact button clicks or configuration tweaks to permanently set your working directory.


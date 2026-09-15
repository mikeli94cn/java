**JSP (JavaServer Pages)** is a Java web technology for creating **dynamic HTML pages on the server**.

A simple way to understand it is:

> **JSP = HTML page with Java-based server-side dynamic content.**

JSP was especially common in older Java web applications and is historically closely related to **Servlets and Tomcat**.

### 1. A simple JSP

For example, a file called `hello.jsp`:

```jsp
<html>
<body>

<h1>Hello!</h1>

<p>Current user: <%= "Mike" %></p>

</body>
</html>
```

The server processes the JSP and sends normal HTML to the browser:

```html
<html>
<body>

<h1>Hello!</h1>

<p>Current user: Mike</p>

</body>
</html>
```

The browser **doesn't know that JSP was used**. It only receives HTML.

---

### 2. JSP vs Servlet

This is the important relationship:

```text
                 Java Web Application
                         │
              ┌──────────┴──────────┐
              │                     │
           Servlet                  JSP
              │                     │
       Java-oriented          HTML-oriented
       request logic          presentation
```

For example, a Servlet might do:

```java
String name = "Mike";
request.setAttribute("name", name);
```

Then forward to:

```text
hello.jsp
```

The JSP displays it:

```jsp
<h1>Hello, ${name}!</h1>
```

So traditionally:

```text
Browser
   ↓
Servlet
   ↓
Business logic
   ↓
JSP
   ↓
HTML
   ↓
Browser
```

This is essentially the **MVC pattern**:

```text
Model       → application data
Controller  → Servlet
View        → JSP
```

---

### 3. JSP is actually converted into a Servlet

This is one of the most interesting things about JSP.

When Tomcat receives a JSP, it doesn't have a special Java execution mechanism completely separate from Servlets.

Conceptually:

```text
hello.jsp
   ↓
JSP engine
   ↓
generated Servlet
   ↓
Java compilation
   ↓
Servlet class
   ↓
JVM executes it
```

So you can think of JSP as a **higher-level way of writing a Servlet's presentation/output code**.

For example:

```jsp
<h1>Hello ${name}</h1>
```

is eventually translated into Java code that generates HTML.

This is why JSP and Servlets are so closely related.

---

### 4. JSP originally allowed Java code inside HTML

Older JSP applications often looked like this:

```jsp
<html>
<body>

<%
    String name = "Mike";
    for (int i = 0; i < 3; i++) {
%>

    <p>Hello <%= name %></p>

<%
    }
%>

</body>
</html>
```

This is called **scriptlet-style JSP**.

It mixes:

```text
HTML + Java
```

directly in the same file.

This worked, but it quickly became difficult to maintain.

Modern Java web development generally avoids putting Java code directly inside JSP.

Instead, you might use:

```jsp
<h1>Hello ${name}</h1>
```

with **Expression Language (EL)** and JSTL/tag libraries.

---

### 5. JSP's historical importance

JSP was very important in the evolution of Java web development:

```text
CGI
 ↓
Servlet
 ↓
JSP
 ↓
Servlet + JSP + MVC frameworks
 ↓
Spring MVC
 ↓
Spring Boot
 ↓
REST APIs + JavaScript frontends
```

JSP solved an important problem:

> Writing HTML directly inside Java Servlets was cumbersome.

Without JSP, you could end up with code like:

```java
out.println("<html>");
out.println("<body>");
out.println("<h1>Hello " + name + "</h1>");
out.println("</body>");
out.println("</html>");
```

JSP made the opposite approach possible:

```jsp
<html>
<body>
<h1>Hello ${name}</h1>
</body>
</html>
```

Much easier for a UI/template author to work with.

---

### 6. JSP vs modern Spring Boot

Today, if you're learning **Spring Boot**, JSP is mostly useful for **understanding legacy Java web applications**.

Modern applications commonly use:

```text
Spring Boot
   ↓
REST API
   ↓
JSON
   ↓
React / Angular / Vue / mobile app
```

rather than:

```text
Spring MVC
   ↓
JSP
   ↓
HTML
```

For server-side HTML rendering, technologies such as **Thymeleaf** are also commonly encountered in Spring applications.

So I would classify JSP as:

> **An important historical Java web technology that helps you understand Servlets, Tomcat, MVC, and older Spring applications, but it is not the main approach for modern REST-based Spring Boot development.**

### The relationship you should remember

```text
JVM
 │
 └── Tomcat
       │
       ├── Servlet
       │      └── Java request/response logic
       │
       └── JSP
              └── HTML-oriented view
```

**Servlet = controller/request processing**

**JSP = server-side HTML view**

**Tomcat = runtime/container that runs them**.

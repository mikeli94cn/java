# Java Backend Development: A Practical Learning Roadmap

Since you're learning Java backend development, my recommendation is:

Start with Spring Boot, learn the Spring Framework fundamentals alongside it, and study Servlet programming underneath them.

You do not need to master Servlet programming before you can build a Spring Boot application. However, understanding what Servlets do will help you understand how Spring MVC, Tomcat, HTTP requests, and REST APIs work.

The goal is not to learn every Java framework. It's to build a mental model of how a backend application works, then gradually build real projects in your IDE.

# 1. Understand the relationship first

## The Java backend technology stack

Your application

Controllers · Services · Repositories · Business logic

Spring Boot + Spring Framework

Auto-configuration · Dependency Injection · Spring MVC · Data access

Servlet container — usually embedded Tomcat

Receives HTTP requests · Manages Servlets · Sends HTTP responses

Java Runtime + Operating System + Network

JVM · Threads · Sockets · Files · Processes

A simplified conceptual stack. Spring Boot applications can use other servlet containers or reactive servers too.

These three technologies are related, but they solve different problems.

|
Technology

|

Main responsibility

|
| --- | --- |
|

Servlet

|

Java API for handling HTTP requests and responses in a servlet container

|
|

Spring Framework

|

Application framework: dependency injection, web MVC, transactions, and more

|
|

Spring Boot

|

Makes Spring applications easier to configure, run, and package

|

Think of it this way:

* Servlet is a lower-level web programming API.

* Spring Framework provides abstractions and infrastructure for building applications.

* Spring Boot simplifies setting up and running Spring applications.

Spring Boot does not replace Spring. It builds on Spring, and a typical Spring Boot web application uses Spring MVC, which runs on the Servlet API.


# 2. The learning order I recommend

Here is a roadmap you can follow directly in IntelliJ IDEA or VS Code. It is organized around projects rather than a long list of disconnected concepts.

## Your roadmap

Beginner → Job-ready foundation

0/6

Phase 1. Java foundation

1–2 weeks

Prepare the Java skills backend work depends on.

Learn

* OOP, interfaces, exceptions, generics

* Collections, Streams, lambdas

* Maven, Git, debugging, logging

PROJECT MILESTONE

Console-based student management system

Phase 2. HTTP and Servlet fundamentals

1 week

Understand how Java receives and responds to HTTP requests.

Learn

* HTTP methods, headers, status codes

* Servlet, HttpServletRequest and Response

* Servlet lifecycle, mappings, sessions, filters

PROJECT MILESTONE

A small Servlet-based login and user application

Phase 3. Spring Framework fundamentals

1–2 weeks

Understand how Spring creates and connects application objects.

Learn

* IoC and Dependency Injection

* ApplicationContext and bean lifecycle

* Configuration, components, constructor injection

PROJECT MILESTONE

Refactor the student system into a Spring application

Phase 4. Spring Boot + REST API

2 weeks

Build your first modern backend service.

Learn

* Spring Initializr, starters, auto-configuration

* Spring MVC controllers and DTOs

* Validation, exception handling, JSON

PROJECT MILESTONE

Student Management REST API

Phase 5. Database and persistence

2–3 weeks

Persist and query real application data.

Learn

* SQL, PostgreSQL or MySQL

* JDBC and Spring Data JPA

* Entities, repositories, transactions

PROJECT MILESTONE

Connect the student API to a relational database

Phase 6. Production and interview skills

Ongoing

Make the project maintainable, testable, and deployable.

Learn

* JUnit, Mockito, integration testing

* Spring Security, authentication, authorization

* Docker, configuration, logging, deployment

PROJECT MILESTONE

Secure, test, containerize, and deploy the API

The durations are rough estimates, assuming regular practice. You can spend more or less time depending on your Java experience.

# 3. Start with a project you can build step by step

I recommend one project throughout the roadmap: a Student Management System.

Instead of building six unrelated tutorial projects, you'll gradually transform one application from a simple Java program into a backend REST service.

## Final project architecture

Client

Browser, frontend, or Postman

Spring Boot Application

Controller

Receives HTTP requests and returns responses

Service

Business rules and application logic

Repository

Database access and queries

PostgreSQL / MySQL

Persistent student records

This is a typical layered architecture. Later, you can add security, tests, caching, and deployment without throwing away the whole project.

## What your finished API will do

|
HTTP request

|

Purpose

|
| --- | --- |
|

`GET /api/students`

|

Get all students

|
|

`GET /api/students/1`

|

Get one student

|
|

`POST /api/students`

|

Create a student

|
|

`PUT /api/students/1`

|

Update a student

|
|

`DELETE /api/students/1`

|

Delete a student

|

These are CRUD operations: Create, Read, Update, Delete.

# 4. Your first IDE project: Spring Boot REST API

Let's begin with a small working application. You can run it before learning all the details of Spring.

## Step 1 — Create the project

Open Spring Initializr .

Choose the following settings:

Project configuration

Starter

Project

Maven

Language

Java

Java version

21 or 25

Packaging

Jar

Dependencies

Spring Web

Validation

Use a supported Java version compatible with the Spring Boot version you select. Java 21 is a good starting point if you already have it installed.

Download the project, unzip it, and open its root directory in your IDE.

## Step 2 — Understand the project structure

A typical Maven project looks like this:

student-management/

`pom.xml`

Maven dependencies and build configuration

`src/main/java/...`

`StudentManagementApplication.java`

`controller/StudentController.java`

`service/StudentService.java`

`model/Student.java`

`src/main/resources/`

`application.properties`

`src/test/java/`

Automated tests

For the first exercise, put all the Java classes in the same package as the generated main application class. This avoids package-scanning problems. You can organize them into subpackages after the first version works.

## Step 3 — Create the Student model

Create `Student.java`:

Java

```
public record Student(
        Long id,
        String name,
        String email
) {}
```

This uses a Java record, which is convenient for representing simple data.

A record automatically provides a constructor, accessors, `equals()`, `hashCode()`, and `toString()`.

## Step 4 — Create the service

Create `StudentService.java`:

Java

```
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    public List<Student> findAll() {
        return List.of(
            new Student(1L, "Alice", "alice@example.com"),
            new Student(2L, "Bob", "bob@example.com")
        );
    }
}
```

For now, the service returns hard-coded data. That's intentional: first learn the request flow, then add database persistence.

## Step 5 — Create the controller

Create `StudentController.java`:

Java

```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
}
```

Notice the constructor:

Java

```
public StudentController(StudentService studentService) {
    this.studentService = studentService;
}
```

Spring creates the `StudentService` bean and injects it into the controller. This is an example of Dependency Injection (DI), one of the most important Spring concepts.

## Step 6 — Run the application

Your generated main class should look similar to this:

Java

```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            StudentManagementApplication.class,
            args
        );
    }
}
```

Run the main method in your IDE.

Then open:

[http://localhost:8080/api/students](http://localhost:8080/api/students) 

You should receive JSON similar to:

JSON

```
[
  {
    "id": 1,
    "name": "Alice",
    "email": "alice@example.com"
  },
  {
    "id": 2,
    "name": "Bob",
    "email": "bob@example.com"
  }
]
```

If the application starts successfully, you've already built a small Spring Boot REST API.


# 5. Now understand what Spring Boot is doing for you

This is where Servlet programming becomes useful.

When you visit `/api/students`, the simplified request flow is:

Diagram options

![](data\:image/svg+xml;utf8,%3Csvg%20id%3D%22mermaid-_r_3t_%22%20width%3D%22729.669189453125%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20class%3D%22flowchart%22%20height%3D%22532.7384033203125%22%20viewBox%3D%224%204%20729.669189453125%20532.7384033203125%22%20role%3D%22graphics-document%20document%22%20aria-roledescription%3D%22flowchart-v2%22%3E%3Cstyle%3E%23mermaid-_r_3t_%7Bfont-family%3A%22-apple-system%22%2C%22BlinkMacSystemFont%22%2C%22Segoe%20UI%22%2C%22Roboto%22%2C%22Oxygen%22%2C%22Ubuntu%22%2C%22Cantarell%22%2C%22Helvetica%20Neue%22%2C%22Arial%22%2C%22sans-serif%22%3Bfont-size%3A14px%3Bfill%3Argb\(13%2C%2013%2C%2013\)%3B%7D%40keyframes%20edge-animation-frame%7Bfrom%7Bstroke-dashoffset%3A0%3B%7D%7D%40keyframes%20dash%7Bto%7Bstroke-dashoffset%3A0%3B%7D%7D%23mermaid-_r_3t_%20.edge-animation-slow%7Bstroke-dasharray%3A9%2C5!important%3Bstroke-dashoffset%3A900%3Banimation%3Adash%2050s%20linear%20infinite%3Bstroke-linecap%3Around%3B%7D%23mermaid-_r_3t_%20.edge-animation-fast%7Bstroke-dasharray%3A9%2C5!important%3Bstroke-dashoffset%3A900%3Banimation%3Adash%2020s%20linear%20infinite%3Bstroke-linecap%3Around%3B%7D%23mermaid-_r_3t_%20.error-icon%7Bfill%3Argb\(249%2C%20249%2C%20249\)%3B%7D%23mermaid-_r_3t_%20.error-text%7Bfill%3Argb\(13%2C%2013%2C%2013\)%3Bstroke%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.edge-thickness-normal%7Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.edge-thickness-thick%7Bstroke-width%3A3.5px%3B%7D%23mermaid-_r_3t_%20.edge-pattern-solid%7Bstroke-dasharray%3A0%3B%7D%23mermaid-_r_3t_%20.edge-thickness-invisible%7Bstroke-width%3A0%3Bfill%3Anone%3B%7D%23mermaid-_r_3t_%20.edge-pattern-dashed%7Bstroke-dasharray%3A3%3B%7D%23mermaid-_r_3t_%20.edge-pattern-dotted%7Bstroke-dasharray%3A2%3B%7D%23mermaid-_r_3t_%20.marker%7Bfill%3Argb\(93%2C%2093%2C%2093\)%3Bstroke%3Argb\(93%2C%2093%2C%2093\)%3B%7D%23mermaid-_r_3t_%20.marker.cross%7Bstroke%3Argb\(93%2C%2093%2C%2093\)%3B%7D%23mermaid-_r_3t_%20svg%7Bfont-family%3A%22-apple-system%22%2C%22BlinkMacSystemFont%22%2C%22Segoe%20UI%22%2C%22Roboto%22%2C%22Oxygen%22%2C%22Ubuntu%22%2C%22Cantarell%22%2C%22Helvetica%20Neue%22%2C%22Arial%22%2C%22sans-serif%22%3Bfont-size%3A14px%3B%7D%23mermaid-_r_3t_%20p%7Bmargin%3A0%3B%7D%23mermaid-_r_3t_%20.label%7Bfont-family%3A%22-apple-system%22%2C%22BlinkMacSystemFont%22%2C%22Segoe%20UI%22%2C%22Roboto%22%2C%22Oxygen%22%2C%22Ubuntu%22%2C%22Cantarell%22%2C%22Helvetica%20Neue%22%2C%22Arial%22%2C%22sans-serif%22%3Bcolor%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.cluster-label%20text%7Bfill%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.cluster-label%20span%7Bcolor%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.cluster-label%20span%20p%7Bbackground-color%3Atransparent%3B%7D%23mermaid-_r_3t_%20.label%20text%2C%23mermaid-_r_3t_%20span%7Bfill%3Argb\(13%2C%2013%2C%2013\)%3Bcolor%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.node%20rect%2C%23mermaid-_r_3t_%20.node%20circle%2C%23mermaid-_r_3t_%20.node%20ellipse%2C%23mermaid-_r_3t_%20.node%20polygon%2C%23mermaid-_r_3t_%20.node%20path%7Bfill%3Argb\(222%2C%20234%2C%20251\)%3Bstroke%3Argb\(83%2C%20154%2C%20248\)%3Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.rough-node%20.label%20text%2C%23mermaid-_r_3t_%20.node%20.label%20text%2C%23mermaid-_r_3t_%20.image-shape%20.label%2C%23mermaid-_r_3t_%20.icon-shape%20.label%7Btext-anchor%3Amiddle%3B%7D%23mermaid-_r_3t_%20.node%20.katex%20path%7Bfill%3A%23000%3Bstroke%3A%23000%3Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.rough-node%20.label%2C%23mermaid-_r_3t_%20.node%20.label%2C%23mermaid-_r_3t_%20.image-shape%20.label%2C%23mermaid-_r_3t_%20.icon-shape%20.label%7Btext-align%3Acenter%3B%7D%23mermaid-_r_3t_%20.node.clickable%7Bcursor%3Apointer%3B%7D%23mermaid-_r_3t_%20.root%20.anchor%20path%7Bfill%3Argb\(93%2C%2093%2C%2093\)!important%3Bstroke-width%3A0%3Bstroke%3Argb\(93%2C%2093%2C%2093\)%3B%7D%23mermaid-_r_3t_%20.arrowheadPath%7Bfill%3Argb\(93%2C%2093%2C%2093\)%3B%7D%23mermaid-_r_3t_%20.edgePath%20.path%7Bstroke%3Argb\(93%2C%2093%2C%2093\)%3Bstroke-width%3A2.0px%3B%7D%23mermaid-_r_3t_%20.flowchart-link%7Bstroke%3Argb\(93%2C%2093%2C%2093\)%3Bfill%3Anone%3B%7D%23mermaid-_r_3t_%20.edgeLabel%7Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3Btext-align%3Acenter%3B%7D%23mermaid-_r_3t_%20.edgeLabel%20p%7Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3B%7D%23mermaid-_r_3t_%20.edgeLabel%20rect%7Bopacity%3A0.5%3Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3Bfill%3Argb\(252%2C%20252%2C%20252\)%3B%7D%23mermaid-_r_3t_%20.labelBkg%7Bbackground-color%3Argba\(252%2C%20252%2C%20252%2C%200.5\)%3B%7D%23mermaid-_r_3t_%20.cluster%20rect%7Bfill%3Argb\(249%2C%20249%2C%20249\)%3Bstroke%3Argba\(0%2C%200%2C%200%2C%200.05\)%3Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.cluster%20text%7Bfill%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20.cluster%20span%7Bcolor%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20div.mermaidTooltip%7Bposition%3Aabsolute%3Btext-align%3Acenter%3Bmax-width%3A200px%3Bpadding%3A2px%3Bfont-family%3A%22-apple-system%22%2C%22BlinkMacSystemFont%22%2C%22Segoe%20UI%22%2C%22Roboto%22%2C%22Oxygen%22%2C%22Ubuntu%22%2C%22Cantarell%22%2C%22Helvetica%20Neue%22%2C%22Arial%22%2C%22sans-serif%22%3Bfont-size%3A12px%3Bbackground%3Argb\(249%2C%20249%2C%20249\)%3Bborder%3A1px%20solid%20rgba\(0%2C%200%2C%200%2C%200.05\)%3Bborder-radius%3A2px%3Bpointer-events%3Anone%3Bz-index%3A100%3B%7D%23mermaid-_r_3t_%20.flowchartTitleText%7Btext-anchor%3Amiddle%3Bfont-size%3A18px%3Bfill%3Argb\(13%2C%2013%2C%2013\)%3B%7D%23mermaid-_r_3t_%20rect.text%7Bfill%3Anone%3Bstroke-width%3A0%3B%7D%23mermaid-_r_3t_%20.icon-shape%2C%23mermaid-_r_3t_%20.image-shape%7Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3Btext-align%3Acenter%3B%7D%23mermaid-_r_3t_%20.icon-shape%20p%2C%23mermaid-_r_3t_%20.image-shape%20p%7Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3Bpadding%3A2px%3B%7D%23mermaid-_r_3t_%20.icon-shape%20rect%2C%23mermaid-_r_3t_%20.image-shape%20rect%7Bopacity%3A0.5%3Bbackground-color%3Argb\(252%2C%20252%2C%20252\)%3Bfill%3Argb\(252%2C%20252%2C%20252\)%3B%7D%23mermaid-_r_3t_%20.label-icon%7Bdisplay%3Ainline-block%3Bheight%3A1em%3Boverflow%3Avisible%3Bvertical-align%3A-0.125em%3B%7D%23mermaid-_r_3t_%20.node%20.label-icon%20path%7Bfill%3AcurrentColor%3Bstroke%3Arevert%3Bstroke-width%3Arevert%3B%7D%23mermaid-_r_3t_%20.node%20text%7Bfont-size%3A16px%3Bfont-weight%3A600%3Bletter-spacing%3A-0.32px%3Bfill%3A%23004f99%3B%7D%23mermaid-_r_3t_%20.edgeLabels%20text%7Bfont-size%3A13px%3Bfont-weight%3A600%3Bletter-spacing%3A-0.08px%3Bfill%3A%23004f99%3B%7D%23mermaid-_r_3t_%20.node%20tspan%5Bfont-weight%3D%22normal%22%5D%2C%23mermaid-_r_3t_%20.edgeLabels%20tspan%5Bfont-weight%3D%22normal%22%5D%7Bfont-weight%3A600%3B%7D%23mermaid-_r_3t_%20.edgeLabel%20.label%20rect%7Bopacity%3A1%3Brx%3A13px%3Bry%3A13px%3Bfill%3A%23f5faff%3Bstroke%3Argb\(206%2C%20219%2C%20229\)%3Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.node%20rect%2C%23mermaid-_r_3t_%20.node%20circle%2C%23mermaid-_r_3t_%20.node%20ellipse%2C%23mermaid-_r_3t_%20.node%20polygon%2C%23mermaid-_r_3t_%20.node%20path%7Bfill%3Argb\(229%2C%20243%2C%20255\)%3Bstroke%3Argba\(0%2C%200%2C%200%2C%200.1\)%3Bstroke-width%3A1px%3B%7D%23mermaid-_r_3t_%20.node%20rect%7Brx%3A16px%3Bry%3A16px%3B%7D%23mermaid-_r_3t_%20.node.mermaid-decision%20.label-container%7Bfill%3A%23f5faff%3Bstroke%3Argb\(206%2C%20219%2C%20229\)%3Bstroke-dasharray%3A2%202%3B%7D%23mermaid-_r_3t_%20.edgePaths%20.flowchart-link%7Bstroke%3Argb\(206%2C%20219%2C%20229\)%3Bstroke-width%3A1px%3Bstroke-linecap%3Around%3Bstroke-linejoin%3Around%3B%7D%23mermaid-_r_3t_%20.marker%7Bfill%3Argb\(206%2C%20219%2C%20229\)%3Bstroke%3Argb\(206%2C%20219%2C%20229\)%3B%7D%23mermaid-_r_3t_%20.node%7Bcolor-scheme%3Alight%3B%7D%23mermaid-_r_3t_%20%3Aroot%7B--mermaid-font-family%3A%22-apple-system%22%2C%22BlinkMacSystemFont%22%2C%22Segoe%20UI%22%2C%22Roboto%22%2C%22Oxygen%22%2C%22Ubuntu%22%2C%22Cantarell%22%2C%22Helvetica%20Neue%22%2C%22Arial%22%2C%22sans-serif%22%3B%7D%3C%2Fstyle%3E%3Cg%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-pointEnd%22%20class%3D%22marker%20flowchart-v2%22%20viewBox%3D%22-5%20-5%2010%2010%22%20refX%3D%220%22%20refY%3D%220%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2210%22%20markerHeight%3D%2210%22%20orient%3D%22auto%22%3E%3Cpath%20d%3D%22M%200%200%20L%204%200%20M%200.8180194846605362%20-3.181980515339464%20L%204%200%20L%200.8180194846605362%203.181980515339464%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%201%3B%20stroke-dasharray%3A%20none%3B%20fill%3A%20none%3B%20stroke-linecap%3A%20round%3B%20stroke-linejoin%3A%20round%3B%22%3E%3C%2Fpath%3E%3C%2Fmarker%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-pointStart%22%20class%3D%22marker%20flowchart-v2%22%20viewBox%3D%22-5%20-5%2010%2010%22%20refX%3D%220%22%20refY%3D%220%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2210%22%20markerHeight%3D%2210%22%20orient%3D%22auto%22%3E%3Cpath%20d%3D%22M%200%200%20L%20-4%200%20M%20-0.8180194846605362%20-3.181980515339464%20L%20-4%200%20L%20-0.8180194846605362%203.181980515339464%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%201%3B%20stroke-dasharray%3A%20none%3B%20fill%3A%20none%3B%20stroke-linecap%3A%20round%3B%20stroke-linejoin%3A%20round%3B%22%3E%3C%2Fpath%3E%3C%2Fmarker%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-circleEnd%22%20class%3D%22marker%20flowchart-v2%22%20viewBox%3D%220%200%2010%2010%22%20refX%3D%2211%22%20refY%3D%225%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2211%22%20markerHeight%3D%2211%22%20orient%3D%22auto%22%3E%3Ccircle%20cx%3D%225%22%20cy%3D%225%22%20r%3D%225%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%201%3B%20stroke-dasharray%3A%201%2C%200%3B%22%3E%3C%2Fcircle%3E%3C%2Fmarker%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-circleStart%22%20class%3D%22marker%20flowchart-v2%22%20viewBox%3D%220%200%2010%2010%22%20refX%3D%22-1%22%20refY%3D%225%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2211%22%20markerHeight%3D%2211%22%20orient%3D%22auto%22%3E%3Ccircle%20cx%3D%225%22%20cy%3D%225%22%20r%3D%225%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%201%3B%20stroke-dasharray%3A%201%2C%200%3B%22%3E%3C%2Fcircle%3E%3C%2Fmarker%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-crossEnd%22%20class%3D%22marker%20cross%20flowchart-v2%22%20viewBox%3D%220%200%2011%2011%22%20refX%3D%2212%22%20refY%3D%225.2%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2211%22%20markerHeight%3D%2211%22%20orient%3D%22auto%22%3E%3Cpath%20d%3D%22M%201%2C1%20l%209%2C9%20M%2010%2C1%20l%20-9%2C9%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%202%3B%20stroke-dasharray%3A%201%2C%200%3B%22%3E%3C%2Fpath%3E%3C%2Fmarker%3E%3Cmarker%20id%3D%22mermaid-_r_3t__flowchart-v2-crossStart%22%20class%3D%22marker%20cross%20flowchart-v2%22%20viewBox%3D%220%200%2011%2011%22%20refX%3D%22-1%22%20refY%3D%225.2%22%20markerUnits%3D%22userSpaceOnUse%22%20markerWidth%3D%2211%22%20markerHeight%3D%2211%22%20orient%3D%22auto%22%3E%3Cpath%20d%3D%22M%201%2C1%20l%209%2C9%20M%2010%2C1%20l%20-9%2C9%22%20class%3D%22arrowMarkerPath%22%20style%3D%22stroke-width%3A%202%3B%20stroke-dasharray%3A%201%2C%200%3B%22%3E%3C%2Fpath%3E%3C%2Fmarker%3E%3C%2Fg%3E%3Cg%20class%3D%22subgraphs%22%3E%3C%2Fg%3E%3Cg%20class%3D%22nodes%22%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-A-0%22%20transform%3D%22translate\(146.9287109375%2C%20182\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-113.9287109375%22%20y%3D%22-30%22%20width%3D%22227.857421875%22%20height%3D%2260%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-9.384615898132324\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EBrowser%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20%2F%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20HTTP%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20client%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-B-1%22%20transform%3D%22translate\(160.66286214192712%2C%20282\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-103.4207763671875%22%20y%3D%22-30%22%20width%3D%22206.841552734375%22%20height%3D%2260%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-9.384615898132324\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EEmbedded%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20Tomcat%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-C-3%22%20transform%3D%22translate\(160.66286214192712%2C%20386.1846160888672\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-100.57325744628906%22%20y%3D%22-34.184614181518555%22%20width%3D%22201.14651489257812%22%20height%3D%2268.36922836303711%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-18.184614181518555\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EServlet%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20API%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20%2F%3C%2Ftspan%3E%3C%2Ftspan%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%221em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EDispatcherServlet%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-D-5%22%20transform%3D%22translate\(123.95444234212243%2C%20494.55384826660156\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-110.1252670288086%22%20y%3D%22-34.184614181518555%22%20width%3D%22220.2505340576172%22%20height%3D%2268.36922836303711%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-18.184614181518555\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3ESpring%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20MVC%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20Handler%3C%2Ftspan%3E%3C%2Ftspan%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%221em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EMapping%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-E-7%22%20transform%3D%22translate\(563.5507705688477%2C%2042\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-101.35909271240234%22%20y%3D%22-30%22%20width%3D%22202.7181854248047%22%20height%3D%2260%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-9.384615898132324\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EStudentController%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-F-9%22%20transform%3D%22translate\(391.9603805541993%2C%20182\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-91.10296249389648%22%20y%3D%22-30%22%20width%3D%22182.20592498779297%22%20height%3D%2260%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-9.384615898132324\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EStudentService%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22node%20default%22%20id%3D%22flowchart-G-13%22%20transform%3D%22translate\(624.3662261962891%2C%20182\)%22%3E%3Crect%20class%3D%22basic%20label-container%22%20style%3D%22%22%20x%3D%22-101.30288696289062%22%20y%3D%22-30%22%20width%3D%22202.60577392578125%22%20height%3D%2260%22%3E%3C%2Frect%3E%3Cg%20class%3D%22label%22%20style%3D%22%22%20transform%3D%22translate\(0%2C%20-9.384615898132324\)%22%3E%3Crect%3E%3C%2Frect%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3Ctext%20y%3D%22-10.1%22%20style%3D%22%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3EJSON%3C%2Ftspan%3E%3Ctspan%20font-style%3D%22normal%22%20class%3D%22text-inner-tspan%22%20font-weight%3D%22normal%22%3E%20serialization%3C%2Ftspan%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edges%20edgePaths%22%3E%3Cpath%20d%3D%22M108.95247395833337%2C212L108.95247395833337%2C240%22%20id%3D%22L_A_B_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_A_B_0%22%20data-points%3D%22W3sieCI6MTA4Ljk1MjQ3Mzk1ODMzMzM3LCJ5IjoyMTJ9LHsieCI6MTA4Ljk1MjQ3Mzk1ODMzMzM3LCJ5IjoyNDR9XQ%3D%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M160.66286214192712%2C312L160.66286214192712%2C340%22%20id%3D%22L_B_C_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_B_C_0%22%20data-points%3D%22W3sieCI6MTYwLjY2Mjg2MjE0MTkyNzEyLCJ5IjozMTJ9LHsieCI6MTYwLjY2Mjg2MjE0MTkyNzEyLCJ5IjozNDR9XQ%3D%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M160.66286214192712%2C420.3692321777344L160.66286214192712%2C448.3692321777344%22%20id%3D%22L_C_D_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_C_D_0%22%20data-points%3D%22W3sieCI6MTYwLjY2Mjg2MjE0MTkyNzEyLCJ5Ijo0MjAuMzY5MjMyMTc3NzM0NH0seyJ4IjoxNjAuNjYyODYyMTQxOTI3MTIsInkiOjQ1Mi4zNjkyMzIxNzc3MzQ0fV0%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M87.24602254231775%2C460.3692321777344L87.24602254231775%2C447.152188203029Q87.24602254231775%2C445.3692321777344%2086.16023610469084%2C443.95501861536127L86.16023610469082%2C443.95501861536127Q85.07444966706393%2C442.54080505298816%2083.66023610469084%2C441.45501861536127L83.66023610469084%2C441.45501861536127Q82.24602254231775%2C440.3692321777344%2080.4630665170231%2C440.3692321777344L18.782956025294652%2C440.3692321777344Q17%2C440.3692321777344%2015.585786437626904%2C439.2834457401075L15.585786437626904%2C439.2834457401075Q14.17157287525381%2C438.1976593024806%2013.085786437626915%2C436.7834457401075L13.085786437626904%2C436.7834457401075Q12%2C435.3692321777344%2012%2C433.5862761524397L12%2C386.1846160888672L12%2C282L12%2C182L12%2C98.78295602529465Q12%2C97%2013.085786437626904%2C95.58578643762691L13.085786437626904%2C95.58578643762691Q14.17157287525381%2C94.17157287525382%2015.585786437626902%2C93.08578643762691L15.585786437626904%2C93.08578643762691Q17%2C92%2018.78295602529466%2C92L495.9523589161117%2C92Q497.73531494140633%2C92%20499.14952850377944%2C90.91421356237309L499.14952850377944%2C90.91421356237308Q500.56374206615254%2C89.82842712474618%20501.64952850377944%2C88.41421356237309L501.64952850377944%2C88.41421356237309Q502.73531494140633%2C87%20502.73531494140633%2C85.21704397470535L502.73531494140633%2C82%22%20id%3D%22L_D_E_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_D_E_0%22%20data-points%3D%22W3sieCI6ODcuMjQ2MDIyNTQyMzE3NzUsInkiOjQ2MC4zNjkyMzIxNzc3MzQ0fSx7IngiOjg3LjI0NjAyMjU0MjMxNzc1LCJ5Ijo0NDAuMzY5MjMyMTc3NzM0NH0seyJ4IjoxMiwieSI6NDQwLjM2OTIzMjE3NzczNDR9LHsieCI6MTIsInkiOjM4Ni4xODQ2MTYwODg4NjcyfSx7IngiOjEyLCJ5IjoyODJ9LHsieCI6MTIsInkiOjE4Mn0seyJ4IjoxMiwieSI6OTJ9LHsieCI6NTAyLjczNTMxNDk0MTQwNjMzLCJ5Ijo5Mn0seyJ4Ijo1MDIuNzM1MzE0OTQxNDA2MzMsInkiOjc4fV0%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M543.2789520263673%2C72L543.2789520263673%2C105.21704397470535Q543.2789520263673%2C107%20542.1931655887404%2C108.41421356237309L542.1931655887404%2C108.41421356237309Q541.1073791511135%2C109.82842712474618%20539.6931655887404%2C110.91421356237308L539.6931655887404%2C110.91421356237309Q538.2789520263673%2C112%20536.4959960010726%2C112L368.3756836864275%2C112Q366.59272766113287%2C112%20365.17851409875976%2C113.08578643762691L365.17851409875976%2C113.08578643762692Q363.76430053638666%2C114.17157287525382%20362.67851409875976%2C115.58578643762691L362.67851409875976%2C115.58578643762691Q361.59272766113287%2C117%20361.59272766113287%2C118.78295602529465L361.59272766113287%2C140%22%20id%3D%22L_E_F_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_E_F_0%22%20data-points%3D%22W3sieCI6NTQzLjI3ODk1MjAyNjM2NzMsInkiOjcyfSx7IngiOjU0My4yNzg5NTIwMjYzNjczLCJ5IjoxMTJ9LHsieCI6MzYxLjU5MjcyNzY2MTEzMjg3LCJ5IjoxMTJ9LHsieCI6MzYxLjU5MjcyNzY2MTEzMjg3LCJ5IjoxNDR9XQ%3D%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M422.3280334472657%2C152L422.3280334472657%2C138.78295602529465Q422.3280334472657%2C137%20423.4138198848926%2C135.5857864376269L423.4138198848926%2C135.5857864376269Q424.49960632251947%2C134.17157287525382%20425.9138198848926%2C133.08578643762692L425.9138198848926%2C133.0857864376269Q427.3280334472657%2C132%20429.11098947256033%2C132L577.0396330860335%2C132Q578.8225891113282%2C132%20580.2368026737013%2C130.9142135623731L580.2368026737013%2C130.91421356237308Q581.6510162360744%2C129.82842712474618%20582.7368026737013%2C128.4142135623731L582.7368026737013%2C128.4142135623731Q583.8225891113282%2C127%20583.8225891113282%2C125.21704397470535L583.8225891113282%2C84%22%20id%3D%22L_F_E_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_F_E_0%22%20data-points%3D%22W3sieCI6NDIyLjMyODAzMzQ0NzI2NTcsInkiOjE1Mn0seyJ4Ijo0MjIuMzI4MDMzNDQ3MjY1NywieSI6MTMyfSx7IngiOjU4My44MjI1ODkxMTEzMjgyLCJ5IjoxMzJ9LHsieCI6NTgzLjgyMjU4OTExMTMyODIsInkiOjgwfV0%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M624.3662261962891%2C72L624.3662261962891%2C140%22%20id%3D%22L_E_G_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_E_G_0%22%20data-points%3D%22W3sieCI6NjI0LjM2NjIyNjE5NjI4OTEsInkiOjcyfSx7IngiOjYyNC4zNjYyMjYxOTYyODkxLCJ5IjoxNDR9XQ%3D%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M624.3662261962891%2C212L624.3662261962891%2C225.21704397470535Q624.3662261962891%2C227%20623.2804397586622%2C228.4142135623731L623.2804397586622%2C228.4142135623731Q622.1946533210353%2C229.82842712474618%20620.7804397586622%2C230.91421356237308L620.7804397586622%2C230.9142135623731Q619.3662261962891%2C232%20617.5832701709944%2C232L219.15620635081552%2C232Q217.37325032552087%2C232%20215.95903676314776%2C233.0857864376269L215.95903676314776%2C233.0857864376269Q214.5448232007747%2C234.17157287525382%20213.45903676314776%2C235.5857864376269L213.45903676314776%2C235.5857864376269Q212.37325032552087%2C237%20212.37325032552087%2C238.78295602529465L212.37325032552087%2C242%22%20id%3D%22L_G_B_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_G_B_0%22%20data-points%3D%22W3sieCI6NjI0LjM2NjIyNjE5NjI4OTEsInkiOjIxMn0seyJ4Ijo2MjQuMzY2MjI2MTk2Mjg5MSwieSI6MjMyfSx7IngiOjIxMi4zNzMyNTAzMjU1MjA4NywieSI6MjMyfSx7IngiOjIxMi4zNzMyNTAzMjU1MjA4NywieSI6MjQ2fV0%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3Cpath%20d%3D%22M160.66286214192712%2C252L160.66286214192712%2C238.78295602529465Q160.66286214192712%2C237%20161.74864857955401%2C235.5857864376269L161.74864857955401%2C235.5857864376269Q162.83443501718094%2C234.17157287525382%20164.24864857955401%2C233.0857864376269L164.24864857955401%2C233.0857864376269Q165.66286214192712%2C232%20167.44581816722177%2C232L178.12199189137203%2C232Q179.90494791666669%2C232%20181.3191614790398%2C230.9142135623731L181.3191614790398%2C230.9142135623731Q182.73337504141287%2C229.82842712474618%20183.8191614790398%2C228.4142135623731L183.8191614790398%2C228.4142135623731Q184.90494791666669%2C227%20184.90494791666669%2C225.21704397470535L184.90494791666669%2C222%22%20id%3D%22L_B_A_0%22%20class%3D%22edge-thickness-normal%20edge-pattern-solid%20edge-thickness-normal%20edge-pattern-solid%20flowchart-link%22%20style%3D%22%3B%22%20data-edge%3D%22true%22%20data-et%3D%22edge%22%20data-id%3D%22L_B_A_0%22%20data-points%3D%22W3sieCI6MTYwLjY2Mjg2MjE0MTkyNzEyLCJ5IjoyNTJ9LHsieCI6MTYwLjY2Mjg2MjE0MTkyNzEyLCJ5IjoyMzJ9LHsieCI6MTg0LjkwNDk0NzkxNjY2NjY5LCJ5IjoyMzJ9LHsieCI6MTg0LjkwNDk0NzkxNjY2NjY5LCJ5IjoyMTh9XQ%3D%3D%22%20marker-end%3D%22url\(%23mermaid-_r_3t__flowchart-v2-pointEnd\)%22%3E%3C%2Fpath%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabels%22%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%3E%3Crect%20class%3D%22background%22%20style%3D%22stroke%3A%20none%22%3E%3C%2Frect%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_A_B_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_B_C_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_C_D_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_D_E_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_E_F_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_F_E_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_E_G_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_G_B_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3Cg%20class%3D%22edgeLabel%22%3E%3Cg%20class%3D%22label%22%20data-id%3D%22L_B_A_0%22%20transform%3D%22translate\(0%2C%200\)%22%3E%3Ctext%20y%3D%22-10.1%22%3E%3Ctspan%20class%3D%22text-outer-tspan%22%20x%3D%220%22%20y%3D%22-0.1em%22%20dy%3D%221.1em%22%3E%3C%2Ftspan%3E%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E)

The important Spring MVC component is `DispatcherServlet`.

It acts as a front controller: it receives incoming requests and dispatches them to the appropriate controller handler.

You don't normally write your own `HttpServlet` when building a Spring Boot REST API. Spring MVC handles that lower-level work.

## A small Servlet example

When you're ready to study the Servlet API, compare your Spring controller with this traditional Servlet:

Java

```
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        response.setContentType("text/plain");
        response.getWriter().println("Hello from Servlet!");
    }
}
```

This example illustrates the lower-level programming model:

* `HttpServlet` is the base class.

* `doGet()` handles HTTP GET requests.

* `HttpServletRequest` provides request information.

* `HttpServletResponse` lets you construct the response.

For a runnable Servlet exercise, create a separate Maven WAR project and deploy it to a servlet container, or use a compatible embedded container. A standalone Servlet class is not sufficient by itself.

Learning objective: Understand the Servlet lifecycle, URL mappings, request/response objects, filters, sessions, and the container. You don't need to recreate all of Spring MVC.

# 6. What to learn in Spring Framework

After your first REST endpoint works, study these concepts in order.

1

IoC and Dependency Injection

Why does Spring create and connect objects? Learn beans, ApplicationContext, component scanning, and constructor injection.

2

Spring MVC

Learn @Controller, @RestController, @RequestMapping, @PathVariable, @RequestParam, @RequestBody, and response handling.

3

Configuration

Learn @Configuration, @Bean, profiles, application.properties, and externalized configuration.

4

AOP and transactions

Understand proxies, cross-cutting concerns, @Transactional, and transaction boundaries.

5

Spring Boot internals

Understand starters, auto-configuration, embedded Tomcat, application startup, and Actuator.

You can learn these while extending your project. Don't spend weeks memorizing annotations before writing code.

# 7. Extend your project into a real backend

Once the first GET endpoint works, implement these milestones in order.

Project checklist

0 of 8

1. Add GET by ID

Practice @PathVariable and returning 404 when a student doesn't exist.

2. Add POST

Practice @RequestBody, JSON deserialization, and HTTP 201 responses.

3. Add PUT and DELETE

Practice updating and deleting records and handling missing IDs.

4. Add validation

Use Jakarta Bean Validation annotations such as @NotBlank and @Email.

5. Add global exception handling

Use @ControllerAdvice and @ExceptionHandler to return consistent errors.

6. Add a database

Learn SQL, JDBC, JPA, entity mapping, repositories, and transactions.

7. Add automated tests

Test services and controllers using JUnit, Mockito, and Spring Boot testing support.

8. Add security and deployment

Learn authentication, authorization, Docker, configuration, and deployment.

# 8. Recommended learning resources

Use the official documentation as your reference, and use your project as the place to practice.

![](https://www.google.com/s2/favicons?domain=https://spring.io\&sz=32)

Spring Boot documentation

Project setup, auto-configuration, web applications, and application packaging.

Read the documentation 

![](https://www.google.com/s2/favicons?domain=https://spring.io\&sz=32)

Spring Framework documentation

Core container, beans, dependency injection, MVC, and transactions.

Read the documentation 

![](https://www.google.com/s2/favicons?domain=https://jakarta.ee\&sz=32)

Jakarta Servlet specification and API

The lower-level web programming concepts behind traditional Java web applications.

Read the Servlet specification 

![](https://www.google.com/s2/favicons?domain=https://spring.academy\&sz=32)

Spring Academy

Structured Spring learning and hands-on exercises.

Explore courses 

# 9. Your immediate next steps

Here's what I suggest you do today:

1. Create the Spring Boot Maven project using Spring Initializr.

2. Add the `Student`, `StudentService`, and `StudentController` classes above.

3. Run the application and verify the JSON response.

4. Put a breakpoint inside `getAllStudents()` and debug the request.

5. Try to explain how the request travels from Tomcat to your controller.

Once you can explain that flow, continue with the POST endpoint and then database persistence.

The key principle: Learn the underlying technology enough to understand what is happening, but use modern Spring Boot to build practical applications from the beginning. You can deepen your Servlet and Spring internals knowledge as your projects become more complex.

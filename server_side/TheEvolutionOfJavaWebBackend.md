# The Evolution of Java Web Backend: From Servlets to Spring Boot and Jakarta EE

The history of Java web backend development is a great way to understand why today's backend architecture looks the way it does.

Java web development did not begin with Spring Boot. It evolved through several generations of technologies, each solving problems that developers encountered in the previous generation.

The central story is this:

Servlets → JSP and JavaBeans → EJB and Java EE → Spring and Hibernate → REST APIs and Spring Boot → Microservices and cloud-native Java

These technologies overlap rather than cleanly replacing one another. Some are specifications, some are implementations, and others are frameworks built on top of them.

## 1. The big picture: Java web backend timeline




### 1995–2000: The early Java web
![PPT - Comp2513 Web/Application Servers PowerPoint Presentation, free download - ID:3032872](https://images.openai.com/static-rsc-4/9fS9x4W8cjnUpONW0XZZZHFQYyF6CNdRpwbZVurQA9qLnYe6nHK2R9YICRvQf2vHjOw38A70sphQgbIXTvOeQasD7b8Z_0pHl3Rf87AH3mDPByken2aODB1QLo_gwUlmUvl5-34dQWWxeBwhS9dQn-7hyqxm5-O9zCv56hdtaxY?purpose=inline)

CGI → Servlets → JSP

Java entered web development through server-side technologies. Servlets allowed Java code to process HTTP requests, while JSP made it easier to generate HTML pages.




### 1999–2006: J2EE enterprise era
![PPT - EJB Overview PowerPoint Presentation, free download - ID:5161576](https://images.openai.com/static-rsc-4/V96vxejZSWaVPp3dSe3_QOdfIDQACX6uFmu5aOsmd8-qKye03iX4glcMmwSU2MtyKvM9a0Bqc8yVqQjVu6LnKcOzLtfCG2vMZnJu9OP46P__l6WaTKcIsjxl2-hPc8NvI4wbe_PIVscjP3k9OyXUqP5v2yWwOdD5irfAHkoF4PQ?purpose=inline)

Servlets · JSP · EJB · JDBC

Sun Microsystems introduced J2EE for large enterprise applications. Application servers provided standardized services for transactions, security, messaging, and component management.




### 2003–2013: Lightweight Java and frameworks
![Разработка архитектуры для чайников. Часть 1 / Habr](https://images.openai.com/static-rsc-4/0l_OgH1VLEMmzJs1BVE_kCk0yFxemVDP7u03-pEgwYHaWk6ik4uSuXxk01Hdr0-oWYyRLM7cLXeLtbvPWPocd3EPkXTk_NIuTut801yfZjhLdbirn43Uq2xjZH2m8k4MS7SGE9hZOKdNH8N0KR2IaqRuV8EihqCh8wJJeFpMJ8A?purpose=inline)

Spring · Hibernate · Struts · MyBatis

Developers increasingly favored dependency injection, simpler Java objects, and flexible persistence tools. Spring and Hibernate became central to many Java enterprise stacks.




### 2014–2019: Spring Boot and REST APIs
![How Java and Spring Boot enable microservices architecture. | Sagar M H posted on the topic | LinkedIn](https://images.openai.com/static-rsc-4/EccYkvnvZFVDXdy-8_ZIyiw0CBKSjngzGFL_9x8K70fB66aU3671TLcK-J--ht_C-sJW5sIyZMZ3yywtW3hf_tMAFHpfNypgm2czhYeVAdtpTIO3_538AO7O_jaAsJXNVeRwBb-akem59EfM6VSnAozHVv-Tjg5s3hxUJH-513o?purpose=inline)

Spring Boot · JSON · REST · embedded servers

Spring Boot simplified configuration and application startup. Backend services increasingly exposed JSON APIs for browsers, mobile apps, and other services instead of generating every page on the server.




### 2020s–present: Cloud-native Java
![Microservices Architecture with Spring Boot & Kubernetes | by AKCoding.com | Medium](https://images.openai.com/static-rsc-4/7DnHB_LObJJmmN46SaKO0tRbBSZeDLB799J68baMcIEJxf_0AFjDDlrhZOda6H323gmecgYJfTut_VF3G6k37qRpf17hFCpGr-mlvNUEQk09Ez08QI_YWHdKLInpTIqkEUqqJIoFakzHTGuVFzCFry5JXG5sGGMSvjBHb7Ic9rM?purpose=inline)

Microservices · containers · observability · virtual threads

Java backends increasingly run in containers and cloud environments. Spring Boot remains prominent, while Jakarta EE and frameworks such as Quarkus and Micronaut continue evolving.

## 2. Generation 1: Servlets and JSP — the foundation (1990s)

Before Java web technologies became widespread, web servers often used CGI (Common Gateway Interface) to execute server-side programs.

Java introduced a more integrated approach.
```
Browser
HTTP request

Web server / Servlet container
Tomcat

Servlet
Java request-handling code

Database
JDBC
```
The main technologies were:

* Servlet: receives HTTP requests and generates HTTP responses.

* JSP (JavaServer Pages): generates dynamic HTML pages, with JSP pages translated into servlets by the container.

* JDBC: lets Java applications communicate with relational databases.

* Tomcat: implements servlet and JSP specifications and runs web applications.

A simplified Servlet example:



```Java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");
        response.getWriter().println("Hello, Java Web!");
    }
}
```

The Servlet container handles the HTTP integration and invokes your handler. You focus on application logic.

The problem: as applications grew, developers repeatedly wrote routing, HTML generation, database access, authentication, and transaction-handling code. That created demand for higher-level frameworks.

## 3. Generation 2: J2EE — standardized enterprise development (1999–2006)

Sun Microsystems introduced the Java 2 Platform, Enterprise Edition, or J2EE, in 1999. It later became Java EE.

J2EE aimed to provide standardized infrastructure for large business systems rather than making every company implement its own enterprise services.

Its major technologies included:

| Technology         | Purpose                                    |
| ------------------ | ------------------------------------------ |
| Servlets and JSP   | Web requests and pages                     |
| EJB                | Enterprise components and managed services |
| JDBC               | Database connectivity                      |
| JTA                | Transaction coordination                   |
| JMS                | Messaging                                  |
| JNDI               | Naming and resource lookup                 |
| JPA's predecessors | Object-relational persistence approaches   |

A typical enterprise deployment used an application server such as WebLogic, WebSphere, or JBoss.

The application server supplied services such as transaction management, security, connection pooling, and component lifecycle management.

### Why did EJB become controversial?

Early versions of EJB, particularly entity beans and their associated programming model, could require substantial configuration and infrastructure. Enterprise applications sometimes became difficult to develop and test.

This created an opening for lighter frameworks that used ordinary Java objects, dependency injection, and simpler persistence approaches.

That is one of the historical reasons Spring became popular.

![](https://www.google.com/s2/favicons?domain=https://www.springframework.org\&sz=32)





## 4. Generation 3: Spring, Hibernate, Struts, and MyBatis (2000s)

This period is particularly important because many ideas used in modern Java backend development became mainstream.




Spring Framework — 2003

![Dependency Injection in Spring (Explained with Coding Examples) | by Ramesh Fadatare | Javarevisited | Medium](https://images.openai.com/static-rsc-4/tgOVyPDcwemh9bCE7mxnM9yjmL8IAcNw2rwBO_UyKC3QV0DR_zYZu3-oVevy3LDfIPncvbbtiOTR-Z1T1XKearmp5aBb5BOSc9xS9ZDu4DhHigKzKbID1Tw0oBKpQr4PlNba7DOZfX99g7W9Gy-UHCVCBb_OZKk4YTjmc1Au-GQ?purpose=inline)

Introduced a flexible programming model centered on dependency injection and modular infrastructure. Spring MVC offered an alternative way to build web applications, and Spring integrated with Java EE APIs rather than requiring developers to use the entire Java EE platform.




Hibernate — early 2000s

![PPT - Hibernate PowerPoint Presentation, free download - ID:4627678](https://images.openai.com/static-rsc-4/5_ZRB59NchWZA0kIXiAye3vhebHLGfgwRixLfEuILHNUXu_LohNP4A50LBlFnRhlSEv24GNLOWQX_WwJMurFyvFY9Ue1imez72p2i3dI3IYw1sfwFolBy2dq46hfmUjXIv8TheHxSz0zqBT_xtoOgDEse-jkcaMOetK4nHIpFbo?purpose=inline)

Popularized object-relational mapping (ORM), letting developers work with Java objects while the framework handled much of the SQL mapping. JPA later standardized a persistence API, and Hibernate became a major JPA implementation.



Struts — early MVC framework

![PPT - UNIT-V The MVC architecture and Struts Framework PowerPoint Presentation - ID:1660483](https://images.openai.com/static-rsc-4/zdZglOlIy1aFU-biR8LssLDKQGR8sTvtYst-hEobWpUvkCnqYp4d1MMp8DNk-R1I76-DGlva1L1Wg3vN_BdLp5YRkN9xAThRWX4__xDhSoENyF0vVLZzr44_DEGfwO9DJew92YWAvb7DS7LtBUcOkGg5NFoMjVTndaYMDEc96G0?purpose=inline)

Helped organize web applications around the Model–View–Controller pattern, separating request handling, business data, and presentation.







MyBatis — SQL mapping

![1. MyBatis Overview - Technical Documents(English) -](https://images.openai.com/static-rsc-4/ECUUisp9b6sI8mT71ZCo8dP7pf-ijXTf78-oO1YdhH9-ckgfHYCZb4PYHWxE5M_mARY4I6steEyz84u3tQc9D72GTZeWfSlQz0SdhtFDXdVc14wT8BVfltNRb8WqfB9kpUkjvynVJT6wdKhS7vVXvyqOkXRHGtXxqTbbrmsB1yc?purpose=inline)

Offers a more SQL-centered alternative to full ORM. Developers explicitly control SQL statements while mapping results to Java objects.

These tools solve different problems. Spring does not simply replace Hibernate, and Hibernate does not replace JDBC. A Spring application can use Hibernate, MyBatis, or JDBC depending on its requirements.

## 5. Generation 4: Spring Boot and the REST API era (2014 onward)

Spring Boot 1.0 reached general availability on April 1, 2014. Its goal was to make Spring applications easier to start, configure, and deploy, including applications packaged with embedded servers.

![](https://www.google.com/s2/favicons?domain=https://spring.io\&sz=32)





The shift was significant: instead of manually assembling a large application-server deployment, developers could create a standalone application and run it with `java -jar`.

A modern backend request might look like this:
```
Frontend
Browser / mobile application

Spring MVC
Routes HTTP requests to controllers

Service layer
Business logic and transactions

Repository / persistence layer
JPA, Hibernate, MyBatis, or JDBC

Database
MySQL / PostgreSQL / Oracle
```
For example, a simple Spring Boot REST controller:



```Java
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping
    public List<String> getStudents() {
        return List.of("Alice", "Bob", "Charlie");
    }
}
```

A request to `GET /api/students` returns JSON, rather than requiring a JSP page to generate HTML.

The framework handles much of the HTTP routing and JSON serialization. You still need to design the business logic, validation, persistence, security, and error handling.

## 6. Java EE becomes Jakarta EE (2017–present)

Java EE did not simply disappear. Its stewardship changed.

1. 2017 — Java EE 8: Oracle's final Java EE release was approved in August 2017.

   ![](https://www.google.com/s2/favicons?domain=https://javaee.github.io\&sz=32)

   javaee.github.io

2. 2017–2019 — Transition: Oracle transferred Java EE technologies to the Eclipse Foundation, where the community continued developing the platform.

3. 2019 — Jakarta EE 8: The first Eclipse Foundation release remained compatible with the Java EE 8 APIs.

4. 2020 — Jakarta EE 9: The platform introduced a major package namespace change from `javax.*` to `jakarta.*` for the specifications it covers. Existing applications may require migration.

5. 2022 — Jakarta EE 10: Continued modernization of the enterprise platform.

6. 2025 — Jakarta EE 11: A further release of the community-driven enterprise platform. Jakarta EE 12 is under development as of October 2026.

   ![](https://www.google.com/s2/favicons?domain=https://jakarta.ee\&sz=32)

   The Eclipse Foundation

   

One detail is especially important for Java developers: not every package beginning with `javax` became `jakarta`. The change applies to the relevant Jakarta EE APIs, not all Java platform packages.

For example:



```Java
// Older Java EE / Jakarta EE 8-era Servlet API
import javax.servlet.http.HttpServlet;

// Jakarta EE 9+ Servlet API
import jakarta.servlet.http.HttpServlet;
```

This is why framework versions, Java versions, and server versions must be compatible with each other.

## 7. Java EE versus Spring versus Spring Boot

These names are often confused because they overlap in the kinds of applications they support.

| Technology           | What it is                           | Main role                                             |
| -------------------- | ------------------------------------ | ----------------------------------------------------- |
| Servlet              | Specification/API                    | HTTP request and response processing                  |
| Tomcat               | Servlet container                    | Runs Servlet-based web applications                   |
| Java EE / Jakarta EE | Enterprise platform specifications   | Standard APIs for enterprise applications             |
| Spring Framework     | Application framework                | Dependency injection, web, data access, transactions  |
| Spring Boot          | Spring application-building toolset  | Auto-configuration, starters, executable applications |
| Hibernate            | ORM framework and JPA implementation | Maps Java objects to relational data                  |
| Quarkus / Micronaut  | Application frameworks               | Modern JVM and cloud-oriented application development |

Spring and Jakarta EE are not strictly mutually exclusive. Spring applications can use selected Jakarta APIs, and both ecosystems can support enterprise backend workloads.

![](https://www.google.com/s2/favicons?domain=https://www.springframework.org\&sz=32)





## 8. What should you learn from this history?

Since your goal is Java backend development, I would follow this practical path:
```
## 01 Learn HTTP and Servlets conceptually
Understand requests, responses, routing, the Servlet container, filters, and the request lifecycle. Write a small Servlet if you want to see how the lower-level pieces work.

## 02 Learn Spring Core
Focus on IoC, dependency injection, beans, configuration, and application contexts. These explain much of what Spring Boot does behind the scenes.

## 03 Build a Spring Boot REST API
Use Maven, Spring MVC, validation, exception handling, and JSON. You don't need to master JSP or EJB first.

## 04 Add persistence and production features
Learn SQL, JDBC, JPA/Hibernate, Spring Data, transactions, security, testing, logging, and deployment.
```
My main advice: 

learn the historical foundations, but build projects with modern tools. 

Understanding Servlets helps you understand Spring MVC; understanding dependency injection helps you understand Spring Boot; and understanding JDBC and SQL helps you understand persistence frameworks.

That way, you learn not just which annotations to use, but also why Java backend development evolved into its current form.

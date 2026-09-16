# What is Hibernate?

**Hibernate** is a Java **ORM (Object-Relational Mapping) framework**.

Its main purpose is to make it easier for a Java application to work with a relational database such as MySQL, PostgreSQL, or Oracle.

The fundamental idea is:

```text
Java world                    Database world

Java Object      ←→           Table
Java field       ←→           Column
Object ID        ←→           Primary Key
Object reference ←→           Foreign Key
```

For example, suppose your Java application has:

```java
class User {
    Long id;
    String name;
    int age;
}
```

and your database has:

```text
users
+----+-------+-----+
| id | name  | age |
+----+-------+-----+
|  1 | Alice |  20  |
|  2 | Bob   |  30  |
+----+-------+-----+
```

Hibernate maps the Java `User` object to the `users` table.

---

# 1. Why was Hibernate created?

Without an ORM framework, Java applications traditionally use **JDBC**.

For example:

```java
String sql = "SELECT id, name, age FROM users WHERE id = ?";

PreparedStatement ps = connection.prepareStatement(sql);
ps.setLong(1, 10);

ResultSet rs = ps.executeQuery();

if (rs.next()) {
    User user = new User();

    user.setId(rs.getLong("id"));
    user.setName(rs.getString("name"));
    user.setAge(rs.getInt("age"));
}
```

This works, but there is a lot of repetitive code:

```text
SQL
 ↓
PreparedStatement
 ↓
parameters
 ↓
ResultSet
 ↓
read columns
 ↓
create Java object
 ↓
copy values
```

Hibernate tries to automate much of this.

Conceptually:

```java
User user = entityManager.find(User.class, 10L);
```

Hibernate takes care of much of the database interaction.

---

# 2. Hibernate's fundamental idea

The central concept is **ORM**.

ORM means:

> **Object-Relational Mapping**

"Object" means the Java object model.

"Relational" means the relational database model.

So Hibernate provides a bridge:

```text
              Hibernate
                  │
        ┌─────────┴─────────┐
        │                   │
 Java Objects          Relational Tables
        │                   │
     User.java             users
     Product.java          products
     Order.java            orders
```

This is why Hibernate is called an **ORM framework**.

---

# 3. An Entity

The most basic Hibernate concept is an **entity**.

An entity is a Java class that represents persistent data.

For example:

```java
@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private int age;

    // constructors, getters, setters
}
```

The important annotations are:

```java
@Entity
@Id
```

`@Entity` says:

> This Java class represents persistent data.

`@Id` says:

> This field is the entity's primary key.

Hibernate can then map it approximately like:

```text
Java                         Database

User                         users
─────────────────────────────────────
id              ←──────→     id
name            ←──────→     name
age             ←──────→     age
```

---

# 4. Hibernate doesn't require you to write SQL for everything

For example, you can conceptually do:

```java
User user = entityManager.find(User.class, 1L);
```

Hibernate generates the appropriate SQL, approximately:

```sql
SELECT id, name, age
FROM users
WHERE id = 1;
```

You work with:

```java
User
```

instead of directly working with:

```text
Connection
PreparedStatement
ResultSet
```

This is the main convenience of ORM.

---

# 5. Hibernate and JPA

This distinction is **extremely important**.

People often say:

> "JPA and Hibernate are the same thing."

They aren't.

Think:

```text
JPA
 │
 │ specification
 ↓
Hibernate
 │
 │ implementation
 ↓
Database
```

More precisely, modern Java uses **Jakarta Persistence**, which evolved from the older JPA specification.

The specification defines concepts such as:

```java
@Entity
@Id
@OneToMany
@ManyToOne
@OneToOne
```

Hibernate is one implementation of that specification.

There are other JPA implementations, but Hibernate is one of the most widely used.

---

# 6. Hibernate and Spring

This is where Hibernate becomes especially important for you as a Spring learner.

A modern Spring Boot application might have:

```text
Your application
       ↓
Spring Data JPA
       ↓
JPA / Jakarta Persistence
       ↓
Hibernate
       ↓
JDBC
       ↓
Database
```

For example:

```java
public interface UserRepository
        extends JpaRepository<User, Long> {
}
```

Then you can write:

```java
User user = userRepository.findById(1L)
                           .orElse(null);
```

You didn't explicitly write:

```sql
SELECT ...
```

Spring Data JPA provides the repository abstraction, while Hibernate commonly performs the actual ORM work underneath.

So remember:

```text
Spring Data JPA ≠ Hibernate
```

and:

```text
Spring Data JPA
       ↓
      JPA
       ↓
   Hibernate
```

---

# 7. CRUD

Hibernate is particularly convenient for CRUD operations.

CRUD means:

```text
C = Create
R = Read
U = Update
D = Delete
```

### Create

```java
User user = new User();
user.setName("Alice");
user.setAge(20);

entityManager.persist(user);
```

Conceptually:

```sql
INSERT INTO users ...
```

### Read

```java
User user = entityManager.find(User.class, 1L);
```

Conceptually:

```sql
SELECT ...
```

### Update

You can modify a managed entity:

```java
user.setAge(21);
```

Hibernate can detect the change and eventually issue an update.

This behavior is called **dirty checking**.

### Delete

```java
entityManager.remove(user);
```

Conceptually:

```sql
DELETE FROM users WHERE id = ...
```

---

# 8. Dirty checking

**Dirty checking** is one of the most important Hibernate concepts.

Suppose:

```java
User user = entityManager.find(User.class, 1L);

user.setName("Bob");
```

You didn't explicitly write:

```java
UPDATE users
SET name = 'Bob'
WHERE id = 1;
```

Hibernate tracks the entity.

At the appropriate point in the transaction, Hibernate detects that the object changed and generates an SQL `UPDATE`.

Conceptually:

```text
Database
   ↓
find()
   ↓
User object
   ↓
change object
   ↓
Hibernate detects change
   ↓
UPDATE SQL
   ↓
Database
```

This is one of the major differences between ORM and simple SQL mapping.

---

# 9. Relationships

Relational databases have relationships:

```text
User
  │
  │ 1:N
  ↓
Orders
```

Hibernate can represent this relationship with Java objects.

For example:

```java
@Entity
class User {

    @Id
    private Long id;

    private String name;

    @OneToMany
    private List<Order> orders;
}
```

You can also have:

```java
@ManyToOne
```

```java
@OneToOne
```

```java
@ManyToMany
```

These correspond to common relational relationships.

For example:

```text
User
 │
 │ 1
 │
 │
 │ N
 ↓
Order
```

can correspond to:

```text
users
  id
   │
   │
   ↓
orders
  user_id
```

Hibernate handles much of the mapping between these two models.

---

# 10. Persistence Context

Another important Hibernate concept is the **persistence context**.

You can think of it initially as a managed collection of entity objects.

```text
Persistence Context

┌───────────────────────┐
│ User #1               │
│ User #2               │
│ Product #10           │
│ Order #100            │
└───────────────────────┘
```

When an entity is managed by the persistence context, Hibernate tracks it.

This enables things such as:

* identity management
* dirty checking
* first-level caching
* automatic synchronization with the database

For example:

```java
User a = entityManager.find(User.class, 1L);
User b = entityManager.find(User.class, 1L);
```

Within the same persistence context, Hibernate can ensure that these references represent the same managed entity instance.

This is a major concept to understand once you go beyond basic CRUD.

---

# 11. First-level cache

Hibernate has a **first-level cache** associated with the persistence context.

For example:

```java
User a = entityManager.find(User.class, 1L);
User b = entityManager.find(User.class, 1L);
```

Hibernate doesn't necessarily need to execute two database queries.

Conceptually:

```text
find(User, 1)
     ↓
Database
     ↓
Persistence Context
     ↓
User #1
```

Then:

```text
find(User, 1)
     ↓
Persistence Context
     ↓
existing User #1
```

This is why understanding the persistence context is important for understanding Hibernate performance.

---

# 12. Lazy loading

Suppose a user has many orders:

```java
User user = entityManager.find(User.class, 1L);
```

Do you immediately want all of the user's orders?

Maybe not.

Hibernate can use **lazy loading**:

```text
User
 │
 ├── id
 ├── name
 └── orders
        ↓
     not loaded yet
```

Later:

```java
user.getOrders();
```

Hibernate may then load the orders from the database.

Conceptually:

```text
Load User
   ↓
Don't load Orders yet
   ↓
getOrders()
   ↓
SQL query
   ↓
Load Orders
```

This can improve performance, but it also creates important issues such as the **N+1 query problem**.

---

# 13. The N+1 problem

This is one of the most important Hibernate interview topics.

Suppose you load 100 users:

```text
SELECT * FROM users;
```

Then Hibernate lazily loads each user's orders:

```text
SELECT * FROM orders WHERE user_id = 1;
SELECT * FROM orders WHERE user_id = 2;
SELECT * FROM orders WHERE user_id = 3;
...
```

You could end up with:

```text
1 query for users
+
100 queries for orders
=
101 queries
```

That's the **N+1 query problem**.

Understanding Hibernate means understanding not only:

> "How can Hibernate generate SQL for me?"

but also:

> **"What SQL is Hibernate actually generating?"**

This is extremely important in real-world applications.

---

# 14. Hibernate doesn't eliminate SQL

This is a common beginner misconception.

Hibernate does **not** mean:

> "I don't need to know SQL anymore."

You absolutely should know SQL.

A good backend developer understands:

```text
Java
  ↓
JPA
  ↓
Hibernate
  ↓
Generated SQL
  ↓
Database execution
```

When performance becomes a problem, you often need to inspect the SQL Hibernate generates.

---

# 15. Hibernate vs MyBatis

This connects directly to your previous question.

### Hibernate

You primarily think in terms of objects:

```java
User user = entityManager.find(User.class, 1L);
```

Hibernate figures out much of the SQL.

```text
Java Object
     ↓
 Hibernate
     ↓
Generated SQL
     ↓
Database
```

### MyBatis

You primarily think in terms of SQL:

```java
@Select("""
    SELECT id, name, age
    FROM users
    WHERE id = #{id}
""")
User findById(Long id);
```

```text
Java
 ↓
Your SQL
 ↓
MyBatis mapping
 ↓
Database
```

So the philosophical difference is approximately:

```text
Hibernate
"Tell me what objects you want."

MyBatis
"Tell me what SQL you want."
```

Neither approach makes the other obsolete.

---

# 16. Hibernate's position in modern Java

Historically:

```text
JDBC
  ↓
Hibernate
  ↓
Spring + Hibernate
  ↓
Spring Data JPA + Hibernate
```

Today, a common stack is:

```text
Spring Boot
     │
     ├── Spring MVC
     │      ↓
     │   REST API
     │
     └── Spring Data JPA
             ↓
       Jakarta Persistence
             ↓
          Hibernate
             ↓
            JDBC
             ↓
         PostgreSQL
```

So Hibernate is **not an old framework like Struts**.

It remains a relevant persistence technology in the modern Java ecosystem.

---

# 17. What you should learn in Hibernate

Since you're studying Java backend systematically, I wouldn't try to memorize hundreds of Hibernate APIs.

Learn these concepts in roughly this order:

```text
1. ORM
   ↓
2. Entity
   ↓
3. JPA / Jakarta Persistence
   ↓
4. Hibernate
   ↓
5. EntityManager
   ↓
6. Persistence Context
   ↓
7. Entity lifecycle
   ↓
8. CRUD
   ↓
9. Relationships
   ↓
10. Lazy vs eager loading
   ↓
11. Dirty checking
   ↓
12. Transactions
   ↓
13. JPQL
   ↓
14. Fetch joins
   ↓
15. N+1 problem
   ↓
16. First-level cache
   ↓
17. Second-level cache
   ↓
18. Hibernate performance
```

The **entity lifecycle** is particularly worth learning:

```text
             persist()
New ──────────────────→ Managed
                          │
                          │ modify
                          ↓
                       Dirty
                          │
                          │ commit/flush
                          ↓
                       Database

Managed ──→ Detached
```

Once you understand that diagram, a lot of Hibernate behavior becomes much easier to understand.

---

## The big picture

If you're learning modern Java backend, I'd organize the technologies like this:

```text
                    Web
                     │
                  HTTP
                     │
                  Tomcat
                     │
              Servlet infrastructure
                     │
               Spring MVC
                     │
                Spring Boot
                     │
                  REST
                     │
                 Service
                     │
              ┌──────┴──────┐
              │             │
        Spring Data JPA   MyBatis
              │
        Jakarta Persistence
              │
          Hibernate
              │
             JDBC
              │
           Database
```

The most important distinction to remember is:

**JPA/Jakarta Persistence** → specification

**Hibernate** → ORM implementation

**Spring Data JPA** → Spring abstraction for working with JPA repositories

**MyBatis** → SQL mapper, providing a different approach to database access

**JDBC** → low-level Java database API

So if you're building a modern Spring Boot backend, **Hibernate is still worth learning—but learn it as part of the larger persistence stack rather than as an isolated framework.**

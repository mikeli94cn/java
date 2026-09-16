# What is MyBatis?

**MyBatis** is a Java **SQL mapping framework** that helps applications communicate with relational databases.

The key idea is:

> **MyBatis lets you write SQL yourself while it handles the mapping between SQL results and Java objects.**

This is different from Hibernate, where the ORM framework tries to manage much more of the object-relational mapping and SQL generation.

---

## 1. The basic idea

Suppose your database has:

```text
users
+----+-------+-----+
| id | name  | age |
+----+-------+-----+
|  1 | Alice |  20  |
|  2 | Bob   |  30  |
+----+-------+-----+
```

And Java has:

```java
public class User {
    private Long id;
    private String name;
    private int age;

    // getters and setters
}
```

With MyBatis, you can explicitly write:

```sql
SELECT id, name, age
FROM users
WHERE id = #{id}
```

and tell MyBatis:

```text
SQL result
   ↓
map columns
   ↓
User object
```

So:

```text
Database
   ↓
    SQL
   ↓
 MyBatis
   ↓
 Java Object
```

---

# 2. A simple MyBatis example

A modern MyBatis application can define a mapper interface:

```java
@Mapper
public interface UserMapper {

    @Select("""
        SELECT id, name, age
        FROM users
        WHERE id = #{id}
    """)
    User findById(Long id);
}
```

Then your service can simply call:

```java
User user = userMapper.findById(1L);
```

MyBatis executes approximately:

```sql
SELECT id, name, age
FROM users
WHERE id = 1;
```

and maps the result:

```text
SQL result
   ↓
id   → User.id
name → User.name
age  → User.age
```

---

# 3. XML configuration

MyBatis also has a traditional XML-based approach.

For example:

```xml
<select id="findById"
        resultType="com.example.User">

    SELECT id, name, age
    FROM users
    WHERE id = #{id}

</select>
```

And the Java mapper:

```java
public interface UserMapper {
    User findById(Long id);
}
```

The XML tells MyBatis:

> When `findById()` is called, execute this SQL and map the result to `User`.

So MyBatis historically has two common styles:

```text
Annotation
    ↓
@Select(...)
@Insert(...)
@Update(...)
@Delete(...)

XML
    ↓
<select>
<insert>
<update>
<delete>
```

XML remains useful for complicated SQL.

---

# 4. Why use MyBatis?

The biggest advantage is **SQL control**.

Suppose you have a complicated query:

```sql
SELECT
    u.id,
    u.name,
    COUNT(o.id) AS order_count
FROM users u
LEFT JOIN orders o
    ON u.id = o.user_id
WHERE u.age >= 18
GROUP BY u.id, u.name
HAVING COUNT(o.id) > 5
ORDER BY order_count DESC;
```

With MyBatis, you can write exactly this SQL.

That makes MyBatis attractive when:

* SQL is complicated
* queries need careful optimization
* database-specific SQL is important
* developers are comfortable with SQL
* you want predictable control over queries

---

# 5. MyBatis vs JDBC

MyBatis is built at a higher level than JDBC.

With JDBC, you might write:

```java
PreparedStatement ps =
    connection.prepareStatement(
        "SELECT id, name, age FROM users WHERE id = ?"
    );

ps.setLong(1, id);

ResultSet rs = ps.executeQuery();

User user = new User();

if (rs.next()) {
    user.setId(rs.getLong("id"));
    user.setName(rs.getString("name"));
    user.setAge(rs.getInt("age"));
}
```

There is a lot of plumbing.

With MyBatis:

```java
@Select("""
    SELECT id, name, age
    FROM users
    WHERE id = #{id}
""")
User findById(Long id);
```

MyBatis handles much of the repetitive JDBC work.

So:

```text
JDBC
Java
 ↓
SQL
 ↓
PreparedStatement
 ↓
ResultSet
 ↓
manually map columns
```

versus:

```text
MyBatis
Java
 ↓
SQL
 ↓
MyBatis
 ↓
Java Object
```

---

# 6. MyBatis vs Hibernate

This is probably the most important comparison for you.

### Hibernate

Hibernate is an **ORM**.

You primarily work with objects:

```java
User user = entityManager.find(User.class, 1L);
```

Hibernate decides how to translate your object-oriented operations into SQL.

```text
Java objects
     ↓
  Hibernate
     ↓
generated SQL
     ↓
 Database
```

### MyBatis

MyBatis is a **SQL mapper**.

You primarily control the SQL:

```java
User user = userMapper.findById(1L);
```

with:

```sql
SELECT id, name, age
FROM users
WHERE id = #{id}
```

```text
Your SQL
   ↓
 MyBatis
   ↓
Java objects
   ↓
 Database
```

The philosophical difference is:

> **Hibernate: "I work primarily with objects; the ORM handles much of the SQL."**

> **MyBatis: "I write the SQL; the framework handles much of the Java/JDBC mapping."**

---

# 7. A useful comparison

|                | JDBC       | MyBatis              | Hibernate/JPA           |
| -------------- | ---------- | -------------------- | ----------------------- |
| Abstraction    | Low        | Medium               | High                    |
| SQL            | You write  | You write            | Often generated         |
| Object mapping | Manual     | Framework            | Framework               |
| ORM            | ❌          | ❌                    | ✅                       |
| SQL control    | Very high  | Very high            | Lower                   |
| Complex SQL    | Good       | Excellent            | Can be more complicated |
| CRUD           | Verbose    | Moderate             | Convenient              |
| Relationships  | Manual     | Explicit SQL/mapping | ORM relationships       |
| Learning model | SQL + Java | SQL + mapping        | Object-relational model |

You can visualize the abstraction levels as:

```text
             Higher abstraction
                    ↑
                    │
              Hibernate/JPA
                    │
                 MyBatis
                    │
                  JDBC
                    │
                    ↓
             Lower abstraction
```

---

# 8. MyBatis with Spring Boot

MyBatis integrates very well with Spring Boot.

A typical architecture might be:

```text
Spring Boot
     │
     ↓
Controller
     │
     ↓
Service
     │
     ↓
MyBatis Mapper
     │
     ↓
SQL
     │
     ↓
Database
```

For example:

```java
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
}
```

Then:

```java
@Service
public class UserService {

    private final UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
```

And:

```java
@Mapper
public interface UserMapper {

    @Select("""
        SELECT id, name, age
        FROM users
        WHERE id = #{id}
    """)
    User findById(Long id);
}
```

So the full flow is:

```text
HTTP
 ↓
Spring MVC
 ↓
Controller
 ↓
Service
 ↓
MyBatis
 ↓
SQL
 ↓
Database
```

---

# 9. Dynamic SQL

One particularly useful MyBatis feature is **dynamic SQL**.

For example, suppose you have a search API where `name` and `age` are optional.

You can write XML like:

```xml
<select id="searchUsers"
        resultType="User">

    SELECT id, name, age
    FROM users

    <where>
        <if test="name != null">
            AND name = #{name}
        </if>

        <if test="age != null">
            AND age = #{age}
        </if>
    </where>

</select>
```

MyBatis dynamically constructs the SQL based on the parameters.

This can be very useful for complicated search/filter APIs.

---

# 10. MyBatis doesn't mean "no database abstraction"

Although MyBatis gives you much more SQL control, it still provides useful infrastructure:

```text
MyBatis
├── SQL execution
├── parameter binding
├── ResultSet mapping
├── Java object mapping
├── dynamic SQL
├── transaction integration
└── connection/resource management
```

So you don't have to deal with all the low-level JDBC mechanics yourself.

---

# 11. MyBatis in the Java ecosystem

You can think of the database-access ecosystem like this:

```text
                    Java Application
                           │
                    Spring Boot
                           │
                ┌──────────┴──────────┐
                │                     │
          Spring Data JPA           MyBatis
                │                     │
               JPA                  SQL
                │                     │
            Hibernate            JDBC internally
                │                     │
                └──────────┬──────────┘
                           ↓
                        Database
```

So **Spring doesn't replace MyBatis**, and MyBatis doesn't replace Spring.

They operate at different layers.

You can even have Spring + MyBatis:

```text
Spring Boot
    +
MyBatis
```

or:

```text
Spring Boot
    +
Spring Data JPA
    +
Hibernate
```

Both are legitimate architectures.

---

# 12. What should you learn?

For your systematic Java backend learning, I'd recommend:

### First learn

```text
SQL
 ↓
JDBC fundamentals
 ↓
JPA concepts
 ↓
Hibernate
 ↓
Spring Data JPA
```

Then learn:

```text
MyBatis
```

You don't need to become an expert in both immediately.

The important conceptual difference is:

```text
Hibernate/JPA

Object-oriented approach
        ↓
Java Entity
        ↓
ORM
        ↓
SQL
        ↓
Database
```

versus:

```text
MyBatis

SQL-oriented approach
        ↓
Your SQL
        ↓
MyBatis
        ↓
Java Object
        ↓
Database
```

If you understand **both approaches**, you'll have a much better understanding of how modern Java applications interact with relational databases—and you'll also understand why a particular Spring Boot project might choose **Spring Data JPA/Hibernate** or **MyBatis**.

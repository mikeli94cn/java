In real Spring Boot apps, “serialization” mostly means:

> Converting **Java objects ⇄ JSON (or XML)** automatically in REST APIs

Spring Boot does this for you using **Jackson** (by default).

Let’s walk through **real-world patterns**, not just basics.

---

# 🧭 1. Big Picture

### Request flow (deserialization)

```text
JSON → HTTP → Spring → Java Object (DTO)
```

### Response flow (serialization)

```text
Java Object → Spring → JSON → HTTP response
```

---

# 🧱 2. Basic Example (End-to-End)

---

## DTO (Data Transfer Object)

```java
public class User {
    private String name;
    private int age;

    // getters + setters
}
```

---

## Controller

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        // JSON → User (deserialization)
        return user; 
        // User → JSON (serialization)
    }
}
```

---

## Request

```json
{
  "name": "Mike",
  "age": 30
}
```

---

## Response

```json
{
  "name": "Mike",
  "age": 30
}
```

---

# ⚙️ 3. How It Works Internally

Spring uses:

* `HttpMessageConverter`
* Jackson `ObjectMapper`

👉 Automatically:

* Reads JSON → object
* Writes object → JSON

---

# 🧩 4. Real-World Customization with Jackson

---

## 4.1 Rename Fields

```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("user_name")
    private String name;

    private int age;
}
```

---

## 4.2 Ignore Fields

```java
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private String name;

    @JsonIgnore
    private String password;
}
```

👉 Never expose sensitive data

---

## 4.3 Include Only Non-null Fields

```java
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String name;
    private String email;
}
```

---

## 4.4 Format Dates

```java
import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
```

---

# 🔁 5. Nested Objects (Real API)

---

## Model

```java
public class Order {
    private Long id;
    private User user;
}
```

---

## JSON

```json
{
  "id": 1,
  "user": {
    "name": "Mike",
    "age": 30
  }
}
```

---

# 🔄 6. Collections

```java
@GetMapping
public List<User> getUsers() {
    return List.of(new User("Mike", 30));
}
```

👉 Automatically serialized to:

```json
[
  {
    "name": "Mike",
    "age": 30
  }
]
```

---

# ⚠️ 7. Common Real-World Problems

---

## 7.1 Infinite Recursion (VERY COMMON)

```java
class User {
    List<Order> orders;
}

class Order {
    User user;
}
```

👉 Causes:

```
StackOverflowError
```

---

### ✅ Solution

```java
import com.fasterxml.jackson.annotation.*;

class User {
    @JsonManagedReference
    List<Order> orders;
}

class Order {
    @JsonBackReference
    User user;
}
```

---

OR:

```java
@JsonIgnore
User user;
```

---

# 🧠 8. DTO vs Entity (IMPORTANT)

---

### ❌ Bad (direct entity exposure)

```java
@GetMapping
public User getUser() {
    return userRepository.findById(1);
}
```

---

### ✅ Good (use DTO)

```java
public class UserDTO {
    private String name;
}
```

```java
@GetMapping
public UserDTO getUser() {
    User user = repo.findById(1);
    return new UserDTO(user.getName());
}
```

👉 Benefits:

* Security
* Decoupling
* Control over serialization

---

# 🔧 9. Custom Serialization Logic

---

## Custom Serializer

```java
public class UpperCaseSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(value.toUpperCase());
    }
}
```

---

## Use it

```java
@JsonSerialize(using = UpperCaseSerializer.class)
private String name;
```

---

# 🧪 10. Validation + Serialization

```java
import jakarta.validation.constraints.*;

public class UserDTO {

    @NotNull
    private String name;

    @Min(18)
    private int age;
}
```

```java
@PostMapping
public UserDTO create(@Valid @RequestBody UserDTO user) {
    return user;
}
```

👉 Combines:

* Validation
* Deserialization
* Serialization

---

# 📦 11. Global Configuration

---

## Customize ObjectMapper

```java
@Bean
public ObjectMapper objectMapper() {
    return JsonMapper.builder()
        .findAndAddModules()
        .build();
}
```

---

## application.properties

```properties
spring.jackson.serialization.indent-output=true
spring.jackson.default-property-inclusion=non_null
```

---

# 🚀 12. Real-World API Example

---

```java
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest req) {

        OrderResponse res = new OrderResponse();
        res.setId(1L);
        res.setStatus("CREATED");

        return res;
    }
}
```

---

### Request DTO

```java
class OrderRequest {
    private Long userId;
    private List<String> items;
}
```

---

### Response DTO

```java
class OrderResponse {
    private Long id;
    private String status;
}
```

---

# 🧠 13. Interview Insights

---

### ❓ What handles serialization in Spring Boot?

👉 Jackson via `HttpMessageConverter`

---

### ❓ Difference: `@RequestBody` vs `@ResponseBody`

| Annotation      | Purpose     |
| --------------- | ----------- |
| `@RequestBody`  | JSON → Java |
| `@ResponseBody` | Java → JSON |

---

### ❓ Why use DTO?

* Avoid exposing DB schema
* Control JSON output
* Prevent security leaks

---

### ❓ Common mistakes

* Returning entities directly
* Infinite recursion
* Not handling nulls

---

# 🧭 14. Mental Model

```text
Controller
   ↓
Jackson (ObjectMapper)
   ↓
JSON ⇄ Java Object
```

---

# 🔚 Final Summary

* Spring Boot uses **Jackson** by default
* `@RequestBody` → deserialization
* Return object → serialization
* Use DTOs for real-world APIs
* Customize with Jackson annotations
* Watch for recursion & security issues

---

# 🚀 If you want next level

I can show you:

* How serialization works with **Hibernate lazy loading**
* Handling polymorphism (`@JsonTypeInfo`)
* Building a full REST API with proper DTO mapping (MapStruct)
* JSON vs Protobuf vs Avro (system design level)

Just tell me 👍

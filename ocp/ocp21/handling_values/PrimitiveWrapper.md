Let’s dive into how Java handles **primitives**, **wrapper classes**, **expressions**, **type conversions**, **casting**, and **using the Math API**. This is a broad topic, so I’ll break it down into digestible chunks, focusing on practical understanding.

---

# 1. **Primitives vs Wrapper Classes**

### **Primitive Types** (Built-in)

Java provides **8 primitive data types** for efficiency:

* `byte` - 1 byte (8 bits)
* `short` - 2 bytes (16 bits)
* `int` - 4 bytes (32 bits)
* `long` - 8 bytes (64 bits)
* `float` - 4 bytes (32 bits, single precision)
* `double` - 8 bytes (64 bits, double precision)
* `char` - 2 bytes (16 bits, Unicode)
* `boolean` - 1 bit (true/false)

### Example: Declaring Primitives

```java
int x = 5;     // integer
double y = 3.14;  // double
boolean flag = true;  // boolean
char letter = 'A';  // character
```

---

### **Wrapper Classes** (Object Types)

Java provides **wrapper classes** for each primitive type. These allow primitives to be used in collections, for reflection, and in places where objects are needed:

| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| `byte`         | `Byte`        |
| `short`        | `Short`       |
| `int`          | `Integer`     |
| `long`         | `Long`        |
| `float`        | `Float`       |
| `double`       | `Double`      |
| `char`         | `Character`   |
| `boolean`      | `Boolean`     |

### Example: Using Wrapper Classes

```java
Integer num = 5;  // using Integer wrapper class
Boolean isActive = Boolean.TRUE;  // using Boolean wrapper
```

#### Autoboxing and Unboxing

* **Autoboxing**: Automatically converts a primitive to a wrapper object.
* **Unboxing**: Automatically converts a wrapper object back to its corresponding primitive type.

```java
int num = 5;
Integer wrapped = num;  // autoboxing
int num2 = wrapped;  // unboxing
```

---

# 2. **Evaluating Arithmetic and Boolean Expressions**

### Arithmetic Expressions

Java supports all standard arithmetic operations (`+`, `-`, `*`, `/`, `%`), and you can perform operations on primitive types or their wrapper classes (after unboxing).

### Example:

```java
int a = 10;
int b = 5;
int result = a + b;  // addition: 15
result = a - b;  // subtraction: 5
result = a * b;  // multiplication: 50
result = a / b;  // division: 2
result = a % b;  // modulus: 0
```

### Integer Division and Floating-point Division

```java
int x = 10;
int y = 4;
System.out.println(x / y);  // output: 2 (integer division)

double z = 10;
double w = 4;
System.out.println(z / w);  // output: 2.5 (floating-point division)
```

---

### Boolean Expressions

Java supports logical operations for boolean values, including:

* **AND** (`&&`)
* **OR** (`||`)
* **NOT** (`!`)
* **Equality** (`==`)
* **Inequality** (`!=`)
* **Comparison** (`<`, `>`, `<=`, `>=`)

### Example:

```java
boolean x = true;
boolean y = false;
System.out.println(x && y);  // AND → false
System.out.println(x || y);  // OR → true
System.out.println(!x);      // NOT → false
```

### Relational Operators:

```java
int a = 10;
int b = 5;

System.out.println(a == b);  // false
System.out.println(a != b);  // true
System.out.println(a > b);   // true
System.out.println(a <= b);  // false
```

---

# 3. **Precedence Rules**

When evaluating expressions, **operator precedence** determines the order in which operations are performed.

### Basic Precedence (from highest to lowest):

1. Parentheses `()`
2. Unary operators `++`, `--`, `+`, `-`, `!`
3. Multiplication `*`, Division `/`, Modulus `%`
4. Addition `+`, Subtraction `-`
5. Relational Operators (`<`, `<=`, `>`, `>=`)
6. Equality `==`, `!=`
7. Logical AND `&&`
8. Logical OR `||`

### Example:

```java
int a = 10;
int b = 5;
int c = 3;

int result = a + b * c;  // result = 10 + (5 * 3) = 25
```

In this case, `*` has higher precedence than `+`.

---

# 4. **Type Conversions and Casting**

Java performs automatic conversions (called **type promotion**) when moving between compatible types. But sometimes, explicit **casting** is needed when the conversion might lose information.

---

### **Implicit Casting** (Widening)

When converting from a **smaller** type to a **larger** type, Java automatically performs the cast (no loss of data).

```java
int a = 100;
long b = a;  // implicit cast from int to long
```

---

### **Explicit Casting** (Narrowing)

When converting from a **larger** type to a **smaller** type, you need to **explicitly cast** because data might be lost.

```java
double a = 10.5;
int b = (int) a;  // explicit cast, loses fractional part
```

---

### **Casting with Wrapper Classes**

Autoboxing and unboxing are used for conversions between primitives and their wrapper classes:

```java
Integer i = 100;  // Autoboxing
int num = i;      // Unboxing
```

---

### **Example: Arithmetic + Type Conversion**

```java
double a = 5.7;
int b = 4;

double result = a / b;  // result is a double (5.7 / 4 = 1.425)
System.out.println(result);

int c = (int) a;  // explicit cast to int (c = 5)
System.out.println(c);
```

---

# 5. **Math API**

The **`Math`** class in Java provides a wide variety of mathematical functions and constants. It’s **static**, so you don’t need to instantiate it.

### Key Methods:

| Method           | Description                   |
| ---------------- | ----------------------------- |
| `Math.abs(x)`    | Absolute value                |
| `Math.max(a, b)` | Maximum of a and b            |
| `Math.min(a, b)` | Minimum of a and b            |
| `Math.pow(a, b)` | `a` raised to the power `b`   |
| `Math.sqrt(x)`   | Square root of x              |
| `Math.random()`  | Random number between 0 and 1 |
| `Math.round(x)`  | Round to nearest integer      |
| `Math.PI`        | The constant π                |

---

### Example:

```java
double x = -10.5;
System.out.println(Math.abs(x));   // 10.5

double y = 25;
System.out.println(Math.sqrt(y));  // 5.0

double z = Math.random();  // Random value between 0 and 1
System.out.println(z);
```

---

# 6. **Combined Example: Arithmetic + Type Conversions**

```java
public class Main {
    public static void main(String[] args) {
        int a = 5;
        double b = 2.5;
        int c = 3;
        
        // Arithmetic
        double result = a + b * c;  // result = 5 + (2.5 * 3) = 12.5
        System.out.println(result);

        // Math API
        double sqrt = Math.sqrt(result);
        System.out.println(sqrt);  // sqrt of 12.5

        // Type casting
        int intResult = (int) sqrt;  // explicit casting (truncating decimal part)
        System.out.println(intResult);  // prints 3
    }
}
```

---

# 7. **Key Takeaways**

### Type System

* **Primitives** → Direct representation of data (faster, no overhead)
* **Wrapper Classes** → Objects that wrap primitive types (used in collections, etc.)

### Expressions

* **Arithmetic operations** follow precedence rules.
* **Boolean expressions** use logical operators to evaluate conditions.

### Type Conversion

* **Implicit**: From smaller to larger types (e.g., `int` to `long`).
* **Explicit**: From larger to smaller types (e.g., `double` to `int`).

### `Math` API

* Provides common mathematical functions and constants like square roots, powers, random numbers, etc.

### Casting

* **Widening**: Java does automatically (e.g., `int` to `long`).
* **Narrowing**: Explicit cast needed (e.g., `double` to `int`).

---

If you'd like to explore **specific scenarios** (like casting between primitives, or solving a problem with the `Math` API), just let

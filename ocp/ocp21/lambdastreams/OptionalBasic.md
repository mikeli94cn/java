Optional<T> is a container object introduced in Java 8 to represent a value that may or may not be present. Its primary goal is to provide a type-level solution for representing optional values instead of relying on null references, which helps reduce the risk of NullPointerExceptions. [1, 2, 3] 
## 1. Core API and Usage Patterns
Instead of checking for null, you use functional methods to handle the presence or absence of data. [4] 

* Creation: Use Optional.of(value) if you are certain it's not null, or Optional.ofNullable(value) if it might be null.
* Handling Absence:
* orElse(defaultValue): Returns a provided default value if the Optional is empty.
   * orElseGet(supplier): Similar to orElse, but lazily computes the default value only if needed.
   * orElseThrow(): Throws a NoSuchElementException (or a custom exception) if empty.
* Conditional Actions:
* ifPresent(consumer): Executes code only if a value is present.
   * ifPresentOrElse(action, emptyAction): Handles both present and absent cases in one call. [2, 3, 5, 6, 7, 8, 9, 10, 11] 

## 2. Integration with Streams
The "real power" of Optional is unleashed when combined with the Stream API. [12] 

* Fluent Pipelines: Streams often return Optional from terminal operations like findFirst(), findAny(), or reduce().
* Optional.stream(): Introduced in Java 9, this converts an Optional into a stream of either zero or one element. This is incredibly useful for filtering out empty values in a stream of optionals:

List<String> results = optionalList.stream()
    .flatMap(Optional::stream) // Flattens Optional<T> to T, skipping empty ones
    .collect(Collectors.toList());

* Shared Methods: Like Streams, Optional has its own map(), flatMap(), and filter() methods that allow you to transform or validate the wrapped value without explicit null-checks. [11, 12, 13, 14, 15, 16] 

## 3. Best Practices (Do's and Don'ts)

| Do [7, 17, 18, 19, 20, 21, 22] | Don't |
|---|---|
| Use as a method return type to indicate a missing result. | Don't use as a field in a class (it's not serializable). |
| Favor orElse() or ifPresent() over get(). | Don't use as a method parameter. |
| Return Optional.empty() instead of null. | Don't use to wrap collections; return an empty collection instead. |

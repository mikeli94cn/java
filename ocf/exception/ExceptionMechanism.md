In Java, exception handling is a mechanism used to manage runtime errors, ensuring the program doesn't crash unexpectedly. [1, 2] 
## 1. The try/catch/finally Block
This is the fundamental way to handle exceptions. [3] 

* try: Wraps the code that might throw an exception.
* catch: Handles the specific exception if it occurs.
* finally: Contains code that always executes (like closing a database connection), regardless of whether an exception was thrown or caught. [4, 5, 6, 7, 8] 

## 2. Multi-Catch Blocks
Introduced to reduce code duplication, a single catch block can handle multiple, unrelated exceptions using the pipe (|) symbol. [9, 10, 11] 

try {
    // Code that might throw IOException or SQLException
} catch (IOException | SQLException e) {
    System.out.println("Error occurred: " + e.getMessage());
}

Note: The exceptions in a multi-catch cannot have an inheritance relationship (e.g., you cannot catch both Exception and IOException in the same block). [12, 13] 
## 3. Try-with-Resources
This is the modern way to handle "closable" resources (like Files or Network Sockets). Any class that implements AutoCloseable can be declared inside the try parentheses. Java will automatically close them for you, even if an exception occurs. [14, 15, 16, 17, 18] 

try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
} // 'br' is closed automatically here

## 4. Custom Exceptions
If Java's built-in exceptions don't describe your error specifically enough, you can create your own by extending the Exception class (for checked exceptions) or RuntimeException (for unchecked exceptions). [19, 20, 21, 22, 23] 

// 1. Define the custom exceptionclass InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class ExceptionDemo {
    // 2. Use 'throws' to declare it
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Access Denied: Must be 18+");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.err.println("Caught Custom Error: " + e.getMessage());
        } finally {
            System.out.println("Validation check complete.");
        }
    }
}

## Key Differences: Checked vs. Unchecked

* Checked Exceptions: Must be handled or declared (e.g., IOException). The compiler forces you to address them.
* Unchecked Exceptions: Extend RuntimeException (e.g., NullPointerException). These usually indicate programming logic errors and don't require a try-catch. [24, 25, 26, 27, 28] 

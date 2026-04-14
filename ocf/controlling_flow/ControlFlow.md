Control flow determines the order in which statements are executed. Java provides branching (selection) and looping (iteration) constructs to manage this logic.
## 1. Selection Statements (Branching)## If / Else
The most basic decision-making construct. It evaluates a boolean expression.

int score = 85;if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B"); // Executes
} else {
    System.out.println("Grade: C");
}

## Switch Statements vs. Switch Expressions
Modern Java (Standardized in Java 14) introduced Switch Expressions, which are cleaner and can return values.

* Traditional Switch: Uses case and break. Forgets a break? You'll "fall through" to the next case.
* Switch Expression: Uses the arrow syntax (->). No break is needed, and it handles multiple labels easily.

String day = "MONDAY";
// Switch Expression (Returns a value)
String typeOfDay = switch (day) {
    case "MONDAY", "TUESDAY", "WEDNESDAY" -> "Workday";
    case "SATURDAY", "SUNDAY"             -> "Weekend";
    default -> "Unknown";
};

------------------------------
## 2. Iteration Statements (Loops)

| Loop Type | Purpose | Example |
|---|---|---|
| for | When you know how many times to repeat. | for(int i=0; i<5; i++) { ... } |
| for-each | To iterate over arrays or collections. | for(String s : list) { ... } |
| while | When repeating depends on a condition. | while(isActive) { ... } |
| do-while | When you must run at least once. | do { ... } while(condition); |

------------------------------
## 3. Branching Statements (break and continue)
These modify the behavior of loops and switches:

* break: Immediately exits the current loop or switch block.
* continue: Skips the rest of the current loop iteration and jumps to the next one.

## Labeled Breaks
In nested loops, a standard break only exits the inner loop. Use a label to exit multiple levels.

outerLoop: for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (i * j > 6) break outerLoop; // Exits both loops
    }
}

## 4. Code Demo: Combining Constructs

public class FlowControl {
    public static void main(String[] args) {
        // Loop with break/continue
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // Skip even numbers
            if (i > 7) break;        // Exit loop if > 7
            
            // Nested Selection
            String description = (i == 1) ? "First" : "Other";
            System.out.println(i + " is " + description);
        }
    }
}



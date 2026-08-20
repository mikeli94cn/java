Merge sort is a classic **divide-and-conquer** sorting algorithm.

The idea:

1. Divide the array into two halves.
2. Recursively sort each half.
3. Merge the two sorted halves.

genui{"learning_viz":{"type_id":"MERGE_SORT"}}

Example:

```
Original:

[8, 3, 5, 1, 9, 2, 7]


Divide:

[8,3,5,1]       [9,2,7]

[8,3] [5,1]     [9,2] [7]


Sort small pieces:

[3,8] [1,5]     [2,9] [7]


Merge:

[1,3,5,8]       [2,7,9]


Final:

[1,2,3,5,7,8,9]
```

---

## Java implementation (top-down recursive merge sort)

```java
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int[] temp = new int[array.length];

        mergeSort(array, temp, 0, array.length - 1);
    }


    private static void mergeSort(int[] array, int[] temp,
                                  int left, int right) {

        // Base case
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        // Divide
        mergeSort(array, temp, left, middle);
        mergeSort(array, temp, middle + 1, right);

        // Merge
        merge(array, temp, left, middle, right);
    }


    private static void merge(int[] array, int[] temp,
                              int left, int middle, int right) {

        // Copy current range into temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }


        int i = left;        // left half pointer
        int j = middle + 1;  // right half pointer
        int k = left;        // original array pointer


        // Compare two halves
        while (i <= middle && j <= right) {

            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }

            k++;
        }


        // Copy remaining left half
        while (i <= middle) {
            array[k] = temp[i];
            i++;
            k++;
        }


        // Copy remaining right half
        while (j <= right) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {

        int[] numbers = {
            8, 3, 5, 1, 9, 2, 7
        };


        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));


        mergeSort(numbers);


        System.out.println("After:");
        System.out.println(Arrays.toString(numbers));
    }
}
```

---

## Output

```
Before:
[8, 3, 5, 1, 9, 2, 7]

After:
[1, 2, 3, 5, 7, 8, 9]
```

---

# How the code works

## 1. Divide phase

This function:

```java
mergeSort(array, temp, left, right);
```

keeps splitting:

```
[8,3,5,1,9,2,7]

        |
        v

[8,3,5,1] [9,2,7]

        |
        v

[8,3] [5,1] [9,2] [7]
```

The stopping condition:

```java
if (left >= right)
    return;
```

means:

```
one element = already sorted
```

---

# 2. Merge phase

The important function:

```java
merge()
```

combines two sorted arrays.

Example:

```
Left:

[3,8]


Right:

[1,5]


Compare:

3 vs 1

take 1


3 vs 5

take 3


8 vs 5

take 5


remaining 8


Result:

[1,3,5,8]
```

---

# Complexity analysis

## Time complexity

Every level merges all elements:

```
Level 1:
n elements

Level 2:
n elements

Level 3:
n elements
```

Number of levels:

```
log2(n)
```

Therefore:

```
O(n log n)
```

---

## Space complexity

Merge sort needs a temporary array:

```java
int[] temp = new int[array.length];
```

So:

```
O(n)
```

extra memory.

---

# Merge sort vs quick sort

|              | Merge Sort                     | Quick Sort |
| ------------ | ------------------------------ | ---------- |
| Average time | O(n log n)                     | O(n log n) |
| Worst case   | O(n log n)                     | O(n²)      |
| Extra memory | O(n)                           | O(log n)   |
| Stable       | Yes                            | Usually no |
| Good for     | Linked lists, external sorting | Arrays     |

---

# Relation to your previous MIXAL question

A Java merge sort hides many low-level operations.

Java:

```java
array[left]
```

The CPU eventually does:

```
calculate address
load memory
compare register
store memory
```

In MIXAL you would manually implement:

* index registers
* memory addresses
* comparisons
* copying values

The algorithm is the same; the abstraction level is different:

```
Merge sort idea
       |
       v
Java code
       |
       v
Compiler
       |
       v
Assembly
       |
       v
Machine instructions
```

That is why implementing algorithms in both Java and MIXAL is a very good way to understand how high-level programming maps to the hardware.

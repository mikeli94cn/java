#include <stdio.h>

// Function to implement Shell Sort
void shellSort(int arr[], int n) {
    // Start with a large gap, then reduce the gap size
    for (int gap = n / 2; gap > 0; gap /= 2) {
        // Do a gapped insertion sort for this gap size.
        for (int i = gap; i < n; i++) {
            // Add arr[i] to the elements that have been gap-sorted
            // save arr[i] in temp and make a hole at position i
            int temp = arr[i];
            int j;
            
            // Shift earlier gap-sorted elements up until the correct 
            // location for arr[i] is found
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            
            // Put temp (the original arr[i]) in its correct location
            arr[j] = temp;
        }
    }
}

// Function to print an array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {12, 34, 54, 2, 3};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    printArray(arr, n);

    shellSort(arr, n);

    printf("Sorted array:   ");
    printArray(arr, n);
    
    return 0;
}

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        ShellSort test = new ShellSort();
        //int[] arr = {2, 1};
        //int[] arr = {3, 1, 4, 2};
        //int[] arr = {4, 3, 2, 1};
        //int[] arr = {7, 2, 4, 6, 8, 1, 5, 3};
        //int[] arr = {7, 10, 2, 16, 4, 13, 6, 9, 8, 12, 1, 11, 5, 15, 3, 14};
        int[] arr = {17, 7, 18, 10, 19, 2, 16, 32, 4, 31, 13, 30, 6, 29, 9, 28, 8, 27, 12, 26, 1, 25, 11, 24, 5, 23, 15, 22, 3, 21, 14, 20};
        //int[] arr = {17, 64, 7, 63, 18, 62, 10, 61, 19, 60, 2, 59, 16, 58, 32, 57, 4, 56, 31, 55, 13, 54, 30, 53, 6, 52, 29, 51, 9, 50, 28, 49, 8, 48, 27, 47, 12, 46, 26, 45, 1, 44, 25, 43, 11, 42, 24, 41, 5, 40, 23, 39, 15, 38, 22, 37, 3, 36, 21, 35, 14, 34, 20, 33};

        //test.insertSort(arr);
        System.out.println(Arrays.toString(arr));
        test.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
       2,1
       1,2

       3,1,4,2
       1,3,4,2
       1,3,4,2
       1,2,3,4

       4,3,2,1
       3,4,2,1
       2,3,4,1
       1,2,3,4

       7,2,4,6,8,1,5,3

*/
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = tmp;
    }

    public void insertSort(int[] arr) {
        for (int i = 2; i <= arr.length; i++) {
            int position = i;
            for (int j = 1; j <= i - 1; j++) {
                if (arr[j - 1] > arr[i - 1]) {
                    position = j;
                    break;
                }
            }
            int tmp = arr[i - 1];
            for (int k = i - 1; k >= position; k--) {
                arr[k] = arr[k - 1];
            }
            arr[position - 1] = tmp;
        }
    }

    public void shellSortDetail(int[] arr, int interval, int start) {
        for(int i=start+interval;i<=arr.length;i=i+interval){
            int position=i;
            for(int j=start;j<=i-interval;j=j+interval){
                if(arr[j-1]>arr[i-1]){
                    position=j;
                    break;
                }
            }
            int tmp=arr[i-1];
            for(int k=i-interval;k>=position;k=k-interval){
                arr[k+interval-1]=arr[k-1];
            }
            arr[position-1]=tmp;
        }
        if(start!=16){
            shellSortDetail(arr, interval, start+1);
        }
    }
    public void shellSortAbstract(int[] arr,  int interval){
        shellSortDetail(arr, interval, 1);
        if(interval!=1){
            shellSortAbstract(arr, interval/2);
        }
    }
    public void shellSort(int[] arr){
        int interval=1;
        int length=arr.length;
        while(length/2!=0){
            interval=interval*2;
        }

        shellSortAbstract(arr, interval);
    }
}


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


    public void shellSort(int[] arr) {
        int gap = 1;
        while (gap * 2 < arr.length) {
            gap = gap * 2;
        }
        for (; gap != 0; gap /= 2) {
            for (int start = 1; start <= gap; start++) {
                for (int i = start + gap; i <= arr.length; i += gap) {
                    int j = i - gap;
                    int value = arr[i - 1];
                    while (j >= 1 && arr[j - 1] > value) {
                        arr[j + gap - 1] = arr[j - 1];
                        j = j - gap;
                    }
                    arr[j + gap - 1] = value;
                }
            }
        }
    }

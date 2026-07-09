public class MergeSort {
    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] arr = {2, 1};
        //int[] arr={2,3,4,1};
        //int[] arr={6,4,7,5,1,8,3,2};
    }


    public void mergeSort(int[] arr) {
        
        mergeArr(arr, 1, arr.length / 2 - 1, arr.length / 2, arr.length);
    }

    public int[] mergeArr(int[] arr, int arr1_start, int arr1_end, int arr2_start, int arr2_end) {
        if(arr1_end-arr1_start<=1 && arr2_start-arr2_end<=1) {
            int[] arr3 = new int[arr.length];
            int i = arr1_start;
            int j = arr2_start;
            while (i <= arr1_end || j <= arr2_end) {
                if (arr[i - 1] <= arr[j - 1] || j > arr2_end) {
                    arr3[i + j - 1] = arr[i - 1];
                    i++;
                } else {
                    arr3[i + j - 1] = arr[j - 1];
                    j++;
                }
            }
            return arr3;
        }else{
            
        }
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 1;
        int j = 1;
        while (i <= arr1.length || j <= arr2.length) {
            if (arr1[i - 1] <= arr2[j - 1] || j > arr2.length) {
                arr3[i + j - 1] = arr1[i - 1];
                i++;
            } else {
                arr3[i + j - 1] = arr2[j - 1];
                j++;
            }
        }
        return arr3;
    }
}



package array101;

import java.util.Arrays;

public class MergeSortTry2 {
    public static void main(String[] args) {
        MergeSortTry2 test = new MergeSortTry2();
        //int[] arr = {2, 1};
        //int[] arr = {3, 1, 4, 2};
        //int[] arr = {4, 3, 2, 1};
        //int[] arr = {7, 2, 4, 6, 8, 1, 5, 3};
        //int[] arr = {4, 1, 7, 3, 8, 2, 5, 6};
        //int[] arr = {7, 10, 2, 16, 4, 13, 6, 9, 8, 12, 1, 11, 5, 15, 3, 14};
        //int[] arr = {17, 7, 18, 10, 19, 2, 16, 32, 4, 31, 13, 30, 6, 29, 9, 28, 8, 27, 12, 26, 1, 25, 11, 24, 5, 23, 15, 22, 3, 21, 14, 20};
        //int[] arr = {17, 64, 7, 63, 18, 62, 10, 61, 19, 60, 2, 59, 16, 58, 32, 57, 4, 56, 31, 55, 13, 54, 30, 53, 6, 52, 29, 51, 9, 50, 28, 49, 8, 48, 27, 47, 12, 46, 26, 45, 1, 44, 25, 43, 11, 42, 24, 41, 5, 40, 23, 39, 15, 38, 22, 37, 3, 36, 21, 35, 14, 34, 20, 33};
        int[] arr = {3, 1, 2};
        System.out.println(Arrays.toString(arr));
        test.mergeSort(arr);
        /*
        test.mergeSortGapInGroup(arr, 1, 1);
        test.mergeSortGapInGroup(arr, 1, 2);
        test.mergeSortGapInGroup(arr, 1, 3);
        test.mergeSortGapInGroup(arr, 1, 4);

        test.mergeSortGap(arr, 1);
        test.mergeSortGap(arr, 2);
        test.mergeSortGap(arr, 4);
*/
        System.out.println(Arrays.toString(arr));

    }

    public void mergeSort(int[] arr) {
        for (int gap = 1; gap < arr.length; gap *= 2) {
            mergeSortGap(arr, gap);
        }
    }

    public void mergeSortGap(int[] arr, int gap) {
        for (int i = 1; i * gap <= arr.length; i++) {
            mergeSortGapInGroup(arr, gap, i);
        }
    }

    public void mergeSortGapInGroup(int[] arr, int gap, int groupNo) {
        /*
        first group:  1,2
        second group: 3,4
                      5,6
                      7,8
                      [1,gap]+(groupNo-1)*2*gap, [gap+1,2gap]+(groupNo-1)*2*gap
         */
        int i = 1;
        int j = gap + 1;
        int base = (groupNo - 1) * 2 * gap;

        int[] result = new int[2 * gap];
        while (i <= gap || j <= 2 * gap) {
            if (j > 2 * gap) {
                result[i + j - gap - 2] = arr[i + base - 1];
                i++;
            } else if (i > gap) {
                result[i + j - gap - 2] = arr[j + base - 1];
                j++;
            } else if (arr[i + base - 1] < arr[j + base - 1]) {
                result[i + j - gap - 2] = arr[i + base - 1];
                i++;
            } else {
                result[i + j - gap - 2] = arr[j + base - 1];
                j++;
            }
        }


        for (int k = 1; k <= result.length; k++) {
            arr[k + base - 1] = result[k - 1];
        }

    }
}

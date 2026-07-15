import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        //int[] arr = {2, 1};
        //int[] arr={2,3,4,1};
        //int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        //int[] arr = {2, 1};
        //int[] arr = {3, 1, 4, 2};
        //int[] arr = {4, 3, 2, 1};
        //int[] arr = {7, 2, 4, 6, 8, 1, 5, 3};
        //int[] arr = {4, 1, 7, 3, 8, 2, 5, 6};
        //int[] arr = {7, 10, 2, 16, 4, 13, 6, 9, 8, 12, 1, 11, 5, 15, 3, 14};
        //int[] arr = {17, 7, 18, 10, 19, 2, 16, 32, 4, 31, 13, 30, 6, 29, 9, 28, 8, 27, 12, 26, 1, 25, 11, 24, 5, 23, 15, 22, 3, 21, 14, 20};
        //int[] arr = {17, 64, 7, 63, 18, 62, 10, 61, 19, 60, 2, 59, 16, 58, 32, 57, 4, 56, 31, 55, 13, 54, 30, 53, 6, 52, 29, 51, 9, 50, 28, 49, 8, 48, 27, 47, 12, 46, 26, 45, 1, 44, 25, 43, 11, 42, 24, 41, 5, 40, 23, 39, 15, 38, 22, 37, 3, 36, 21, 35, 14, 34, 20, 33};
        //int[] arr = {3, 1, 2};
        int[] arr = {7, 2, 4, 6, 1, 5, 3};
        //int[] arr = {1, 1, 4, 2, 1, 3};
        System.out.println(Arrays.toString(arr));
        //test.mergeSort(arr, 1, arr.length);
        test.mergeSortIter(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr, int start, int end) {
        int length = end - start + 1;
        if (length > 1) {
            mergeSort(arr, start, length / 2 + start - 1);
            mergeSort(arr, length / 2 + start, end);
        }
        combine(arr, start, end);
    }

    public void combine(int[] arr, int start, int end) {
        int length = end - start + 1;
        if (length > 1) {
            int first_end = length / 2 + start - 1;
            int second_start = length / 2 + start;
            int i = start;
            int j = second_start;
            int[] sorted = new int[end - start + 1];
            while (i <= first_end || j <= end) {
                if (j > end) {
                    sorted[i - start + j - second_start] = arr[i - 1];
                    i++;
                } else if (i > first_end) {
                    sorted[i - start + j - second_start] = arr[j - 1];
                    j++;
                } else if (arr[i - 1] < arr[j - 1]) {
                    sorted[i - start + j - second_start] = arr[i - 1];
                    i++;
                } else {
                    sorted[i - start + j - second_start] = arr[j - 1];
                    j++;
                }
            }
            for (int k = start; k <= end; k++) {
                arr[k - 1] = sorted[k - start];
            }
        }
    }


    public void mergeSortIter(int[] arr) {
        for (int gap = 1; gap < arr.length; gap *= 2) {
            int totalGroup;
            if (arr.length % (2 * gap) == 0) {
                totalGroup = arr.length / (2 * gap);
            } else {
                totalGroup = arr.length / (2 * gap) + 1;
            }

            for (int groupNo = 1; groupNo <= totalGroup; groupNo++) {
                int limit;
                if (groupNo < totalGroup) {
                    limit = 2 * gap;
                } else {
                    limit = arr.length - 2 * gap * (groupNo - 1);
                }
                if (limit > gap) {
                    int i = 1;
                    int j = gap + 1;
                    int base = 2 * gap * (groupNo - 1);
                    int[] res = new int[limit];
                    while (i <= gap || j <= limit) {
                        int curPosIdx = i + j - gap - 2;
                        if (j > limit) {
                            res[curPosIdx] = arr[i + base - 1];
                            i++;
                        } else if (i > gap) {
                            res[curPosIdx] = arr[j + base - 1];
                            j++;
                        } else if (arr[i + base - 1] < arr[j + base - 1]) {
                            res[curPosIdx] = arr[i + base - 1];
                            i++;
                        } else {
                            res[curPosIdx] = arr[j + base - 1];
                            j++;
                        }
                    }
                    for (int k = 1; k <= limit; k++) {
                        arr[k + base - 1] = res[k - 1];
                    }
                }
            }
        }
    }
}

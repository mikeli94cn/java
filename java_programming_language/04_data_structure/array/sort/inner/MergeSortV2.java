public class MergeSortV2 {

    public static void main(String[] args) {
        //int[] arr = {7, 2, 6, 5, 1, 3, 8, 4};
        //int[] arr = {2, 1};
        //int[] arr = {2, 3, 4, 1};
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
        //int[] arr = {7, 2, 4, 6, 1, 5, 3};
        //int[] arr = {1, 1, 4, 2, 1, 3};
        int[] arr = {7, 3, 5, 5, 1, 2, 2, 3, 9, 2, 2, 7, 1, 7, 3, 2, 3, 6, 6, 7};
        MergeSortIter test = new MergeSortIter();
        System.out.println(Arrays.toString(arr));
        int[] bakArr = new int[arr.length];
        //test.mergeSortIter(arr, bakArr);
        test.mergeSortRecur(arr, bakArr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
    public void mergeSortIter(int[] arr, int[] bakArr) {
        for (int width = 1; width < arr.length; width *= 2) {
            for (int start = 1; start <= arr.length; start = start + 2 * width) {
                int start1 = start;
                int end1 = start1 + width - 1;
                int start2 = start1 + width;
                int end2 = Math.min(start2 + width - 1, arr.length);
                merge(arr, bakArr, start1, end1, start2, end2);
            }
        }
    }

    public void mergeSortRecur(int[] arr, int[] bakArr, int start, int end) {
        if (end - start > 1) {
            mergeSortRecur(arr, bakArr, start, start / 2 + end / 2);
            mergeSortRecur(arr, bakArr, start / 2 + end / 2 + 1, end);
        }
        merge(arr, bakArr, start, start / 2 + end / 2, start / 2 + end / 2 + 1, end);
    }

    public void merge(int[] arr, int[] bakArr, int start1, int end1, int start2, int end2) {
        int i = start1;
        int j = start2;
        for (int k = start1; k <= end2; k++) {
            if ((i <= end1) && (j > end2 || arr[i - 1] < arr[j - 1])) {
                bakArr[k - 1] = arr[i - 1];
                i++;
            } else {
                bakArr[k - 1] = arr[j - 1];
                j++;
            }
        }
        for (int k = start1; k <= end2; k++) {
            arr[k - 1] = bakArr[k - 1];
        }
    }
    
}

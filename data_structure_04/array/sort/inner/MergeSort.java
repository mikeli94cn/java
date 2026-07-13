public class MergeSort {
    
    public void mergeSort(int[] arr) {

        mergeArr(arr, 1, arr.length / 2 - 1, arr.length / 2, arr.length);
    }

    public int[] mergeArr(int[] arr, int arr1_start, int arr1_end, int arr2_start, int arr2_end) {
        if (arr1_end - arr1_start <= 1 && arr2_start - arr2_end <= 1) {
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
        } else {

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

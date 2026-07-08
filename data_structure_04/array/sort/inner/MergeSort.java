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

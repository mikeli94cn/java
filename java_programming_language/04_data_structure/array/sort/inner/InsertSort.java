    public void insertSort(int[] arr) {
        for (int i = 2; i <= arr.length; i++) {
            int value = arr[i - 1];
            int j = i - 1;
            while (j >= 1 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j + 1 - 1] = value;
        }
    }

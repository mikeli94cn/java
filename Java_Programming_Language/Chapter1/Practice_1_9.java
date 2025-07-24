import java.util.Arrays;

public class Practice_1_9 {
    /*modify the fibonacci application to store the sequence into an array */
    /*and print the list of values at the end */
    public static void main(String[] args) {

        final int INIT;
        INIT=10;
        int[] arr;
        arr=new int[INIT];
        
        initArr(arr);

        printArr(arr);
        
        arr[0]=1;
        arr[1]=1;
        int i=3;
        while ( (arr[i-3]+arr[i-2])<50 ) {
            arr[i-1]=arr[i-3]+arr[i-2];
            i++;
            if(i==arr.length){
                arr=scale(arr);
            }
        }

        printArr(arr);
    }

    //return int[] type is key. Because function is pass value.
    //java reference var is equals with C pointer
    //https://gitee.com/lishuo94/c_programming_language/blob/master/Charpter5/dynamic_arr_20250724.c
    public static int[] scale(int[] arr){
        int[] newArr;
        newArr=new int[2*arr.length];
        for(int i=1;i<=newArr.length;i++){
            if(i<=arr.length){
                newArr[i-1]=arr[i-1];
            }
            else{
                newArr[i-1]=-1;
            }
        }
        return newArr;
    }

    public static void initArr(int[] arr){
        for(int i=1;i<=arr.length;i++){
            arr[i-1]=-1;
        }
    }

    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
        
    }
    
}

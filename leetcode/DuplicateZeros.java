import java.util.*;
public class DuplicateZeros {

    public static void main(String[] args) {

        DuplicateZeros test=new DuplicateZeros();
        //int[] arr={1,0,2,3,0,4,5,0};
        int[] arr={1,2,3};
        test.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        //1,0,2,3,0,4,5,0
        //1,0,0,2,3,0,0,4
        //1,2,3
        //1,2,3
    }

    public void duplicateZeros(int[] arr){
        int[] dupArr=new int[arr.length];
        int i=1;
        int j=1;
        while(i<=arr.length){
            if(j>dupArr.length){
                break;
            }else{
                dupArr[j-1]=arr[i-1];
                if(arr[i-1]==0 && j<=dupArr.length-1){
                    dupArr[j]=arr[i-1];
                    j++;
                }
                i++;
                j++;
            }
        }
        for(int k=1;k<=arr.length;k++){
            arr[k-1]=dupArr[k-1];
        }
    }

}

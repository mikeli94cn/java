import java.util.Arrays;

public class LeetCode2161 {

    public static void main(String[] args) {
        int[] test1={9,12,5,10,14,3,10};
        int pivot1=10;
        int[] test2={-3,4,3,2};
        int pivot2=2;
        LeetCode2161 testCase=new LeetCode2161();
        System.out.println( Arrays.toString( testCase.pivotArray(test1, pivot1) ));
        System.out.println( Arrays.toString( testCase.pivotArray(test2, pivot2) ));
    }

    public int[] pivotArray(int[] nums, int pivot){
        int[] res=new int[nums.length];
        boolean[] flag=new boolean[nums.length];
        
        for (int i=1;i<=nums.length;i++) {
           flag[i-1]=true;
        }

        int exist=0;
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]<pivot){
                res[exist]=nums[i-1];
                flag[i-1]=false;
                exist++;
            }
        }
        for(int i=1; i<=nums.length;i++){
            if( flag[i-1] && nums[i-1]==pivot){
                res[exist]=nums[i-1];
                flag[i-1]=false;
                exist++;
            }
        }
        for(int i=1;i<=nums.length;i++){
            if( flag[i-1] && nums[i-1]>pivot){
                res[exist]=nums[i-1];
                flag[i-1]=false;
                exist++;
            }
        }
        return res;
    }
}

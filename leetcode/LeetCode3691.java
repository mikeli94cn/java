import java.util.ArrayList;
import java.util.Collections;

public class LeetCode3691 {
    public static void main(String[] args) {
        int[] nums={4,2,5,1};
        int k=3;
        System.out.println(maxTotalValue(nums, k));

    }

        public static long maxTotalValue(int[] nums, int k){
        //1.iterate +
        //2.get subArr max,min +
        //3.add to a list +
        //4.sort and fetch top n value +

        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1;i<=nums.length;i++){
            int max=nums[i-1];
            int min=nums[i-1];
            for(int j=i+1;j<=nums.length;j++){
                if(nums[j-1]>max){
                    max=nums[j-1];
                }

                if(nums[j-1]<min){
                    min=nums[j-1];
                }
                int value=max-min;
                res.add(value);
            }
        }

        long sum=0;
        for(int i=1;i<=k;i++){
            sum=sum+res.peek();
        }


        return sum;
    }
}

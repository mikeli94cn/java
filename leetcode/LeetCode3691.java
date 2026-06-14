import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

public class LeetCode3691 {
  public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new FileReader("data"));
       String line=br.readLine();
       br.close();
       String[] arr=line.split(",");
       int[] nums=new int[arr.length];
       for(int i=1;i<=arr.length;i++){
           nums[i-1]=Integer.parseInt(arr[i-1]);
       }
      int k = 7610;
    System.out.println(maxTotalValue(nums, k));
  }

  public static long maxTotalValue(int[] nums, int k) {
    // 1.iterate +
    // 2.get subArr max,min +
    // 3.add to a priority queue , if > queue min elem, poll and add, if not, skip
    // 4.fetch pq values and sum

    PriorityQueue<Integer> res =
        new PriorityQueue<>();
    for (int i = 1; i <= nums.length; i++) {
      int max = nums[i - 1];
      int min = nums[i - 1];
      for (int j = i; j <= nums.length; j++) {
          int value;
        if (j == i) {
            value=0;
        } else {
          if (nums[j - 1] > max) {
            max = nums[j - 1];
          }

          if (nums[j - 1] < min) {
            min = nums[j - 1];
          }
          value = max - min;
        }
        if(res.size()<k){
            res.add(value);
        }else{
            if(value>res.peek()){
                res.poll();
                res.add(value);
            }
        }
      }
    }

    long sum = 0;
    for (int i = 1; i <= k; i++) {
      sum = sum + res.poll();
    }

    return sum;
  }
}

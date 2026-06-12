import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode3691 {
  public static void main(String[] args) {
    int[] nums = {11, 8};
    int k = 2;
    System.out.println(maxTotalValue(nums, k));
  }

  public static long maxTotalValue(int[] nums, int k) {
    // 1.iterate +
    // 2.get subArr max,min +
    // 3.add to a priority queue +
    // 4.fetch top n value +

    PriorityQueue<Integer> res =
        new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 1; i <= nums.length; i++) {
      int max = nums[i - 1];
      int min = nums[i - 1];
      for (int j = i; j <= nums.length; j++) {
        if (j == i) {
          res.add(0);
        } else {
          if (nums[j - 1] > max) {
            max = nums[j - 1];
          }

          if (nums[j - 1] < min) {
            min = nums[j - 1];
          }
          int value = max - min;
          res.add(value);
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

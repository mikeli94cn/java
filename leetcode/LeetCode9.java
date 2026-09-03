import java.util.ArrayList;
import java.util.List;

public class LeetCode9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            List<Integer> arr = new ArrayList<>();
            boolean res = true;
            while (x != 0) {
                arr.add(x % 10);
                x = x / 10;
            }

            for (int i = 1; i <= (arr.size() + 1) / 2; i++) {
                // i-1,arr.size()-i
                if (arr.get(i - 1) != arr.get(arr.size() - i)) {
                    res = false;
                    break;
                }
            }
            return res;
        }
    }
}

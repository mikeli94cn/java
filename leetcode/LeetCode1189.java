import java.util.HashMap;
import java.util.Map;

public class LeetCode1189 {
    public static void main(String[] args) {
        String text = "xyz";
        System.out.println(maxNumberBalloon(text));
    }

    public static int maxNumberBalloon(String text) {
        HashMap<Character, Integer> res = new HashMap<>();
        res.put('b', 0);
        res.put('a', 0);
        res.put('l', 0);
        res.put('o', 0);
        res.put('n', 0);
        
        char[] chs = text.toCharArray();
        for (char c : chs) {
            if (res.containsKey(c)) {
                res.put(c, res.get(c) + 1);
            }
        }

        int maxNumber = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : res.entrySet()) {
            if (entry.getKey() == 'l' || entry.getKey() == 'o') {
                maxNumber = Math.min(maxNumber, entry.getValue() / 2);
            } else {
                maxNumber = Math.min(maxNumber, entry.getValue());
            }
        }
        return maxNumber;
    }
}

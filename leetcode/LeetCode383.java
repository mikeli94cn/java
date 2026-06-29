import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode383 {
    public static void main(String[] args) {
        LeetCode383 test = new LeetCode383();
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(test.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ranArr = ransomNote.toCharArray();
        HashMap<Character, Integer> ranMap = new HashMap<>();
        foo(ranArr, ranMap, ranArr.length);

        char[] magArr = magazine.toCharArray();
        HashMap<Character, Integer> magMap = new HashMap<>();
        foo(magArr, magMap, magArr.length);

        boolean flag=true;
        Iterator<Map.Entry<Character, Integer>> ranIter=ranMap.entrySet().iterator();
        while(ranIter.hasNext()){
            Map.Entry<Character, Integer> entry=ranIter.next();
            if(entry.getValue() > magMap.get(entry.getKey())){
                flag=false;
                break;
            }
        }
        return flag;
    }


    public void foo(char[] arr, HashMap<Character, Integer> map, int n) {
        if (n > 1) {
            foo(arr, map, n - 1);
            safePut(map, arr[n - 1]);
        } else {
            safePut(map, arr[n - 1]);
        }
    }

    public void safePut(HashMap<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}

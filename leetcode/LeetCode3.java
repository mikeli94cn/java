import java.util.Scanner;
//import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.util.Map;

public class LeetCode3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        LeetCode3 test=new LeetCode3();
        int res=test.lengthOfLongestSubstring(n);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String n){
        LinkedHashMap<Character,Integer> res=new LinkedHashMap<>();
        int subLen=0;
        int longest=0;
        char[] chArr=n.toCharArray();
        for (int i = 1; i <= chArr.length; i++) {
            char c=chArr[i-1];
            if(res.containsKey(c)){
                int prevLoc=res.get(c);
                subLen=i-prevLoc;
                while(true){
                    if(res.containsKey(c)){
                        res.pollFirstEntry();
                    }else{
                        break;
                    }
                }
                res.put(c, i);

            }else{
                res.put(c, i);
                subLen++;
            }
            
            if(subLen>longest){
                longest=subLen;
            }
        }
        return longest;
    }
}

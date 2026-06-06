import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode3 {

    public static void main(String[] args) {
        
    }

    public int lengthOfLongestSubstring(String n){
        LinkedHashMap<Character,Integer> res=new LinkedHashMap<>();
        int subLen=0;
        int longest=0;
        char[] chArr=n.toCharArray();
        for (int i = 1; i <= chArr.length; i++) {
            char c=chArr[i-1];
            if(res.containsKey(c)){
                subLen=i-res.get(c);
                for(i=1;i<=res.get(c);i++){
                    res.pollFirstEntry();
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

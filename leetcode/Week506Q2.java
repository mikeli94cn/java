import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week506Q2 {
    public static void main(String[] args) {
        //int[] nums={1,2,2,1,2,3,3,3};
        //int[] nums={5,5,5,5};
        int[] nums={1,2,3,4};
        System.out.println(getLength(nums));
    }

    
    public static int getLength(int[] nums){
        int longest=0;
        for(int i=1;i<=nums.length;i++){
            for(int j=nums.length;j>=i;j--){
                int[] subArr=Arrays.copyOfRange(nums, i-1, j);
                if(judgeBalance(subArr)){
                    if(longest<subArr.length){
                        longest=subArr.length;
                        break;
                    }
                }
            }
        }
        return longest;

    }

    public static boolean judgeBalance(int[] nums){
        boolean flag=true;
        HashMap<Integer,Integer> res=new HashMap<>();
        for(int i : nums){
            if(res.containsKey(i)){
                res.put(i, res.get(i)+1);
            }else{
                res.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list=new ArrayList<>(res.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int maxFreq=list.getLast().getValue();
        for(Map.Entry<Integer,Integer> e : list){
            if(e.getValue()*2 != maxFreq && e.getValue() != maxFreq){
                flag=false;
                break;
            }
        }
        return flag;
    }
}

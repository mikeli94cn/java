import java.util.Scanner;
import java.util.*;

class StringAnalysis_100_2
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] arr=sc.nextLine().split("@");

        Map<String,Integer> usedMap=new HashMap<String,Integer>();
        String[] usedArr=arr[1].split(",");
        for(int i=0;i<usedArr.length;i++)
        {
            String[] temp= usedArr[i].split(":");
            usedMap.put(temp[0],Integer.valueOf(temp[1]));
        }

        StringBuilder builder=new StringBuilder();
        String[] allArr=arr[0].split(",");
        for(int i=0;i<allArr.length;i++)
        {
            String[] temp=allArr[i].split(":");

            builder.append(temp[0]).append(":").append(Integer.valueOf(temp[1])  -usedMap.getOrDefault(temp[0],0)  ).append(",");
        }

        System.out.println(builder.deleteCharAt(builder.length()-1));
    }
}

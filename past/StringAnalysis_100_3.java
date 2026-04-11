import java.util.Scanner;
import java.util.*;

class StringAnalysis_100_3
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String[] str= sc.nextLine().split("@");
        String[] allStr =str[0].split(",");
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        ArrayList<Character> list=new ArrayList<Character>();

        for(int i=0;i<allStr.length;i++)
        {
            String[] aStr=allStr[i].split(":");
            char ch1=aStr[0].charAt(0);
            int n1=Integer.parseInt(aStr[1]);
            map.put(ch1,n1);
            list.add(ch1);
        }

        if(str.length>1)
        {
            String[] yongStr=str[1].split(",");

            for(int i=0;i<yongStr.length;i++)
            {
                String[] yStr=yongStr[i].split(":");
                char ch2=yStr[0].charAt(0);
                int n2=Integer.parseInt(yStr[1]);
                map.put(ch2,map.get(ch2)-n2);
            }
        }
        else
        {
            String res=str[0]+"@";
            System.out.println(res);
            return;
        }

        ArrayList<String> list2=new ArrayList<String>();
        for(int i=0;i<list.size();i++)
        {
            char c=list.get(i);
            String x="";
            if(map.get(c)>0)
            {
                x=c+":"+map.get(c);
                list2.add(x);
            }
        }

        if(list2.size()>0)
        {
            for(int i=0;i<list2.size()-1;i++)
            {
                System.out.print(list2.get(i)+",");
            }
            System.out.println(list2.get(list2.size()-1));
        }
    }
}
import java.util.*;
public class LeetCode3121 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();
        int result=numberOfSpecialChars(word);
        System.out.println(result);
    }

    public static int numberOfSpecialChars(String word){
        boolean[][] res=new boolean[26][3];
        char[] wordCh=word.toCharArray();
        for (char ch : wordCh) {
           if(ch>='A' && ch<'a'){
               if(res[ch-'A'][0]==true){
                   continue;
               }else{
                   if(res[ch-'A'][1]==false && res[ch-'A'][2]==false){
                       res[ch-'A'][2]=true;
                       res[ch-'A'][0]=true;
                   }else if(res[ch-'A'][1]==false && res[ch-'A'][2]==true){
                       continue;
                   }else if(res[ch-'A'][1]==true && res[ch-'A'][2]==false){
                       res[ch-'A'][2]=true;
                   }else if(res[ch-'A'][1]==true && res[ch-'A'][2]==true){
                       continue;
                   }
               }
           } else{
               if(res[ch-'a'][0]==true){
                   continue;
               }else{
                   if(res[ch-'a'][1]==false && res[ch-'a'][2]==false){
                       res[ch-'a'][1]=true;
                   }else if(res[ch-'a'][1]==false && res[ch-'a'][2]==true){
                       //this case wont happen
                   }else if(res[ch-'a'][1]==true && res[ch-'a'][2]==false){
                       continue;
                   }else if(res[ch-'a'][1]==true && res[ch-'a'][2]==true){
                       res[ch-'a'][0]=true;
                   }
               }
           }
        }

        int count=0;
        for(boolean[] item : res){
            if(item[0]==false && item[1]==true && item[2]==true){
                count++;
            }
        }
        return count;
    }
}

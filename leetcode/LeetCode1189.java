package org.example;

import java.util.HashMap;
import java.util.*;

public class LeetCode1189 {

    public static void main(String[] args) {

        String text="xyz";
        System.out.println(maxNumberOfBallons(text));
    }

    public static int maxNumberOfBallons(String text){
        char[] chs=text.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:chs){
            if(c=='b'||c=='a'||c=='l'||c=='o'||c=='n'){
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                }else{
                    map.put(c, 1);
                }
            }
        }
        int maxNumber=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> entry:map.entrySet() ){
            if(entry.getKey()=='l'){
                maxNumber=Math.min(maxNumber, entry.getValue()/2 );
            }else{
                maxNumber=Math.min(maxNumber, entry.getValue() );
            }
        }
        return maxNumber;
    }
}

import java.util.Collections;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;

class ZojB002{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String lineA=sc.nextLine();
        String[] valA=lineA.split(" ");
        String lineB=sc.nextLine();
        String[] valB=lineB.split(" ");
        HashMap<Integer,Double> res=new HashMap<>();
        for(int i=2;i<=valA.length;i=i+2){
            int key=Integer.parseInt(valA[i-1]);
            double value=Double.parseDouble(valA[i]);
            if(res.containsKey(key)){
                res.put(key,res.get(key)+value);
            }else{
                res.put(key,value);
            }
        }
        for(int i=2;i<=valB.length;i=i+2){
            int key=Integer.parseInt(valB[i-1]);
            double value=Double.parseDouble(valB[i]);
            if(res.containsKey(key)){
                res.put(key,res.get(key)+value);
            }else{
                res.put(key,value);
            }
        }
        TreeMap<Integer,Double> resTree=new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Integer,Double> entry:res.entrySet()){
            if(entry.getValue()!=0){
                resTree.put(entry.getKey(),entry.getValue());
            }
        }
        StringBuilder sbd=new StringBuilder();
        sbd.append(resTree.size()+" ");
        
        DecimalFormat df=new DecimalFormat("0.0");
        for(Map.Entry<Integer,Double> entry:resTree.entrySet()){
            sbd.append(entry.getKey());
            sbd.append(" ");
            sbd.append(df.format(entry.getValue()));
            sbd.append(" ");
        }

        sbd.delete(sbd.length()-1,sbd.length());
        System.out.println(sbd);
    }
}

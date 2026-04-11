import java.io.*;

public class Ex03_20_java{

public static void main(String[] args){

    String str;
    int i,n,sum;
    
    str="";
    sum=0;
    try{
    BufferedReader input=new BufferedReader( new InputStreamReader(System.in)   );
    str=input.readLine();
    }
    catch(Exception e){
    System.out.println("input error");
    }
    
    n=Integer.parseInt(str);
    
    for (i=1;i<=n;i++){
    sum=sum+i;
    }
    
    System.out.println(sum);
    
} 

}
import java.util.Scanner;

class ZojB001{
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] params=input.split(" ");
        int a=Integer.parseInt(params[0]);
        int b=Integer.parseInt(params[1]);
        
        int resInt=a+b;
        String symbol= (resInt<0?"-":"");
        String resStr=String.valueOf(Math.abs(resInt));
        
        StringBuilder sbd=new StringBuilder();
        int n=0;
        for(int i=resStr.length();i>=1;i--){
            sbd=sbd.insert(0,resStr.substring(i-1,i));
            n++;
            if(n%3==0 && i!=1){
                sbd=sbd.insert(0,",");
            }
        }
        sbd.insert(0,symbol);
        System.out.println(sbd.toString());

    }
}

import java.util.Scanner;
import java.util.ArrayList;

public class DemToBin{
    public static void main(String[] args){
        /*
        1.提示输入一个数字
        2.获取输入的数字
        3.对数字进行转换
        4.保存并输出转换的结果
        ###后续可优化的地方：将转换过程组合成函数，后续直接调用函数
        ###升级：将这个做成工具类，其他文件可以使用
        */
        System.out.println("please input:");
        Scanner sc;
        sc=new Scanner(System.in);
        int num;
        num=sc.nextInt();
        ArrayList<Integer> al;
        al=new ArrayList<Integer>();
        do{
            //System.out.println(num%2);
            al.add(num%2);
            num=num/2;        
        }while(num!=0);
        //System.out.println(al.toString());
        int n,ndx;
        for(n=al.size();n>=1;n--){
            ndx=n-1;
            System.out.print(al.get(ndx));
        }
    }
} 

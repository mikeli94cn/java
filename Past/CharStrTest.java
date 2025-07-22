import java.util.Scanner;

class CharStrTest{
    public static void main(String[] args){
        //1.打印一个字符
        char ch='A';
        //String str;
        System.out.println(ch);
        //2.读取一个字符
        Scanner sc;
        sc=new Scanner(System.in);
        //str=sc.next();
        ch=sc.next().charAt(0);
        System.out.println(ch);


    }
}

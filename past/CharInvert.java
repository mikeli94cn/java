import java.util.Scanner;
public class CharInvert{

    //1.输入一个字符
    //如果是小写字母，就转换成大写字母
    //如果是大写字母，就转换成小写字母
    //其他字符，则输出，“不是字母”

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char c1= sc.next().charAt(0);

        if (c1>='a' &&c1<='z')
        //a is 97,A is 65. so turn lowercase is minus 32; turn uppercase is plus 32;
        System.out.println(    (char)(c1-32));
        else if( c1>='A' &&c1<='Z' )
        System.out.println( (char)(c1+32) );
        else
        System.out.println(c1+" is not an char");


        


    }


}
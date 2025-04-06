import java.util.Scanner;

class CharStrTest{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
	/*
		char ch1,ch2;
		//打印1个字符
		ch1='A';
		ch2=97;//a的ASCII码。Java使用Unicode，但第一个字节与ASCII一致
		System.out.println(ch1);
		System.out.println(ch2);

		//读取1个字符
		ch1=sc.next().charAt(0);
		ch2=sc.next().charAt(0);
		System.out.println(ch1);
		System.out.println(ch2);

		//比较两个字符
		System.out.println(ch1==ch2);
	*/

		String str1,str2,str3,str4;
		str1="你好";
		str2="你好";
		//打印1个字符串
		System.out.println(str1);
		System.out.println(str2);
		//读取1个字符串
		//str1=sc.next();
		//str2=sc.nextLine();
		//System.out.println(str1);
		//System.out.println(str2);
		//比较两个字符串
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		str3=new String("中国");
		str4=new String("中国");
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));



	}
}

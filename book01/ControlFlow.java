import java.util.Scanner;

public class ControlFlow{
	public static void main(String[] args){
		//straight flow
		String name="Teacher Wu";
		int age=20;
		String course="English";
		double salary=3000;
		System.out.println(name+" this year "+age+" years old,mainly teach "+course+",salary is "+salary);

		//choose flow
		String name2="Wu Ji Zhang";
		int age2=15;
		
		if(age2>=16){
			System.out.println(name2+" is already an adult");
		}
		if(age2<16){
			System.out.println(name2+" is an non-adult");
		}

		if(age2>=16)
			System.out.println(name2+" is already an adult");
		else
			System.out.println(name2+"is an non-adult");

		int age3=20;
		if(age3<16 && age3>0)
			System.out.println("non-adult!");
		else if(age3>=16 && age3<40)
			System.out.println("teenage!");
		else if(age3>=40 && age3<60)
			System.out.println("middle");
		else if(age3>=60)
			System.out.println("old age");
		else
			System.out.println("age < 0");
		
		int num2=1;
		switch(num2){
		case 1:
			System.out.println("withdraw");
			break;
		case 2:
			System.out.println("exit");
			break;
		case 3:
			System.out.println("transfer");
			break;
		default:
			System.out.println("others");
		}

		Scanner sc;
		sc=new Scanner(System.in);
		System.out.println("please input a integer:(1:withdraw 2:exit 3:transfer 4:others)");
		int num3=sc.nextInt();
		switch(num3){
		case 1:
			System.out.println("withdraw");
			break;
		case 2:
			System.out.println("exit");
			break;
		case 3:
			System.out.println("transfer");
			break;
		default:
			System.out.println("others");
		}


		int score=100;
		switch(score/10){
			case 10:
			case 9:
				System.out.println("perfect");
				break;
			case 8:
				System.out.println("good");
				break;
			case 7:
				System.out.println("middle");
				break;
			case 6:
				System.out.println("reach line");
				break;
			default:
				System.out.println("not reach line");
		}

		int j1=0;
		while(j1<10){
			System.out.println("hello java");
			j1++;
		}

		//while(true)
		//	System.out.println("hello jvm");

		int j2=0;
		do{
			System.out.println("hello world");
		}while(j2<0);

		for(int i=0;i<10;i++)
			System.out.println("i="+i);

		//for(;;)
		//	System.out.println("hello");

		for(int i=0;i<5;i++){
			if(i==2)
				continue;
			System.out.println("i="+i);
		}
	}
}

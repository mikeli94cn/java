import java.util.ArrayList;

public class Loop{
    public static void main(String[] args){
        /*
        while
        do..while
        for
        foreach
        */
        int n=1;
        int sum=0;
        while(n<=100){
            sum=sum+n;
            n=n+1;
        }
        System.out.println(sum);

        int m=1;
        int res=0;
        do{
            res=res+m;
            m=m+1;
        }while(m<=100);
        System.out.println(res);

		int s=0;
		for(int i=1;i<=100;i++){
			s=s+i;
		}
		System.out.println(s);

		ArrayList<Integer> al;
		al=new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		for(int a:al){
			System.out.println(a);
		}
    }
}

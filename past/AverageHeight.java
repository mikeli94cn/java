package ACM;

import java.util.*;
/*
read ten students' height
calculate average height

*/

public class AverageHeight{

    public static void main(String[] args){
	    int[] arr;
		arr=new int[10];
	    //read ten integer number	
		Scanner sc;
		sc=new Scanner(System.in);
		int largest=0;
		for(int i=1;i<=10;i++){
		    System.out.println("please input an integer:");

		    int idx=i-1;
			arr[idx]=sc.nextInt();
			if(i==1) largest=arr[0];
			else if(largest<arr[idx]) largest=arr[idx];
		
		}
		/*
		double sum=0;
		double average=0;
		for(int j :arr){
		    //
		    //System.out.println(j);
			sum=sum+j;
		}
		average=sum/arr.length;
		System.out.println("sum of height is "+ sum+",average is "+average);
		*/
		System.out.println("largest of height is "+largest);
	}
}

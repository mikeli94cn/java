import java.util.Arrays;

public class Practice_1_12{
	static int[] scale(int[] arr){
		int[] newArr;
		newArr=new int[2*arr.length];
		for(int i=1;i<=2*arr.length;i++){
			if(i<=arr.length){
				newArr[i-1]=arr[i-1];
			}
			else{
				newArr[i-1]=0;
			}
		}
		return newArr;
	}

	static double[] scale(double[] arr){
		double[] newArr;
		newArr=new double[2*arr.length];
		for(int i=1;i<=2*arr.length;i++){
			if(i<=arr.length){
				newArr[i-1]=arr[i-1];
			}
			else{
				newArr[i-1]=0.0;
			}
		}
		return newArr;
	}

	static String[] scale(String[] arr){
		String[] newArr;
		newArr=new String[2*arr.length];
		for(int i=1;i<=2*arr.length;i++){
			if(i<=arr.length){
				newArr[i-1]=arr[i-1];
			}
			else{
				newArr[i-1]="";
			}
		}
		return newArr;
	}

	static FibNumber[] scale(FibNumber[] arr){
		FibNumber[] newArr;
		newArr=new FibNumber[2*arr.length];
		for(int i=1;i<=2*arr.length;i++){
			if(i<=arr.length){
				newArr[i-1]=new FibNumber(arr[i-1].getValue(),arr[i-1].getIsEven(),arr[i-1].getResult());
			}
			else{
				newArr[i-1]=new FibNumber();
			}
		}
		return newArr;
	}
	
	public static void main(String[] args){
		int[] arrInt=new int[10];
		for(int i=1;i<=arrInt.length;i++){
			arrInt[i-1]=1;
		}
		System.out.println(Arrays.toString(arrInt));
		arrInt=scale(arrInt);
		System.out.println(Arrays.toString(arrInt));

		double[] arrDouble=new double[10];
		for(int i=1;i<=arrDouble.length;i++){
			arrDouble[i-1]=1;
		}
		System.out.println(Arrays.toString(arrDouble));
		arrDouble=scale(arrDouble);
		System.out.println(Arrays.toString(arrDouble));
		
		String[] arrString=new String[10];
		for(int i=1;i<=arrString.length;i++){
			arrString[i-1]="java";
		}
		System.out.println(Arrays.toString(arrString));
		arrString=scale(arrString);
		System.out.println(Arrays.toString(arrString));

		FibNumber[] arrFibNumber=new FibNumber[10];
		for(int i=1;i<=arrFibNumber.length;i++){
			arrFibNumber[i-1]=new FibNumber(3,true,"3 true");
		}
		for(int i=1;i<=arrFibNumber.length;i++){
			System.out.print(arrFibNumber[i-1].getValue()+" ");
			System.out.print(arrFibNumber[i-1].getIsEven()+" ");
			System.out.print(arrFibNumber[i-1].getResult()+";");
		}
		System.out.println();
		arrFibNumber=scale(arrFibNumber);
		
		for(int i=1;i<=arrFibNumber.length;i++){
			System.out.print(arrFibNumber[i-1].getValue()+" ");
			System.out.print(arrFibNumber[i-1].getIsEven()+" ");
			System.out.print(arrFibNumber[i-1].getResult()+";");
		}

		System.out.println();
	    	
		FibNumber[] arr;
		arr=new FibNumber[10];
		for(int i=1;i<=arr.length;i++){
			arr[i-1]=new FibNumber();
		}
		
		arr[0].setValue(1);
		arr[1].setValue(1);

		int i=3;
		while(true){
			int tmp=arr[i-3].getValue()+arr[i-2].getValue();
			if(tmp<50){
				arr[i-1].setValue(tmp);
				i++;
			}
			else{
				break;
			}
		}

		for(int j=1;j<=arr.length;j++){
			if(arr[j-1].getValue()!=0){
				arr[j-1].setIsEven( (arr[j-1].getValue()%2)==0 );
				arr[j-1].setResult(arr[j-1].getValue()+" "+arr[j-1].getIsEven());
			}
		}

		for(int j=1;j<=arr.length;j++){
			if( arr[j-1].getValue() != 0){
				System.out.println( arr[j-1].getResult() );
			}
		}

	}
}

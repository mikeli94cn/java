class MyImprovedFibonacci{
	final static int MAX_INDEX=9;
	static String getMark(int num){
		if(num%2==0)
			return " *";
		else
			return "";
	}

	public static void main(String[] args){
		int a=1;
		int b=1;
		for(int i=1;i<=MAX_INDEX;i++){
			String mark;
			if(i==1)
			{
				System.out.println(i+": "+a+getMark(a));
			}
			else if(i==2){
				System.out.println(i+": "+b+getMark(b));
			}
			else{
				System.out.println(i+": "+(a+b)+getMark(a+b));
				int tmp=b;
				b=a+b;
				a=tmp;
			}

		}
	}
}

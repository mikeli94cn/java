/*==============================*
* 1.print <100 fab num          *
* 2.add judge even              *
* 3.add printf                  *
*===============================*/
class ImprovedFibonacciFormat{
	static int  fabnacci(int i){
		if(i==1 || i==2){
			return 1;
		}
		else{
			return fabnacci(i-1)+fabnacci(i-2);
		}
	}

	static boolean judgeEven(int value){
		if(value%2==0){
			return true;
		}
		else{
			return false;
		}
	}

	public  static void main(String args[]){
		int preSetNum=2000000000;
		for(int i=1;i<=preSetNum;i++){
			int value=fabnacci(i);
			if(value<=100){
				boolean isEven=judgeEven(value);
				String evenResult="";
				if(isEven){
					evenResult="*";
				}
				System.out.printf("%d %d %s\n",i,value,evenResult);
			}
			else{
				break;
			}
		}
	}
}


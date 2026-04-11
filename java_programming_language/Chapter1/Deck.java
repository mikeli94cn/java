
public class Deck{
	/*
	public static final int DECK_SIZE=52;
	private Card[] cards=new Card[DECK_SIZE];
	public void print(){
		for(int i=0;i<cards.length;i++){
			System.out.println(cards[i]);
		}
	}
	*/
	static double average(int[] values){
		if(values == null){
			throw new IllegalArgumentException();
		}
		else{
			if(values.length == 0){
				throw new IllegalArgumentException();
			}
			else{
				double sum=0.0;
				for(int i=0;i<values.length;i++){
					sum += values[i];
				}
				return sum / values.length;
			}
		}
	}

	static double averageNew(int[] values){
		if(values == null | values.length == 0){
			throw new IllegalArgumentException();
		}
		else{
			double sum=0.0;
			for(int i=1;i<=values.length;i++){
				sum+=values[i-1];
			}
			return sum / values.length;
		}
	}

	static double averageConLogic(int[] values){
		if(values == null || values.length == 0){
			throw new IllegalArgumentException();
		}
		else{
			double sum = 0.0;
			for(int i=1;i<=values.length;i++){
				sum += values[i-1];
			}
			return sum / values.length;
		}
	}

	public static void main(String[] args){
		try{
			int[] arr;
			arr=new int[52];
			for(int i=1;i<=52;i++){
				arr[i-1]=i;
			}

			for(int i=1;i<=53;i++){
				System.out.println(arr[i-1]);
			}
		}catch(IndexOutOfBoundsException ex){
			System.out.println("array index out of bound");
		}finally{
			System.out.println("print at end");
		}

	}
}

public class ReadArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个4*5的数组
		int[][] arr;
		arr=new int[4][5];
		int idx,jdx;
		idx=0;
		jdx=0;
		for(int i=1;i<=4;i++){
			idx=i-1;
			for(int j=1;j<=5;j++){
				jdx=j-1;
				arr[idx][jdx]=j+(i-1)*5;
			}
			
			
		}
		
		for(int i=1;i<=4;i++){
			idx=i-1;
			for(int j=1;j<=5;j++){
				jdx=j-1;
				System.out.println( "["+i+"]["+j+"]"+ arr[idx][jdx]);
			}
			
			
		}

	}

}

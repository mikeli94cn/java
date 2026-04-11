class Fibonacci2_1_2 {
	static final int MAX=50;
	/* print the Fibonacci sequence for values less than MAX */
	public static void main(String[] args) {
		int lo=1;
		int hi=1;
		System.out.println(lo);
		while(hi < MAX){
			System.out.println(hi);
			hi=lo+hi;
			lo=hi-lo;
		}
	}
}

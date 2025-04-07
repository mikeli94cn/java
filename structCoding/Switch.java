class Switch
{
	public static void main(String[] args)
	{
		if(1==1)
			System.out.println("1==1");
		else
			System.out.println("1<>1");

		int guess=10;
		if(guess<=3)
			System.out.println("<=3");

		else
			if(3<guess && guess<=6)
				System.out.println("<3 and <=6");
			else
				System.out.println(">6");


	}
}

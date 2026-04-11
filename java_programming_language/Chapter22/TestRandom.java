import java.lang.*;
import java.util.*;

public class TestRandom{
	public static void main(String[] args){
		//method 1 : java.lang.Math.random()
		//generate a double number which >=0.0 and <1.0
		System.out.println(Math.random());

		//methond 2 :java.util.Random class
		
		//Random() return a Random object
		//if do not set seed,default random seed is current timestamp
		Random rand1=new Random();
		//Random(long seed)
		//set random generator seed. the seed decide the random sequence
		//such as 1->[283,74,3,478...]
		//        2->[1783,212,897...]
		//        seed is fixed,then random sequence it generate will be fixed
		Random rand2=new Random(100);
		//setSeed(long seed)
		//change random seed
		rand2.setSeed(10000);
		
		//nextBoolean()
		System.out.println("timestamp nextBoolean() is "+rand1.nextBoolean());
		//rand2 generate pre-set random sequence
		//every time run is fixed result
		System.out.println("seed nextBoolean() is "+rand2.nextBoolean());
		System.out.println("seed nextBoolean() is "+rand2.nextBoolean());
		System.out.println("seed nextBoolean() is "+rand2.nextBoolean());
		//nextInt()
		System.out.println("timestamp nextInt() is "+rand1.nextInt());
		System.out.println("seed nextInt() is "+rand2.nextInt());
		System.out.println("seed nextInt() is "+rand2.nextInt());
		System.out.println("seed nextInt() is "+rand2.nextInt());
		
		//nextInt scope: [Integer.MIN_VALUE,Integer.MAX_VALUE] 
		System.out.println("nextInt scope: "+Integer.MIN_VALUE+" "+Integer.MAX_VALUE);
		
		//nextInt(int ceiling)
		//generate random scope: [0,ceiling)
		int ceiling=100; //[0,100)
		System.out.println("timestamp nextInt(ceiling) is "+rand1.nextInt(ceiling));
		System.out.println("seed nextInt(ceiling) is "+rand2.nextInt(ceiling));
		System.out.println("seed nextInt(ceiling) is "+rand2.nextInt(ceiling));
		System.out.println("seed nextInt(ceiling) is "+rand2.nextInt(ceiling));
		
		//nextInt scope: [Integer.MIN_VALUE,Integer.MAX_VALUE] 
		System.out.println("nextInt scope: "+Integer.MIN_VALUE+" "+Integer.MAX_VALUE);

		//nextLong()
		System.out.println("timestamp nextLong() is "+rand1.nextLong());
		System.out.println("seed nextLong() is "+rand2.nextLong());
		System.out.println("seed nextLong() is "+rand2.nextLong());
		System.out.println("seed nextLong() is "+rand2.nextLong());
		//nextLong scope: [Long.MIN_VALUE,Long.MAX_VALUE] 
		System.out.println("nextLong scope: "+Long.MIN_VALUE+" "+Long.MAX_VALUE);
		
		//nextDouble()
		System.out.println("timestamp nextDouble() is "+rand1.nextDouble());
		System.out.println("seed nextDouble() is "+rand2.nextDouble());
		System.out.println("seed nextDouble() is "+rand2.nextDouble());
		System.out.println("seed nextDouble() is "+rand2.nextDouble());
		//nextDouble scope: [Double.MIN_VALUE,Double.MAX_VALUE] 
		System.out.println("nextDouble scope: "+Double.MIN_VALUE+" "+Double.MAX_VALUE);
	}
}

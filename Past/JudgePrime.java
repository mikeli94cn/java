import java.lang.*;
public class JudgePrime
{
    //input:
    //judge:
    //    1.exact divdide by the number until (aim number-1)
    //    2.exact divide by the number  ∧1/2
    //output:


    public static void main(String[] args)
    {
        //input:
            //create random:Math.random   Random
            //int var=(int)(Math.random()*10000)+2;
            int var=3413;



        //judge:
        /*
        //1.method 1
        boolean primeflag=true;
        int count=0;
        for(int i=2;i<var;i++)
        {
            count++;
            if( var%i==0  )
            {
                primeflag=false;
                break;
            }
        }
        */

        //2.method 2
        //static double	pow(double a, double b)
        //Returns the value of the first argument raised to the power of the second argument.
        boolean primeflag=true;
        int count=0;
        for(int i=2;i<Math.pow(var,0.5) ;i++)
        {
            count++;
            if( var%i==0  )
            {
                primeflag=false;
                break;
            }
        }        

        //output:
        if(primeflag)
            System.out.println(var+" is  prime.count is "+count);
        else
            System.out.println(var+" is  not prime.count is "+count);
        
    }
}
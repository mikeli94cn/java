import java.time.Instant;

class KarlMax
{
    public static void main(String[] args) {
        /*
        m+f+c=30
        3m+2f+c=50
        calc all m,f,c

        0<=m<=10
        0<=f<=20
        10<=c<=20
        */
        
        int m,f,c;

        long utstart=System.currentTimeMillis();
        for(m=0;m<=10;m++)
            for(f=0;f<=20;f++)
            {    
                c=30-m-f;
                if((3*m+2*f+c)==50)
                    System.out.printf("%d %d %d\n",m,f,c);
            }
            long utend=System.currentTimeMillis();
            long t_interval=utend-utstart;
        System.out.printf("%d\n",utstart);
        System.out.printf("%d\n",utend);
        System.out.printf("%d\n",t_interval);    


         utstart=System.currentTimeMillis();
        for(m=0;m<=10;m++)
            for(c=10;c<=20;c++)
            {    
                f=30-m-c;
                if((3*m+2*f+c)==50)
                    System.out.printf("%d %d %d\n",m,f,c);
            }
        /*
        long unixTimeStamp=Instant.now().getEpochSecond();
        System.out.printf("%d\n",unixTimeStamp);
        */

        
         utend=System.currentTimeMillis();

         t_interval=utend-utstart;
        System.out.printf("%d\n",utstart);
        System.out.printf("%d\n",utend);
        System.out.printf("%d\n",t_interval);

    




        
    }
}
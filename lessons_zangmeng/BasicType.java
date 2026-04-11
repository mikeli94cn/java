public class BasicType {
    public static final double PI=3.14;         //public static final
    public static void main(String[] args){
        byte b=120;
        System.out.println(b);
        /*
        byte b2=128;        //byte scope:-128~127,beyond scope
        byte b3=-129;
        */

        short s=200;        //short,2 bytes,useless
        System.out.println(s);

        int i=100;          //declare and initialize. int is most frequent use type. 4 bytes. -2^31 ~ 2^31-1
        System.out.println(i);
        int j;              //declare
        j=200;              //initialize
        System.out.println(j);

        long la=100;        //without L,stored as int
        long lb=1000L;      //long integer
        long lc=2000l;

        float f=123.04f;
        System.out.println(f);
        float f2=34.5F;
        System.out.println(f2);
        float f3=100;
        System.out.println(f3);
        //float f4=100.0;     //decimals in java default stored as double type. so double convert into float will  report error

        double d=123.4D;
        System.out.println(d);
        double d2=34.5d;
        System.out.println(d2);
        double d3=100.2;
        System.out.println(d3);
        double d4=100;
        System.out.println(d4);

        /* space:32 '.':46 '0':48 'A':65 'a':97 */
        //char c='我';

        printASCII();
		printUnicode();


        char c1=32;
        char cPoint=46;
        char c2=48;
        char c3=65;
        char c4=97;
        System.out.println(c1);
        System.out.println(cPoint);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        char ch1='我';
        System.out.println(ch1);
        System.out.println((int)ch1);
        char ch2='b';
        System.out.println(ch2);
        char ch3='\u002e';      /*char store 2 bytes,16 bits, 4 hex. So \u002e can express an char*/
        System.out.println(ch3);

        //printUnicode();

        boolean flag=false;
        System.out.println(flag);
        boolean flag2=true;
        System.out.println(flag2);

        if(5>3) {
            int var = 0;
        }
        //System.out.println(var);        //report error

        int var1=10;
        //int var1=20;                    //var1 has been defined in this scope

        if(5>3){
            //int i=10;                   //i has been defined in this function
        }

        int var2;
        //System.out.println(var2);         //variable has not been initialized

        //single comment

        /*
        * several comment
        *
        *  */

        /**
         * doc comment
         */

        int r=5;
        double area=PI*r*r;
        System.out.println("the area is "+area);

        byte castB=100;
        int castI=castB;
        System.out.println("i="+castI);

        int castI2=100;
        //byte castB2=castI2;     //int store physical size > byte ,cannot directly conversion
        byte castB2=(byte)castI2;   //but can force conversion

        double castD =12.3;
        int castI3=(int)castD;
        System.out.println("castI3="+castI3);


    }

    /*
    * desc:print ASCII
    * param:null
    * return:null
    * */
    static void printASCII(){
        System.out.println("====print ASCII====");
        for(char i=0;i<=127;i++)
            System.out.println(i);
        System.out.println("====end print====");
        return ;
    }

    static void printUnicode(){
        System.out.println("====print Unicode====");
        for(char i=0;i<65535;i++)
            System.out.println(i);
        System.out.println("====end print====");
        return ;
    }


}

public class BasicType {
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




    }
}

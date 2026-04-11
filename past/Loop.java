public class Loop{
    public static void main(String[] args){
        /*
        while
        do..while
        for
        foreach
        */
        int n=1;
        int sum=0;
        while(n<=100){
            sum=sum+n;
            n=n+1;
        }
        System.out.println(sum);

        int m=1;
        int res=0;
        do{
            res=res+m;
            m=m+1;
        }while(m<=100);
        System.out.println(res);
    }
}

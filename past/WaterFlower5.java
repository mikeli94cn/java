class WaterFlower5
{
    public static void main(String[] args) {
        for(int n=10000;n<=99999;n++)
        {
            int a=n%10;
            int b=(n/10)%10;
            int c=(n/100)%10;
            int d=(n/1000)%10;
            int e=(n/10000)%10;
            if((a*a*a*a*a+b*b*b*b*b+c*c*c*c*c+d*d*d*d*d+e*e*e*e*e)==n)
                System.out.println(n);

        }
    }
}
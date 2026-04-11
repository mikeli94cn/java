class WaterFlower3
{
    public static void main(String[] args) {
        for(int n=100;n<=999;n++)
        {
            int a=n%10;
            int b=(n/10)%10;
            int c=(n/100)%10;
            if((a*a*a+b*b*b+c*c*c)==n)
                System.out.println(n);

        }
    }
}
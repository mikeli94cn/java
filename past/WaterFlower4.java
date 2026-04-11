class WaterFlower4
{
    public static void main(String[] args) {
        for(int n=1000;n<=9999;n++)
        {
            int a=n%10;
            int b=(n/10)%10;
            int c=(n/100)%10;
            int d=(n/1000)%10;
            if((a*a*a*a+b*b*b*b+c*c*c*c+d*d*d*d)==n)
                System.out.println(n);

        }
    }
}
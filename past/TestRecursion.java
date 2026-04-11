class TestRecursion
{
    public static void main(String[] args) 
    {
        System.out.println(func(5));
    }
    static int func(int n)
    {
        if(n==0) return 0;
        if(n==1) return 1;
        return 3*func(n-1)-2*func(n-2);
    }

}
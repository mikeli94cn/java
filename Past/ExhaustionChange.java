class ExhaustionChange
{
    public static void main(String[] args) {
        for(int i1=0;i1<=10;i1++)
            for(int i2=0;i2<=5;i2++)
                for(int i3=0;i3<=2;i3++)
                    for(int i4=0;i4<=1;i4++)
                    {    if((i1+2*i2+5*i3+10*i4)==10) 
                            System.out.printf("1:%d,2:%d,5:%d,10:%d%n",i1,i2,i3,i4);
                    }
    }
}
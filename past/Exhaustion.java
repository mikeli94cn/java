class Exhaustion
{
    public static void main(String[] args) {
        int v1=5;
        int v2=10;
        int v3=50;
        int v4=100;

        int n1=50;
        int n2=50;
        int n3=40;
        int n4=20;

        /*
        for(int i1=0;i1<=n1;i1++)
            for (int i2=0;i2<=n2;i2++)
                for(int i3=0;i3<=n3;i3++)
                    for(int i4=0;i4<=n4;i4++)
                    {
                        if(5*i1+10*i2+50*i3+100*i4==2000 && (i1+i2+i3+i4)==50)
                            System.out.printf("5:%d,10:%d,50:%d,100:%d%n",i1,i2,i3,i4);
                    }
        */
        for(int i1=0;i1<=n1;i1++)
            for (int i2=0;i2<=n2;i2++)
                for(int i3=0;i3<=n3;i3++)
                {
                    int i4=50-i1-i2-i3;
                    if(i4<0)
                        continue;
                    else
                        if(5*i1+10*i2+50*i3+100*i4==2000)
                            System.out.printf("5:%d,10:%d,50:%d,100:%d%n",i1,i2,i3,i4);
                }

        
    }
}
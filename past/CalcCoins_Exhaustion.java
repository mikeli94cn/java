class CalcCoins_Exhaustion
{


    public static void main(String[] args) 
    {
        int[] a={1,2,5};

        //print already known situation
        System.out.println("10%n");
        System.out.println("1,1,1,1,1,1,1,1,1,1%n");

        for(int i1=0;i1<=2;i1++)
            if(a[i1]==10)
            {
                System.out.printf("%d%n",a[i1]);
                break;
            }
            else
                for(int i2=0;i2<=2;i2++)
                    if((a[i1]+a[i2])==10)
                    {
                        System.out.printf("%d,%d%n",a[i1],a[i2]);
                        break;
                    }
                    else
                        for(int i3=0;i3<=2;i3++)
                            if((a[i1]+a[i2]+a[i3])==10)
                            {
                                System.out.printf("%d,%d,%d%n",a[i1],a[i2],a[i3]);
                                break;
                            }
                            else
                                for(int i4=0;i4<=2;i4++)
                                    if((a[i1]+a[i2]+a[i3]+a[i4])==10)
                                    {
                                        System.out.printf("%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4]);
                                        break;
                                    }
                                    else
                                        for(int i5=0;i5<=2;i5++)
                                            if((a[i1]+a[i2]+a[i3]+a[i4]+a[i5])==10)
                                            {
                                                System.out.printf("%d,%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4],a[i5]);
                                                break;
                                            }
                                            else
                                                for(int i6=0;i6<=2;i6++)
                                                    if((a[i1]+a[i2]+a[i3]+a[i4]+a[i5]+a[i6])==10)
                                                    {
                                                        System.out.printf("%d,%d,%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4],a[i5],a[i6]);
                                                        break;
                                                    }
                                                    else
                                                        for(int i7=0;i7<=2;i7++)
                                                            if((a[i1]+a[i2]+a[i3]+a[i4]+a[i5]+a[i6]+a[i7])==10)
                                                            {
                                                                System.out.printf("%d,%d,%d,%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4],a[i5],a[i6],a[i7]);
                                                                break;
                                                            }
                                                            else
                                                                for(int i8=0;i8<=2;i8++)
                                                                    if((a[i1]+a[i2]+a[i3]+a[i4]+a[i5]+a[i6]+a[i7]+a[i8])==10)
                                                                    {
                                                                        System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4],a[i5],a[i6],a[i7],a[i8]);
                                                                        break;
                                                                    }
                                                                    else
                                                                        for(int i9=0;i9<=2;i9++)
                                                                            if((a[i1]+a[i2]+a[i3]+a[i4]+a[i5]+a[i6]+a[i7]+a[i8]+a[i9])==10)
                                                                            {
                                                                                System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d%n",a[i1],a[i2],a[i3],a[i4],a[i5],a[i6],a[i7],a[i8],a[i9]);
                                                                                break;
                                                                            }

                                                                
    }
}
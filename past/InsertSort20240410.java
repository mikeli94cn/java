import java.util.Arrays;

class  InsertSort20240410
{
    public static void main(String[] args) {
        int[] arr={9,7,31,2,73,8,19,96,3,46};
        for(int n=1;n<=arr.length-1;n++)
        {
            for(int m=1;m<=n;m++)
                if(arr[n+1-1]<arr[m-1])
                {
                    int temp=arr[n+1-1];
                    for(int k=n;k>=m;k--)
                        arr[k+1-1]=arr[k-1];
                    arr[m-1]=temp;
                    break;
                }
            System.out.println(Arrays.toString(arr));
        }
    }

    
}
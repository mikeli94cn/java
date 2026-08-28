class SumOneToHundred{
    public static void main(String[] args) {
        System.out.println(sumIter(100));
        System.out.println(sumRecur(100));
    }

    static int sumIter(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+i;
        }
        return sum;
    }

    static int sumRecur(int n){
        if(n==1){
            return 1;
        }else{
            return n+sumRecur(n-1);
        }
    }
}

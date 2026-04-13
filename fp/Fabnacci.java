class Fabnacci{
    public static void main(String[] args) {
        System.out.println(fabRecur(20));
        System.out.println(fabIter(20));
    }

    static int fabRecur(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return fabRecur(n-1)+fabRecur(n-2);
        }
    }

    static int fabIter(int n){
        int a=1;
        int b=1;
        int c=0;
        if(n==1){
            return a;
        }else if(n==2){
            return b;
        }else {
            for(int i=3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;
            }
            return c;
        }



    }
}

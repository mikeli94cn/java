enum Operation {
    ADD{
        public int apply(int a,int b){
            return a+b;
        }
    },
    SUBSTRACT{
        public int apply(int a,int b){
            return a-b;
        }
    };

    public abstract int apply(int a,int b);
}

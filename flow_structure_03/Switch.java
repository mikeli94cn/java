class Switch
{
    public static void main(String[] args)
    {
        if(1==1)
            System.out.println("1==1");
        else
            System.out.println("1<>1");

        int guess=10;
        if(guess<=3)
            System.out.println("<=3");

        else
            if(3<guess && guess<=6)
                System.out.println("<3 and <=6");
            else
                System.out.println(">6");
        int a=1;

        float b=1.0f; //swicth cannot convert type of float
        
        byte c=1; 

        char d='A';
        
        boolean e=true; //swicth cannot convert type of boolean

        switch(c){
            case 1.0f:
                System.out.println("switch int a to char b");
                break;
            default:
                System.out.println("nth happen");
                break;
        }

    }
}

class HanoPrint
{
    static void hanoTower(int n,String p1,String p2,String p3)
    {
        if(n==0)
        {

        } 
        else 
        {
            hanoTower(n-1,p1,p3,p2);
            System.out.printf("%s -> %s%n",p1,p2);
            hanoTower(n-1,p3,p2,p1);
        }
    }

    public static void main(String[] args) {
        hanoTower(3,"A","B","C");
        //hanoTower(1,"A","C");
        //hanoTower(1,"B","C");
    }
}
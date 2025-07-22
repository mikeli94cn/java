class HanoNum
{
    static int hanoTower(int n)
    {
        if(n==1)    return 1;
        else    return hanoTower(n-1)*2+1;
    }

    public static void main(String[] args) {
        System.out.printf("1:%d%n",hanoTower(1));
        System.out.printf("2:%d%n",hanoTower(2));
        System.out.printf("3:%d%n",hanoTower(3));
        System.out.printf("4:%d%n",hanoTower(4));
        System.out.printf("5:%d%n",hanoTower(5));
        System.out.printf("6:%d%n",hanoTower(6));
    }
}
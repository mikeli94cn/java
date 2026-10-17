class Switch {
    public static void main(String[] args) {
        System.out.println("1==1");

        int guess = 10;
        if (guess <= 3)
            System.out.println("<=3");

        else if (3 < guess && guess <= 6)
            System.out.println("<3 and <=6");
        else
            System.out.println(">6");

        byte c = 1;

        switch (c) {
            case 1:
                System.out.println("switch int a to char b");
                break;
            default:
                System.out.println("nth happen");
                break;
        }

    }
}

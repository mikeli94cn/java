class AbstractTest{
    // graph
    // |--state_and_behaviour
    // |    |--x
    // |    |--y
    // |    |--setPosition()
    // |    `--draw()
    // |
    // |
    // `--subclass
    //      |--rectangle
    //      `--square




    public static void main(String[] args) {
        //Rectangle r1=new Rectangle();
        Square s1=new Square();
        s1.setPosition(1.0, 2.0);
        s1.draw();
    }

}

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

    abstract class Graph{
        protected double x;
        protected double y;
        public void setPosition(double x,double y){
            this.x=x;
            this.y=y;
            System.out.println("setPosition from super class Graph");
        }
        abstract void draw();

       

    }

    class Rectangle extends Graph{
        void draw(){
            System.out.println("the realization of draw method of Rectangle");
        }
    }

    class Square extends Graph{
        void draw(){
            System.out.println("Square's draw function");
        }
    }

    public static void main(String[] args) {
        //Rectangle r1=new Rectangle();
        Square s1=new Square();
    }

}

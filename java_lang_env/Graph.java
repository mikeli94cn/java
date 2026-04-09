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

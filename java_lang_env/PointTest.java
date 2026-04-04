class PointTest{
    public static void main(String[] args) {
        Point lowerLeft;
        Point upperRight;
        lowerLeft=new Point();
        upperRight=new Point(100.0,200.0);
        lowerLeft.setX(1.0);
        lowerLeft.setY(1.0);
        upperRight.setX(100.0);
        upperRight.setY(100.0);
        System.out.printf("lowerLeft.(x,y) is (%f,%f),upperRight.(x,y) is (%f,%f)\n",
                lowerLeft.getX(),lowerLeft.getY(),upperRight.getX(),upperRight.getY());
    }
}

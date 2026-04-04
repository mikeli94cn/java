class Point extends Object{
    private double x;
    private double y;

    Point(){    /*constructor to initialize */
        x=0.0;
        y=0.0;
    }

    Point(double x,double y){    /*constructor to initialize to specific value*/
        this.x=x;
        this.y=y;
    }

    public void setX(double x) { /* accessor method */
        this.x = x;
    }

    public void setY(double y) { /* accessor method */
        this.y = y;
    }

    public double getX() { /* accessor method */
        return x;
    } 

    public double getY() { /* accessor method */
        return y;
    }
}

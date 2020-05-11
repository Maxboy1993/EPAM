package by.nareiko.shape.entity;

public class Point {
    private double x;
    private double y;

    public Point(){}

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object ob){
        if (ob == this) return true;
        if (ob == null) return false;
        if(getClass() != ob.getClass()) return false;
        Point point = (Point) ob;
        return  x == ((Point) ob).x && y == ((Point) ob).y;
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime*result + (int) x;
        result = prime*result + (int) y;
        return result;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getClass().getName()).append(", coordinate x is: " + x + ", coordinate y is: " + y);
       return str.toString();
    }
}

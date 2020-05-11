package by.nareiko.shape.entity.factory;


import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;

public class EntityFactory {
    private static EntityFactory instance;
    private Point point;
    private Triangle triangle;

    private EntityFactory(){}

    public static EntityFactory getInstance(){
        if (instance == null){
            instance = new EntityFactory();
        }
        return instance;
    }
    public Point getPoint(){
        if (point == null){
            point = new Point();
        }
        return point;
    }

    public Triangle getTriangle() {
            if (triangle == null){
            triangle = new Triangle();
        }
        return triangle;
    }

}

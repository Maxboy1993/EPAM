package by.nareiko.shape.service;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;

public interface TriangleService {
    public double calculateSide(Point point1, Point point2);
    public double[] calculateTriangleSides(Triangle triangle);
    double calculateArea(Triangle triangle);
    double calculatePerimeter(Triangle triangle);
    boolean isRectangular(Triangle triangle);
    boolean isIsosceles(Triangle triangle);
    boolean isEquilateral(Triangle triangle);
    boolean isAcuteAngled(Triangle triangle);
    boolean isObtuse(Triangle triangle);

}

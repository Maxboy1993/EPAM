package by.nareiko.shape.service.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.service.TriangleService;

public class TriangleServiceImpl implements TriangleService {

    public double calculateSide(Point point1, Point point2){
        double x1 = point1.getX();
        double y1 = point1.getY();

        double x2 = point2.getX();
        double y2 =point2.getY();

        double side = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return side;
    }

    public double[] calculateTriangleSides(Triangle triangle){
        double[] sides = new double[3];
        sides[0] = calculateSide(triangle.getPoint1(), triangle.getPoint2());
        sides[1] = calculateSide(triangle.getPoint2(), triangle.getPoint3());
        sides[2] = calculateSide(triangle.getPoint3(), triangle.getPoint1());
        return sides;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        double perimeter = calculatePerimeter(triangle);
        double[] sides = calculateTriangleSides(triangle);
        double area = Math.sqrt(perimeter * (perimeter - sides[0])*(perimeter - sides[1])*(perimeter - sides[2]));
        return area;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        double perimeter = 0.5*(sides[0] + sides[1] + sides[2]);
        return perimeter;
    }

    @Override
    public boolean isRectangular(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        boolean isRectangular = false;
        if (Math.pow(sides[0],2) == Math.pow(sides[1],2) + Math.pow(sides[2],2) ||
        Math.pow(sides[1],2) == Math.pow(sides[0],2) + Math.pow(sides[2],2) ||
        Math.pow(sides[2],2) == Math.pow(sides[1],2) + Math.pow(sides[0],2)){
            isRectangular = true;
        }
        return isRectangular;
    }

    @Override
    public boolean isIsosceles(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        boolean isIsosceles = false;
        if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]){
            isIsosceles = true;
        }
        return isIsosceles;
    }

    @Override
    public boolean isEquilateral(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        boolean isEquilateral = false;
        if (sides[0] == sides[1] && sides[1] == sides[2]){
            isEquilateral = true;
        }
        return isEquilateral;
    }

    @Override
    public boolean isAcuteAngled(Triangle triangle) {

        double[] sides = calculateTriangleSides(triangle);
        boolean isAcuteAngled = false;
        if (Math.pow(sides[0],2) > Math.pow(sides[1],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[1],2) > Math.pow(sides[0],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[2],2) > Math.pow(sides[1],2) + Math.pow(sides[0],2)){
            isAcuteAngled = true;
        }
        return isAcuteAngled;
    }

    @Override
    public boolean isObtuse(Triangle triangle) {
        boolean isObtuse = false;
        if (!(isRectangular(triangle) || isAcuteAngled(triangle))){
            isObtuse = true;
        }
        return isObtuse;
    }


}

package by.nareiko.shape.service.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.service.TriangleService;
import by.nareiko.shape.service.impl.TriangleServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {
    private TriangleService triangleService;
    private Triangle triangle;

    @BeforeClass
    public void inisializeTriangle() throws TriangleException {
        triangleService = new TriangleServiceImpl();
        triangle = new Triangle(new Point(3, 5), new Point(9, 20), new Point(11, 18));
    }

    @Test
    public void testCalculateSide() {
       double actual =  triangleService.calculateSide(new Point(3, 5), new Point(9, 20));
        double expected = 16.1555;
        assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testCalculateTriangleSides() throws TriangleException {
        double[] actual = triangleService.calculateTriangleSides(triangle);
    double[] expected = {16.16, 2.83, 15.26};
    assertEquals(actual, expected, 0.1);
        }

    @Test
    public void testCalculateArea() throws TriangleException {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        double perimeter = triangleService.calculatePerimeter(triangle);
        double actual = Math.sqrt(perimeter * (perimeter - sides[0])*(perimeter - sides[1])*(perimeter - sides[2]));
        double expected = 21.0;
        assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testCalculatePerimeter() throws TriangleException {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        double actual = 0.5*(sides[0] + sides[1] + sides[2]);
        double expected = 17.125;
        assertEquals(actual, expected, 0.1);

    }

//    @Test
//    public void testIsTriangle() throws TriangleException {
//        double[] sides = triangleService.calculateTriangleSides(triangle);
//        boolean isTriangle = false;
//        boolean sidesChecking = false;
//        if ((sides[0] + sides[1] > sides[2]) && (sides[0] + sides[2] > sides[1]) && (sides[1] + sides[2] > sides[0])){
//            sidesChecking = true;
//        }
//        boolean pointsChecking = false;
//        if ((triangle.getPoint3().getX() - triangle.getPoint1().getX())/(triangle.getPoint2().getX() - triangle.getPoint1().getX()) !=
//                (triangle.getPoint3().getY() - triangle.getPoint1().getY())/(triangle.getPoint2().getY() - triangle.getPoint1().getY())){
//            pointsChecking = true;
//        }
//        if (sidesChecking && pointsChecking){
//            isTriangle = true;
//        }
//        boolean actual = isTriangle;
//        boolean expected = true;
//        assertEquals(actual, expected);
//    }

    @Test
    public void testIsRectangular() {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        boolean isRectangular = false;
        if (Math.pow(sides[0],2) == Math.pow(sides[1],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[1],2) == Math.pow(sides[0],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[2],2) == Math.pow(sides[1],2) + Math.pow(sides[0],2)){
            isRectangular = true;
        }
        boolean actual = isRectangular;
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsIsosceles() {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        boolean isIsosceles = false;
        if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]){
            isIsosceles = true;
        }
        boolean actual = isIsosceles;
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsEquilateral() {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        boolean isEquilateral = false;
        if (sides[0] == sides[1] && sides[1] == sides[2]){
            isEquilateral = true;
        }
        boolean actual = isEquilateral;
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsAcuteAngled() {
        double[] sides = triangleService.calculateTriangleSides(triangle);
        boolean isAcuteAngled = false;
        if (Math.pow(sides[0],2) > Math.pow(sides[1],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[1],2) > Math.pow(sides[0],2) + Math.pow(sides[2],2) ||
                Math.pow(sides[2],2) > Math.pow(sides[1],2) + Math.pow(sides[0],2)){
            isAcuteAngled = true;
        }
        boolean actual = isAcuteAngled;
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsObtuse() {
        boolean isObtuse = false;
        if (!(triangleService.isRectangular(triangle) || triangleService.isAcuteAngled(triangle))){
            isObtuse = true;
        }
        boolean actual = isObtuse;
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
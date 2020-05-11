package by.nareiko.shape.validator;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.service.impl.TriangleServiceImpl;
import by.nareiko.shape.validator.TriangleValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleValidatorTest {
    private static final String DELIMITER = "\\s+";
    private static final int NUMBER_OF_ELEMENTS = 6;
    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;
    private static final String REGEX_DOUBLE_NUMBER = "^\\d*[.,]?\\d+$";
    Point point1;
    Point point2;
    Point point3;
    Triangle triangle;
    TriangleValidator validator;

    @BeforeClass
    public void inisialize() throws TriangleException {
        point1 = new Point(3, 5);
        point2 = new Point(9, 20);
        point3 = new Point(11, 18);
        triangle = new Triangle(point1, point2, point3);
        validator = new TriangleValidator();
    }
    @Test
    public void testIsDouble() {
        String value = "22.5";
        boolean expected = value.matches(REGEX_DOUBLE_NUMBER);
        boolean actual = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsCorrectTriangleData() {
        String dataLine = "3 5 9 20 11 18";
        boolean flag = false;
        String[] splitLine = dataLine.split(DELIMITER);
        if (splitLine.length == NUMBER_OF_ELEMENTS) {
            flag = true;
            if (!validator.isDouble(splitLine[X1_POSITION]) || !validator.isDouble(splitLine[Y1_POSITION])) {
                flag = false;
            }
            if (!validator.isDouble(splitLine[X2_POSITION]) || !validator.isDouble(splitLine[Y2_POSITION])) {
                flag = false;
            }
            if (!validator.isDouble(splitLine[X3_POSITION]) || !validator.isDouble(splitLine[Y3_POSITION])) {
                flag = false;
            }
        }
        boolean actual = flag;
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsTriangle() {
        double side1, side2, side3;
        TriangleServiceImpl triangleService = new TriangleServiceImpl();
        side1 = triangleService.calculateSide(point1, point2);
        side2 = triangleService.calculateSide(point2, point3);
        side3 = triangleService.calculateSide(point3, point1);

        boolean checkingSides = false;
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            checkingSides = true;
        }
        boolean isTriangle = false;
        boolean checkingPoints = validator.isPointsNoOnOneStraightLine(point1, point2, point3);
        if (checkingSides && checkingPoints){
            isTriangle = true;
        }
        boolean actual = isTriangle;
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testTestIsTriangle() {
        double[] sides = new TriangleServiceImpl().calculateTriangleSides(triangle);
        boolean isTriangle = false;
        boolean checkingSides = false;
        if ((sides[0] + sides[1] > sides[2]) && (sides[0] + sides[2] > sides[1]) && (sides[1] + sides[2] > sides[0])){
            checkingSides = true;
        }

        boolean checkingPoints = validator.isPointsNoOnOneStraightLine(triangle.getPoint1(), triangle.getPoint2(), triangle.getPoint3());
        if (checkingSides && checkingPoints){
            isTriangle = true;
        }
        boolean actual = isTriangle;
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsPointsNoOnOneStraightLine() {
        boolean pointsChecking = false;
        if ((point3.getX() - point1.getX()) / (point2.getX() - point1.getX()) !=
                (point3.getY() - point1.getY()) / (point2.getY() - point1.getY())) {
            pointsChecking = true;
        }
        boolean actual = pointsChecking;
        boolean expected = true;
        assertEquals(actual, expected);
    }
}
package by.nareiko.shape.validator;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.service.impl.TriangleServiceImpl;



public class TriangleValidator {
    private static final String DELIMITER = "\\s+";
    private static final int NUMBER_OF_ELEMENTS = 6;
    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;
    private static final String REGEX_DOUBLE_NUMBER = "^\\d*[.,]?\\d+$";

    public static boolean isDouble(String value) {
        return value.matches(REGEX_DOUBLE_NUMBER);
    }



    public boolean isCorrectTriangleData(String dataLine) throws TriangleException {
        boolean flag = false;
        String[] splitLine;
        splitLine = dataLine.split(DELIMITER);
        if (splitLine.length == NUMBER_OF_ELEMENTS) {
            flag = true;

            if (!isDouble(splitLine[X1_POSITION]) || !isDouble(splitLine[Y1_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[X2_POSITION]) || !isDouble(splitLine[Y2_POSITION])) {
                flag = false;
            }
            if (!isDouble(splitLine[X3_POSITION]) || !isDouble(splitLine[Y3_POSITION])) {
                flag = false;
            }
        }
        return flag;
    }
    public boolean isTriangle(Point point1, Point point2, Point point3) {

        if(point1 == null || point2 == null || point3 == null){
            return false;
        }

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
        boolean checkingPoints = isPointsNoOnOneStraightLine(point1, point2, point3);
        if (checkingSides && checkingPoints){
            isTriangle = true;
        }
        return isTriangle;
    }

    public boolean isTriangle(Triangle triangle) {
        double[] sides = new TriangleServiceImpl().calculateTriangleSides(triangle);
        boolean isTriangle = false;
        boolean checkingSides = false;
        if ((sides[0] + sides[1] > sides[2]) && (sides[0] + sides[2] > sides[1]) && (sides[1] + sides[2] > sides[0])){
            checkingSides = true;
        }
        boolean checkingPoints = isPointsNoOnOneStraightLine(triangle.getPoint1(), triangle.getPoint2(), triangle.getPoint3());
        if (checkingSides && checkingPoints){
            isTriangle = true;
        }
        return isTriangle;
    }

    public boolean isPointsNoOnOneStraightLine(Point point1, Point point2, Point point3) {
        boolean pointsChecking = false;
        if ((point3.getX() - point1.getX()) / (point2.getX() - point1.getX()) !=
                (point3.getY() - point1.getY()) / (point2.getY() - point1.getY())) {
            pointsChecking = true;
        }
        return pointsChecking;
    }
}

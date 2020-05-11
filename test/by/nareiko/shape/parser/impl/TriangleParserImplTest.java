package by.nareiko.shape.parser.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.parser.TriangleParser;
import by.nareiko.shape.parser.impl.TriangleParserImpl;
import by.nareiko.shape.validator.TriangleValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleParserImplTest {
    private static final String DELIMITER = "\\s+";
    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;
    TriangleParser triangleParser;
    List<String> listTriangles;

    @BeforeClass
    public void setUp() {
        triangleParser = new TriangleParserImpl();

        listTriangles = new ArrayList<>();
        listTriangles.add("3 5 9 20 11 18");
        listTriangles.add("3w2 1 4 1 1 2 3");
    }

    @Test
    public void parsTriangleTest() throws TriangleException {
        TriangleValidator triangleValidator = new TriangleValidator();

        boolean isCorrectData = triangleValidator.isCorrectTriangleData(listTriangles.get(0));
        Triangle triangle;
        Point point1;
        Point point2;
        Point point3;
            String[] data = listTriangles.get(0).split(DELIMITER);
            point1 = new Point(Double.parseDouble(data[X1_POSITION]), Double.parseDouble(data[Y1_POSITION]));
            point2 = new Point(Double.parseDouble(data[X2_POSITION]), Double.parseDouble(data[Y2_POSITION]));
            point3 = new Point(Double.parseDouble(data[X3_POSITION]), Double.parseDouble(data[Y3_POSITION]));
            triangle = new Triangle(3, point1, point2, point3);
            Triangle actual = triangle;

        Triangle expected = new Triangle(3, new Point(3, 5), new Point(9, 20), new Point(11, 18));
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParserException.class)
    public void parsTestException() throws ParserException, TriangleException {

        Triangle actualListTriangle;
        actualListTriangle = triangleParser.parseTriangle(null);
    }
}
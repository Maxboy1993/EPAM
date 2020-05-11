package by.nareiko.shape.parser.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.parser.TriangleParser;
import by.nareiko.shape.validator.TriangleValidator;



public class TriangleParserImpl implements TriangleParser {
    private static final String DELIMITER = "\\s+";
    private static final int X1_POSITION = 0;
    private static final int Y1_POSITION = 1;
    private static final int X2_POSITION = 2;
    private static final int Y2_POSITION = 3;
    private static final int X3_POSITION = 4;
    private static final int Y3_POSITION = 5;

    @Override
    public Triangle parseTriangle(String stringData) throws ParserException {
        if (stringData == null || stringData.isEmpty()) {
            throw new ParserException("list is null");
        }
        TriangleValidator triangleValidator = new TriangleValidator();
        try {
            boolean isCorrectData = triangleValidator.isCorrectTriangleData(stringData);
        Triangle triangle;
        Point point1;
        Point point2;
        Point point3;
        if (isCorrectData) {
            String[] data = stringData.split(DELIMITER);
             point1 = new Point(Double.parseDouble(data[X1_POSITION]), Double.parseDouble(data[Y1_POSITION]));
             point2 = new Point(Double.parseDouble(data[X2_POSITION]), Double.parseDouble(data[Y2_POSITION]));
             point3 = new Point(Double.parseDouble(data[X3_POSITION]), Double.parseDouble(data[Y3_POSITION]));
             triangle = new Triangle(point1, point2, point3);
             boolean isTriangle = triangleValidator.isTriangle(triangle);
            if (isTriangle) {
                return triangle;
            }
        }
        }catch (TriangleException e){
            throw new ParserException ("Error durin parsing!", e);
        }
        return null;
    }
}

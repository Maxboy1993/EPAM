package by.nareiko.shape.creator.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.CreatorException;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.parser.TriangleParser;
import by.nareiko.shape.parser.parserFactory.ParserFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;



import java.util.ArrayList;
import java.util.List;




public class TriangleCreatorImplTest {
private TriangleCreatorImpl triangleCreator;
List<String> list;

@BeforeClass
public void inisilize(){
    triangleCreator = new TriangleCreatorImpl();
    list = new ArrayList<>();
    list.add("3 5 9 20 11 18");
}

    @Test
    public void testCreateTriangles() throws ParserException, TriangleException {
        List<Triangle> triangleList = new ArrayList<>();
        Triangle triangle;
        TriangleParser triangleParser = ParserFactory.getInstance().getTriangleParser();
             triangle = triangleParser.parseTriangle(list.get(0));
            if (triangle != null){
                triangleList.add(triangle);
            }
        Triangle actual = triangleList.get(0);
        Triangle expected = new Triangle(new Point(3, 5), new Point(9, 20), new Point(11, 18));
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CreatorException.class)
    public void createTrianglesTestExceptionNull() throws CreatorException, ParserException, TriangleException {
        List<Triangle> triangles;
        triangles = triangleCreator.createTriangles(null);
    }
}
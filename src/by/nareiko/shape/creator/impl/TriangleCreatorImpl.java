package by.nareiko.shape.creator.impl;

import by.nareiko.shape.creator.TriangleCreator;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.CreatorException;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.parser.TriangleParser;
import by.nareiko.shape.parser.parserFactory.ParserFactory;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorImpl implements TriangleCreator {
    @Override
    public List<Triangle> createTriangles(List<String> stringList) throws TriangleException, CreatorException, ParserException {
        if (stringList == null){
            throw new CreatorException("list is empty!");
        }
        List<Triangle> triangleList = new ArrayList<>();
        Triangle triangle;
        TriangleParser triangleParser = ParserFactory.getInstance().getTriangleParser();
        for (String elem: stringList) {
            triangle = triangleParser.parseTriangle(elem);
            if (triangle != null){
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}

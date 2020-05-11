package by.nareiko.shape.creator;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.CreatorException;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;

import java.util.List;

public interface TriangleCreator {
    List<Triangle> createTriangles(List<String> stringList) throws TriangleException, CreatorException, ParserException;
}

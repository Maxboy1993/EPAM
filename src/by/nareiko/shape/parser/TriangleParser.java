package by.nareiko.shape.parser;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.exception.ParserException;
import by.nareiko.shape.exception.TriangleException;

public interface TriangleParser {
    Triangle parseTriangle(String stringData) throws TriangleException, ParserException;
}

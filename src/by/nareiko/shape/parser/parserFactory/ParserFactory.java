package by.nareiko.shape.parser.parserFactory;

import by.nareiko.shape.parser.TriangleParser;
import by.nareiko.shape.parser.impl.TriangleParserImpl;

public class ParserFactory {
    private static ParserFactory instance;
    private TriangleParser triangleParser;
    private ParserFactory(){}

    public static  ParserFactory getInstance(){
    if (instance == null){
        instance = new ParserFactory();
    }
    return instance;
    }

    public  TriangleParser getTriangleParser(){
        if (triangleParser == null){
            triangleParser = new TriangleParserImpl();
        }
        return triangleParser;
    }
}

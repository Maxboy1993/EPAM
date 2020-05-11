package parser.impl;

import by.nareiko.ih.composite.impl.TextComponent;
import by.nareiko.ih.composite.impl.Type;
import by.nareiko.ih.parser.TextParser;
import by.nareiko.ih.parser.impl.SymbolParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymbolParserTest {

    @Test
    public void testGetInstance() {
        TextParser parserActual = SymbolParser.getInstance();
        TextParser parserExpected = SymbolParser.getInstance();

        assertEquals(parserActual, parserExpected);
    }

    @Test
    public void testParse() {

    }
}
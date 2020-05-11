package reader.impl;

import by.nareiko.ih.exception.ReaderException;
import by.nareiko.ih.reader.TextReader;
import by.nareiko.ih.reader.impl.TextReaderImpl;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.*;

public class TextReaderImplTest {
    TextReaderImpl textReader;
    @Test
    public void testRead() throws ReaderException {
        Path path = Paths.get("resources/resource");
        textReader = new TextReaderImpl();
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }catch (IOException e){
            throw  new ReaderException("Mistake during reading!");
        }
        String text = "";
        for (int i = 0; i < lines.size(); i++) {
            text.concat(lines.get(i));
        }
        int expected = 784;
        int actual = text.length();

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = ReaderException.class)
    public void testGetThrowException() throws ReaderException {
        Path path = Paths.get("resources/resource");
        textReader = new TextReaderImpl();
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }catch (IOException e){
            throw  new ReaderException("Mistake during reading!");
        }
        String text = "";
        for (int i = 0; i < lines.size(); i++) {
            text.concat(lines.get(i));
        }
    }
}
package by.nareiko.ih.reader;

import by.nareiko.ih.exception.ReaderException;

public interface TextReader {
    String read(String filePath) throws ReaderException;
}

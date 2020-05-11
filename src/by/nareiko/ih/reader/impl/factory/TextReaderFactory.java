package by.nareiko.ih.reader.impl.factory;

import by.nareiko.ih.reader.TextReader;
import by.nareiko.ih.reader.impl.TextReaderImpl;

public class TextReaderFactory {
    private static final TextReaderFactory instance = new TextReaderFactory();
    private TextReader textDao;
    private TextReaderFactory(){}

    public TextReader getTextDao(){
        if (textDao == null){
            textDao = new TextReaderImpl();
        }
        return textDao;
    }
}

package by.nareiko.ih.reader.impl;

import by.nareiko.ih.reader.TextReader;
import by.nareiko.ih.exception.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextReaderImpl implements TextReader {

    private static final String FILE_NAME = "resources/resource";
    static Logger logger = LogManager.getLogger();

    @Override
    public String read(String filePath) throws ReaderException {
        if (filePath == null || filePath.isEmpty()){
            filePath = FILE_NAME;
        }
        Path path = Paths.get(filePath);
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }catch (IOException e){
            logger.log(Level.FATAL, "file: " + filePath + " is empty");
            throw  new ReaderException("Mistake during reading!");
        }
        String text = "";
        for (int i = 0; i < lines.size(); i++) {
           text.concat(lines.get(i));
        }
        return text;
    }
}

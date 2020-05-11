package by.nareiko.shape.dao.impl;

import by.nareiko.shape.exception.DaoException;
import by.nareiko.shape.dao.TriangleDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TriangleDaoImpl implements TriangleDao {
    private static final String FILE_NAME = "src/by/nareiko/shape/resources/resource";
    static Logger logger = LogManager.getLogger();

    @Override
    public List<String> readData(String pathData) throws DaoException {

        if (pathData == null || pathData.isEmpty()) {
            pathData = FILE_NAME;
        }
        Path path = Paths.get(pathData);
        List<String> lines;
        try{
            lines = Files.readAllLines(path);
            if (lines.isEmpty()){
                logger.log(Level.FATAL, "file: " + pathData + " is empty");
                throw  new DaoException("Error, lines are empty!");
            }
        }catch (IOException e){
            logger.log(Level.FATAL, "file: " + pathData + " is empty");
            throw new DaoException("Mistake during reading!", e);

        }
        return lines;

    }
}


package by.nareiko.shape.dao;

import by.nareiko.shape.exception.DaoException;

import java.io.IOException;
import java.util.List;

public interface TriangleDao {
    List<String> readData(String pathData) throws DaoException, IOException;
}

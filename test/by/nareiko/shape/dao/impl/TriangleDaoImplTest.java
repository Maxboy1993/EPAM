package by.nareiko.shape.dao.impl;

import by.nareiko.shape.dao.TriangleDao;
import by.nareiko.shape.dao.daoFactory.DaoFactory;
import by.nareiko.shape.dao.impl.TriangleDaoImpl;
import by.nareiko.shape.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleDaoImplTest {
    private static final String FILE_NAME = "src/by/nareiko/shape/resources/resource";
    private static final String TEST_FILE_NAME = "src/by/nareiko/shape/resources/test_resource";

    @Test
    public void testReadData() throws IOException, DaoException {
            Path path = Paths.get(FILE_NAME);
            List<String> expectedLines = new ArrayList<>();
            expectedLines.add("5 1 2 5 1 2");
            expectedLines.add("");
            expectedLines.add("3 1 4 1 1 2 3");
            expectedLines.add("3w2 1 4 1 1 2 3");
            expectedLines.add("       5 1 2 5 1 2");
            expectedLines.add("8 7 6 5 1 2");
            expectedLines.add("3 1 4 1 1 2 3w");
        DaoFactory daoFactory = DaoFactory.getInstence();
        TriangleDao triangleDao = new TriangleDaoImpl();
    List<String> actualLines = triangleDao.readData(FILE_NAME);
    assertEquals(expectedLines, actualLines);
    }

    @Test(expectedExceptions = DaoException.class)
    public void reedDataTestEmptyFile() throws DaoException, IOException {
        DaoFactory daoFactory = DaoFactory.getInstence();
        TriangleDao triangleDao = new TriangleDaoImpl();
        List<String> lines = triangleDao.readData(TEST_FILE_NAME);
    }
    }

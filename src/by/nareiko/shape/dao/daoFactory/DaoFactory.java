package by.nareiko.shape.dao.daoFactory;

import by.nareiko.shape.dao.TriangleDao;
import by.nareiko.shape.dao.impl.TriangleDaoImpl;

public class DaoFactory {
    private static DaoFactory instance;
    private TriangleDao triangleDao;
    public DaoFactory(){}

    public static DaoFactory getInstence(){
        if (instance == null){
            instance = new DaoFactory();
        }return instance;
    }

    public TriangleDao getTriangleDao(){
        if (triangleDao == null){
            triangleDao = new TriangleDaoImpl();
        }
        return triangleDao;
    }
}

package by.nareiko.shape.entity;

import by.nareiko.shape.exception.TriangleException;
import by.nareiko.shape.observer.TriangleObserver;
import by.nareiko.shape.observer.TriangleObserverable;
import by.nareiko.shape.observer.impl.AreaTriangleObserver;
import by.nareiko.shape.observer.impl.PerimeterTriangleObserver;
import by.nareiko.shape.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements TriangleObserverable {
    static Logger logger = LogManager.getLogger();
    private List<TriangleObserver> observers;
    private static long counter;
    private long id;
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(){
        initializeObservers();
    }

    public Triangle(Point point1, Point point2, Point point3) throws TriangleException {

        TriangleValidator validator = new TriangleValidator();
        if (!validator.isTriangle(point1, point2, point3)){
            logger.error("It is not triangle!");
            throw new TriangleException("Wrong triangle data!");
        }

        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
        counter++;
        this.id = counter;
        initializeObservers();
        }

    public Triangle(long id, Point point1, Point point2, Point point3) throws TriangleException {

        TriangleValidator validator = new TriangleValidator();
        if (!validator.isTriangle(point1, point2, point3)){
            logger.error("It is not triangle!");
            throw new TriangleException("Wrong triangle data!");
        }
        setId(id);
        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
        initializeObservers();
    }

    public Point getPoint1() {
        return point1;
    }

    public final void setPoint1(Point point1) throws TriangleException {
        if (point1 == null){
            logger.error("Point 1 is null!");
            throw new TriangleException("Wrong point 1 data!");
        }
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public final void setPoint2(Point point2) throws TriangleException {
        if (point2 == null){
            logger.error("Point 2 is null!");
            throw new TriangleException("Wrong point 2 data!");
        }
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public final void setPoint3(Point point3) throws TriangleException {
        if (point3 == null){
            logger.error("Point 3 is null!");
            throw new TriangleException("Wrong point 3 data!");
        }
        this.point3 = point3;
    }

    public long getId() {
        return id;
    }

    public final void setId(long id) throws TriangleException {
        if (id <= 0){
            logger.error("Id <= 0!");
            throw new TriangleException("Wrong id data!");
        }
        this.id = id;
    }

    private void initializeObservers(){
        observers = new ArrayList<>();
        observers.add(new PerimeterTriangleObserver());
        observers.add(new AreaTriangleObserver());
    }

    @Override
    public void attach(List<TriangleObserver> observerList) {
        this.observers = observers;
    }

    @Override
    public void detach(TriangleObserver observer) {
        this.observers = null;
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            if (observers.get(i) != null){
                observers.get(i).updateTriangle(this);
            }
        }
    }

    @Override
    public boolean equals(Object ob){
        if (this == ob) return  true;
        if (ob == null) return false;
        if (getClass() != ob.getClass()) return  false;
        Triangle triangle = (Triangle) ob;
        return id == ((Triangle) ob).getId();
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime*result + (int) id;
        result = prime*result + point1.hashCode();
        result = prime*result + point2.hashCode();
        result = prime*result + point3.hashCode();
        return result;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getClass().getName() + ", id is: " + id + ", point1 is: " + point1.toString() + ", point2 is: " + point2.toString() + ", point3 is: " + point3.toString());
    return str.toString();
    }
}

package by.nareiko.shape.util.comparator;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.service.impl.TriangleServiceImpl;

import java.util.Comparator;

public class AreaComparator implements Comparator<Triangle> {
    private TriangleServiceImpl triangleService = new TriangleServiceImpl();
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (triangleService.calculateArea(o1) - triangleService.calculateArea(o2));
    }
}

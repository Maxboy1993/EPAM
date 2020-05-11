package by.nareiko.shape.observer.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.observer.TriangleObserver;
import by.nareiko.shape.observer.WareHouse;
import by.nareiko.shape.service.impl.TriangleServiceImpl;

public class PerimeterTriangleObserver implements TriangleObserver {
    @Override
    public void updateTriangle(Triangle triandle) {
        long id = triandle.getId();
        TriangleServiceImpl triangleService = new TriangleServiceImpl();
        double perimeter = triangleService.calculatePerimeter(triandle);
        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.putPerimeter(id, perimeter);
    }
}

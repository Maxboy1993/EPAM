package by.nareiko.shape.observer.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.observer.TriangleObserver;
import by.nareiko.shape.observer.WareHouse;
import by.nareiko.shape.service.impl.TriangleServiceImpl;

public class AreaTriangleObserver implements TriangleObserver {

    @Override
    public void updateTriangle(Triangle triandle) {
        TriangleServiceImpl triangleService = new TriangleServiceImpl();
        long id  = triandle.getId();
        double area = triangleService.calculateArea(triandle);
        WareHouse wareHouse = WareHouse.getInstance();
        wareHouse.putArea(id, area);
    }
}

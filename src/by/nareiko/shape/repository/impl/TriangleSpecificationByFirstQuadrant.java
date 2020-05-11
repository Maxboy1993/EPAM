package by.nareiko.shape.repository.impl;

import by.nareiko.shape.entity.Point;
import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.repository.TriangleSpecification;

import java.util.ArrayList;
import java.util.List;

public class TriangleSpecificationByFirstQuadrant implements TriangleSpecification {

    @Override
    public boolean test(Triangle triangle) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(triangle.getPoint1());
        pointList.add(triangle.getPoint2());
        boolean flag = true;
        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.get(i).getX() <=0 || pointList.get(i).getY() <= 0){
                flag = false;
            }
        }
        return flag;
    }
}
